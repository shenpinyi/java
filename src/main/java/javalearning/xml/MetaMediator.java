package javalearning.xml;

import java.util.List;
import java.util.TimeZone;

public class MetaMediator {

	private static final String RELEASING_PARTY_TYPE_ORIG = "Orig";
	private static final String RELEASING_PARTY_TYPE_TERM = "Term";
	private static final String RELEASING_PARTY_TYPE_NETWORK = "Network";
	private static final String RELEASING_PARTY_TYPE_USER = "User";
	
	private static final String SUPPLY_SERVICE_1000 = "1000";
	private static final String SUPPLY_SERVICE_2000 = "2000";
	private static final String SUPPLY_SERVICE_3000 = "3000";
	private static final String SUPPLY_SERVICE_4000 = "4000";
	private static final String SUPPLY_SERVICE_5000 = "5000";

	private static final String IN_ORIGIN_DIGITS_1800 = "1800";
	private static final String IN_ORIGIN_DIGITS_1300 = "1300";
	private static final String IN_ORIGIN_DIGITS_13 = "13";

	private static final String ITFS_ON = "true";
	private static final String ITFS_OFF = "false";

	private static final String PRESENCE_ON = "true";
	private static final String PRESENCE_OFF = "false";
	
	private static final String ONNET = "onnet";
	private static final String OFFNET = "offnet";
	
	private static final String LOCAL = "local";
	private static final String NATIONAL = "national";

	private static final String CALL_STATUS_ON = "1";
	private static final String CALL_STATUS_OFF = "0";
	
	

	public static void process(List<MetaRawCdr> cdrs) {

		if (cdrs == null || cdrs.size() < 1) {
			return;
		}

		cdrs.sort((MetaRawCdr c1, MetaRawCdr c2) -> {
			if (c1.getIcSeizeTime() > c2.getIcSeizeTime()) {
				return 1;
			} else if (c1.getIcSeizeTime() < c2.getIcSeizeTime()) {
				return -1;
			} else {
				return 0;
			}
		});

		MetaRawCdr first = cdrs.get(0);
		MetaRawCdr last = cdrs.get(cdrs.size() - 1);

		MetaMediatedCdr mediCdr = new MetaMediatedCdr();

		mediCdr.setCallSeq(first.getSeqnum());
		mediCdr.setStartTime(parseTime(last.getConnectTime()));

		if (first.getReleasingParty().equals(RELEASING_PARTY_TYPE_ORIG)) {
			mediCdr.setEndTime(parseTime(first.getDisconnectTime()));
		} else if (first.getReleasingParty().equals(RELEASING_PARTY_TYPE_TERM)) {
			mediCdr.setEndTime(parseTime(last.getDisconnectTime()));
		} else {
			mediCdr.setEndTime(parseTime(first.getDisconnectTime()));
		}

		mediCdr.setOrigCac(first.getUdAs_uda_1_value());
		mediCdr.setOrigSd(first.getUdAs_uda_2_value());
		mediCdr.setOrigin(first.getRoutingInfo_callingPartyRoutedAddr_value());
		mediCdr.setOriginUnnormalised(first.getRoutingInfo_callingPartyRoutedAddr_value());

		TimeZone tz = getTimeZoneFromNumber(mediCdr.getOrigin());
		mediCdr.setStartTimeLocal(getLocalTime(mediCdr.getStartTime(), tz));
		mediCdr.setEndTimeLocal(getLocalTime(mediCdr.getEndTime(), tz));
		mediCdr.setLc(first.getLongcall());
		mediCdr.setDuration(mediCdr.getEndTime() - mediCdr.getStartTime());

		mediCdr.setLcType(null); // TODO

		mediCdr.setConnected(first.getConnected());
		mediCdr.setDialledDigits(first.getRoutingInfo_requestedAddr_value());
		mediCdr.setDialledDigitsUnnormalised(first.getRoutingInfo_requestedAddr_value());
		mediCdr.setTermCac(last.getUdAs_uda_5_value());
		mediCdr.setTermSd(last.getUdAs_uda_6_value());
		mediCdr.setTarget(getNormalisedAddr(last.getRoutingInfo_routedAddr_value()));
		mediCdr.setTargetUnnormalised(last.getRoutingInfo_routedAddr_value());

		if (first.getOrigParty_trunkGroup_trunkaccounting() != null
				&& !first.getOrigParty_trunkGroup_trunkaccounting().equals("")) {
			mediCdr.setInTrunk(first.getOrigParty_trunkGroup_trunkaccounting());
			mediCdr.setInTrunkGroupId(first.getOrigParty_trunkGroup_trunkGroupId());
		} else {
			mediCdr.setInTrunk(first.getOrigParty_chargeAddr_value());
			mediCdr.setInTrunkGroupId(first.getOrigParty_chargeAddr_value());
		}

		if (first.getTermParty_trunkGroup_trunkaccounting() != null
				&& !first.getTermParty_trunkGroup_trunkaccounting().equals("")) {
			mediCdr.setOutTrunk(last.getTermParty_trunkGroup_trunkaccounting());
			mediCdr.setOutTrunkGroupId(last.getTermParty_trunkGroup_trunkGroupId());
		} else {
			mediCdr.setOutTrunk(last.getTermParty_chargeAddr_value());
			mediCdr.setOutTrunkGroupId(last.getTermParty_chargeAddr_value());
		}

		mediCdr.setReleaseReason(first.getReleaseReason_1_value());

		/*
		 * Look at UDA 10 in the 1st CFS record and if this field has a value of
		 * 170 then it is an ITFS call. Look at UDA 10 in the 1st CFS record and
		 * if this field has a value of 160 then it is a PRESENCE call
		 */
		if (first.getUdAs_uda_10_value().equals("170")) {
			mediCdr.setItfs(ITFS_ON);
		} else if (first.getUdAs_uda_10_value().equals("160")) {
			mediCdr.setPresence(PRESENCE_ON);
		}

		mediCdr.setVoiceData(getVoiceData(first.getSignalingInfo_mediaCapabilityUsed()));

		/**
		 * If UDA10 has a value of 100 or 110 then the call is an IN call. This
		 * needs to be looked at from the 1st CFS record. If value 100 look at
		 * the RequestedAddr to identify if 13/1300 or 1800
		 */

		if (first.getUdAs_uda_10_value().equals("100")) {
			mediCdr.setInOriginDigits(first.getRoutingInfo_requestedAddr_value());
		} else if (first.getUdAs_uda_10_value().equals("110")) {
			mediCdr.setInOriginDigits(first.getRoutingInfo_requestedAddr_value());
		}

		/**
		 * This field (RedirectCount) will indicate that there is a diversion
		 * scenario
		 */
		mediCdr.setDiversion(last.getCallForwardInfo_redirectCount());

		/**
		 * We consinder 1414 and 1474 as Onnet (EWSD and Genband). So if UDA1
		 * and UDA5 both have values of 1414 or 1474 then the call is considered
		 * Onnet.
		 */
		mediCdr.setOnnetOffnet(
				isOnnet(first.getUdAs_uda_1_value()) && isOnnet(first.getUdAs_uda_5_value()) ? ONNET : OFFNET);

		mediCdr.setLocalNational(isLocal(mediCdr) ? LOCAL : NATIONAL);
		mediCdr.setState(getState(mediCdr.getOrigin()));

		/*
		 * TODO Check the value of META_BILLING_TYPE field. This field will
		 * indicate if trunk based on Apty billing: Trunk Based billing:
		 * META_ID_VALUE = trunkaccounting (Eg. DCC12610031BW ) Apty Billing:
		 * META_ID_VALUE = CallingPartyAddr (Eg. 0290960452)
		 * 
		 */
		mediCdr.setIdValue("");

		/*
		 * TODO Should this be from the 1st or last CFS record? POI,Trunk and A
		 * Party Billing will be performed. CTS will have UDA 10 set to 190 for
		 * CTS and UDA 5 giving a link to that Customer 1261 for all CTS and a
		 * prefix per customer after <UDA id="5">12610031</UDA> <UDA
		 * id="10">190</UDA>
		 */
		mediCdr.setBillingType("");

		/*
		 * TODO: As we we would have to look at the outgoing trunk rather than
		 * the term CAC/SD
		 */
		mediCdr.setOverflow("");

		/*
		 * Map the value from the 1st CFS record to this field
		 */
		mediCdr.setPchargeVec(first.getSignalingInfo_pChargingVector_icidvalue());

		/*
		 * TODO If the call was connected from a directly connected customer
		 * then the provider ID will be 1. If it was an interconnect trunk then
		 * the call will have a provider of 1.
		 * 
		 * Also calls that trigger 13/1300/1800/presence usage types will also
		 * have a provider set to 1.
		 * 
		 */
		mediCdr.setServPorv("");

		/*
		 * If the META_DURATION > 0 set the value to 1 otherwise set value to
		 * zero
		 */
		mediCdr.setCallStatusId(mediCdr.getDuration() > 0 ? CALL_STATUS_ON : CALL_STATUS_OFF);

		/*
		 * Map the value of UDA10 into this field.
		 */
		mediCdr.setCallType(first.getUdAs_uda_10_value());

		/**@formatter:off
		 * Set the appropriate values based on the table below. 
		 * 1000 1800 Service 
		 * 2000 13 Service 
		 * 3000 1300 Service 
		 * 4000 Presence 
		 * 5000 ITFS
		 * @formatter:on
		 */
		if (mediCdr.getItfs() != null && mediCdr.getItfs().equals(ITFS_ON)) {
			mediCdr.setSuppService(SUPPLY_SERVICE_5000);
		} else if (mediCdr.getItfs() != null && mediCdr.getPresence().equals(PRESENCE_ON)) {
			mediCdr.setSuppService(SUPPLY_SERVICE_4000);
		} else if (mediCdr.getInOriginDigits() != null && mediCdr.getInOriginDigits().equals(IN_ORIGIN_DIGITS_1800)) {
			mediCdr.setSuppService(SUPPLY_SERVICE_1000);
		} else if (mediCdr.getInOriginDigits() != null && mediCdr.getInOriginDigits().equals(IN_ORIGIN_DIGITS_1300)) {
			mediCdr.setSuppService(SUPPLY_SERVICE_3000);
		} else if (mediCdr.getInOriginDigits() != null && mediCdr.getInOriginDigits().equals(IN_ORIGIN_DIGITS_13)) {
			mediCdr.setSuppService(SUPPLY_SERVICE_2000);
		}
		
	}

	private static String getState(String origin) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean isLocal(MetaMediatedCdr mediCdr) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean isOnnet(String udAs_uda_1_value) {
		// TODO Auto-generated method stub
		return false;
	}

	private static String getVoiceData(String signalingInfo_mediaCapabilityUsed) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String getNormalisedAddr(String addr) {
		String OrigNum = "";

		if (addr != null) {

			Integer CallNoEndIndex = addr.indexOf(' ');

			if (CallNoEndIndex > 0) {

				OrigNum = addr.substring(0, CallNoEndIndex);

			} else {

				OrigNum = addr;
			}

			// checkNORMOrigCallAdd(OrigNum,inNORM_Rec);

			if (OrigNum.startsWith("2") || OrigNum.startsWith("3") || OrigNum.startsWith("7") || OrigNum.startsWith("8")
					|| OrigNum.startsWith("4") || OrigNum.startsWith("011")) {

				return "0" + OrigNum;

			} else if (OrigNum.startsWith("13") || OrigNum.startsWith("1800") || OrigNum.startsWith("198")) {

				return OrigNum;

			} else if (OrigNum.startsWith("61")) {

				return "0" + OrigNum.substring(2);

			} else {

				return OrigNum;

			}

		}
		return "";
	}

	private static long parseTime(String connectTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static long getLocalTime(long time, TimeZone tz) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static TimeZone getTimeZoneFromNumber(String origin) {
		// TODO Auto-generated method stub
		return null;
	}

}

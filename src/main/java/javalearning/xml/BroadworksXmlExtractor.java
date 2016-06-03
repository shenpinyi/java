package javalearning.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
//import org.apache.log4j.Logger;
//import org.apache.log4j.FileAppender;
//import org.apache.log4j.Appender;
import java.text.SimpleDateFormat;
//import powertel.common.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * BroadWorks class
 * 
 * @purpose Stores the entire xml tags in this class
 */
class BroadWorksCDR {
	private Vector<CdrData> cdrData;
	private String version;

	public BroadWorksCDR() {
		cdrData = new Vector<CdrData>();
		version = null;
	}

	public void addCdrData(CdrData rhs) {
		cdrData.addElement(rhs);
	}

	public Vector<CdrData> getCdrData() {
		return cdrData;
	}

	public void addVersion(String rhs) {
		version = rhs;
	}

	public String getVersion() {
		return version;
	}

	public String toString() {
		String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();

		buf.append("--- cdrData ---").append(newline);
		for (int i = 0; i < cdrData.size(); i++) {
			buf.append(cdrData.elementAt(i)).append(newline);
		}

		buf.append("--- version ---").append(newline);
		buf.append(version).append(newline);

		return buf.toString();
	}
}

/**
 * RecordId class
 * 
 * @purpose Stored the child elements of RecordId tag found in the HeaderModule
 */

class RecordId {
	private String eventCounter;
	private String systemId;
	private String recDate;
	private String sysTimeZone;

	public RecordId() {
		eventCounter = null;
		systemId = null;
		recDate = null;
		sysTimeZone = null;
	}

	public void setEventCounter(String rhs) {
		eventCounter = rhs;
	}

	public String getEventCounter() {
		return eventCounter;
	}

	public void setSystemId(String rhs) {
		systemId = rhs;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setDate(String rhs) {
		recDate = rhs;
	}

	public String getDate() {
		return recDate;
	}

	public void setSysTimeZone(String rhs) {
		sysTimeZone = rhs;
	}

	public String getSysTimeZone() {
		return sysTimeZone;

	}

	public String getRecordIdStr() {
		String outRecId = eventCounter + systemId + recDate + sysTimeZone;
		return outRecId;
	}

	public String toString() {
		String newline = System.getProperty("line.separator");

		StringBuffer buf = new StringBuffer();
		buf.append("--- eventCounter  ---").append(newline);
		buf.append(eventCounter).append(newline);

		buf.append("--- SystemId  ---").append(newline);
		buf.append(systemId).append(newline);

		buf.append("--- RecordDate  ---").append(newline);
		buf.append(recDate).append(newline);

		buf.append("--- SysTimeZone  ---").append(newline);
		buf.append(sysTimeZone.toString()).append(newline);

		return buf.toString();
	}

}

/**
 * PartialCallBeginModule class
 * 
 * @purpose Stored the child nodes of partialCallBeginModule Module tag found in
 *          the cdrData
 */
class PartialCallBeginModule {
	private String failOverCorrelationId;

	public PartialCallBeginModule() {
		failOverCorrelationId = null;
	}

	public void setFailOverCorrelationId(String failOverCorrelationId) {
		this.failOverCorrelationId = failOverCorrelationId;
	}

	public String getFailOverCorrelationId() {
		return failOverCorrelationId;
	}

	public String toString() {
		String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();
		buf.append("--- correlation Id PartialCallBeginModule---").append(newline);
		buf.append(failOverCorrelationId).append(newline);
		return buf.toString();
	}

}

/**
 * PartialCallEndModule class
 * 
 * @purpose Stored the child nodes of partialCallEndModule Module tag found in
 *          the cdrData
 */
class PartialCallEndModule {

	private String failOverCorrelationId;

	public PartialCallEndModule() {
		failOverCorrelationId = null;
	}

	public void setFailOverCorrelationId(String failOverCorrelationId) {
		this.failOverCorrelationId = failOverCorrelationId;
	}

	public String getFailOverCorrelationId() {
		return failOverCorrelationId;
	}

	public String toString() {
		String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();
		buf.append("--- correlation Id PartialCallEndModule  ---").append(newline);
		buf.append(failOverCorrelationId).append(newline);
		return buf.toString();
	}

}

/**
 * CentrexModule class
 * 
 * @purpose Stored the child nodes of centrex Module tag found in the cdrData
 */
class CentrexModule {

	private String group;
	private String trunkGroupName;
	private String trunkGroupInfo;
	private String redirectingNumber;
	private String redirectingPresentationIndicator;
	private String redirectingReason;
	private String extTrackingId;

	public CentrexModule() {
		group = null;
		trunkGroupName = null;
		trunkGroupInfo = null;
		redirectingNumber = null;
		redirectingPresentationIndicator = null;
		redirectingReason = null;
		extTrackingId = null;
	}

	public void setGroup(String rhs) {
		group = rhs;
	}

	public String getGroup() {
		return group;
	}

	public void setTrunkGroupName(String rhs) {
		trunkGroupName = rhs;
	}

	public String getTrunkGroupName() {
		return trunkGroupName;
	}

	public void setTrunkGroupInfo(String rhs) {
		trunkGroupInfo = rhs;
	}

	public String getTrunkGroupInfo() {
		return trunkGroupInfo;
	}

	public void setRedirectingReason(String rhs) {
		redirectingReason = rhs;
	}

	public String getRedirectingReason() {
		return redirectingReason;
	}

	public void setRedirectingNumber(String rhs) {
		redirectingNumber = rhs;
	}

	public String getRedirectingNumber() {
		return redirectingNumber;
	}

	public void setExtTrackingId(String rhs) {
		extTrackingId = rhs;
	}

	public String getExtTrackingId() {
		return extTrackingId;
	}

	public void setRedirectingPresentationIndicator(String rhs) {
		redirectingPresentationIndicator = rhs;
	}

	public String getRedirectingPresentationIndicator() {
		return redirectingPresentationIndicator;
	}

	public String toString() {
		String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();
		buf.append("--- Group  ---").append(newline);
		buf.append(group).append(newline);
		buf.append("--- TrunkGroupName  ---").append(newline);
		buf.append(trunkGroupName).append(newline);
		buf.append("--- TrunkGroupInfo  ---").append(newline);
		buf.append(trunkGroupInfo).append(newline);
		buf.append("--- RedirectingNumber  ---").append(newline);
		buf.append(redirectingNumber).append(newline);
		buf.append("--- RedirectingPresentationIndicator  ---").append(newline);
		buf.append(redirectingPresentationIndicator).append(newline);
		buf.append("--- RedirectingReason  ---").append(newline);
		buf.append(redirectingReason).append(newline);
		buf.append("--- ExtTrackingId  ---").append(newline);
		buf.append(extTrackingId).append(newline);
		return buf.toString();
	}
}

/**
 * HeaderModule class
 * 
 * @purpose Stored the child nodes of HeaderModule tag found in the cdrData
 */

class HeaderModule {
	private RecordId recId;
	private String serviceProvider;
	private String type;

	public HeaderModule() {
		recId = new RecordId();
		serviceProvider = null;
		type = null;
	}

	public void addRecordId(RecordId rhs) {
		recId = rhs;
	}

	public RecordId getRecordId() {
		return recId;
	}

	public void setServiceProvider(String rhs) {
		serviceProvider = rhs;
	}

	public String getServiceProvider() {
		return serviceProvider;
	}

	public void setType(String rhs) {
		type = rhs;
	}

	public String getType() {
		return type;
	}

	public String toString() {
		String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();
		if (recId != null) {
			buf.append("--- RecordId  ---").append(newline);
			buf.append(recId).append(newline);
		} else {
			buf.append("--- RecordId  ---").append(newline);
			buf.append("recId-null").append(newline);
		}
		buf.append("--- ServiceProvider  ---").append(newline);
		buf.append(serviceProvider).append(newline);

		buf.append("--- Type ---").append(newline);
		buf.append(type).append(newline);

		return buf.toString();
	}

}

/**
 * BasicModule class
 * 
 * @purpose Stored the child nodes of BasicModule tag found in the cdrData
 */

class BasicModule {
	private String userNumber;
	private String direction;
	private String asCallType;
	private String callingNumber;
	private String callingPresentationIndicator;
	private String dialedDigit;
	private String calledNumber;
	private String networkTranslatedNumber;
	private String startTime;
	private String userTimeZone;
	private String localCallId;
	private String answerIndicator;
	private String answerTime;
	private String releaseTime;
	private String terminationCause;
	private String callCategory;
	private String chargeIndicator;
	private String releasingParty;
	private String userId;
	private String clidPermitted;
	private String namePermitted;
	private String netwkCallType;
	private String typeOfNetwork;
	private String remoteCallId;
	private String groupNumber;
	private String carrierIdentificationCode;
	private String networkTranslatedGroup;
	private String otherPartyName;
	private String callingPresentationNumber;
	private String callingAssertedNumber;

	public BasicModule() {
		userNumber = null;
		direction = null;
		asCallType = null;
		callingNumber = null;
		callingPresentationIndicator = null;
		dialedDigit = null;
		calledNumber = null;
		networkTranslatedNumber = null;
		startTime = null;
		userTimeZone = null;
		localCallId = null;
		answerIndicator = null;
		answerTime = null;
		releaseTime = null;
		terminationCause = null;
		callCategory = null;
		chargeIndicator = null;
		typeOfNetwork = null;
		releasingParty = null;
		userId = null;
		clidPermitted = null;
		namePermitted = null;
		netwkCallType = null;
		remoteCallId = null;
		groupNumber = null;
		carrierIdentificationCode = null;
		networkTranslatedGroup = null;
		otherPartyName = null;
		callingPresentationNumber = null;
		callingAssertedNumber = null;

	}

	public void setcallingPresentationNumber(String rhs) {
		callingPresentationNumber = rhs;
	}

	public String getcallingPresentationNumber() {
		return callingPresentationNumber;
	}

	public void setcallingAssertedNumber(String rhs) {
		callingAssertedNumber = rhs;
	}

	public String getcallingAssertedNumber() {
		return callingAssertedNumber;
	}

	public void setOtherPartyName(String rhs) {
		otherPartyName = rhs;
	}

	public String getOtherPartyName() {
		return otherPartyName;
	}

	public void setGroupNumber(String rhs) {
		groupNumber = rhs;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setCarrierIdentificationCode(String rhs) {
		carrierIdentificationCode = rhs;
	}

	public String getCarrierIdentificationCode() {
		return carrierIdentificationCode;
	}

	public void setNetworkTranslatedGroup(String rhs) {
		networkTranslatedGroup = rhs;
	}

	public String getNetworkTranslatedGroup() {
		return networkTranslatedGroup;
	}

	public void setUserNumber(String rhs) {
		userNumber = rhs;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setDirection(String rhs) {
		direction = rhs;
	}

	public String getDirection() {
		return direction;
	}

	public void setAsCallType(String rhs) {
		asCallType = rhs;
	}

	public String getAsCallType() {
		return asCallType;
	}

	public void setCallingNumber(String rhs) {
		callingNumber = rhs;
	}

	public String getCallingNumber() {
		return callingNumber;
	}

	public void setCallingPresentationIndication(String rhs) {
		callingPresentationIndicator = rhs;
	}

	public String getCallingPresentationIndication() {
		return callingPresentationIndicator;
	}

	public void setDialedDigit(String rhs) {
		dialedDigit = rhs;
	}

	public String getDialedDigit() {
		return dialedDigit;
	}

	public void setCalledNumber(String rhs) {
		calledNumber = rhs;
	}

	public String getCalledNumber() {
		return calledNumber;
	}

	public void setNetworkTranslatedNumber(String rhs) {
		networkTranslatedNumber = rhs;
	}

	public String getNetworkTranslatedNumber() {
		return networkTranslatedNumber;
	}

	public void setStartTime(String rhs) {
		startTime = rhs;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setUserTimeZone(String rhs) {
		userTimeZone = rhs;
	}

	public String getUserTimeZone() {
		return userTimeZone;
	}

	public void setLocalCallId(String rhs) {
		localCallId = rhs;
	}

	public String getLocalCallId() {
		return localCallId;
	}

	public void setAnswerIndicator(String rhs) {
		answerIndicator = rhs;
	}

	public String getAnswerIndicator() {
		return answerIndicator;
	}

	public void setAnswerTime(String rhs) {
		answerTime = rhs;
	}

	public String getAnswerTime() {
		return answerTime;
	}

	public void setReleaseTime(String rhs) {
		releaseTime = rhs;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setTerminationCause(String rhs) {
		terminationCause = rhs;
	}

	public String getTerminationCause() {
		return terminationCause;
	}

	public void setCallCategory(String rhs) {
		callCategory = rhs;
	}

	public String getCallCategory() {
		return callCategory;
	}

	public void setNetworkCallType(String rhs) {
		netwkCallType = rhs;
	}

	public String getNetworkCallType() {
		return netwkCallType;
	}

	public void setchargeIndicator(String rhs) {
		chargeIndicator = rhs;
	}

	public String getchargeIndicator() {
		return chargeIndicator;
	}

	public void setTypeOfNetwork(String rhs) {
		typeOfNetwork = rhs;
	}

	public String getTypeOfNetwork() {
		return typeOfNetwork;
	}

	public void setReleasingParty(String rhs) {
		releasingParty = rhs;
	}

	public String getReleasingParty() {
		return releasingParty;
	}

	public void setUserId(String rhs) {
		userId = rhs;
	}

	public String getUserId() {
		return userId;
	}

	public void setClidPermitted(String rhs) {
		clidPermitted = rhs;
	}

	public String getClidPermitted() {
		return clidPermitted;
	}

	public void setNamePermitted(String rhs) {
		namePermitted = rhs;
	}

	public String getNamePermitted() {
		return namePermitted;
	}

	public void setRemoteCallId(String rhs) {
		remoteCallId = rhs;
	}

	public String getRemoteCallId() {
		return remoteCallId;
	}

	public String toString() {
		String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();

		buf.append("--- BasicModule ---").append(newline);
		buf.append("--UserNumber--").append(newline);
		buf.append(getUserNumber()).append(newline);

		buf.append("--Direction--").append(newline);
		buf.append(getDirection()).append(newline);

		buf.append("--CallType--").append(newline);
		buf.append(getAsCallType()).append(newline);

		buf.append("--CallingNumber--").append(newline);
		buf.append(getCallingNumber()).append(newline);

		buf.append("--CallingPresentationIndicator--").append(newline);
		buf.append(getCallingPresentationIndication()).append(newline);

		buf.append("--DialedDigit--").append(newline);
		buf.append(getDialedDigit()).append(newline);

		buf.append("--calledNumber--").append(newline);
		buf.append(getCalledNumber()).append(newline);

		buf.append("--networkTranslatedNumber--").append(newline);
		buf.append(getNetworkTranslatedNumber()).append(newline);

		buf.append("--StartTime--").append(newline);
		buf.append(getStartTime()).append(newline);

		buf.append("--UserTimeZone--").append(newline);
		buf.append(getUserTimeZone()).append(newline);

		buf.append("--LocalCallId--").append(newline);
		buf.append(getLocalCallId()).append(newline);

		buf.append("--remotecallid--").append(newline);
		buf.append(getRemoteCallId()).append(newline);

		buf.append("--AnswerIndicator--").append(newline);
		buf.append(getAnswerIndicator()).append(newline);

		buf.append("--AnswerTime--").append(newline);
		buf.append(getAnswerTime()).append(newline);

		buf.append("--ReleaseTime--").append(newline);
		buf.append(getReleaseTime()).append(newline);

		buf.append("--Termination Cause--").append(newline);
		buf.append(getTerminationCause()).append(newline);

		buf.append("--Call Category--").append(newline);
		buf.append(getCallCategory()).append(newline);

		buf.append("--NetworkCallType--").append(newline);
		buf.append(getNetworkCallType()).append(newline);

		buf.append("--chargeIndicator--").append(newline);
		buf.append(getchargeIndicator()).append(newline);

		buf.append("--typeOfNetwork--").append(newline);
		buf.append(getTypeOfNetwork()).append(newline);

		buf.append("--Releasing Party--").append(newline);
		buf.append(getReleasingParty()).append(newline);

		buf.append("--User Id--").append(newline);
		buf.append(getUserId()).append(newline);

		buf.append("--clidPermitted--").append(newline);
		buf.append(getClidPermitted()).append(newline);

		buf.append("--namePermitted--").append(newline);
		buf.append(getNamePermitted()).append(newline);

		buf.append("--groupNumber--").append(newline);
		buf.append(getGroupNumber()).append(newline);

		buf.append("--carrierIdentificationCode--").append(newline);
		buf.append(getCarrierIdentificationCode()).append(newline);

		buf.append("--NetworkTranslatedGroup--").append(newline);
		buf.append(getNetworkTranslatedGroup()).append(newline);

		buf.append("--OtherPartyName--").append(newline);
		buf.append(getOtherPartyName()).append(newline);

		buf.append("--callingPresentationNumber--").append(newline);
		buf.append(getcallingPresentationNumber()).append(newline);

		buf.append("--callingAssertedNumber--").append(newline);
		buf.append(getcallingAssertedNumber()).append(newline);

		return buf.toString();

	}

}

/**
 * IpModule class
 * 
 * @purpose Stored the child nodes of IpModule tag found in the cdrData
 */
class IpModule {
	private String route;
	private String networkCallId;
	private String codec;
	private String accessDeviceAddr;
	private String accessCallId;
	private String codecUsage;
	private String userAgent;

	public IpModule() {
		route = null;
		networkCallId = null;
		codec = null;
		accessDeviceAddr = null;
		accessCallId = null;
		userAgent = null;
	}

	public void setRoute(String rhs) {
		route = rhs;
	}

	public String getRoute() {
		return route;
	}

	public void setCodec(String rhs) {
		codec = rhs;
	}

	public String getCodec() {
		return codec;
	}

	public void setCodecUsage(String rhs) {
		codecUsage = rhs;
	}

	public String getCodecUsage() {
		return codecUsage;
	}

	public void setAccessDeviceAddr(String rhs) {
		accessDeviceAddr = rhs;
	}

	public String getAccessDeviceAddr() {
		return accessDeviceAddr;
	}

	public void setAccessCallId(String rhs) {
		accessCallId = rhs;
	}

	public String getAccessCallId() {
		return accessCallId;
	}

	public void setNetworkCallId(String rhs) {
		networkCallId = rhs;
	}

	public String getNetworkCallId() {
		return networkCallId;
	}

	public void setUserAgent(String rhs) {
		userAgent = rhs;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public String toString() {
		String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();

		buf.append("--- route ---").append(newline);
		buf.append(getRoute()).append(newline);

		buf.append("--- networkCallId ---").append(newline);
		buf.append(getNetworkCallId()).append(newline);

		buf.append("--- codec ---").append(newline);
		buf.append(getCodec()).append(newline);

		buf.append("--- AccessDeviceAddress ---").append(newline);
		buf.append(getAccessDeviceAddr()).append(newline);

		buf.append("--- AccessCallId ---").append(newline);
		buf.append(getAccessCallId()).append(newline);

		buf.append("--- Codec Usage ---").append(newline);
		buf.append(getCodecUsage()).append(newline);

		buf.append("--- UserAgent ---").append(newline);
		buf.append(getUserAgent()).append(newline);

		return buf.toString();
	}

}

/**
 * CdrData class
 * 
 * @purpose Stored the child elements of CdrData tag found in the broadWorksCD
 */

class CdrData {
	private HeaderModule hdrModule;
	private BasicModule basModule;
	private CentrexModule centrexModule;
	private IpModule ipModule;
	private PartialCallBeginModule partialCallBeginModule;
	private PartialCallEndModule partialCallEndModule;

	public CdrData() {
		hdrModule = new HeaderModule();
		basModule = new BasicModule();
		centrexModule = new CentrexModule();
		ipModule = new IpModule();
		partialCallBeginModule = new PartialCallBeginModule();
		partialCallEndModule = new PartialCallEndModule();
	}

	public void addHdrModule(HeaderModule rhs) {
		hdrModule = rhs;
	}

	public HeaderModule getHeaderModule() {
		return hdrModule;
	}

	public void addBasModule(BasicModule rhs) {
		basModule = rhs;
	}

	public BasicModule getBasicModule() {
		return basModule;
	}

	public void addCentrexModule(CentrexModule rhs) {
		centrexModule = rhs;
	}

	public CentrexModule getCentrexModule() {
		return centrexModule;
	}

	public void addIpModule(IpModule rhs) {
		ipModule = rhs;
	}

	public IpModule getIpModule() {
		return ipModule;
	}

	public void addPartialCallBeginModule(PartialCallBeginModule rhs) {
		partialCallBeginModule = rhs;
	}

	public PartialCallBeginModule getPartialCallBeginModule() {
		return partialCallBeginModule;
	}

	public void addPartialCallEndModule(PartialCallEndModule rhs) {
		partialCallEndModule = rhs;
	}

	public PartialCallEndModule getPartialCallEndModule() {
		return partialCallEndModule;
	}

	public String toString() {
		String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();

		if (hdrModule != null) {
			buf.append("--- HdrModule  ---").append(newline);
			buf.append(hdrModule.toString()).append(newline);
		}

		if (basModule != null) {
			buf.append("--- Basic Module  ---").append(newline);
			buf.append(basModule.toString()).append(newline);
		}
		if (centrexModule != null) {
			buf.append("--- Centrex Module  ---").append(newline);
			buf.append(centrexModule.toString()).append(newline);
		}
		if (ipModule != null) {
			buf.append("--- IP Module  ---").append(newline);
			buf.append(centrexModule.toString()).append(newline);
		}

		if (partialCallBeginModule != null) {
			buf.append("--- Partial Call Begin Module  ---").append(newline);
			buf.append(partialCallBeginModule.toString()).append(newline);
		}
		if (partialCallEndModule != null) {
			buf.append("--- Partial Call End Module  ---").append(newline);
			buf.append(partialCallEndModule.toString()).append(newline);
		}
		return buf.toString();
	}

}

/**
 * Si class
 * 
 * @purpose Singleton Class with reusage String manipulation routines
 */
class Si {
	private static Si singleton = new Si();
	private static StringBuffer outRec = new StringBuffer();

	private Si() {
	}

	public static Si getInstance() {
		return singleton;
	}

	protected static void pr(String rhs) {
		System.out.println(rhs);
	}

	protected static String appendOutStr(String rhs) {
		if (rhs != null) {
			outRec.append(rhs.trim()).append(",");
		} else {
			outRec.append(",");
		}
		return outRec.toString();

	}

	protected static String appendLastStr(String rhs) {
		if (rhs != null) {
			outRec.append(rhs.trim());
		}
		return outRec.toString();
	}

	protected static String getOutStr() {
		return outRec.toString();
	}

	protected static void clearOutStr() {
		if (outRec.length() > 0) {
			outRec.delete(0, outRec.length());
		}
	}
}

/**
 * DomBroadworksUnmarshaller
 * 
 * @purpose Stores the entire extracted value of xml tags into the object
 */
class DomBroadworksUnmarshaller {
	public DomBroadworksUnmarshaller() {
	}

	/**
	 * Method - unMarshallBroadWorksCDR
	 * 
	 * @purpose creates BroadWorksCDR object and stores the entire extracted
	 *          value of xml tags into the object
	 */

	public BroadWorksCDR unMarshallBroadWorksCDR(Node rootNode) throws UnSupportedTagException {
		BroadWorksCDR bwCdr = new BroadWorksCDR();
		Node n;
		// Si.pr("Node Type: " + rootNode.getNodeType() + " Node Name: " +
		// rootNode.getNodeName());
		// System.exit(43);
		NodeList nodes = rootNode.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			n = nodes.item(i);

			if (n.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = n.getNodeName();
				if (nodeName.equals("cdrData")) {
					// disp Si.pr(">" + n.getNodeName());
					bwCdr.addCdrData(unMarshallCdrData(n));
				} else if (nodeName.equals("#textNode")) {
				} else {
					BroadworksXmlExtractor.xmlset.add("broadworksCDR:" + n.getNodeName());

				}
			}

		}
		return bwCdr;

	}

	/**
	 * Method- unMarshallCdrData
	 * 
	 * @purpose creates CdrData object and stores the entire extracted value of
	 *          child elements of CdrData tags into the object
	 */
	public CdrData unMarshallCdrData(Node rootNode) throws UnSupportedTagException {
		CdrData cdrData = new CdrData();
		Node n;
		NodeList nodes = rootNode.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			n = nodes.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = n.getNodeName();
				// disp Si.pr("**" + n.getNodeName());
				if (nodeName.equals("headerModule")) {
					cdrData.addHdrModule(unMarshallHdrModuleData(n));
				} else if (nodeName.equals("basicModule")) {
					cdrData.addBasModule(unMarshallBasModuleData(n));
				} else if (nodeName.equals("centrexModule")) {
					cdrData.addCentrexModule(unMarshallCentrexModuleData(n));
				} else if (nodeName.equals("ipModule")) {
					cdrData.addIpModule(unMarshallIpModuleData(n));
				} else if (nodeName.equals("partialCallBeginModule")) {
					cdrData.addPartialCallBeginModule(unMarshallPartialCallBeginModuleData(n));
				} else if (nodeName.equals("partialCallEndModule")) {
					cdrData.addPartialCallEndModule(unMarshallPartialCallEndModuleData(n));
				} else {
					// throw new UnSupportedTagException("Incorrect Module Tag
					// in cdrData Found: " + n.getNodeName());
					// BroadworksXmlExtractor.log.info("code cdrdata: " +
					// n.getNodeName());
					BroadworksXmlExtractor.xmlset.add("cdrData:" + n.getNodeName());
				}

			} // end of if loop

		} // end of for loop
		return cdrData;
	}

	/**
	 * Method- unMarshallBasModuleData
	 * 
	 * @purpose creates BasicModule object and stores the entire extracted value
	 *          of child elements of BasicModule xml tags into the object
	 */
	public BasicModule unMarshallBasModuleData(Node rootNode) throws UnSupportedTagException {
		BasicModule basModule = new BasicModule();
		Node n;
		NodeList nodes = rootNode.getChildNodes();
		int nodeLength = nodes.getLength();
		for (int i = 0; i < nodeLength; i++) {
			n = nodes.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = n.getNodeName();
				// disp Si.pr(">>>" + n.getNodeName());
				if (nodeName.equals("userNumber")) {
					basModule.setUserNumber(unmarshallText(n));
				} else if (nodeName.equals("direction")) {
					basModule.setDirection(unmarshallText(n));
				} else if (nodeName.equals("asCallType")) {
					basModule.setAsCallType(unmarshallText(n));
				} else if (nodeName.equals("callingNumber")) {
					basModule.setCallingNumber(unmarshallText(n));
				} else if (nodeName.equals("callingPresentationIndicator")) {
					basModule.setCallingPresentationIndication(unmarshallText(n));
				} else if (nodeName.equals("dialedDigits")) {
					basModule.setDialedDigit(unmarshallText(n));
				} else if (nodeName.equals("calledNumber")) {
					basModule.setCalledNumber(unmarshallText(n));
				} else if (nodeName.equals("networkTranslatedNumber")) {
					basModule.setNetworkTranslatedNumber(unmarshallText(n));
				} else if (nodeName.equals("networkTranslatedGroup")) {
					basModule.setNetworkTranslatedGroup(unmarshallText(n));
				} else if (nodeName.equals("otherPartyName")) {
					basModule.setOtherPartyName(unmarshallText(n));
				} else if (nodeName.equals("startTime")) {
					basModule.setStartTime(unmarshallText(n));
				} else if (nodeName.equals("userTimeZone")) {
					basModule.setUserTimeZone(unmarshallText(n));
				} else if (nodeName.equals("clidPermitted")) {
					basModule.setClidPermitted(unmarshallText(n));
				} else if (nodeName.equals("localCallId")) {
					basModule.setLocalCallId(unmarshallText(n));
				} else if (nodeName.equals("answerIndicator")) {
					basModule.setAnswerIndicator(unmarshallText(n));
				} else if (nodeName.equals("answerTime")) {
					basModule.setAnswerTime(unmarshallText(n));
				} else if (nodeName.equals("releaseTime")) {
					basModule.setReleaseTime(unmarshallText(n));
				} else if (nodeName.equals("terminationCause")) {
					basModule.setTerminationCause(unmarshallText(n));
				} else if (nodeName.equals("callCategory")) {
					basModule.setCallCategory(unmarshallText(n));
				} else if (nodeName.equals("networkCallType")) {
					basModule.setNetworkCallType(unmarshallText(n));
				} else if (nodeName.equals("chargeIndicator")) {
					basModule.setchargeIndicator(unmarshallText(n));
				} else if (nodeName.equals("typeOfNetwork")) {
					basModule.setTypeOfNetwork(unmarshallText(n));
				} else if (nodeName.equals("releasingParty")) {
					basModule.setReleasingParty(unmarshallText(n));
				} else if (nodeName.equals("userId")) {
					basModule.setUserId(unmarshallText(n));
				} else if (nodeName.equals("clidPermitted")) {
					basModule.setClidPermitted(unmarshallText(n));
				} else if (nodeName.equals("namePermitted")) {
					basModule.setNamePermitted(unmarshallText(n));
				} else if (nodeName.equals("remoteCallId")) {
					basModule.setRemoteCallId(unmarshallText(n));
				} else if (nodeName.equals("groupNumber")) {
					basModule.setGroupNumber(unmarshallText(n));
				} else if (nodeName.equals("carrierIdentificationCode")) {
					basModule.setCarrierIdentificationCode(unmarshallText(n));
				} else if (nodeName.equals("callingPresentationNumber")) {
					basModule.setcallingPresentationNumber(unmarshallText(n));
				} else if (nodeName.equals("callingAssertedNumber")) {
					basModule.setcallingAssertedNumber(unmarshallText(n));
				} else {
					// throw new UnSupportedTagException("Incorrect Module Tag
					// Found in basicModule: " + n.getNodeName());
					// BroadworksXmlExtractor.log.info("code basicmodule: " +
					// n.getNodeName());
					BroadworksXmlExtractor.xmlset.add("basicmodule:" + n.getNodeName());
				}

			} // end of if loop

			// disp if(i==(nodeLength-1))
			// {
			// Si.pr(basModule.toString());

			// Si.pr("Service provider: " + hdrModule.getServiceProvider());
			// Si.pr("TYpe: " + hdrModule.getType());
			// }

		} // end of for loop
		return basModule;
	}

	/**
	 * Method-unMarshallPartialCallEndModuleData
	 * 
	 * @purpose creates PartialCallEndModule object and stores the entire
	 *          extracted value of child elements of PartialCallEndModule xml
	 *          tags into the object
	 */

	public PartialCallEndModule unMarshallPartialCallEndModuleData(Node rootNode) throws UnSupportedTagException {
		PartialCallEndModule partialModule = new PartialCallEndModule();
		Node n;
		NodeList nodes = rootNode.getChildNodes();
		int nodeLength = nodes.getLength();
		for (int i = 0; i < nodeLength; i++) {
			n = nodes.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = n.getNodeName();
				// disp Si.pr(">>>" + n.getNodeName());
				if (nodeName.equals("failoverCorrelationId")) {
					partialModule.setFailOverCorrelationId(unmarshallText(n));
				} else {
					// throw new UnSupportedTagException("Incorrect Module Tag
					// Found in centrexModule: " + n.getNodeName());
					// BroadworksXmlExtractor.log.info("code centrexmodule: " +
					// n.getNodeName());
					BroadworksXmlExtractor.xmlset.add("centrexmodule:" + n.getNodeName());
				}

			} // end of if loop

			// disp if(i==(nodeLength-1))
			// {
			// Si.pr(centrModule.toString());
			// }

		} // end of for loop
		return partialModule;
	}

	/**
	 * Method-unMarshallPartialCallBeginModuleData
	 * 
	 * @purpose creates PartialCallBeginModule object and stores the entire
	 *          extracted value of child elements of PartialCallBeginModule xml
	 *          tags into the object
	 */

	public PartialCallBeginModule unMarshallPartialCallBeginModuleData(Node rootNode) throws UnSupportedTagException {
		PartialCallBeginModule partialModule = new PartialCallBeginModule();
		Node n;
		NodeList nodes = rootNode.getChildNodes();
		int nodeLength = nodes.getLength();
		for (int i = 0; i < nodeLength; i++) {
			n = nodes.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = n.getNodeName();
				// disp Si.pr(">>>" + n.getNodeName());
				if (nodeName.equals("failoverCorrelationId")) {
					partialModule.setFailOverCorrelationId(unmarshallText(n));
				} else {
					// throw new UnSupportedTagException("Incorrect Module Tag
					// Found in centrexModule: " + n.getNodeName());
					// BroadworksXmlExtractor.log.info("code centrexmodule: " +
					// n.getNodeName());
					BroadworksXmlExtractor.xmlset.add("centrexmodule:" + n.getNodeName());
				}

			} // end of if loop

			// disp if(i==(nodeLength-1))
			// {
			// Si.pr(centrModule.toString());
			// }

		} // end of for loop
		return partialModule;
	}

	/**
	 * Method-unMarshallCentrexModuleData
	 * 
	 * @purpose creates CentrexModule object and stores the entire extracted
	 *          value of child elements of CentrexModule xml tags into the
	 *          object
	 */

	public CentrexModule unMarshallCentrexModuleData(Node rootNode) throws UnSupportedTagException {
		CentrexModule centrModule = new CentrexModule();
		Node n;
		NodeList nodes = rootNode.getChildNodes();
		int nodeLength = nodes.getLength();
		for (int i = 0; i < nodeLength; i++) {
			n = nodes.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = n.getNodeName();
				// disp Si.pr(">>>" + n.getNodeName());
				if (nodeName.equals("group")) {
					centrModule.setGroup(unmarshallText(n));
				} else if (nodeName.equals("trunkGroupName")) {
					centrModule.setTrunkGroupName(unmarshallText(n));
				} else if (nodeName.equals("trunkGroupInfo")) {
					centrModule.setTrunkGroupInfo(unmarshallText(n));
				} else if (nodeName.equals("redirectingNumber")) {
					centrModule.setRedirectingNumber(unmarshallText(n));
				} else if (nodeName.equals("redirectingPresentationIndicator")) {
					centrModule.setRedirectingPresentationIndicator(unmarshallText(n));
				} else if (nodeName.equals("redirectingReason")) {
					centrModule.setRedirectingReason(unmarshallText(n));
				} else if (nodeName.equals("extTrackingId")) {
					centrModule.setExtTrackingId(unmarshallText(n));
				} else {
					// throw new UnSupportedTagException("Incorrect Module Tag
					// Found in centrexModule: " + n.getNodeName());
					// BroadworksXmlExtractor.log.info("code centrexmodule: " +
					// n.getNodeName());
					BroadworksXmlExtractor.xmlset.add("centrexmodule:" + n.getNodeName());
				}

			} // end of if loop

			// disp if(i==(nodeLength-1))
			// {
			// Si.pr(centrModule.toString());
			// }

		} // end of for loop
		return centrModule;
	}

	/**
	 * Method-unMarshallIpModuleData
	 * 
	 * @purpose creates IpModule object and stores the entire extracted value of
	 *          child elements of IpModule xml tags into the object
	 */
	public IpModule unMarshallIpModuleData(Node rootNode) throws UnSupportedTagException {
		IpModule ipModule = new IpModule();
		Node n;
		NodeList nodes = rootNode.getChildNodes();
		int nodeLength = nodes.getLength();
		for (int i = 0; i < nodeLength; i++) {
			n = nodes.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = n.getNodeName();
				// disp Si.pr(">>>" + n.getNodeName());
				if (nodeName.equals("route")) {
					ipModule.setRoute(unmarshallText(n));
				} else if (nodeName.equals("networkCallID")) {
					ipModule.setNetworkCallId(unmarshallText(n));
				} else if (nodeName.equals("codec")) {
					ipModule.setCodec(unmarshallText(n));
				} else if (nodeName.equals("accessDeviceAddress")) {
					ipModule.setAccessDeviceAddr(unmarshallText(n));
				} else if (nodeName.equals("accessCallID")) {
					ipModule.setAccessCallId(unmarshallText(n));
				} else if (nodeName.equals("codecUsage")) {
					ipModule.setCodecUsage(unmarshallText(n));
				} else if (nodeName.equals("userAgent")) {
					ipModule.setUserAgent(unmarshallText(n));
				} else {
					// throw new UnSupportedTagException("Incorrect Module Tag
					// Found in IpModule: " + n.getNodeName());
					// BroadworksXmlExtractor.log.info("code IPMODULE: " +
					// n.getNodeName());
					BroadworksXmlExtractor.xmlset.add("IPMODULE:" + n.getNodeName());
				}

			} // end of if loop

			// disp if(i==(nodeLength-1))
			// {
			// Si.pr(ipModule.toString());
			// }

		} // end of for loop
		return ipModule;
	}

	/**
	 * Method-unMarshallHeaderModuleData
	 * 
	 * @purpose creates HeaderModule object and stores the entire extracted
	 *          value of child elements of HeaderModule xml tags into the object
	 */
	public HeaderModule unMarshallHdrModuleData(Node rootNode) throws UnSupportedTagException {
		HeaderModule hdrModule = new HeaderModule();
		Node n;
		NodeList nodes = rootNode.getChildNodes();
		int nodeLength = nodes.getLength();
		for (int i = 0; i < nodeLength; i++) {
			n = nodes.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = n.getNodeName();
				// disp Si.pr(">>>" + n.getNodeName());
				if (nodeName.equals("recordId")) {
					// Si.pr("Node Name: " + n.getNodeName() + "Node Type: " +
					// n.getNodeType() + "Node Value: " + n.getNodeValue());
					hdrModule.addRecordId(unMarshallRecordId(n));
				} else if (nodeName.equals("serviceProvider")) {
					hdrModule.setServiceProvider(unmarshallText(n));
					// Si.pr("Service provider: " + hdrModule.
					// getServiceProvider());
				} else if (nodeName.equals("type")) {
					hdrModule.setType(unmarshallText(n));
				} else {
					// throw new UnSupportedTagException("Incorrect Module Tag
					// Found in HeaderModule: " + n.getNodeName());
					// BroadworksXmlExtractor.log.info("code HeaderModule: " +
					// n.getNodeName());
					BroadworksXmlExtractor.xmlset.add("HeaderModule:" + n.getNodeName());

				}

			} // end of if loop

			// disp if(i==(nodeLength-1))
			// {
			// Si.pr(hdrModule.toString());

			// Si.pr("Service provider: " + hdrModule.getServiceProvider());
			// Si.pr("TYpe: " + hdrModule.getType());
			// }

		} // end of for loop
		return hdrModule;
	}

	/**
	 * Method-unMarshallRecordId
	 * 
	 * @purpose creates RecordId object and stores the entire extracted value of
	 *          child elements of RecordIdModule xml tags into the object
	 */

	public RecordId unMarshallRecordId(Node rootNode) throws UnSupportedTagException {
		RecordId recId = new RecordId();
		Node n;
		NodeList nodes = rootNode.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			n = nodes.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = n.getNodeName();
				// disp Si.pr(">>>>" + n.getNodeName());
				if (nodeName.equals("eventCounter")) {
					recId.setEventCounter(unmarshallText(n));
				} else if (nodeName.equals("systemId")) {
					// Si.pr("Service provider: " + hdrModule.
					// getServiceProvider());
					recId.setSystemId(unmarshallText(n));
				} else if (nodeName.equals("date")) {
					recId.setDate(unmarshallText(n));
				} else if (nodeName.equals("systemTimeZone")) {
					recId.setSysTimeZone(unmarshallText(n));
				} else {
					// throw new UnSupportedTagException("Incorrect Module Tag
					// Found in RecordId: " + n.getNodeName());
					// BroadworksXmlExtractor.log.info("code RecordId: " +
					// n.getNodeName());
					BroadworksXmlExtractor.xmlset.add("RecordId:" + n.getNodeName());
				}

				// Si.pr("Record Id eventcounter: " + recId.getEventCounter() +
				// " SystemId:" + recId.getSystemId());
				// Si.pr("Date: " + recId.getDate() + "SysTimeZone: " +
				// recId.getSysTimeZone());
				// Si.pr(recId.toString());
			} // end of if loop

		} // end of for loop
		return recId;

	}

	/**
	 * Method-unmarshallText
	 * 
	 * @purpose Reads the Text Node and returns back the text part alone
	 */
	private String unmarshallText(Node textNode) {
		StringBuffer buf = new StringBuffer();

		Node n;
		NodeList nodes = textNode.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			n = nodes.item(i);

			if (n.getNodeType() == Node.TEXT_NODE) {
				buf.append(n.getNodeValue());
			} else {
				// expected a text-only node!
			}
		}
		return buf.toString();
	}

}

/**
 * Class-UnSupportedTagException
 * 
 * @purpose Tags which are recognized or coded by the module will throw
 *          UnSupportedTagException exception class
 */
class UnSupportedTagException extends Exception {
	// Parameterless Constructor
	public UnSupportedTagException() {
	}

	// Constructor that accepts a message
	public UnSupportedTagException(String message) {
		super(message);
	}
}

/**
 * Class-GeneralException
 * 
 * @purpose Custom Exception Message of the module will throw GeneralException
 *          class
 */

class GeneralException extends Exception {
	// Parameterless Constructor
	public GeneralException() {
	}

	// Constructor that accepts a message
	public GeneralException(String message) {
		super(message);
	}
}

/**
 * Class-FileNotFoundException
 * 
 * @purpose where there is no input file to be process it will throw an
 *          InputFileNotFoundException class
 */

class InputFileNotFoundException extends Exception {
	// Parameterless Constructor
	public InputFileNotFoundException() {
	}

	// Constructor that accepts a message
	public InputFileNotFoundException(String message) {
		super(message);
	}
}

/**
 * Class-EmailMessage
 * 
 * @purpose Consist of the methods to email the exit status of the module
 */

class XMLValidation {

	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println("EmployeeRequest.xml validates against Employee.xsd? "
	 * +validateXMLSchema("Employee.xsd", "EmployeeRequest.xml"));
	 * System.out.println(
	 * "EmployeeResponse.xml validates against Employee.xsd? "
	 * +validateXMLSchema("Employee.xsd", "EmployeeResponse.xml"));
	 * System.out.println("employee.xml validates against Employee.xsd? "
	 * +validateXMLSchema("Employee.xsd", "employee.xml"));
	 * 
	 * }
	 */

	public static boolean validateXMLSchema(String xsdPath, String xmlPath) {

		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
			return false;
		}
		return true;
	}
}

/*
 * #============================================================================
 * ==# # # # Title BroadworksXmlExtractor class # # # # # # Purpose: Identified
 * the input broadworks xml file, # # Extracts and formats the require xml
 * fields and # # generates the output csv file # # #
 * #============================================================================
 * ==#
 */

public class BroadworksXmlExtractor {
	// public static Logger log = Logger.getLogger(
	// BroadworksXmlExtractor.class.getName());
	// private final static powertel.common.ApplicationProperties
	// applicationProperties =
	// powertel.common.ApplicationProperties.getInstance();
	public static Set<String> xmlset = new HashSet<String>();
	private static Vector<String> xmlFileList = new Vector<String>();

	public static boolean isDirectory(String dirPath) {
		if ((dirPath == null) || (dirPath.equals(""))) {
			return false;
		}
		File f = new File(dirPath);
		if ((!f.exists()) || (!f.isDirectory())) {
			return false;
		}
		return true;
	}

	public static boolean isFile(String dirPath) {
		if ((dirPath == null) || (dirPath.equals(""))) {
			return false;
		}
		File f = new File(dirPath);
		if ((!f.exists()) || (!f.isFile())) {
			return false;
		}
		return true;
	}

	public static void main(String args[]) {
		BroadWorksCDR bwCdr = null;
		Vector<CdrData> cd = null;
		CdrData cdrRec = null;
		HeaderModule hdrModule = null;
		BasicModule basModule = null;
		CentrexModule centrexModule = null;
		IpModule ipModule = null;
		PartialCallBeginModule partialCallBeginModule = null;
		PartialCallEndModule partialCallEndModule = null;
		RecordId recId = null;
		boolean debugLogHeaderOn = false;
		boolean debugBasicLogOn = false;
		boolean debugCentrexLogOn = false;
		boolean debugIpModuleLogOn = false;
		String headerLine = null;
		StringBuffer outRec = new StringBuffer();
		String eventCounter = null;
		String finalOutStr = null;
		String outputFileName = null;
		StringBuffer messageBody = null;
		// EmailMessage em=null;
		String newline = System.getProperty("line.separator");
		int inputFileCnt = 0;
		int valFailCnt = 0;

		String ver = null;
		try {

			String logDir = "D:/99 Projects/04 Amdocs/BMS/task006/test001/"; // TODO
			if ((logDir == null) || (logDir.isEmpty())) {
				// log.error("bwks.pathToLogDir is not found in the
				// Application.Properties file");
				throw new GeneralException("bwks.pathToLogDir is not found from Application properties file");
			}

			StackTraceElement[] stack = Thread.currentThread().getStackTrace();
			StackTraceElement main = stack[stack.length - 1];
			String mainClass = main.getClassName();
			if ((mainClass == null) || (mainClass.isEmpty())) {
				System.out.println("cannot proceed without knowing the class name");
				System.exit(2);

			}
			java.util.Date now = new java.util.Date(); // java.util.Date, NOT
														// java.sql.Date or
														// java.sql.Timestamp!
			String format3 = new SimpleDateFormat("yyyyMMddHHmmss").format(now);
			String logFileName = mainClass + "." + format3 + ".log";
			System.out.println("\n**************Log file for this run: " + logFileName + "\n**************\n");
			// Logger rootLogger = Logger.getRootLogger();
			// Enumeration appenders = rootLogger.getAllAppenders();
			// FileAppender fa = null;
			// while(appenders.hasMoreElements())
			// {
			// Appender currAppender = (Appender) appenders.nextElement();
			// if(currAppender instanceof FileAppender)
			// {
			// fa = (FileAppender) currAppender;
			// }
			// }
			// if(fa != null)
			// {
			// // System.out.println("Appender append value: " +
			// fa.getAppend());
			// // fa.setFile("/asm/home/asmtst01/xmlparser/log/" + logFileName);
			// fa.setFile(logDir + "/" + logFileName);
			// fa.activateOptions();
			// }
			// else
			// {
			// System.out.println("No File Appender found");
			// System.exit(2);
			// }

			String inputDir = "D:/99 Projects/04 Amdocs/BMS/task006/test001/"; // TODO
			if ((inputDir == null) || (inputDir.isEmpty())) {
				// log.error("bwks.pathToInputDir is not found in the
				// Application.Properties file");
				throw new GeneralException("bwks.pathToInputDir not found from Application properties file");
			}
			if (!isDirectory(inputDir)) {
				// log.error("Not a Valid Directory" + inputDir);
				throw new GeneralException("Not a Valid Directory" + inputDir);
			}

			String outputDir = "D:/99 Projects/04 Amdocs/BMS/task006/test001/";// TODO
			if ((outputDir == null) || (outputDir.isEmpty())) {
				// log.error("bwks.pathToOutputDir is not found in the
				// Application.Properties file");
				throw new GeneralException("bwks.pathToOutputDir not found from Application properties file");
			}
			if (!isDirectory(outputDir)) {
				// log.error("Not a Valid Directory" + outputDir);
				throw new GeneralException("Not a Valid Directory" + outputDir);
			}

			final String bwksPattern = ".*xml$"; // TODO
			if ((bwksPattern == null) || (bwksPattern.isEmpty())) {
				// log.error("bwksPattern is not found in the
				// Application.Properties file");
				throw new GeneralException("bwksPattern is not found from Application properties file");
			}

			String archiveDir = "D:/99 Projects/04 Amdocs/BMS/task006/test001/";// TODO
			if ((archiveDir == null) || (archiveDir.isEmpty())) {
				// log.error("archiveDir is not found in the
				// Application.Properties file");
				throw new GeneralException("archiveDir is not found from Application properties file");
			}
			if (!isDirectory(archiveDir)) {
				// log.error("Not a Valid Directory" + archiveDir);
				throw new GeneralException("Not a Valid Directory" + archiveDir);
			}

			String errorDir = "D:/99 Projects/04 Amdocs/BMS/task006/test001/";// TODO
			if ((errorDir == null) || (errorDir.isEmpty())) {
				// log.error("errorDir is not found in the
				// Application.Properties file");
				throw new GeneralException("errorDir is not found from Application properties file");
			}

			String xsdFilePath = "D:/99 Projects/04 Amdocs/BMS/task006/test001/BizPhonesCDR.xsd"; // TODO
			if ((xsdFilePath == null) || (xsdFilePath.isEmpty())) {
				// log.error("xsdFilePath is not found in the
				// Application.Properties file");
				throw new GeneralException("xsdFilePath is not found from Application properties file");
			}

			if (!isFile(xsdFilePath)) {
				// log.error("Not a Valid File" + xsdFilePath);
				throw new GeneralException("Not a Valid File" + xsdFilePath);
			}

			// log.info("****Application properties File***");
			// log.info("bwks.pathToInputFile: " + inputDir);
			// log.info("bwks.pathToOutputFile: " + outputDir);
			// log.info("bwks.archiveDir: " + archiveDir);
			// log.info("bwks.filepattern: " + bwksPattern);
			// log.info("mail.smtp.server: " + smtpServer);
			// log.info("mail.smtp.toEmail: " + smtpToEmailList);
			// log.info("mail.smtp.fromEmail: " + smtpFromEmail);
			// log.info("bwks.pathToLogDir: " + logDir);
			// log.info("bwks.pathToErrorDir: " + errorDir);
			// log.info("bwks.xsdfile: " + xsdFilePath);
			// log.info("**********************************");

			// Configuring the email
			// em=new
			// EmailMessage("aravindan.ramachandran@aapt.com.au","broadworks@aapt.com.au","localhost");
			// em=new EmailMessage(smtpToEmailList,smtpFromEmail,smtpServer);

			// final String pattern="^BW.*\\.xml$";
			File f = new File(inputDir); // current directory

			FilenameFilter textFilter = new FilenameFilter() {
				public boolean accept(File dir, String name) {
					// String lowercaseName = name.toLowerCase();
					// if (lowercaseName.endsWith(".xml")) {
					if (name.matches(bwksPattern)) {
						return true;
					} else {
						return false;
					}
				}
			};

			File[] files = f.listFiles(textFilter);
			valFailCnt = 0;
			inputFileCnt = 0;
			for (File dfile : files) {
				if (dfile.isDirectory()) {
					// System.out.println("directory:" + dfile.getName());
					continue;
				} else {
					xmlFileList.addElement(dfile.getCanonicalPath());
					inputFileCnt++;
					outputFileName = outputDir + "/" + dfile.getName() + ".csv";
					File file = new File(dfile.getCanonicalPath());

					// log.info("Extracting the xml file1: " +
					// dfile.getCanonicalPath() );
					// log.info("outputfilename: " + outputFileName);
					java.util.Date nowarch = new java.util.Date(); // java.util.Date,
																	// NOT
																	// java.sql.Date
																	// or
																	// java.sql.Timestamp!
					String formatArch = new SimpleDateFormat("yyyyMMddHHmmss").format(now);
					String archiveFileName = dfile.getName() + "." + formatArch;
					// log.info("archivefilename: " + archiveFileName);

					// boolean
					// retVal=XMLValidation.validateXMLSchema("/asm/home/asmtst01/xmlparser/classes/broadWorksCDR.xsd",
					// dfile.getCanonicalPath());
					// log.info("xsd filepath: " + xsdFilePath);
					boolean retVal = XMLValidation.validateXMLSchema(xsdFilePath, dfile.getCanonicalPath());
					// boolean retVal=true;
					if (retVal) {
						// log.info("Successfully Validating the xml file: " +
						// dfile.getCanonicalPath());
					} else {
						// log.error("Failed Validating the xml file: " +
						// dfile.getCanonicalPath());
						boolean movFlag = dfile.renameTo(new File(errorDir + "/" + dfile.getName()));
						if (!movFlag) {
							 System.out.println("Unable to Move the Input File from " +
							 dfile.getCanonicalPath() + " to " + errorDir +
							 "/" + dfile.getName());
							throw new GeneralException("Unable to Move the Input File from " + dfile.getCanonicalPath()
									+ " to " + errorDir + "/" + dfile.getName());
						} else {
							 System.out.println("successfully moved the input file: " +
							 dfile.getCanonicalPath() + " to " + errorDir +
							 "/" + dfile.getName());
						}

						valFailCnt++;
						continue;
					}

					FileWriter writer = new FileWriter(outputFileName);
					BufferedReader br = new BufferedReader(new FileReader("D:/99 Projects/04 Amdocs/BMS/task006/test001/header.csv"));
					InputSource src = new InputSource(new FileInputStream(file));
					DomBroadworksUnmarshaller domUms = new DomBroadworksUnmarshaller();

					org.apache.xerces.parsers.DOMParser prsr = new org.apache.xerces.parsers.DOMParser();
					prsr.parse(src);
					Document doc = prsr.getDocument();
					bwCdr = domUms.unMarshallBroadWorksCDR(doc.getDocumentElement());
					cd = bwCdr.getCdrData();
					ver = bwCdr.getVersion();
					int lineCnt = 0;
					while ((headerLine = br.readLine()) != null) {
						lineCnt++;
						writer.append(headerLine);
						writer.append('\n');
					}
					if (lineCnt != 2) {
						throw new GeneralException("header line not found from header.csv file");
					}

					for (int i = 0; i < cd.size(); i++) {
						cdrRec = cd.elementAt(i);
						hdrModule = cdrRec.getHeaderModule();
						basModule = cdrRec.getBasicModule();
						centrexModule = cdrRec.getCentrexModule();
						ipModule = cdrRec.getIpModule();
						partialCallBeginModule = cdrRec.getPartialCallBeginModule();
						partialCallEndModule = cdrRec.getPartialCallEndModule();

						// -------------------- Header Module
						// ---------------------- //

						recId = hdrModule.getRecordId();

						// Clear the Out buffer
						Si.clearOutStr();
						/*
						 * 
						 * //field 1 recId-eventcounter-Header
						 * Si.appendOutStr(recId.getEventCounter());
						 * 
						 * //field 2 recId-SystemId-Header
						 * Si.appendOutStr(recId.getSystemId());
						 * 
						 * //field 3 recId-Date-Header
						 * Si.appendOutStr(recId.getDate());
						 * 
						 * //field 4 recId-systimezone-Header
						 * Si.appendOutStr(recId.getSysTimeZone());
						 */

						// field 1 RecordId
						Si.appendOutStr(recId.getRecordIdStr());

						// field 2 serviceProvider-Header
						Si.appendOutStr(hdrModule.getServiceProvider());

						// field 3 type-Header
						Si.appendOutStr(hdrModule.getType());

						// field 4 userNumber
						Si.appendOutStr(basModule.getUserNumber());

						// field 5 groupNumber
						Si.appendOutStr(basModule.getGroupNumber());

						// field 6 direction
						Si.appendOutStr(basModule.getDirection());

						// field 7 callingNumber
						Si.appendOutStr(basModule.getCallingNumber());

						// field 8 callingPresentationIndicator
						Si.appendOutStr(basModule.getCallingPresentationIndication());

						// field 9 calledNumber
						Si.appendOutStr(basModule.getCalledNumber());

						// field 10 Starttime
						Si.appendOutStr(basModule.getStartTime());

						// field 11 UserTimeZone
						Si.appendOutStr(basModule.getUserTimeZone());

						// field 12 answerIndicator
						Si.appendOutStr(basModule.getAnswerIndicator());

						// field 13 answerTime
						Si.appendOutStr(basModule.getAnswerTime());

						// field 14 releaseTime
						Si.appendOutStr(basModule.getReleaseTime());

						// field 15 terminationCause
						Si.appendOutStr(basModule.getTerminationCause());

						// field 16 networkType(need)
						Si.appendOutStr(null);

						// field 17 carrierIdentificationCode
						Si.appendOutStr(basModule.getCarrierIdentificationCode());

						// field 18 dialedDigits
						Si.appendOutStr(basModule.getDialedDigit());

						// field 19 callCategory
						Si.appendOutStr(basModule.getCallCategory());

						// field 20 networkCallType
						Si.appendOutStr(basModule.getNetworkCallType());

						// field 21 networkTranslatedNumber
						Si.appendOutStr(basModule.getNetworkTranslatedNumber());

						// field 22 networkTranslatedGroup
						Si.appendOutStr(basModule.getNetworkTranslatedGroup());

						// field 23 releasingParty
						Si.appendOutStr(basModule.getReleasingParty());

						// field 24 route
						Si.appendOutStr(ipModule.getRoute());

						// field 25 networkCallId
						Si.appendOutStr(ipModule.getNetworkCallId());

						// field 26 codec
						Si.appendOutStr(ipModule.getCodec());

						// field 27 accessDeviceAddress
						Si.appendOutStr(ipModule.getAccessDeviceAddr());

						// field 28 accessCallID
						Si.appendOutStr(ipModule.getAccessCallId());

						// field 29 Spare
						Si.appendOutStr(null);

						// field 30 failoverCorrelationId
						Si.appendOutStr(null);

						// field 31 Spare
						Si.appendOutStr(null);

						// field 32 group
						Si.appendOutStr(centrexModule.getGroup());

						// field 33 department-centrex
						Si.appendOutStr(null);

						// field 34 accountCode-centrex
						Si.appendOutStr(null);

						// field 35 authorizationCode-centrex
						Si.appendOutStr(null);

						// field 36 originalCalledNumber-centrex
						Si.appendOutStr(null);

						// field 37 OriginalCalledPresentationIndicator-centrex
						Si.appendOutStr(null);

						// field 38 OriginalCalledReason-centrex
						Si.appendOutStr(null);

						// field 39 redirectingNumber-centrex
						Si.appendOutStr(centrexModule.getRedirectingNumber());

						// field 40 redirectedPresentationIndicator-centrex
						Si.appendOutStr(centrexModule.getRedirectingPresentationIndicator());

						// field 41 redirectingReason-centrex
						Si.appendOutStr(centrexModule.getRedirectingReason());

						// field 42 chargeIndicator
						Si.appendOutStr(basModule.getchargeIndicator());

						// field 43 typeOfNetwork
						Si.appendOutStr(basModule.getTypeOfNetwork());

						// field 44 voicePortalCalling.invocationTime-centrex
						Si.appendOutStr(null);

						// field 45 LocalCallId
						Si.appendOutStr(basModule.getLocalCallId());

						// field 46 remoteCallId(need)
						Si.appendOutStr(basModule.getRemoteCallId());

						// field 47 callingPartyCategory
						Si.appendOutStr(null);

						// field 48 instantconference.invocationTime
						// field 49 instantconference.callId
						// field 50 instantConference.to
						// field 51 instantConference.from
						// field 52 instantConference.conferenceId
						// field 53 instantConference.role
						// field 58
						for (int ctr = 1; ctr <= 11; ctr++) {
							Si.appendOutStr(null);
						}
						// field 59 key-IP
						// field 60 creator-IP
						// field 61 OriginatorNetwork-IP
						// field 62 TerminatorNetwork-IP
						for (int ctr = 1; ctr <= 4; ctr++) {
							Si.appendOutStr(null);
						}
						// 63-120 centrex Fields
						for (int ctr = 1; ctr <= 58; ctr++) {
							Si.appendOutStr(null);
						}
						// field 121 userId-basmodule
						Si.appendOutStr(basModule.getUserId());

						// field 122 otherPartyName (need)
						Si.appendOutStr(basModule.getOtherPartyName());

						// field 123 OtherPartyNamePresentationIndicator
						Si.appendOutStr(null);

						// field 124-134 -centrex fields
						for (int ctr = 1; ctr <= 11; ctr++) {
							Si.appendOutStr(null);
						}

						// field 135 trunkGroupName
						Si.appendOutStr(centrexModule.getTrunkGroupName());

						// Field 136 -140 centrex fields
						for (int ctr = 1; ctr <= 5; ctr++) {
							Si.appendOutStr(null);
						}
						// field 141 clidPermitted
						Si.appendOutStr(basModule.getClidPermitted());

						// field 142-143
						for (int ctr = 1; ctr <= 2; ctr++) {
							Si.appendOutStr(null);
						}

						// field 144 accessNetworkInfo-IP
						Si.appendOutStr(null);

						// field 145 chargingfunctionaddresses-IP
						Si.appendOutStr(null);

						// field 146-187 centrex
						// field 146-156
						for (int ctr = 1; ctr <= 11; ctr++) {
							Si.appendOutStr(null);
						}

						// field 157
						Si.appendOutStr(ipModule.getCodecUsage());

						// field 158-181
						for (int ctr = 1; ctr <= 24; ctr++) {
							Si.appendOutStr(null);
						}
						// field 182 trunkgroupinfo
						Si.appendOutStr(centrexModule.getTrunkGroupInfo());

						// field 183-187
						for (int ctr = 1; ctr <= 5; ctr++) {
							Si.appendOutStr(null);
						}
						// field 188-192 basic
						// module(need)q850Cause,dialedDigitsContext,calledNumberContext,networkTranslatedNumberContext,callingNumberContext
						for (int ctr = 1; ctr <= 5; ctr++) {
							Si.appendOutStr(null);
						}
						// field 193-197 centrex
						for (int ctr = 1; ctr <= 5; ctr++) {
							Si.appendOutStr(null);
						}

						// field 198 routingNumber-IP
						Si.appendOutStr(null);

						// field 199-field 208 centrex
						for (int ctr = 1; ctr <= 10; ctr++) {
							Si.appendOutStr(null);
						}

						// field 209-220 3gpp
						for (int ctr = 1; ctr <= 12; ctr++) {
							Si.appendOutStr(null);
						}

						// field 221 otherInfoInPCV-IP
						Si.appendOutStr(null);

						// field 222 receivedCallingNumber-basicmodule(need)
						Si.appendOutStr(null);

						// field 223-230 centrex
						for (int ctr = 1; ctr <= 8; ctr++) {
							Si.appendOutStr(null);
						}
						// field 231 asCallType
						Si.appendOutStr(basModule.getAsCallType());

						// field 232 -271
						for (int ctr = 1; ctr <= 40; ctr++) {
							Si.appendOutStr(null);
						}
						// Field 272
						Si.appendOutStr(basModule.getNamePermitted());

						// Field 273 - 293
						for (int ctr = 1; ctr <= 21; ctr++) {
							Si.appendOutStr(null);
						}

						// field 294
						Si.appendOutStr(null);

						// field 295
						Si.appendOutStr(partialCallBeginModule.getFailOverCorrelationId());

						// field 296
						Si.appendLastStr(partialCallEndModule.getFailOverCorrelationId());

						// field 297
						Si.appendOutStr(basModule.getcallingPresentationNumber());

						// field 298
						Si.appendOutStr(basModule.getcallingAssertedNumber());

						// field 299 extTrackingId-centrex
						Si.appendOutStr(centrexModule.getExtTrackingId());

						// field 300 UserAgent
						Si.appendOutStr(ipModule.getUserAgent());

						finalOutStr = Si.getOutStr();

						if (debugLogHeaderOn) {
							Si.pr(" ");
							Si.pr("*****Header Module*****");
							Si.pr("Record Id- EventCounter:" + recId.getEventCounter());
							Si.pr("Record Id-SystemId:" + recId.getSystemId());
							Si.pr("Record Id-date:" + recId.getDate());
							Si.pr("Record Id-SysTimeZone:" + recId.getSysTimeZone());

							Si.pr("Service Id: " + hdrModule.getServiceProvider());
							Si.pr("Type:" + hdrModule.getType());

							// log.debug("*****Header Module*****");
							// log.debug("Record Id- EventCounter:" +
							// recId.getEventCounter());
							Si.pr("Record Id-SystemId:" + recId.getSystemId());
							Si.pr("Record Id-date:" + recId.getDate());
							Si.pr("Record Id-SysTimeZone:" + recId.getSysTimeZone());

							Si.pr("Service Id: " + hdrModule.getServiceProvider());
							Si.pr("Type:" + hdrModule.getType());
						}

						// log.debug("*****Header Module*****");
						// log.debug("Record Id- EventCounter:" +
						// recId.getEventCounter());
						// log.debug("Record Id-SystemId:" +
						// recId.getSystemId());
						// log.debug("Record Id-date:" + recId.getDate());
						// log.debug("Record Id-SysTimeZone:" +
						// recId.getSysTimeZone());
						//
						// log.debug("Service Id: " +
						// hdrModule.getServiceProvider());
						// log.debug("Type:" + hdrModule.getType());

						// ----------------- Basic Module
						// --------------------------//

						if (debugBasicLogOn) {
							Si.pr(" ");
							Si.pr("*****Basic Module*****");
							Si.pr("UserNumber: " + basModule.getUserNumber());
							Si.pr("Direction: " + basModule.getDirection());
							Si.pr("Group Number: " + basModule.getGroupNumber());
							Si.pr("Carrier Identification Code: " + basModule.getCarrierIdentificationCode());
							Si.pr("Network Translated Group: " + basModule.getNetworkTranslatedGroup());
							Si.pr("AsCallType: " + basModule.getAsCallType());
							Si.pr("CallingNumber: " + basModule.getCallingNumber());
							Si.pr("CallingPresentationIndication: " + basModule.getCallingPresentationIndication());
							Si.pr("Dialed Digit: " + basModule.getDialedDigit());
							Si.pr("Called Number: " + basModule.getCalledNumber());
							Si.pr("Network Translated Number: " + basModule.getNetworkTranslatedNumber());
							Si.pr("StartTime: " + basModule.getStartTime());
							Si.pr("UserTimeZone: " + basModule.getUserTimeZone());
							Si.pr("Localcallid: " + basModule.getLocalCallId());
							Si.pr("Remotecallid: " + basModule.getRemoteCallId());
							Si.pr("Answer Indicator: " + basModule.getAnswerIndicator());
							Si.pr("Answer Time: " + basModule.getAnswerTime());
							Si.pr("Release Time: " + basModule.getReleaseTime());
							Si.pr("Termination Cause: " + basModule.getTerminationCause());
							Si.pr("Call Category: " + basModule.getCallCategory());
							Si.pr("Network Call type: " + basModule.getNetworkCallType());
							Si.pr("Charge Indicator: " + basModule.getchargeIndicator());
							Si.pr("Type of Network: " + basModule.getTypeOfNetwork());
							Si.pr("Releasing Party: " + basModule.getReleasingParty());
							Si.pr("UserId: " + basModule.getUserId());
							Si.pr("clid permitted: " + basModule.getClidPermitted());
							Si.pr("Name permitted: " + basModule.getNamePermitted());
							Si.pr("OtherPartyName: " + basModule.getOtherPartyName());
							Si.pr("callingPresentationNumber: " + basModule.getcallingPresentationNumber());
							Si.pr("callingAssertedNumber: " + basModule.getcallingAssertedNumber());
						}

						//
						// log.debug("*****Basic Module*****");
						// log.debug("UserNumber: " +
						// basModule.getUserNumber());
						// log.debug("Direction: " + basModule.getDirection());
						// log.debug("Group Number: " +
						// basModule.getGroupNumber());
						// log.debug("Carrier Identification Code: " +
						// basModule.getCarrierIdentificationCode());
						// log.debug("Network Translated Group: " +
						// basModule.getNetworkTranslatedGroup());
						// log.debug("AsCallType: " +
						// basModule.getAsCallType());
						// log.debug("CallingNumber: " +
						// basModule.getCallingNumber());
						// log.debug("CallingPresentationIndication: " +
						// basModule.getCallingPresentationIndication());
						// log.debug("Dialed Digit: " +
						// basModule.getDialedDigit());
						// log.debug("Called Number: " +
						// basModule.getCalledNumber());
						// log.debug("Network Translated Number: " +
						// basModule.getNetworkTranslatedNumber());
						// log.debug("StartTime: " + basModule.getStartTime());
						// log.debug("UserTimeZone: "
						// +basModule.getUserTimeZone());
						// log.debug("Localcallid: "
						// +basModule.getLocalCallId());
						// log.debug("Remotecallid: "
						// +basModule.getRemoteCallId());
						// log.debug("Answer Indicator: "
						// +basModule.getAnswerIndicator());
						// log.debug("Answer Time: "
						// +basModule.getAnswerTime());
						// log.debug("Release Time: "
						// +basModule.getReleaseTime());
						// log.debug("Termination Cause: "
						// +basModule.getTerminationCause());
						// log.debug("Call Category: "
						// +basModule.getCallCategory());
						// log.debug("Network Call type: " +
						// basModule.getNetworkCallType());
						// log.debug("Charge Indicator: "
						// +basModule.getchargeIndicator());
						// log.debug("Type of Network: " +
						// basModule.getTypeOfNetwork());
						// log.debug("Releasing Party: " +
						// basModule.getReleasingParty());
						// log.debug("UserId: " + basModule.getUserId());
						// log.debug("clid permitted: " +
						// basModule.getClidPermitted());
						// log.debug("Name permitted: " +
						// basModule.getNamePermitted());
						// log.debug("OtherPartyName: " +
						// basModule.getOtherPartyName());
						// log.debug("callingPresentationNumber: " +
						// basModule.getcallingPresentationNumber());
						// log.debug("callingAssertedNumber: " +
						// basModule.getcallingAssertedNumber());

						// --------------------------Centrex Module
						// ----------------------//
						if (debugCentrexLogOn) {
							Si.pr(" ");
							Si.pr("*****Centrex Module*****");
							Si.pr("group: " + centrexModule.getGroup());
							Si.pr("Trunk group Name: " + centrexModule.getTrunkGroupName());
							Si.pr("Trunk group Info: " + centrexModule.getTrunkGroupInfo());
							Si.pr("RedirectingNumber: " + centrexModule.getRedirectingNumber());
							Si.pr("RedirectingPresentationIndicator: "
									+ centrexModule.getRedirectingPresentationIndicator());
							Si.pr("RedirectingReason: " + centrexModule.getRedirectingReason());
							Si.pr("ExtTrackingId: " + centrexModule.getExtTrackingId());
						}

						// log.debug("*****Centrex Module*****");
						// log.debug("group: "+centrexModule.getGroup());
						// log.debug("Trunk group Name: " +
						// centrexModule.getTrunkGroupName());
						// log.debug("Trunk group Info: "
						// +centrexModule.getTrunkGroupInfo());
						// log.debug("RedirectingNumber: "
						// +centrexModule.getRedirectingNumber());
						// log.debug("RedirectingPresentationIndicator: "
						// +centrexModule.getRedirectingPresentationIndicator());
						// log.debug("RedirectingReason: "
						// +centrexModule.getRedirectingReason());
						// log.debug("ExtTrackingId: "
						// +centrexModule.getExtTrackingId());

						// ----------------------------IP Module
						// ------------------------//
						if (debugIpModuleLogOn) {
							Si.pr(" ");
							Si.pr("*****Ip Module*****");
							Si.pr("Route: " + ipModule.getRoute());
							Si.pr("Codec: " + ipModule.getCodec());
							Si.pr("Codec Usage: " + ipModule.getCodecUsage());
							Si.pr("Access Device Addr: " + ipModule.getAccessDeviceAddr());
							Si.pr("Access Call Id: " + ipModule.getAccessCallId());
							Si.pr("Network Call Id: " + ipModule.getNetworkCallId());
						}

						// log.debug("*****Ip Module*****");
						// log.debug("Route: " + ipModule.getRoute());
						// log.debug("Codec: " + ipModule.getCodec());
						// log.debug("Codec Usage: " +
						// ipModule.getCodecUsage());
						// log.debug("Access Device Addr: " +
						// ipModule.getAccessDeviceAddr());
						// log.debug("Access Call Id: " +
						// ipModule.getAccessCallId());
						// log.debug("Network Call Id: " +
						// ipModule.getNetworkCallId());

						// Si.pr(finalOutStr);
						writer.append(finalOutStr);
						writer.append('\n');

					} // end of for loop
					Si.pr("Total cdrdata size: " + cd.size());
					// log.info("Total cdrdata size: " + cd.size());

					writer.flush();
					writer.close();
					if (br != null)
						br.close();

					boolean movFlag = dfile.renameTo(new File(archiveDir + "/" + archiveFileName));
					if (!movFlag) {
						// log.error("Unable to Move the Input File from " +
						// dfile.getCanonicalPath() + " to " + archiveDir + "/"
						// + archiveFileName);
						throw new GeneralException("Unable to Move the Input File from " + dfile.getCanonicalPath()
								+ " to " + archiveDir + "/" + archiveFileName);
					} else {
						// log.info("successfully moved the input file: " +
						// dfile.getCanonicalPath() + " to " + archiveDir + "/"
						// + archiveFileName);
					}

				} // end of else loop
					// System.out.println(file.getCanonicalPath());
			} // end of outer for loop

			// log.info("Tags that are not handled:" +xmlset);
			if (valFailCnt > 0) {
				// log.error("XML File Failed Validation:" + valFailCnt);
				throw new GeneralException("XML File Failed Validation:" + valFailCnt);
			}
			if (inputFileCnt == 0) {
				// log.error("No Input XML Files Found");
				throw new InputFileNotFoundException("No Input XML Files Found");
			}

			Si.pr("Total Input Files: " + inputFileCnt);
			Si.pr("XML File Failed Validation:" + valFailCnt);
			// log.info("Total Input Files: " + inputFileCnt);
			// log.info("XML File Failed Validation:" + valFailCnt);
			// messageBody=new StringBuffer();
			// messageBody.append("Total Input Files: " + inputFileCnt).append(
			// newline );
			// messageBody.append("Validation Failed Files: " +
			// valFailCnt).append( newline );
			// for( int i=0; i<xmlFileList.size(); i++ ){
			// messageBody.append( xmlFileList.elementAt(i) ).append( newline );
			// }
			//// log.info("*** XML Extractor Completed Successfully *****");
			// try {
			// em.SendEmailMessageList("XML Extractor Completed
			// Successfully",messageBody.toString());
			// }
			// catch(Exception e) {
			// log.error("XML Extractor Completed Successfully but email not
			// sent " + messageBody.toString());
			// System.exit(2);
			// }
			System.exit(0);

		} catch (Exception ex) {
			// log.error("Exception:" , ex);
			ex.printStackTrace();

			Si.pr("Total Input Files: " + inputFileCnt);
			// log.info("Total Input Files: " + inputFileCnt);
			// log.error("XML File Failed Validation:" + valFailCnt);

			// messageBody=new StringBuffer();
			// messageBody.append("Total Input Files: " + inputFileCnt).append(
			// newline );
			// messageBody.append("Validation Failed Files: " +
			// valFailCnt).append( newline );
			// for( int i=0; i<xmlFileList.size(); i++ ){
			// messageBody.append( xmlFileList.elementAt(i) ).append( newline );
			// }
			//// log.error("*** XML Extractor Failed *****");
			//
			// try {
			// em.SendEmailMessageList("XML Extractor Failed " + ((ex instanceof
			// InputFileNotFoundException) ? "-No Input XML Files" :
			// ""),messageBody.toString());
			// }
			// catch(Exception e) {
			// log.error("XML Extractor Failed but email not sent " +
			// messageBody.toString());
			// }
			if (ex instanceof InputFileNotFoundException) {
				System.exit(99);
			} else {
				System.exit(2);
			}
		}

	}
}

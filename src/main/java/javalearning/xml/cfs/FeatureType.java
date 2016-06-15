//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.14 at 11:04:31 AM AEST 
//


package javalearning.xml.cfs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeatureType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FeatureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ArReactivationDelaySetup"/>
 *     &lt;enumeration value="AcReactivationDelaySetup"/>
 *     &lt;enumeration value="ArReactivationBusyRingback"/>
 *     &lt;enumeration value="AcReactivationBusyRingback"/>
 *     &lt;enumeration value="ArReactivationDelayTimeout"/>
 *     &lt;enumeration value="AcReactivationDelayTimeout"/>
 *     &lt;enumeration value="ArReactivationDelayCust"/>
 *     &lt;enumeration value="AcDeactivation"/>
 *     &lt;enumeration value="SelectiveCallForwarding"/>
 *     &lt;enumeration value="AnonCallRejectActivation"/>
 *     &lt;enumeration value="AnonCallRejectDeactivation"/>
 *     &lt;enumeration value="AnonCallRejectContinuation"/>
 *     &lt;enumeration value="ArActivationImmed"/>
 *     &lt;enumeration value="AcActivationImmed"/>
 *     &lt;enumeration value="ArActivationDelaySetup"/>
 *     &lt;enumeration value="AcActivationDelaySetup"/>
 *     &lt;enumeration value="ArActivationBusyRingback"/>
 *     &lt;enumeration value="AcActivationBusyRingback"/>
 *     &lt;enumeration value="ArActivationDelayTimeout"/>
 *     &lt;enumeration value="AcActivationDelayTimeout"/>
 *     &lt;enumeration value="ArActivationDelayCust"/>
 *     &lt;enumeration value="AcReactivationDelayCust"/>
 *     &lt;enumeration value="CustomerOriginatedTraceActivation"/>
 *     &lt;enumeration value="SelectiveCallRejection"/>
 *     &lt;enumeration value="DistinctiveRingingCallWaiting"/>
 *     &lt;enumeration value="ScreeningListEditingDailyContRecord"/>
 *     &lt;enumeration value="CallingNumDeliveryBlockingActivation"/>
 *     &lt;enumeration value="SelectiveCallAcceptance"/>
 *     &lt;enumeration value="CallingNumberDelivery"/>
 *     &lt;enumeration value="CallingNameDelivery"/>
 *     &lt;enumeration value="BulkCallingLineIdentification"/>
 *     &lt;enumeration value="CallingIdentityDeliveryAndSuppression"/>
 *     &lt;enumeration value="CallingNameDeliveryBlocking"/>
 *     &lt;enumeration value="CNDandCNAM"/>
 *     &lt;enumeration value="CallWaitingDeluxe"/>
 *     &lt;enumeration value="ARStage1"/>
 *     &lt;enumeration value="BurstCall"/>
 *     &lt;enumeration value="NoFeature"/>
 *     &lt;enumeration value="ThreeWayCall"/>
 *     &lt;enumeration value="UnconditionalOrSelectiveCallForwarding"/>
 *     &lt;enumeration value="BusyOrDelayedCallForwarding"/>
 *     &lt;enumeration value="UsageSensitiveThreeWayCall"/>
 *     &lt;enumeration value="DefaultAINServiceFeature"/>
 *     &lt;enumeration value="WakeupAlarmActivation"/>
 *     &lt;enumeration value="UsageSensitiveCallForwarding"/>
 *     &lt;enumeration value="UsageSensitiveCallWaiting"/>
 *     &lt;enumeration value="CallDeliveryToCallWaiting"/>
 *     &lt;enumeration value="LastCallReturn"/>
 *     &lt;enumeration value="CallContentChannel"/>
 *     &lt;enumeration value="LineHunting"/>
 *     &lt;enumeration value="FMFM"/>
 *     &lt;enumeration value="Monitor"/>
 *     &lt;enumeration value="Whisper"/>
 *     &lt;enumeration value="BargeIn"/>
 *     &lt;enumeration value="UnconditionalCallForwarding"/>
 *     &lt;enumeration value="SelectiveCallForwarding"/>
 *     &lt;enumeration value="BusyCallForwarding"/>
 *     &lt;enumeration value="DelayedCallForwarding"/>
 *     &lt;enumeration value="MandatoryAccountCode"/>
 *     &lt;enumeration value="CallBarringActivate"/>
 *     &lt;enumeration value="CallBarringDeactivate"/>
 *     &lt;enumeration value="LegPartOfForwardedCall"/>
 *     &lt;enumeration value="ReminderCall"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FeatureType")
@XmlEnum
public enum FeatureType {


    /**
     * Automatic Recall reactivation: delayed processing
     *             resulting in attempted call setup.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 32
     *           
     * 
     */
    @XmlEnumValue("ArReactivationDelaySetup")
    AR_REACTIVATION_DELAY_SETUP("ArReactivationDelaySetup"),

    /**
     * Automatic Callback reactivation: delayed processing
     *             resulting in attempted call setup.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 33
     *           
     * 
     */
    @XmlEnumValue("AcReactivationDelaySetup")
    AC_REACTIVATION_DELAY_SETUP("AcReactivationDelaySetup"),

    /**
     * Automatic Recall reactivation: Busy ringback; no
     *             resumption of scanning.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 34
     *           
     * 
     */
    @XmlEnumValue("ArReactivationBusyRingback")
    AR_REACTIVATION_BUSY_RINGBACK("ArReactivationBusyRingback"),

    /**
     * Automatic Callback reactivation: Busy ringback; no
     *             resumption of scanning.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 35
     *           
     * 
     */
    @XmlEnumValue("AcReactivationBusyRingback")
    AC_REACTIVATION_BUSY_RINGBACK("AcReactivationBusyRingback"),

    /**
     * Automatic Recall reactivation: delayed processing
     *             resulting in timeout.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 36
     *           
     * 
     */
    @XmlEnumValue("ArReactivationDelayTimeout")
    AR_REACTIVATION_DELAY_TIMEOUT("ArReactivationDelayTimeout"),

    /**
     * Automatic Callback reactivation: delayed processing
     *             resulting in timeout.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 37
     *           
     * 
     */
    @XmlEnumValue("AcReactivationDelayTimeout")
    AC_REACTIVATION_DELAY_TIMEOUT("AcReactivationDelayTimeout"),

    /**
     * Automatic Recall reactivation: delayed processing
     *             ended by customer deactivation or extended by reactivation.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 38
     *           
     * 
     */
    @XmlEnumValue("ArReactivationDelayCust")
    AR_REACTIVATION_DELAY_CUST("ArReactivationDelayCust"),

    /**
     * Automatic Callback Deactivation: delayed processing
     *             ended by customer deactivation.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 39
     *           
     * 
     */
    @XmlEnumValue("AcDeactivation")
    AC_DEACTIVATION("AcDeactivation"),

    /**
     * Selective Call Forwarding.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 52
     *           
     * 
     */
    @XmlEnumValue("SelectiveCallForwarding")
    SELECTIVE_CALL_FORWARDING("SelectiveCallForwarding"),

    /**
     * Anonymous Call Rejection: Activation.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 57
     *           
     * 
     */
    @XmlEnumValue("AnonCallRejectActivation")
    ANON_CALL_REJECT_ACTIVATION("AnonCallRejectActivation"),

    /**
     * Anonymous Call Rejection: deactivation.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 58
     *           
     * 
     */
    @XmlEnumValue("AnonCallRejectDeactivation")
    ANON_CALL_REJECT_DEACTIVATION("AnonCallRejectDeactivation"),

    /**
     * Anonymous Call Rejection: continuation.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 59
     *           
     * 
     */
    @XmlEnumValue("AnonCallRejectContinuation")
    ANON_CALL_REJECT_CONTINUATION("AnonCallRejectContinuation"),

    /**
     * Automatic Recall activation: delayed processing
     *             resulting in attempted call setup.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 60
     *           
     * 
     */
    @XmlEnumValue("ArActivationImmed")
    AR_ACTIVATION_IMMED("ArActivationImmed"),

    /**
     * Automatic Callback activation: delayed processing
     *             resulting in attempted call setup.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 61
     *           
     * 
     */
    @XmlEnumValue("AcActivationImmed")
    AC_ACTIVATION_IMMED("AcActivationImmed"),

    /**
     * Automatic Recall activation: delayed processing
     *             resulting in attempted call setup.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 62
     *           
     * 
     */
    @XmlEnumValue("ArActivationDelaySetup")
    AR_ACTIVATION_DELAY_SETUP("ArActivationDelaySetup"),

    /**
     * Automatic Callback activation: delayed processing
     *             resulting in attempted call setup.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 63
     *           
     * 
     */
    @XmlEnumValue("AcActivationDelaySetup")
    AC_ACTIVATION_DELAY_SETUP("AcActivationDelaySetup"),

    /**
     * Automatic Recall activation: Busy ringback; no
     *             resumption of scanning.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 64
     *           
     * 
     */
    @XmlEnumValue("ArActivationBusyRingback")
    AR_ACTIVATION_BUSY_RINGBACK("ArActivationBusyRingback"),

    /**
     * Automatic Callback activation: Busy ringback; no
     *             resumption of scanning.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 65
     *           
     * 
     */
    @XmlEnumValue("AcActivationBusyRingback")
    AC_ACTIVATION_BUSY_RINGBACK("AcActivationBusyRingback"),

    /**
     * Automatic Recall activation: delayed processing
     *             resulting in timeout.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 66
     *           
     * 
     */
    @XmlEnumValue("ArActivationDelayTimeout")
    AR_ACTIVATION_DELAY_TIMEOUT("ArActivationDelayTimeout"),

    /**
     * Automatic Callback activation: delayed processing
     *             resulting in timeout.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 67
     *           
     * 
     */
    @XmlEnumValue("AcActivationDelayTimeout")
    AC_ACTIVATION_DELAY_TIMEOUT("AcActivationDelayTimeout"),

    /**
     * Automatic Recall activation: delayed processing ended
     *             by customer deactivation or extended by reactivation.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 68
     *           
     * 
     */
    @XmlEnumValue("ArActivationDelayCust")
    AR_ACTIVATION_DELAY_CUST("ArActivationDelayCust"),

    /**
     * Automatic Callback Reactivation: delayed processing
     *             extended by reactivation.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 69
     *           
     * 
     */
    @XmlEnumValue("AcReactivationDelayCust")
    AC_REACTIVATION_DELAY_CUST("AcReactivationDelayCust"),

    /**
     * Customer Originated Trace activation.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 70
     *           
     * 
     */
    @XmlEnumValue("CustomerOriginatedTraceActivation")
    CUSTOMER_ORIGINATED_TRACE_ACTIVATION("CustomerOriginatedTraceActivation"),

    /**
     * Selective Call Rejection.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 72
     *           
     * 
     */
    @XmlEnumValue("SelectiveCallRejection")
    SELECTIVE_CALL_REJECTION("SelectiveCallRejection"),

    /**
     * Distinctive Ringing / Call Waiting.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 73
     *           
     * 
     */
    @XmlEnumValue("DistinctiveRingingCallWaiting")
    DISTINCTIVE_RINGING_CALL_WAITING("DistinctiveRingingCallWaiting"),

    /**
     * Screening List Editing daily continuation record.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 74
     *           
     * 
     */
    @XmlEnumValue("ScreeningListEditingDailyContRecord")
    SCREENING_LIST_EDITING_DAILY_CONT_RECORD("ScreeningListEditingDailyContRecord"),

    /**
     * Calling Number Delivery Blocking activation.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 75
     *           
     * 
     */
    @XmlEnumValue("CallingNumDeliveryBlockingActivation")
    CALLING_NUM_DELIVERY_BLOCKING_ACTIVATION("CallingNumDeliveryBlockingActivation"),

    /**
     * Selective Call Acceptance.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 79
     *           
     * 
     */
    @XmlEnumValue("SelectiveCallAcceptance")
    SELECTIVE_CALL_ACCEPTANCE("SelectiveCallAcceptance"),

    /**
     * Calling Number Delivery.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 80
     *           
     * 
     */
    @XmlEnumValue("CallingNumberDelivery")
    CALLING_NUMBER_DELIVERY("CallingNumberDelivery"),

    /**
     * Calling Name Delivery.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 82
     *           
     * 
     */
    @XmlEnumValue("CallingNameDelivery")
    CALLING_NAME_DELIVERY("CallingNameDelivery"),

    /**
     * Bulk Calling Line Identification.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 84
     *             CLASS Feature Code (see Table 415, GR-1100-CORE)
     *           
     * 
     */
    @XmlEnumValue("BulkCallingLineIdentification")
    BULK_CALLING_LINE_IDENTIFICATION("BulkCallingLineIdentification"),

    /**
     * Calling Identity Delivery and Suppression.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 85
     *           
     * 
     */
    @XmlEnumValue("CallingIdentityDeliveryAndSuppression")
    CALLING_IDENTITY_DELIVERY_AND_SUPPRESSION("CallingIdentityDeliveryAndSuppression"),

    /**
     * Calling Name Delivery Blocking.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 86
     *           
     * 
     */
    @XmlEnumValue("CallingNameDeliveryBlocking")
    CALLING_NAME_DELIVERY_BLOCKING("CallingNameDeliveryBlocking"),

    /**
     * CND and CNAM (both assigned).
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 87
     *           
     * 
     */
    @XmlEnumValue("CNDandCNAM")
    CN_DAND_CNAM("CNDandCNAM"),

    /**
     * Call Waiting Deluxe.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 89
     *           
     * 
     */
    @XmlEnumValue("CallWaitingDeluxe")
    CALL_WAITING_DELUXE("CallWaitingDeluxe"),

    /**
     * Automatic Recall: Completion of the first stage of
     *             two stage AR.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 95
     *           
     * 
     */
    @XmlEnumValue("ARStage1")
    AR_STAGE_1("ARStage1"),

    /**
     * Burst Call.
     *             CLASS Feature Code (see Table 415, GR-1100-CORE) 200
     *           
     * 
     */
    @XmlEnumValue("BurstCall")
    BURST_CALL("BurstCall"),

    /**
     * No service feature.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 0
     *           
     * 
     */
    @XmlEnumValue("NoFeature")
    NO_FEATURE("NoFeature"),

    /**
     * Three way call.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 10
     *           
     * 
     */
    @XmlEnumValue("ThreeWayCall")
    THREE_WAY_CALL("ThreeWayCall"),

    /**
     * Unconditional or Selective Call forwarding.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 12
     *           
     * 
     */
    @XmlEnumValue("UnconditionalOrSelectiveCallForwarding")
    UNCONDITIONAL_OR_SELECTIVE_CALL_FORWARDING("UnconditionalOrSelectiveCallForwarding"),

    /**
     * Busy or delayed call forwarding.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 14
     *           
     * 
     */
    @XmlEnumValue("BusyOrDelayedCallForwarding")
    BUSY_OR_DELAYED_CALL_FORWARDING("BusyOrDelayedCallForwarding"),

    /**
     * Usage sensitive three way call.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 18
     *           
     * 
     */
    @XmlEnumValue("UsageSensitiveThreeWayCall")
    USAGE_SENSITIVE_THREE_WAY_CALL("UsageSensitiveThreeWayCall"),

    /**
     * Default AIN service feature.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 27
     *           
     * 
     */
    @XmlEnumValue("DefaultAINServiceFeature")
    DEFAULT_AIN_SERVICE_FEATURE("DefaultAINServiceFeature"),

    /**
     * Wakeup alarm activation.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 31
     *           
     * 
     */
    @XmlEnumValue("WakeupAlarmActivation")
    WAKEUP_ALARM_ACTIVATION("WakeupAlarmActivation"),

    /**
     * Usage sensitive call forwarding.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 49
     *           
     * 
     */
    @XmlEnumValue("UsageSensitiveCallForwarding")
    USAGE_SENSITIVE_CALL_FORWARDING("UsageSensitiveCallForwarding"),

    /**
     * Usage sensitive call waiting (vendor specific).
     *             Service Feature Code (see Table 12, GR-1100-CORE) 50
     *           
     * 
     */
    @XmlEnumValue("UsageSensitiveCallWaiting")
    USAGE_SENSITIVE_CALL_WAITING("UsageSensitiveCallWaiting"),

    /**
     * Call delivery to call waiting (vendor specific).
     *             Service Feature Code (see Table 12, GR-1100-CORE) 83
     *           
     * 
     */
    @XmlEnumValue("CallDeliveryToCallWaiting")
    CALL_DELIVERY_TO_CALL_WAITING("CallDeliveryToCallWaiting"),

    /**
     * Last call return.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 154
     *           
     * 
     */
    @XmlEnumValue("LastCallReturn")
    LAST_CALL_RETURN("LastCallReturn"),

    /**
     * Call Content Channel: this is a vendor-specific
     *             service feature code used for Call Content Channels.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 800
     *           
     * 
     */
    @XmlEnumValue("CallContentChannel")
    CALL_CONTENT_CHANNEL("CallContentChannel"),

    /**
     * Line hunting: this is a vendor-specific service
     *             feature code use when a service provider configures the switch to
     *             do so, to make it easier not to bill subscribers for line hunting.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 801
     *           
     * 
     */
    @XmlEnumValue("LineHunting")
    LINE_HUNTING("LineHunting"),

    /**
     * Find-Me Follow-Me: this is a vendor-specific service
     *             feature code used to bill subscribers for FMFM.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 802
     *           
     * 
     */
    FMFM("FMFM"),

    /**
     * This is a vendor-specific service feature code used
     *             to identify a call where a subscriber has dialed the monitor
     *             access code.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 802
     *           
     * 
     */
    @XmlEnumValue("Monitor")
    MONITOR("Monitor"),

    /**
     * This is a vendor-specific service feature code used
     *             to identify a call where a subscriber has dialed the whisper
     *             access code.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 802
     *           
     * 
     */
    @XmlEnumValue("Whisper")
    WHISPER("Whisper"),

    /**
     * This is a vendor-specific service feature code used
     *             to identify a call where a subscriber has dialed the barge-in
     *             access code.
     *             Service Feature Code (see Table 12, GR-1100-CORE) 802
     *           
     * 
     */
    @XmlEnumValue("BargeIn")
    BARGE_IN("BargeIn"),

    /**
     * Unconditional forwarding: used to distinguish between
     *             the two scenarios in the Telcordia Service Feature Code 12 (see
     *             Table 12, GR-1100-CORE).
     *           
     * 
     */
    @XmlEnumValue("UnconditionalCallForwarding")
    UNCONDITIONAL_CALL_FORWARDING("UnconditionalCallForwarding"),

    /**
     * Busy call forwarding: used to distinguish between
     *             the two scenarios in the Telcordia Service Feature Code 14 (see
     *             Table 12, GR-1100-CORE).
     *           
     * 
     */
    @XmlEnumValue("BusyCallForwarding")
    BUSY_CALL_FORWARDING("BusyCallForwarding"),

    /**
     * Delayed call forwarding: used to distinguish between
     *             the two scenarios in the Telcordia Service Feature Code 14 (see
     *             Table 12, GR-1100-CORE).
     *           
     * 
     */
    @XmlEnumValue("DelayedCallForwarding")
    DELAYED_CALL_FORWARDING("DelayedCallForwarding"),

    /**
     * The user provided an Account Code in order to
     *             authenticate themselves to the ANI screening / Mandatory Account
     *             Codes service.
     *           
     * 
     */
    @XmlEnumValue("MandatoryAccountCode")
    MANDATORY_ACCOUNT_CODE("MandatoryAccountCode"),

    /**
     * Call barring activation.
     *           
     * 
     */
    @XmlEnumValue("CallBarringActivate")
    CALL_BARRING_ACTIVATE("CallBarringActivate"),

    /**
     * Call barring deactivation.
     *           
     * 
     */
    @XmlEnumValue("CallBarringDeactivate")
    CALL_BARRING_DEACTIVATE("CallBarringDeactivate"),

    /**
     * The leg was part of a forwarded call. In a forwarding
     *             scenario where A called B who forwarded the call to C, this element
     *             will appear in the CDRs for both the A-B and B-C legs of the call.
     *             The downstream billing systems can disambiguate which leg of the
     *             call is being referred to by the presence in the B-C CDR of another
     *             <Feature> element specifying the forwarding reason.
     * 
     *             Introduced: Version 1.0, Compatibility Level 2.
     *           
     * 
     */
    @XmlEnumValue("LegPartOfForwardedCall")
    LEG_PART_OF_FORWARDED_CALL("LegPartOfForwardedCall"),

    /**
     * Reminder call.
     * 
     *              Introduced: Version 1.0, Compatibility Level 6.
     *            
     * 
     */
    @XmlEnumValue("ReminderCall")
    REMINDER_CALL("ReminderCall");
    private final String value;

    FeatureType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FeatureType fromValue(String v) {
        for (FeatureType c: FeatureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

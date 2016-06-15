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
 * <p>Java class for SkipReasonType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SkipReasonType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SignalChannelOffline"/>
 *     &lt;enumeration value="MediaChannelOffline"/>
 *     &lt;enumeration value="SignalStackRejected"/>
 *     &lt;enumeration value="SignalChannelRejected"/>
 *     &lt;enumeration value="SignalChannelCongested"/>
 *     &lt;enumeration value="MediaChannelCongested"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SkipReasonType")
@XmlEnum
public enum SkipReasonType {


    /**
     * The signaling associated with the channel was offline.
     *           
     * 
     */
    @XmlEnumValue("SignalChannelOffline")
    SIGNAL_CHANNEL_OFFLINE("SignalChannelOffline"),

    /**
     * The media associated with the channel was offline.
     *           
     * 
     */
    @XmlEnumValue("MediaChannelOffline")
    MEDIA_CHANNEL_OFFLINE("MediaChannelOffline"),

    /**
     * The request was rejected by the signaling stack
     *             associated with the channel.
     *           
     * 
     */
    @XmlEnumValue("SignalStackRejected")
    SIGNAL_STACK_REJECTED("SignalStackRejected"),

    /**
     * The request was rejected by the signaling channel
     *             associated with the channel.
     *           
     * 
     */
    @XmlEnumValue("SignalChannelRejected")
    SIGNAL_CHANNEL_REJECTED("SignalChannelRejected"),

    /**
     * The signaling channel is congested and the request was
     *             rejected to reduce the level of traffic.
     *           
     * 
     */
    @XmlEnumValue("SignalChannelCongested")
    SIGNAL_CHANNEL_CONGESTED("SignalChannelCongested"),

    /**
     * The media circuits associated with the channel are
     *             congested and the request was rejected to reduce the level of
     *             traffic.
     *           
     * 
     */
    @XmlEnumValue("MediaChannelCongested")
    MEDIA_CHANNEL_CONGESTED("MediaChannelCongested");
    private final String value;

    SkipReasonType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SkipReasonType fromValue(String v) {
        for (SkipReasonType c: SkipReasonType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

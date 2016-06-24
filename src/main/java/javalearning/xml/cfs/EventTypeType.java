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
 * <p>Java class for EventTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EventTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="FeatureActivation"/>
 *     &lt;enumeration value="FeatureDeactivation"/>
 *     &lt;enumeration value="FeatureUsage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EventTypeType")
@XmlEnum
public enum EventTypeType {


    /**
     * It is not known what kind of event generated the CDR.
     *             This value is not expected in normal CDRs.
     *           
     * 
     */
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),

    /**
     * The CDR was generated by the activation of a feature.
     *           
     * 
     */
    @XmlEnumValue("FeatureActivation")
    FEATURE_ACTIVATION("FeatureActivation"),

    /**
     * The CDR was generated by the deactivation of a
     *             feature.
     *           
     * 
     */
    @XmlEnumValue("FeatureDeactivation")
    FEATURE_DEACTIVATION("FeatureDeactivation"),

    /**
     * The CDR was generated by the use of the management
     *             features of the service. Note that this does not refer to the
     *             service itself: for example, with Selective Call Forwarding this
     *             may be generated by listening to the current destination, not when
     *             a call is forwarded by the service.
     *           
     * 
     */
    @XmlEnumValue("FeatureUsage")
    FEATURE_USAGE("FeatureUsage");
    private final String value;

    EventTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EventTypeType fromValue(String v) {
        for (EventTypeType c: EventTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
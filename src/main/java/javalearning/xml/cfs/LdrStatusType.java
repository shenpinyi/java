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
 * <p>Java class for LdrStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LdrStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FirstLDR"/>
 *     &lt;enumeration value="IntermediateLDR"/>
 *     &lt;enumeration value="LastLDR"/>
 *     &lt;enumeration value="NoLDR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LdrStatusType")
@XmlEnum
public enum LdrStatusType {


    /**
     * The long duration call record is the first generated
     *             for this call.
     *           
     * 
     */
    @XmlEnumValue("FirstLDR")
    FIRST_LDR("FirstLDR"),

    /**
     * The long duration call record is the second or
     *             subsequent generated for this call.
     *           
     * 
     */
    @XmlEnumValue("IntermediateLDR")
    INTERMEDIATE_LDR("IntermediateLDR"),

    /**
     * The long duration call record is the last generated
     *             for this call and represents the call termination.
     *           
     * 
     */
    @XmlEnumValue("LastLDR")
    LAST_LDR("LastLDR"),

    /**
     * This is not a long duration call record. This value
     *             should not be seen in CDRs.
     *           
     * 
     */
    @XmlEnumValue("NoLDR")
    NO_LDR("NoLDR");
    private final String value;

    LdrStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LdrStatusType fromValue(String v) {
        for (LdrStatusType c: LdrStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
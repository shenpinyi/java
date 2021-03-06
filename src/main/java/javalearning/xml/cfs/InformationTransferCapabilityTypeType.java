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
 * <p>Java class for InformationTransferCapabilityTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InformationTransferCapabilityTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="itu"/>
 *     &lt;enumeration value="iso"/>
 *     &lt;enumeration value="national"/>
 *     &lt;enumeration value="network"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InformationTransferCapabilityTypeType")
@XmlEnum
public enum InformationTransferCapabilityTypeType {


    /**
     * ITU-T standardized coding as specified in Q.931.
     *           
     * 
     */
    @XmlEnumValue("itu")
    ITU("itu"),

    /**
     * ISO/IEC Standard.
     *           
     * 
     */
    @XmlEnumValue("iso")
    ISO("iso"),

    /**
     * National standard.
     *           
     * 
     */
    @XmlEnumValue("national")
    NATIONAL("national"),

    /**
     * Standard defined for the network (either public or
     *             private) present on the network side of the interface.
     *           
     * 
     */
    @XmlEnumValue("network")
    NETWORK("network");
    private final String value;

    InformationTransferCapabilityTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InformationTransferCapabilityTypeType fromValue(String v) {
        for (InformationTransferCapabilityTypeType c: InformationTransferCapabilityTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

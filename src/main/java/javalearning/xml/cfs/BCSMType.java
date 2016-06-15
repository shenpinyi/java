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
 * <p>Java class for BCSMType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BCSMType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="orig"/>
 *     &lt;enumeration value="term"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BCSMType")
@XmlEnum
public enum BCSMType {


    /**
     * The originating basic call state model.
     *           
     * 
     */
    @XmlEnumValue("orig")
    ORIG("orig"),

    /**
     * The terminating basic call state model.
     *           
     * 
     */
    @XmlEnumValue("term")
    TERM("term");
    private final String value;

    BCSMType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BCSMType fromValue(String v) {
        for (BCSMType c: BCSMType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

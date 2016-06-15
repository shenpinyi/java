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
 * <p>Java class for NpSourceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NpSourceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Query"/>
 *     &lt;enumeration value="Switch"/>
 *     &lt;enumeration value="Signaling"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NpSourceType")
@XmlEnum
public enum NpSourceType {


    /**
     * The Number Portability information came from an LNP
     *             query.
     *           
     * 
     */
    @XmlEnumValue("Query")
    QUERY("Query"),

    /**
     * The Number Portability information came from LNP
     *             information configured on the switch.
     * 
     */
    @XmlEnumValue("Switch")
    SWITCH("Switch"),

    /**
     * The Number Portability information came from
     *             signaling.
     *           
     * 
     */
    @XmlEnumValue("Signaling")
    SIGNALING("Signaling");
    private final String value;

    NpSourceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NpSourceType fromValue(String v) {
        for (NpSourceType c: NpSourceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

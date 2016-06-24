//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.14 at 11:04:31 AM AEST 
//


package javalearning.xml.cfs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Specifies information about the Information Transfer
 *         Capability as signaled in the ISUP, corresponding to the Bearer
 *         Capabilities in Q.931. See that standard for the meaning of the values.
 * 
 *         Introduced: Version 1.0, Compatibility Level 2.
 *       
 * 
 * <p>Java class for InformationTransferCapabilityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InformationTransferCapabilityType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.metaswitch.com/cfs/billing/V1.0>FiveBitValueType">
 *       &lt;attribute name="type" type="{http://www.metaswitch.com/cfs/billing/V1.0}InformationTransferCapabilityTypeType" default="itu" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InformationTransferCapabilityType", propOrder = {
    "value"
})
public class InformationTransferCapabilityType {

    @XmlValue
    protected short value;
    @XmlAttribute(name = "type")
    protected InformationTransferCapabilityTypeType type;

    /**
     * An unsigned number in range 0-31.
     *       
     * 
     */
    public short getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(short value) {
        this.value = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link InformationTransferCapabilityTypeType }
     *     
     */
    public InformationTransferCapabilityTypeType getType() {
        if (type == null) {
            return InformationTransferCapabilityTypeType.ITU;
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformationTransferCapabilityTypeType }
     *     
     */
    public void setType(InformationTransferCapabilityTypeType value) {
        this.type = value;
    }

}
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.14 at 11:04:31 AM AEST 
//


package javalearning.xml.cfs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies information about the User Service Information
 *         signaled in the ISUP, corresponding to the Bearer Capabilities in
 *         Q.931.
 * 
 *         Introduced: Version 1.0, Compatibility Level 2.
 *       
 * 
 * <p>Java class for UserServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserServiceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InformationTransferCapability" type="{http://www.metaswitch.com/cfs/billing/V1.0}InformationTransferCapabilityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserServiceType", propOrder = {
    "informationTransferCapability"
})
public class UserServiceType {

    @XmlElement(name = "InformationTransferCapability")
    protected InformationTransferCapabilityType informationTransferCapability;

    /**
     * Gets the value of the informationTransferCapability property.
     * 
     * @return
     *     possible object is
     *     {@link InformationTransferCapabilityType }
     *     
     */
    public InformationTransferCapabilityType getInformationTransferCapability() {
        return informationTransferCapability;
    }

    /**
     * Sets the value of the informationTransferCapability property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformationTransferCapabilityType }
     *     
     */
    public void setInformationTransferCapability(InformationTransferCapabilityType value) {
        this.informationTransferCapability = value;
    }

}

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
 * Specifies information about the handling of a call in
 *         Routing. There are some circumstances where CDRs are generated for
 *         call legs that do not go through Routing, for example the CDR that is
 *         generated for a Conference Bridge in a conference call, in which case
 *         all of the elements within the RoutingInfo may be absent.
 *       
 * 
 * <p>Java class for RoutingInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoutingInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestedAddr" type="{http://www.metaswitch.com/cfs/billing/V1.0}AddressType" minOccurs="0"/>
 *         &lt;element name="DestAddr" type="{http://www.metaswitch.com/cfs/billing/V1.0}AddressType" minOccurs="0"/>
 *         &lt;element name="RoutedAddr" type="{http://www.metaswitch.com/cfs/billing/V1.0}AddressType" minOccurs="0"/>
 *         &lt;element name="CallingPartyRoutedAddr" type="{http://www.metaswitch.com/cfs/billing/V1.0}AddressType" minOccurs="0"/>
 *         &lt;element name="CallingPartyOrigAddr" type="{http://www.metaswitch.com/cfs/billing/V1.0}AddressType" minOccurs="0"/>
 *         &lt;element name="FailedTrunkGroups" type="{http://www.metaswitch.com/cfs/billing/V1.0}FailedTrunkGroupsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoutingInfoType", propOrder = {
    "requestedAddr",
    "destAddr",
    "routedAddr",
    "callingPartyRoutedAddr",
    "callingPartyOrigAddr",
    "failedTrunkGroups"
})
public class RoutingInfoType {

    @XmlElement(name = "RequestedAddr")
    protected AddressType requestedAddr;
    @XmlElement(name = "DestAddr")
    protected AddressType destAddr;
    @XmlElement(name = "RoutedAddr")
    protected AddressType routedAddr;
    @XmlElement(name = "CallingPartyRoutedAddr")
    protected AddressType callingPartyRoutedAddr;
    @XmlElement(name = "CallingPartyOrigAddr")
    protected AddressType callingPartyOrigAddr;
    @XmlElement(name = "FailedTrunkGroups")
    protected FailedTrunkGroupsType failedTrunkGroups;

    /**
     * Gets the value of the requestedAddr property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getRequestedAddr() {
        return requestedAddr;
    }

    /**
     * Sets the value of the requestedAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setRequestedAddr(AddressType value) {
        this.requestedAddr = value;
    }

    /**
     * Gets the value of the destAddr property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getDestAddr() {
        return destAddr;
    }

    /**
     * Sets the value of the destAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setDestAddr(AddressType value) {
        this.destAddr = value;
    }

    /**
     * Gets the value of the routedAddr property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getRoutedAddr() {
        return routedAddr;
    }

    /**
     * Sets the value of the routedAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setRoutedAddr(AddressType value) {
        this.routedAddr = value;
    }

    /**
     * Gets the value of the callingPartyRoutedAddr property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getCallingPartyRoutedAddr() {
        return callingPartyRoutedAddr;
    }

    /**
     * Sets the value of the callingPartyRoutedAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setCallingPartyRoutedAddr(AddressType value) {
        this.callingPartyRoutedAddr = value;
    }

    /**
     * Gets the value of the callingPartyOrigAddr property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getCallingPartyOrigAddr() {
        return callingPartyOrigAddr;
    }

    /**
     * Sets the value of the callingPartyOrigAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setCallingPartyOrigAddr(AddressType value) {
        this.callingPartyOrigAddr = value;
    }

    /**
     * Gets the value of the failedTrunkGroups property.
     * 
     * @return
     *     possible object is
     *     {@link FailedTrunkGroupsType }
     *     
     */
    public FailedTrunkGroupsType getFailedTrunkGroups() {
        return failedTrunkGroups;
    }

    /**
     * Sets the value of the failedTrunkGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link FailedTrunkGroupsType }
     *     
     */
    public void setFailedTrunkGroups(FailedTrunkGroupsType value) {
        this.failedTrunkGroups = value;
    }

}

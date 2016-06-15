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
 * This value represents the value of the Echo Control Device
 *         Indicator signalled in an ISUP call.
 * 
 *         Introduced: Version 1.0, Compatibility Level 7.
 *       
 * 
 * <p>Java class for EchoControlInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EchoControlInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Recv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EchoControlInfoType", propOrder = {
    "sent",
    "recv"
})
public class EchoControlInfoType {

    @XmlElement(name = "Sent")
    protected String sent;
    @XmlElement(name = "Recv")
    protected String recv;

    /**
     * Gets the value of the sent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSent() {
        return sent;
    }

    /**
     * Sets the value of the sent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSent(String value) {
        this.sent = value;
    }

    /**
     * Gets the value of the recv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecv() {
        return recv;
    }

    /**
     * Sets the value of the recv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecv(String value) {
        this.recv = value;
    }

}

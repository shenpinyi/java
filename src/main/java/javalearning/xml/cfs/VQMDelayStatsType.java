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
 * Defines VQM delay stats
 * 
 * <p>Java class for VQMDelayStatsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VQMDelayStatsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EndSystemDelay" type="{http://www.metaswitch.com/cfs/billing/V1.0}DelayType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VQMDelayStatsType", propOrder = {
    "endSystemDelay"
})
public class VQMDelayStatsType {

    @XmlElement(name = "EndSystemDelay")
    protected String endSystemDelay;

    /**
     * Gets the value of the endSystemDelay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndSystemDelay() {
        return endSystemDelay;
    }

    /**
     * Sets the value of the endSystemDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndSystemDelay(String value) {
        this.endSystemDelay = value;
    }

}
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.14 at 11:04:31 AM AEST 
//


package javalearning.xml.cfs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the details of a single trunk that was either
 *         skipped or tried and failed during routing.
 *       
 * 
 * <p>Java class for FailedTrunkGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FailedTrunkGroupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TrunkGroupId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Reason" type="{http://www.metaswitch.com/cfs/billing/V1.0}TrunkFailReasonType" maxOccurs="2"/>
 *       &lt;/sequence>
 *       &lt;attribute name="trunkaccounting" type="{http://www.metaswitch.com/cfs/billing/V1.0}TrunkAccountingType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FailedTrunkGroupType", propOrder = {
    "trunkGroupId",
    "reason"
})
public class FailedTrunkGroupType {

    @XmlElement(name = "TrunkGroupId")
    protected int trunkGroupId;
    @XmlElement(name = "Reason", required = true)
    protected List<TrunkFailReasonType> reason;
    @XmlAttribute(name = "trunkaccounting")
    protected String trunkaccounting;

    /**
     * Gets the value of the trunkGroupId property.
     * 
     */
    public int getTrunkGroupId() {
        return trunkGroupId;
    }

    /**
     * Sets the value of the trunkGroupId property.
     * 
     */
    public void setTrunkGroupId(int value) {
        this.trunkGroupId = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrunkFailReasonType }
     * 
     * 
     */
    public List<TrunkFailReasonType> getReason() {
        if (reason == null) {
            reason = new ArrayList<TrunkFailReasonType>();
        }
        return this.reason;
    }

    /**
     * Gets the value of the trunkaccounting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrunkaccounting() {
        return trunkaccounting;
    }

    /**
     * Sets the value of the trunkaccounting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrunkaccounting(String value) {
        this.trunkaccounting = value;
    }

}

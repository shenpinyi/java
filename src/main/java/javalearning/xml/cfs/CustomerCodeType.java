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
 * Specifies the customer code associated with a call. The
 *         namespace of the customer code may depend on the underlying signaling
 *         technology so the type attribute should be used to decide how to
 *         interpret the value.
 * 
 *         Introduced: Version 1.0, Compatibility Level 2.
 *       
 * 
 * <p>Java class for CustomerCodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerCodeType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.metaswitch.com/cfs/billing/V1.0>CustomerCodeValueType">
 *       &lt;attribute name="type" use="required" type="{http://www.metaswitch.com/cfs/billing/V1.0}CustomerCodeTypeType" />
 *       &lt;attribute name="qualifier" type="{http://www.metaswitch.com/cfs/billing/V1.0}CustomerCodeQualifierType" />
 *       &lt;attribute name="service" type="{http://www.metaswitch.com/cfs/billing/V1.0}CustomerCodeServiceType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerCodeType", propOrder = {
    "value"
})
public class CustomerCodeType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "type", required = true)
    protected CustomerCodeTypeType type;
    @XmlAttribute(name = "qualifier")
    protected String qualifier;
    @XmlAttribute(name = "service")
    protected String service;

    /**
     * The customer code value for this call.
     * 
     *         Introduced: Version 1.0, Compatibility Level 2.
     *       
     * 
     * The customer code value may be a German-UKK
     *           (GermanUKKValueType) or an unknown customer code
     *           (CustomerCodeUnknownValueType).
     *         
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerCodeTypeType }
     *     
     */
    public CustomerCodeTypeType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerCodeTypeType }
     *     
     */
    public void setType(CustomerCodeTypeType value) {
        this.type = value;
    }

    /**
     * Gets the value of the qualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualifier() {
        return qualifier;
    }

    /**
     * Sets the value of the qualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualifier(String value) {
        this.qualifier = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

}

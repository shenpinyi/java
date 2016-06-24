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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the overall structure of the file, comprising a
 *         header, the body of CDRs and a footer.
 *       
 * 
 * <p>Java class for FileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileHeader" type="{http://www.metaswitch.com/cfs/billing/V1.0}FileHeaderType"/>
 *         &lt;element name="CDRs" type="{http://www.metaswitch.com/cfs/billing/V1.0}CdrsType"/>
 *         &lt;element name="FileFooter" type="{http://www.metaswitch.com/cfs/billing/V1.0}FileFooterType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="compatibility" type="{http://www.metaswitch.com/cfs/billing/V1.0}SchemaCompatibilityType" default="1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileType", propOrder = {
    "fileHeader",
    "cdRs",
    "fileFooter"
})
public class FileType {

    @XmlElement(name = "FileHeader", required = true)
    protected FileHeaderType fileHeader;
    @XmlElement(name = "CDRs", required = true)
    protected CdrsType cdRs;
    @XmlElement(name = "FileFooter", required = true)
    protected FileFooterType fileFooter;
    @XmlAttribute(name = "compatibility")
    protected Long compatibility;

    /**
     * Gets the value of the fileHeader property.
     * 
     * @return
     *     possible object is
     *     {@link FileHeaderType }
     *     
     */
    public FileHeaderType getFileHeader() {
        return fileHeader;
    }

    /**
     * Sets the value of the fileHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileHeaderType }
     *     
     */
    public void setFileHeader(FileHeaderType value) {
        this.fileHeader = value;
    }

    /**
     * Gets the value of the cdRs property.
     * 
     * @return
     *     possible object is
     *     {@link CdrsType }
     *     
     */
    public CdrsType getCDRs() {
        return cdRs;
    }

    /**
     * Sets the value of the cdRs property.
     * 
     * @param value
     *     allowed object is
     *     {@link CdrsType }
     *     
     */
    public void setCDRs(CdrsType value) {
        this.cdRs = value;
    }

    /**
     * Gets the value of the fileFooter property.
     * 
     * @return
     *     possible object is
     *     {@link FileFooterType }
     *     
     */
    public FileFooterType getFileFooter() {
        return fileFooter;
    }

    /**
     * Sets the value of the fileFooter property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileFooterType }
     *     
     */
    public void setFileFooter(FileFooterType value) {
        this.fileFooter = value;
    }

    /**
     * Gets the value of the compatibility property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getCompatibility() {
        if (compatibility == null) {
            return  1L;
        } else {
            return compatibility;
        }
    }

    /**
     * Sets the value of the compatibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCompatibility(Long value) {
        this.compatibility = value;
    }

}
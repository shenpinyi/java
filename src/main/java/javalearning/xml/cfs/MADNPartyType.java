//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.14 at 11:04:31 AM AEST 
//


package javalearning.xml.cfs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the details of a user with a Multiple Appearance
 *         Directory Number (MADN) on this system.
 * 
 *         This is a concrete derivation of the abstract PartyType. Parsers may
 *         use the value of the attribute xsi:type, which will be set to
 *         "MADNPartyType" to determine what kind of party is being described.
 *       
 * 
 * <p>Java class for MADNPartyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MADNPartyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.metaswitch.com/cfs/billing/V1.0}PartyType">
 *       &lt;sequence>
 *         &lt;element name="SubscriberAddr" type="{http://www.metaswitch.com/cfs/billing/V1.0}AddressType"/>
 *         &lt;element name="CallingPartyAddr" type="{http://www.metaswitch.com/cfs/billing/V1.0}AddressType"/>
 *         &lt;element name="ChargeAddr" type="{http://www.metaswitch.com/cfs/billing/V1.0}AddressType"/>
 *         &lt;element name="BusinessGroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIPCallId" type="{http://www.metaswitch.com/cfs/billing/V1.0}SIPCallIdType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="subscribergroup" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="privacy" use="required" type="{http://www.metaswitch.com/cfs/billing/V1.0}PrivacyType" />
 *       &lt;attribute name="billingtype" use="required" type="{http://www.metaswitch.com/cfs/billing/V1.0}BillingTypeType" />
 *       &lt;attribute name="cpc" type="{http://www.metaswitch.com/cfs/billing/V1.0}CallingPartyCategoryType" />
 *       &lt;attribute name="ani-ii" type="{http://www.metaswitch.com/cfs/billing/V1.0}ANI-IIType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MADNPartyType")
public class MADNPartyType
    extends PartyType
{


}

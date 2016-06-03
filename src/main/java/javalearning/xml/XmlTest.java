package javalearning.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlTest {

	public static void main(String[] args) {

		validateXml();
	}

	private static void validateXml() {
		File schemaFile;
		String path = "D:/99 Projects/04 Amdocs/BMS/task006/";
		String xsdname = "BizPhonesCDR.xsd";
		String xmlname = "BW-CDR-20160602130000-2-0050560115C7-008341.xml.Error";
		schemaFile = new File(path + xsdname);

		Source xmlFile = new StreamSource(new File(path + xmlname));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema;
		try {
			schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);
			System.out.println(xmlFile.getSystemId() + " is valid");
		} catch (SAXException | IOException e) {
			System.out.println(xmlFile.getSystemId() + " is NOT valid");
			System.out.println("Reason: " + e.getLocalizedMessage());
		}
	}

}

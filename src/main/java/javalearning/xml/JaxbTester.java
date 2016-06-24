package javalearning.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import javalearning.xml.cfs.AddressType;
import javalearning.xml.cfs.AddressesType;
import javalearning.xml.cfs.AppServerPartyType;
import javalearning.xml.cfs.BusinessLinePartyType;
import javalearning.xml.cfs.CallType;
import javalearning.xml.cfs.CarrierSelectInfoType;
import javalearning.xml.cfs.DupType;
import javalearning.xml.cfs.FailedTrunkGroupsType;
import javalearning.xml.cfs.FeaturesType;
import javalearning.xml.cfs.FileType;
import javalearning.xml.cfs.IndividualLinePartyType;
import javalearning.xml.cfs.MADNPartyType;
import javalearning.xml.cfs.MLHGPilotPartyType;
import javalearning.xml.cfs.NetworkTrunkPartyType;
import javalearning.xml.cfs.NoPartyPartyType;
import javalearning.xml.cfs.PBXPartyType;
import javalearning.xml.cfs.PChargingVectorType;
import javalearning.xml.cfs.PartyType;
import javalearning.xml.cfs.RoutingInfoType;
import javalearning.xml.cfs.SignalingInfoType;
import javalearning.xml.cfs.SignalingTypeType;
import javalearning.xml.cfs.TrunkGroupType;
import javalearning.xml.cfs.UDAsType;

public class JaxbTester {

	public static void main(String[] args) {

		convert();

	}
	
	private static void convert() {
		
		// initiate the configuration
		final CdrConfig conf = new CdrConfig().add("header", Arrays.asList(new String[]{
			"header_seqnum",
			"header_equipmentType",
			"header_equipmentId",
			"header_createTime"
		})).add("call", Arrays.asList(new String[]{
			"call_seqnum",  //CallSeqnum
			"call_error",
			"call_connected", //connected
			"call_correlator",
			"call_clazz",

			"call_releasingParty",
			"call_releaseReason_1_type",
			"call_releaseReason_1_loc",
			"call_releaseReason_1_value", //ReleaseReason
			"call_releaseReason_2_type",

			"call_releaseReason_2_loc",
			"call_releaseReason_2_value",
			"call_connectTime", //ConnectTime
			"call_disconnectTime", //DisconnectTime
			"call_longcall", //longcall

			"call_udAs_uda_1_value", //UDA1
			"call_udAs_uda_2_value", //UDA2
			"call_udAs_uda_5_value", //UDA5
			"call_udAs_uda_6_value", //UDA6
			"call_udAs_uda_10_value", //UDA10

			"call_routingInfo_callingPartyRoutedAddr_type",
			"call_routingInfo_callingPartyRoutedAddr_value", //CallingPartyAddr
			"call_routingInfo_requestedAddr_type",
			"call_routingInfo_requestedAddr_value", //RequestedAddr
			"call_routingInfo_routedAddr_type",

			"call_routingInfo_routedAddr_value", //RoutedAddr
			"call_origParty_trunkGroup_trunkaccounting", //trunkaccounting
			"call_origParty_trunkGroup_trunkGroupId", //TrunkGroupId
			"call_signalingInfo_mediaCapabilityRequested", 
			"call_signalingInfo_mediaCapabilityUsed", //MediaCapabilityType
			"callForwardInfo_redirectCount",	//RedirectCount

			"call_signalingInfo_pChargingVector_icidvalue", //icidvalue
			"call_termParty_trunkGroup_trunkaccounting", //trunkaccounting
			"call_termParty_trunkGroup_trunkGroupId", //TrunkGroupId
			"call_icSeizeTime",
			"call_origParty_chargeAddr_value",

			"call_termParty_chargeAddr_value",
			"call_intelligentNetworkInfo_chargeAddr_value"
		})).add("event", Arrays.asList(new String[]{
				
		})).add("footer", Arrays.asList(new String[]{
			"footer_lastModTime",
			"footer_numCDRs",
			"footer_dataErroredCDRs",
			"footer_writeErroredCDRs"
		})).add("title", Arrays.asList(new String[]{
				"title_seqnum",  //CallSeqnum
				"title_error",
				"title_connected", //connected
				"title_correlator",
				"title_clazz",

				"title_releasingParty",
				"title_releaseReason_1_type",
				"title_releaseReason_1_loc",
				"title_releaseReason_1_value", //ReleaseReason
				"title_releaseReason_2_type",

				"title_releaseReason_2_loc",
				"title_releaseReason_2_value",
				"title_connectTime", //ConnectTime
				"title_disconnectTime", //DisconnectTime
				"title_longcall", //longcall

				"title_udAs_uda_1_value", //UDA1
				"title_udAs_uda_2_value", //UDA2
				"title_udAs_uda_5_value", //UDA5
				"title_udAs_uda_6_value", //UDA6
				"title_udAs_uda_10_value", //UDA10

				"title_routingInfo_callingPartyRoutedAddr_type",
				"title_routingInfo_callingPartyRoutedAddr_value", //CallingPartyAddr
				"title_routingInfo_requestedAddr_type",
				"title_routingInfo_requestedAddr_value", //RequestedAddr
				"title_routingInfo_routedAddr_type",

				"title_routingInfo_routedAddr_value", //RoutedAddr
				"title_origParty_trunkGroup_trunkaccounting", //trunkaccounting
				"title_origParty_trunkGroup_trunkGroupId", //TrunkGroupId
				"title_signalingInfo_mediaCapabilityRequested", 
				"title_signalingInfo_mediaCapabilityUsed", //MediaCapabilityType
				"title_callForwardInfo_redirectCount",	//RedirectCount

				"title_signalingInfo_pChargingVector_icidvalue", //icidvalue
				"title_termParty_trunkGroup_trunkaccounting", //trunkaccounting
				"title_termParty_trunkGroup_trunkGroupId", //TrunkGroupId
				"title_icSeizeTime",
				"title_origParty_chargeAddr_value",

				"title_termParty_chargeAddr_value",
				"title_intelligentNetworkInfo_chargeAddr_value"
			})).addFieldNameMapping("title_seqnum", "seqnum")  //CallSeqnum
				.addFieldNameMapping("title_error", "error")
				.addFieldNameMapping("title_connected", "connected") //connected
				.addFieldNameMapping("title_correlator", "correlator")
				.addFieldNameMapping("title_clazz", "clazz")

				.addFieldNameMapping("title_releasingParty", "releasingParty")
				.addFieldNameMapping("title_releaseReason_1_type", "releaseReasonType1")
				.addFieldNameMapping("title_releaseReason_1_loc", "releaseReasonLoc1")
				.addFieldNameMapping("title_releaseReason_1_value", "releaseReason1") //ReleaseReason
				.addFieldNameMapping("title_releaseReason_2_type", "releaseReasonType2")

				.addFieldNameMapping("title_releaseReason_2_loc", "releaseReasonLoc2")
				.addFieldNameMapping("title_releaseReason_2_value", "releaseReason2")
				.addFieldNameMapping("title_connectTime", "connectTime") //ConnectTime
				.addFieldNameMapping("title_disconnectTime", "disconnectTime") //DisconnectTime
				.addFieldNameMapping("title_longcall", "longcall") //longcall

				.addFieldNameMapping("title_udAs_uda_1_value", "uda1") //UDA1
				.addFieldNameMapping("title_udAs_uda_2_value", "uda2") //UDA2
				.addFieldNameMapping("title_udAs_uda_5_value", "uda5") //UDA5
				.addFieldNameMapping("title_udAs_uda_6_value", "uda6") //UDA6
				.addFieldNameMapping("title_udAs_uda_10_value", "uda10") //UDA10

				.addFieldNameMapping("title_routingInfo_callingPartyRoutedAddr_type", "callingPartyAddrType")
				.addFieldNameMapping("title_routingInfo_callingPartyRoutedAddr_value", "callingPartyAddr") //CallingPartyAddr
				.addFieldNameMapping("title_routingInfo_requestedAddr_type", "requestedAddrType")
				.addFieldNameMapping("title_routingInfo_requestedAddr_value", "requestedAddr") //RequestedAddr
				.addFieldNameMapping("title_routingInfo_routedAddr_type", "routedAddrType")

				.addFieldNameMapping("title_routingInfo_routedAddr_value", "routedAddr") //RoutedAddr
				.addFieldNameMapping("title_origParty_trunkGroup_trunkaccounting", "origTrunkaccounting") //trunkaccounting
				.addFieldNameMapping("title_origParty_trunkGroup_trunkGroupId", "origTrunkGroupId") //TrunkGroupId
				.addFieldNameMapping("title_signalingInfo_mediaCapabilityRequested", "mediaCapabilityRequested")
				.addFieldNameMapping("title_signalingInfo_mediaCapabilityUsed", "mediaCapabilityUsed") //MediaCapabilityType
				.addFieldNameMapping("title_callForwardInfo_redirectCount", "redirectCount")	//RedirectCount

				.addFieldNameMapping("title_signalingInfo_pChargingVector_icidvalue", "icidvalue") //icidvalue
				.addFieldNameMapping("title_termParty_trunkGroup_trunkaccounting", "termTrunkaccounting")
				.addFieldNameMapping("title_termParty_trunkGroup_trunkGroupId", "termTrunkGroupId")
				.addFieldNameMapping("title_icSeizeTime", "icSeizeTime")
		        .addFieldNameMapping("title_origParty_chargeAddr_value", "origChargeAddr")

		        .addFieldNameMapping("title_termParty_chargeAddr_value", "termChargeAddr")
		        .addFieldNameMapping("title_intelligentNetworkInfo_chargeAddr_value", "intelligentNetworkChargeAddr");
		
		// for every files in the path, parse the file and get the list of lines
		Arrays.asList(new File("D:\\99 Projects\\07 MetaSwitch\\convert").listFiles(f -> {
			return f.getName().matches(".*(?<!csv)$");
		})).forEach(f -> {
			convertXmlToCsv(f, conf);
		});
	}

	private static void convertXmlToCsv(File file, CdrConfig conf) {

		try {
			
			Unmarshaller unmarshaller = JAXBContext.newInstance(FileType.class).createUnmarshaller();

			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));

			XMLStreamReader streamReader = XMLInputFactory.newInstance().createXMLStreamReader(reader);

			FileType cdrFile = unmarshaller.unmarshal(streamReader, FileType.class).getValue();

			System.out.println(String.format("Now converting %s", file.getName()));
			

			List <Map<String, String>> recordMaps = new ArrayList<>();
			
			// write header line			
//			recordMaps.add(parse(cdrFile.getFileHeader(), "header", conf, new HashMap<String, String>()));
			
			// write title of CDRs
			recordMaps.add(conf.fieldNameMap);
			
			// write CDRs
			cdrFile.getCDRs().getCallOrEvent().forEach((cdr) -> {
				recordMaps.add(parse(cdr, "call", conf, new HashMap<String, String>()));
			});
			
//			cdrFile.getCDRs().getCallOrEvent().
//			    forEach(c -> {
//			    	CallType cdr = (CallType) c;
//			    	if (cdr != null && cdr.getOrigParty() != null && cdr.getOrigParty().getChargeAddr() != null) {
//			    		System.out.println("chargeAddr:" + ((CallType) c).getOrigParty().getChargeAddr().getValue());
//			    	} else {
//			    		System.out.println("NA");
//			    	}
//			    	});
//            System.out.println(recordMaps);
			// write footer
//			recordMaps.add(parse(cdrFile.getFileFooter(), "footer", conf, new HashMap<String, String>()));
			
			System.out.println(String.format("%s has %d records parsed.", file.getPath(), recordMaps.size()));
			
			// write into csv file
			writeCsvFile(recordMaps, file.getPath() + ".csv", conf);
			

		} catch (JAXBException | FileNotFoundException | XMLStreamException | FactoryConfigurationError e) {
			e.printStackTrace();
		}
	}
	
	private static void writeCsvFile(List <Map<String, String>> recordMaps, String fileName, CdrConfig conf) {
		StringBuffer buff = new StringBuffer();
		
		recordMaps.forEach(line -> {
			String recordType = line.keySet().iterator().next();
			List <String> fields = null;
			if (recordType.startsWith("header")) {
				buff.append("HDR");
				fields = conf.getFieldsByType("header");
			} else if (recordType.startsWith("call")) {
				buff.append("CDR");
				fields = conf.getFieldsByType("call");
			} else if (recordType.startsWith("footer")) {
				buff.append("TRL");
				fields = conf.getFieldsByType("footer");
			} else if (recordType.startsWith("title")) {
				buff.append("RecTyp");
				fields = conf.getFieldsByType("title");
			} else {
				System.out.println("Unknown recordType: recordType=" + recordType);
			}
			
			if (fields != null) {
				fields.forEach(f -> {
					buff.append(",");
					if (line.containsKey(f)) {
						buff.append(line.get(f));
					}
				});
			}
			
			buff.append("\r\n");
		});
		
		try {
			Writer writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(buff.toString());
			writer.flush();
			writer.close();
			System.out.println(String.format("CSV file has been writen %s.", fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Map<String, String> parse(Object o, String prefix, CdrConfig conf, Map<String, String> columns) {

		
		Field[] fields = o.getClass().getDeclaredFields();
		
		List <Field> list = new ArrayList<Field>( Arrays.asList(fields));
		
		
		if (hasSuperClass(o.getClass())) {
			List <Field> listSuper = Arrays.asList(o.getClass().getSuperclass().getDeclaredFields()); 
			list.addAll(listSuper);
		}
		

		list.forEach(field -> {
			
			String fieldName = prefix + "_" +field.getName();
			
			field.setAccessible(true);

			try {
				
				if (field.get(o) == null) {
					return;
				} else if (isBasicType(field.getType())) {
//					if (conf.getFieldSet().contains(fieldName)) {
						columns.put(fieldName, field.get(o) + "");
//					}
				} else if (isIterable(field.getType()) && field.get(o) != null) {
					ParameterizedType listType = (ParameterizedType) field.getGenericType();
					
					int i = 1;
					Iterator iter = ((List) field.get(o)).iterator();

					if (isBasicType(listType.getActualTypeArguments()[0].getClass())) {
						while (iter.hasNext()) {
							columns.put(fieldName + "_" + i, iter.next() + "");
							i++;
						}
						
					} else {
						while (iter.hasNext()) {
							parse(iter.next(), fieldName + "_" + i, conf, columns);
							i++;
						}
					}
				} else if (isMap(field.getType())) {
					ParameterizedType listType = (ParameterizedType) field.getGenericType();
					
					int i = 1;
					Iterator iter = ((Map) field.get(o)).keySet().iterator();

					if (isBasicType(listType.getActualTypeArguments()[1].getClass())) {
						while (iter.hasNext()) {
							Object key = iter.next();
							columns.put(fieldName + "_" + key, ((Map) field.get(o)).get(key) + "");
						}
						
					} else {
						while (iter.hasNext()) {
							Object key = iter.next();
							parse(((Map) field.get(o)).get(key), fieldName + "_" + key, conf, columns);
						}
					}
				} else if (isComplexType(field.getType()) && field.get(o) != null){

					//System.out.println(field.getType() + ":    " + fieldName + " : " + field.get(o) + ": " + field.get(o).getClass().getDeclaredFields().length);
					parse(field.get(o), fieldName, conf, columns);
					
				} else if (isIgnore(field.getType())) {
					
				} else {
					System.out.println("Unknown fields, fieldName=" + fieldName + ", fieldType=" + field.getType());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		return columns;
	}



	private static boolean hasSuperClass(Class<?> clazz) {
		Set<Class<?>> clazzes = new HashSet<>();

		clazzes.addAll(Arrays.asList(new Class<?>[] { 
			BusinessLinePartyType.class,
		    AppServerPartyType.class,
		    NetworkTrunkPartyType.class,
		    MLHGPilotPartyType.class,
		    PBXPartyType.class,
		    IndividualLinePartyType.class,
		    NoPartyPartyType.class,
		    MADNPartyType.class
		}));

		return clazzes.contains(clazz) || clazz.isEnum();
	}

	private static boolean isBasicType(Class<?> clazz) {
		Set<Class<?>> clazzes = new HashSet<>();

		clazzes.addAll(Arrays.asList(new Class<?>[] { Boolean.class, Character.class, Byte.class, Short.class,
				Integer.class, Long.class, String.class, Float.class, Double.class, Void.class, Enum.class, long.class,
				int.class, char.class, short.class, int.class, boolean.class, float.class, double.class, byte.class,
				BigInteger.class, Object.class, BigDecimal.class }));

		return clazzes.contains(clazz) || clazz.isEnum();
	}
	
	private static boolean isIgnore(Class<?> clazz) {
		Set<Class<?>> clazzes = new HashSet<>();

		clazzes.addAll(Arrays.asList(new Class<?>[] {  }));

		return clazzes.contains(clazz) || clazz.isEnum();
	}

	private static boolean isComplexType(Class<?> clazz) {
		Set<Class<?>> clazzes = new HashSet<>();

		clazzes.addAll(Arrays.asList(new Class<?>[] { 
			
			FeaturesType.class,
			PartyType.class,
			RoutingInfoType.class,
			CarrierSelectInfoType.class,
			SignalingInfoType.class,
			UDAsType.class,
			AddressType.class,
			PChargingVectorType.class,
			TrunkGroupType.class,
			DupType.class,
			SignalingTypeType.class,
			AddressesType.class,
			FailedTrunkGroupsType.class
		}));

		return clazzes.contains(clazz) || clazz.isEnum();
	}

	private static boolean isIterable(Class<?> clazz) {
		Set<Class<?>> clazzes = new HashSet<>();

		clazzes.addAll(Arrays.asList(new Class<?>[] { List.class, }));

		return clazzes.contains(clazz);
	}

	private static boolean isMap(Class<?> clazz) {
		Set<Class<?>> clazzes = new HashSet<>();

		clazzes.addAll(Arrays.asList(new Class<?>[] { HashMap.class, }));

		return clazzes.contains(clazz);
	}

/*	private static void parseField(Class<?> clazz, String prefix, HashMap<String, Class<?>> fmp) {

		Field[] fields = clazz.getDeclaredFields();

		Arrays.asList(fields).forEach(field -> {
			field.setAccessible(true);
			if (isIterable(field.getType())) {
				ParameterizedType listType = (ParameterizedType) field.getGenericType();

				if (!isBasicType(listType.getActualTypeArguments()[0].getClass())) {
					// System.out.println(prefix + field.getName() + "[]");
					fmp.put(prefix + field.getName() + "[]", listType.getActualTypeArguments()[0].getClass());
				} else {
					parseField(listType.getActualTypeArguments()[0].getClass(), prefix + field.getName() + "_[]_", fmp);
				}
			} else if (isMap(field.getType())) {
				// System.out.println(prefix + field.getName());
				fmp.put(prefix + field.getName(), field.getType());
			} else if (!isBasicType(field.getType())) {
				parseField(field.getType(), prefix + field.getName() + "_", fmp);
			} else {
				// System.out.println(prefix + field.getName());
				fmp.put(prefix + field.getName(), field.getType());
			}

		});

	}*/

}

class CdrConfig {
	
	static class CdrConfigNode {
		String type;
		List <String> fieldNames;
		
		CdrConfigNode(String _type, List <String> _fieldNames) {
			type = _type;
			fieldNames = _fieldNames;
		}
	}
	
	List <CdrConfigNode> configs;
	HashSet<String> fieldSet;
	HashMap<String, String> fieldNameMap;
	
	CdrConfig() {
		configs = new ArrayList <CdrConfigNode>();
		fieldNameMap = new HashMap<String, String>();
	}
	
	public CdrConfig add(String _type, List <String> _fieldNames) {
		configs.add(new CdrConfigNode(_type, _fieldNames));
		fieldSet();
		return this;
	}
	
	public CdrConfig addFieldNameMapping(String sourceName, String targetName) {
		fieldNameMap.put(sourceName, targetName);
		return this;
	}
	
	private void fieldSet() {
		fieldSet = new HashSet<String>();
		configs.forEach(e -> {
			e.fieldNames.forEach(f -> {
				fieldSet.add(f);
				});
			});
	}
	
	public List<String> getFieldsByType(String _type) {
		for (CdrConfigNode node : configs) {
			if (node.type.equals(_type)) {
				return node.fieldNames;
			}
		}
		
		return null;
	}
	
	public HashSet<String> getFieldSet() {
		return fieldSet;
	}
}


package javalearning.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IoTest {

	public static void main(String[] args) {
//		dividDw();
		sortDw();
		sortOutput();
//		mergeFiles();
//		sortMerge();
//		addSrdPrefix();
		takeoffPrefix("COMPLETE_", "D:\\99 Projects\\04 Amdocs\\BMS\\task005\\test23\\complete\\");
		takeoffPrefix("DW-", "D:\\99 Projects\\04 Amdocs\\BMS\\task005\\test22\\dw\\");
//		
		takeoffSuffix("_20160607.{6}", "D:\\99 Projects\\04 Amdocs\\BMS\\task005\\test23\\complete\\");
		
//		testFileInputStream();
		
		
//		testReader();
		
//		testWriter();
		
//		testBufferedReader();
		
//		testBufferedWriter();
		
	}
	
	private static void takeoffPrefix(String prefix, String path) {
		File[] files = listFiles(path, "^" + prefix +".*");
		for (int i = 0; i < files.length; i ++) {
			files[i].renameTo(new File(path + files[i].getName().substring(prefix.length())));

		}		
	}
	
	private static void takeoffSuffix(String suffix, String path) {
		File[] files = listFiles(path, "^.*" + suffix +"\\.csv\\.parse");
		for (int i = 0; i < files.length; i ++) {
			//files[i].renameTo(new File(path + files[i].getName().substring(prefix.length())));
//			System.out.println(files[i].getName().replaceFirst(suffix, ""));
			files[i].renameTo(new File(path + files[i].getName().replaceFirst(suffix, "")));

		}		
	}
	
	
	private static void sortMerge() {
		
//		String path = "D:\\99 Projects\\04 Amdocs\\BMS\\task001\\UnitTesting\\DW_Files";
		String path = "D:\\99 Projects\\04 Amdocs\\BMS\\task004debugAEM\\convert";
		int fisrtLineIgnore = 0; // lines should be ignored at beginning
		int lastLineIgnore = 0;  // lines should be ignored at last
		
		/*
		0	914407312
		1	569014111
		2	OTHER_OTHER
		3	Open CA
		4	1411
		5	011976000
		6	Australia/Sydney
		7
		8	9999
		9	0394197931
		0
		1
		2	2016-05-10T21:34:44
		3	2016-05-11T00:04:45
		4	9002
		5	10
		6	PSTN
		7	S49901C84255
		*/
		int[] columns = {0, 2};  //use the origin index to sort
		int[] sorts = {0, 1}; // 0, asc, 1, desc
		int[] writeFields = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		
		// list files with filter
		File[] files1 = listFiles(path, ".*\\.merge$");
		for (int i = 0; i < files1.length; i ++) {
			System.out.println(files1[i]);
			sortCsv(files1[i].getAbsolutePath(), fisrtLineIgnore, lastLineIgnore, columns, sorts, writeFields);
		}
	}
	
	private static void mergeFiles() {
		
		String path = "D:\\99 Projects\\04 Amdocs\\BMS\\task004debugAEM\\convert";
		
		File[] files = listFiles(path, "^COMPLETE((?!lcf).)*\\.csv.parse$");
		
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path + "\\COMPLETE.csv.merge"));

			for (int i = 0; i < files.length; i++) {
				BufferedReader reader = new BufferedReader(new FileReader(files[i].getAbsolutePath()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					writer.write(line + "\r\n");
				}
				writer.flush();
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
        files = listFiles(path, "^DW((?!lcf).)*\\.csv.parse$");
		
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path + "\\DW.csv.merge"));

			for (int i = 0; i < files.length; i++) {
				BufferedReader reader = new BufferedReader(new FileReader(files[i].getAbsolutePath()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					writer.write(line + "\r\n");
				}
				writer.flush();
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	private static void dividDw() {
		String before = "D:\\99 Projects\\04 Amdocs\\BMS\\task005\\DW\\DW-oca02_20160511.csv";
		
		Map <String, StringBuffer> dw = new HashMap <String, StringBuffer>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(before));
			String line;
			int countCdr = 0, countFile = 0;
			while ((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields.length != 20) {
					System.out.println("line format error, line=" + line);
					continue;
				}
				
				countCdr++;
				
				if (dw.containsKey(fields[18])) {
					dw.get(fields[18]).append(line + "\r\n");
				} else {
					countFile++;
					StringBuffer fileBuff = new StringBuffer();
					fileBuff.append(line + "\r\n");
					dw.put(fields[18], fileBuff);
				}
			}
			
			System.out.println(String.format("%d records, %d files loaded", countCdr, countFile));
			
			for (String filename : dw.keySet()) {
				String newfile = filename.replaceAll(".xml", "");
				newfile = newfile + ".csv";
				BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\99 Projects\\04 Amdocs\\BMS\\task005\\DW\\DW-" + newfile));
				writer.write(dw.get(filename).toString());
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	private static void addSrdPrefix() {
		String before = "D:\\99 Projects\\04 Amdocs\\BMS\\task001\\newref05small.csv";
		
		Map <String, List<StringBuffer>> dw = new HashMap <String, List<StringBuffer>>();
		
		int maxLen = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(before));
			String line;
			StringBuffer newbuff = new StringBuffer();
			int MAX_PREFIX = 10; 
			while ((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields.length < 9) {
					System.out.println("Incorrect line, line=" + line);
					continue;
				}
				
				String resourceId = fields[2];
				String altResourceId = fields[3];
				
				char[] idChars = resourceId.toCharArray();
				char[] altChars = altResourceId.toCharArray();
				char[] preChars = new char[100];
				
				for (int i= 0; i < 
						Math.min(MAX_PREFIX, Math.min(idChars.length, altChars.length)); i ++) {
					if (idChars[i] == altChars[i]) {
						preChars[i] = idChars[i];
						if (i > maxLen) {
							maxLen = i;
							System.out.println(resourceId + ";" + altResourceId);
						}
					} else {
						break;
					}
				}
				
				for (int i = 0; i < preChars.length; i++) {
					if (preChars[i] == 0) {
						fields[8] = String.valueOf(preChars, 0, i);
						break;
					}
				}
				
				for (int i = 0; i < fields.length; i ++) {
					newbuff.append(fields[i]);
//					System.out.print(fields[i]);
					if (i != fields.length - 1) {
						newbuff.append(",");
//						System.out.print(",");
					} else {
						newbuff.append("\r\n");
//						System.out.print("#\r\n");
					}
				}
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\99 Projects\\04 Amdocs\\BMS\\task001\\newref05new.csv"));
			writer.write(newbuff.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(maxLen + 1);
		
		
		
	}
	
	private static void testBufferedWriter() {
		try 
		(
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:/temp/test20160525.csv"));
			) 
		{
			writer.write("hello everyone");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	private static void testWriter() {
		try 
		(
			Writer writer = new FileWriter("D:/temp/test20160525.csv");
			) 
		{
			writer.write("hello");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	private static void testBufferedReader() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("D:/temp/F400result.csv"));
			String s = null;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void testReader() {
		try {
//			Reader reader = new BufferedReader(new FileReader("D:/temp/F400result.csv"));
			Reader reader = new FileReader("D:/temp/F400result.csv");
			char[] cbuff = new char[1024];
			
			while (reader.read(cbuff) != -1) {
				for (char c : cbuff){
					System.out.print(c);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void testFileInputStream() {
		try {
			InputStream in = new FileInputStream("D:/temp/F400result.csv");
			byte[] buff = new byte[1024];
			while (in.read(buff) != -1) {
				for (byte b : buff){
					System.out.print(Byte.toString(b));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void sortDw() {
//		String path = "D:\\99 Projects\\04 Amdocs\\BMS\\task001\\UnitTesting\\DW_Files";
		String path = "D:\\99 Projects\\04 Amdocs\\BMS\\task004debugAEM\\convert";
		int fisrtLineIgnore = 0; // lines should be ignored at beginning
		int lastLineIgnore = 0;  // lines should be ignored at last
		
		/*
		0(primary ASC-0)->16 	914580584
		1->0	Open CA
		2->1	1423
		3->2	0733379955
		4->3	Australia/Brisbane
		5->4	
		6->5	1414
		7->6	0458458316
		8->7	
		9->8	
		10->9	2016-05-10T23:58:44
		11->10	2016-05-11T00:01:08
		12->11	144
		13->12	243
		14->13	GSM
		15->14	S106802C284985
		16(secondary DESC-1)->15 	ON_OTHER
		17->17	569006942
		18->NA	oca02-kent-syd_20160511000108.xml
		19->NA	oca02-kent-syd
		 * */
		
		int[] columns = {0, 16};  //use the origin index to sort
		int[] sorts = {0, 1}; // 0, asc, 1, desc
		int[] writeFields = {0,17,16,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		// list files with filter
		File[] files1 = listFiles(path, "^DW((?!lcf).)*\\.csv$");
		for (int i = 0; i < files1.length; i ++) {
			System.out.println(files1[i]);
			sortCsv(files1[i].getAbsolutePath(), fisrtLineIgnore, lastLineIgnore, columns, sorts, writeFields);
		}
	}
	
	private static void sortOutput() {
//		String path = "D:\\99 Projects\\04 Amdocs\\BMS\\task001\\UnitTesting\\Output_Files";
		
		String path = "D:\\99 Projects\\04 Amdocs\\BMS\\task004debugAEM\\convert";
		int fisrtLineIgnore = 1; // lines should be ignored at beginning
		int lastLineIgnore = 0;  // lines should be ignored at last
		
		/*
		0->NA
		1->0	Open CA
		2->1	1423
		3->2	0399121231
		4->3	Australia/Sydney
		5->4	S97612C266189
		6->5	1414
		7->6	0385184465
		8->7	
		9->8	
		10->9	2016-05-10T23:52:23
		11->10	2016-05-11T00:01:08
		12->11	525
		13->12	243
		14->13	PSTN
		15->14	
		16(secondary DESC)->15	ON_OTHER
		17(primary ASC)->16	914568768
		18->17	569006941
		19->NA	oca02-kent-syd_20160511000108TEST15.xml
		20->NA	oca02-kent-syd
		*/
		int[] columns = {17, 16};
		int[] sorts = {0, 1}; // 0, asc, 1, desc
		int[] writeFields = {17,18,16,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		// list files with filter
		File[] files1 = listFiles(path, "^COMPLETE((?!lcf).)*\\.csv$");
		for (int i = 0; i < files1.length; i ++) {
			System.out.println(files1[i]);
			sortCsv(files1[i].getAbsolutePath(), fisrtLineIgnore, lastLineIgnore, columns, sorts, writeFields);
		}
	}
	
	
	
	private static File[] listFiles(String path, String regex) {
		File folder = new File(path);
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (name.matches(regex)) {
					return true;
				}
				return false;
			}
		};
		return folder.listFiles(filter);
	}
	
	private static void sortCsv(String fileName, int fisrtLineIgnore,
			int lastLineIgnore, int[] columns, int[] sorts, int[] writeFields) {
		
		List <String> lines = null;
		List <String> lines2 = null;
		
		List <String> head = new ArrayList<>();
		List <String> tail = new ArrayList<>();
		
		try {
			lines = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < lines.size() && i < fisrtLineIgnore; i++) {
			head.add(lines.remove(0));
		}


		for (int i = 0; i < lines.size() && i < lastLineIgnore; i++) {
			tail.add(lines.remove(lines.size() - 1));
		}

		try {
			lines2 = Files.readAllLines(Paths.get(fileName + "#1"));
			for (int i = 0; i < lines2.size() && i < fisrtLineIgnore; i++) {
				lines2.remove(0);
			}
			for (int i = 0; i < lines2.size() && i < lastLineIgnore; i++) {
				lines2.remove(lines2.size() - 1);
			}
			lines.addAll(lines2);
		} catch (IOException e) {
		}

		List<String[]> list = new ArrayList<>();
		for (int i = 0; i < lines.size(); i ++) {
			list.add(lines.get(i).split(","));
		}
		
		
		list = sortCsv(columns, sorts, 0, list);
		StringBuffer buff = new StringBuffer();
		
		for (String[] fields : list) {
			
			
			
			// write every field to new line
			for (int i = 0; i < writeFields.length; i ++) {
				
				if (fields.length < writeFields[i] + 1) {
					buff.append(",");
				} else {
					buff.append(fields[writeFields[i]] + ",");
				}
				
			}
			
			buff.delete(buff.length() - 1, buff.length());
			
			buff.append("\r\n");
		}
		
		try {
			File csv = new File(fileName+".parse");

			BufferedWriter bw = new BufferedWriter(new FileWriter(csv), 500 * 1024);
			bw.write(buff.toString());
			bw.close();
			System.out.println(csv.getAbsolutePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static List<String[]> sortCsv(int[] columns, int[] sorts, int idx, List<String[]> lines) {
		
		if (idx >= columns.length) {
			return lines;
		}
		
		int column = columns[idx];
		int sort = sorts[idx];
		
		if (lines.size() <= 1) {
			return lines;
		}
		
		Comparator <String> comparator;
		
		if (sort == 0) {
			comparator = new Comparator<String> () {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			};
		} else {
			comparator = new Comparator<String> () {
				@Override
				public int compare(String o1, String o2) {
					return o2.compareTo(o1);
				}
			};
		}
		
		Map<String, List<String[]>> m = new TreeMap<>(comparator);
		
		for (String[] fields : lines) {
			if (m.containsKey(fields[column])) {
				m.get(fields[column]).add(fields);
			} else {
				
				List<String[]> subs = new ArrayList<>();
				subs.add(fields);
				m.put(fields[column], subs);
			}
		}
		
		List<String[]> sortedList = new ArrayList<>();
		
		for (String key : m.keySet()) {
			List<String[]> sub = m.get(key);
			List<String[]> sortedSub = sortCsv(columns, sorts, idx + 1, sub);
			for (String[] fields : sortedSub) {
				sortedList.add(fields);
			}
		}
		return sortedList;
	}
}

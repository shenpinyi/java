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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IoTest {

	public static void main(String[] args) {
		sortDw();
		sortOutput();
		
//		testFileInputStream();
		
//		testReader();
		
//		testWriter();
		
//		testBufferedReader();
		
//		testBufferedWriter();
		
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
		int fisrtLineIgnore = 1; // lines should be ignored at beginning
		int lastLineIgnore = 0;  // lines should be ignored at last
		int[] columns = {16, 15};
		int[] sorts = {0, 1}; // 0, asc, 1, desc
		int[] ignoreFields = {17, 18};
		
		// list files with filter
		File[] files1 = listFiles(path, "^DW((?!lcf).)*\\.csv$");
		for (int i = 0; i < files1.length; i ++) {
			System.out.println(files1[i]);
			sortCsv(files1[i].getAbsolutePath(), fisrtLineIgnore, lastLineIgnore, columns, sorts, ignoreFields);
		}
	}
	
	private static void sortOutput() {
//		String path = "D:\\99 Projects\\04 Amdocs\\BMS\\task001\\UnitTesting\\Output_Files";
		
		String path = "D:\\99 Projects\\04 Amdocs\\BMS\\task004debugAEM\\convert";
		int fisrtLineIgnore = 1; // lines should be ignored at beginning
		int lastLineIgnore = 0;  // lines should be ignored at last
		int[] columns = {17, 16};
		int[] sorts = {0, 1}; // 0, asc, 1, desc
		int[] ignoreFields = {0, 19, 20};
		
		// list files with filter
		File[] files1 = listFiles(path, "^COMPLETE((?!lcf).)*\\.csv$");
		for (int i = 0; i < files1.length; i ++) {
			System.out.println(files1[i]);
			sortCsv(files1[i].getAbsolutePath(), fisrtLineIgnore, lastLineIgnore, columns, sorts, ignoreFields);
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
			int lastLineIgnore, int[] columns, int[] sorts, int[] ignoreFields) {
		
		List <String> lines = null;
		
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
		
		List<String[]> list = new ArrayList<>();
		for (int i = 0; i < lines.size(); i ++) {
			list.add(lines.get(i).split(","));
		}
		
		list = sortCsv(columns, sorts, 0, list);
		StringBuffer buff = new StringBuffer();
		
		for (String[] fields : list) {
			
			for (int i = 0; i < fields.length; i ++) {
				boolean isIgnore = false;
				
				for (int j = 0; j < ignoreFields.length; j++) {
					if (i == ignoreFields[j]) {
						isIgnore = true;
					}
				}
				
				if (isIgnore) { //delete useless column
					continue;
				}
				
				
				buff.append(fields[i] + ",");
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

package javalearning.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class TestNet {

	public static void main(String[] args) {

//		testInetAddress();
//		testCode();
//		testUrl();
//		testDownload();
//		testGet();
		testPost();
	}
	
	
	private static void testPost() {
		
		try {
			URL url = new URL("https://blade.tpg.com.au/cgi-bin/ias.cgi");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty( "charset", "utf-8");
			conn.setRequestMethod("POST");
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes("scr=login.cgi&SEC_username=jshn&SEC_password=temp1234&scriptname=%2Fcgi-bin%2Fias.cgi&parameters=scr%3Dmenu_main%252ecgi&SEC_usertype=operator");
			wr.flush();
			wr.close();
			
			InputStream in = conn.getInputStream();
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(reader);

			System.out.println(conn.getResponseCode());
			System.out.println(conn.getResponseMessage());
			System.out.println(conn.getHeaderFields());
			
			Map <String, List<String>> headers = conn.getHeaderFields();
			
			String cookie = null;
			for (String key : headers.keySet()) {
				
				if (key != null && key.equals("Set-Cookie")) {
					cookie = headers.get(key).get(0);
				}
				
			}
			
			String line = null;
			while ((line =br.readLine()) != null) {
				System.out.println(line);
			}
			
			URL url2 = new URL("https://blade.tpg.com.au/cgi-bin/ias.cgi?scr=user_query.cgi&cust_id=&username=000518&domain=&name_f=&name_s=&name_b=&addr_1=&addr_2=&addr_c=&addr_s=&addr_pc=&phone_h=&phone_w=&phone_m=&phone_f=&email=&bill_id=&owner=&phone_s=&msn=&sim_num=&phone_did=&prod_inst=&nbn_avc=&phone_id=&ident=&part_sn=&cc_num=&status=all");
			HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
			conn2.setRequestMethod("GET");
			conn2.setRequestProperty("Cookie", cookie);
			BufferedReader reader2 = new BufferedReader(new InputStreamReader (conn2.getInputStream()));
			System.out.println(conn2.getResponseCode());
			
			line = null;
			while ((line = reader2.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void testGet() {
		try {
			URL url = new URL("http://blade.tpg.com.au/cgi-bin/ias.cgi?scr=menu_main.cgi");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			InputStream in = conn.getInputStream();
			System.out.println(conn.getResponseCode());
			Map <String, List<String>> header = conn.getHeaderFields();
			for (String key : header.keySet()) {
				for (String value : header.get(key)) {
					System.out.println(key + "->" + value);
				}
			}
			
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			while ((line =br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void testDownload() {
		try {
			URL url = new URL("http://confluence.it.aapt.com.au/download/attachments/31756190/NBN-Operations-Manual-v1.7a-20120903_Sept2012.pdf?version=1&modificationDate=1372212674000&api=v2");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(100000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Charset", "UTF-8");
			InputStream inStream = conn.getInputStream();
			System.out.println("Size of file to be downloaded :" +conn.getContentLength());
			System.out.println("Response code: " + conn.getResponseCode());
			System.out.println("Content type: " + conn.getContentType());
			System.out.println("Content encoding: " + conn.getContentEncoding());
			
//			RandomAccessFile file = new RandomAccessFile("D:\\temp\\a.pdf", "rw");
			OutputStream file = new FileOutputStream( "D:\\temp\\a.pdf" );
			
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			int length = 0;
			while ((hasRead = inStream.read(buffer)) != -1) {
				file.write(buffer, 0, hasRead);
				length += hasRead;
			}
			System.out.println("Size of file been downloaded: " +length);
			file.close();
			inStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@SuppressWarnings("unused")
	private static void testInetAddress() {
		try {
//			InetAddress addr = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
			InetAddress addr = InetAddress.getByName("tpg.com.au");
			System.out.println(addr.getHostName());
			System.out.println(addr.getHostAddress());
			System.out.println(addr.getCanonicalHostName());
			System.out.println(addr.isReachable(5000) + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private static void testCode() {
		try {
			String s = URLEncoder.encode("Hello world 中文", "UTF-8");
			System.out.println(s);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String s;
		try {
			s = URLDecoder.decode("Hello+world+%E4%B8%AD%E6%96%87", "UTF-8");
			System.out.println(s);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	private static void testUrl() {
		try {
			URL url = new URL("https://jcsweb.tpgtelecom.com.au/JCSWEB/WalletSupport?method=GET&command=byMSISDN&path=services&MSISDN=11111");
			url.openConnection();
			System.out.println(url.getFile());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getProtocol());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

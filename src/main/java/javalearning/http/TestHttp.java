package javalearning.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;

public class TestHttp {

	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0";
	private static final String ACCEPT = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
	private static final String HOST = "www.woolworths.com.au";
	private static final String ACCEPT_LANGUAGE = "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3";
	private static final String ACCEPT_ENCODING = "gzip, deflate, br";
	private static final String COOKIE = "ASP.NET_SessionId=0nrknxiarwlfyfix11fmt1ln; w-arjshtsw=x0d69bd6a35dd4495bbd4e1b9460c2d08xoticihcx; w-rsjhf=PGcgdD0iOGQ5ZDU1YjBjYmJkNGMxZDhjNmJkYjFhYTE3YWU5ZjZ2a296eWtkZHh2IiAvPg==; TS01137cfb=014b5256e0db8ef71e6d802bab825bafcf8d2da2d2780f6496cd264b2fd1d980b0154c43de55658e15f67ffb427fbe9746cb0eeb9ad744793d013833e92ec5be66c91d7d37412aab738aa6b09481a51ff55141209e";
	private static final String CONNECTION = "keep-alive";

	public static void main(String[] args) {

//		testGet();
		
		testParser();

	}
	
	
	private static void testParser() {
		
		try {
			Parser parser = new Parser("https://www.google.com.au");
			parser.setEncoding("gb2312");
			NodeList list = parser.parse(null);
			
			StringBuffer buff = new StringBuffer();
			processNodeList(list, null, 0, buff);
			System.out.println(buff.toString());
			
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void printTag(Node node, StringBuffer buff) {
		
//		StringToken st = new STringToken(node.getClass().);
		
	}

	private static void processNodeList(NodeList list, String keyword, int level, StringBuffer buff) {
		SimpleNodeIterator iterator = list.elements();
		while (iterator.hasMoreNodes()) {
			Node node = iterator.nextNode();
			NodeList childList = node.getChildren();
			buff.append("\r\n");
			printSp(level, buff);
			buff.append(">>>>>>>>" + node.getClass().getSimpleName());
//			System.out.println(">>>>>>>[" + node.toHtml() + "]");
			if (null == childList)
			{
				String result = node.toPlainTextString();
//				if (keyword != null && result.indexOf(keyword) != -1)
//					System.out.println(result);
//				else if (keyword == null)
//					buff.append(">>>>>>>" );
//					printSp(level, buff);
					buff.append("[" + result + "]" + "\r\n");
			} //end if
			else 
			{
				processNodeList(childList, keyword, level + 1, buff);
			}//end else
		}//end wile
	}
	
	private static void printSp(int level, StringBuffer buff) {
		
		for (int i = 0; i < level; i ++) {
			buff.append("      ");
		}
		
	}
	

	private static void testGet() {

		String url = "https://www.woolworths.com.au/apis/ui/browse?aisle=fruit-veg&category=fresh-fruit&formatObject=%7B%22name%22:%22fresh+fruit%22%7D&pageNumber=1&pageSize=36&sortType=Name&url=%2FShop%2FBrowse%2Ffruit-veg%2Ffresh-fruit";
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		// request.addHeader("User-Agent", USER_AGENT);
		// request.addHeader("Accept", ACCEPT);
		// request.addHeader("Host", HOST);
		// request.addHeader("Accept-Language", ACCEPT_LANGUAGE);
		// request.addHeader("Accept-Encoding", ACCEPT_ENCODING);
		// request.addHeader("Cookie", COOKIE);
		// request.addHeader("Connection", CONNECTION);

		try {
			HttpHost proxy = new HttpHost("10.224.63.59", 8080, "http");

			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			request.setConfig(config);

			HttpResponse response = httpClient.execute(request);

			System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
				// System.out.println(line);
			}
			
			
			Writer writer = new BufferedWriter(new FileWriter("D:/temp/home.html"));
			writer.write(result.toString());
			writer.flush();
			writer.close();

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

package javalearning.string;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

	public static void main(String[] args) {
		System.out.println("22222".startsWith("2"));
		System.out.println("22222 2".indexOf(" "));
		System.out.println(" 22222".indexOf(" "));
		
		StringTokenizer st = new StringTokenizer(" 22222");
		System.out.println(st.nextToken());
		
		System.out.println("0011aaaaa".matches("^(2|3|7|8|4|011).*"));
		
		Pattern sdPattern = Pattern.compile("^((14\\D\\d{2})|(14\\d{2}))(642|742|743|62|42|43|44|73|72|5|2|3|7|9)");
		Matcher sdMatcher = sdPattern.matcher("141230287335222 2");
		if (sdMatcher.find()) {
			System.out.println(sdMatcher.group(1));
		}
		
		String
	    incomingSd = "",
	    outgoingSd = "62";
	    String s1 = String.format("%03d%03d", 
                Integer.valueOf(incomingSd != null && !incomingSd.equals("") ? incomingSd : "0"),
                Integer.valueOf(outgoingSd != null && !outgoingSd.equals("") ? outgoingSd : "0"));

	    System.out.println(s1);
	    
	    String routeId = "ICR_DDD_AAA_EEE_WWWW";
	    String trunkType = "";
	    String trunkName = "";
	    String trunkLocation = "";
	    String resourceId = "";
	    String serviceKey = "";

	    StringTokenizer routeIdTokens = new StringTokenizer(routeId, "_");
	    if (routeIdTokens.hasMoreTokens()) {
	        trunkType = routeIdTokens.nextToken();
	    }
	    if (routeIdTokens.hasMoreTokens()) {
	        trunkName = routeIdTokens.nextToken();
	    }
	    if (routeIdTokens.hasMoreTokens()) {
	        trunkLocation = routeIdTokens.nextToken();
	    }
	    resourceId = trunkType + "_" + trunkName + "_" + trunkLocation;
	    System.out.println(resourceId + ", " +
	    		trunkType + ", " +
	    		trunkName + ", " +
	    		trunkLocation + ", ");

	}

}

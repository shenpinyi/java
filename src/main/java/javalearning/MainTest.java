package javalearning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {

	public static void main(String[] args) {

		System.out.println(new Date(1462943460000L));
		
		try {
			
			Long l1 = 1462888800000L;
			Long l2 = 1462975199000L;
			
			System.out.println(new SimpleDateFormat("yyyyMMdd").parse("20160511").getTime());
			System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").parse("20160511235959").getTime());
			System.out.println(l2 - l1);
			
			System.out.println((l1 + 86389999) > l2); 
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}

package javalearning;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainTest {

	public static void main(String[] args) throws ParseException {

System.out.println(String.format("%d",1L));
		
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyyMMdd HH:mm:ss");
		System.out.println(sdf.format(11111111111L));
		
		
	}

}

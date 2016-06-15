package javalearning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainTest {

	public static void main(String[] args) {


		
		
		try {
			Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-05-15 16:58:35");
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.MINUTE, 9);
			c.add(Calendar.SECOND, 39);
			System.out.println(c.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

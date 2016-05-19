package javalearning.datetime;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class DateTest {

	public static void main(String[] args) {
		
		// Use System.currentTimeMillis to get millisecond of current
//		test01();
		
		// Test Date
//		test02();
		
		// Test Calendar
//		test03();
		
		// Test TimeZone
//		test04();
		
		// Test using TimeZone in Calendar
//		test05();
		
		// Format display
//		test06();
		
		// Test Locale
//		test07();

		// Test utc time
		test08();
	}
	
	
	public static void test01() {
		System.out.println(System.currentTimeMillis()); //1463548793100
	}
	
	
	public static void test02() {
		
		// New a Date without parameter, we get current date
		Date d1 = new Date();
		System.out.println("New Date without parameter d1: " + d1);
		
		// New a Date using parameter, we get target date
		Date d2 = new Date(System.currentTimeMillis() - 10000000);
		System.out.println("New Date with parameter d2: " + d2);
		
		// Method after, before, compareTo
		System.out.println("d1 after d2? " + d1.after(d2));
		System.out.println("d1 before d2? " + d1.before(d2));
		System.out.println("d1 comareTo d2? " + d1.compareTo(d2));
		System.out.println("d1 eqals d2? " + d1.equals(d2));
//		System.out.println("d1 - d2? " + (d1 - d2)); //not support
		
		// Get millisecond from Date
		System.out.println("Millisecond of d1: " + d1.getTime());
		System.out.println("Millisecond of d2: " + d2.getTime());
		
	}
	
	public static void test03() {
		
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		System.out.println(c.getTime());
		System.out.println(c.getTimeInMillis());
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.SECOND));
		System.out.println(c.get(Calendar.AM_PM));
		
		c.roll(Calendar.MINUTE, 20);
		System.out.println(c.getTime());
		
		c.add(Calendar.MINUTE, -20);
		System.out.println(c.getTime());
		
		c.set(Calendar.MONTH, Calendar.AUGUST);
		System.out.println(c.getTime());
		
		c.set(Calendar.YEAR, 1300);
		System.out.println(c.getTime());
		System.out.println(c.getTimeInMillis());
		
		c.set(2017, 7, 13);
		System.out.println(c.getTime());
		
		c.set(2050, 2, 19, 10, 23, 14);
		System.out.println(c.getTime());
	}
	
	public static void test04() {

		// get all timezone ids
//		for (String s : TimeZone.getAvailableIDs()) {
//			System.out.println(s);
//		}
		
		// get timezone ids using millisecond offset
//		for (String s : TimeZone.getAvailableIDs(10 * 1000 * 3600)) {
//			System.out.println(s);
//		}
		
		// get timezone of local machine
		System.out.println(TimeZone.getDefault().getID());
		System.out.println(TimeZone.getDefault().getRawOffset());
		System.out.println(TimeZone.getDefault().getDisplayName());
		System.out.println(TimeZone.getTimeZone("Australia/Sydney"));
		
	}
	
	public static void test05() {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone(TimeZone.getAvailableIDs(8 * 1000 * 3600)[0]));
		c.set(Calendar.HOUR, 3);
		c.set(Calendar.AM_PM, 1);
		System.out.println(c.getTime()); // display the time in local machine, not in the timezone
		System.out.println(c.getTimeZone().getDisplayName());
		System.out.println(c.get(Calendar.HOUR)); // get the time in the timezone
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));
		System.out.println(c.get(Calendar.AM_PM));
		
	}
	
	public static void test06() {
		SimpleDateFormat sdf = new SimpleDateFormat("'Today is' dd-MM-yyyy, 'now is' HH:mm:ss, 'timezone is' Z");
		System.out.println(sdf.format(new Date()));
		
		// convert string to date
		try {
			Date d = sdf.parse("Today is 18-05-2016, now is 16:48:12, timezone is +1000");
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		// convert string to date using timezone
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
		sdf2.setTimeZone(TimeZone.getTimeZone(TimeZone.getAvailableIDs(8 * 1000 * 3600)[0]));
		try {
			Date d2 = sdf2.parse("20160518165346");
			System.out.println(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private static void test07(){
		
//		for (Locale lcl : Locale.getAvailableLocales()) {
//			System.out.println(lcl.getDisplayCountry() + " " + lcl.getDisplayLanguage()
//			+ " "  + lcl.getCountry() + " " + lcl.getLanguage());
//		}
		
		Locale lcl = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("datetime", lcl);
		ResourceBundle bundle2 = ResourceBundle.getBundle("datetime", Locale.getAvailableLocales()[0]);
		System.out.println(bundle.getString("hello"));
		System.out.println(bundle2.getString("hello"));
		
		System.out.println(bundle.getString("msg"));
		System.out.println(bundle2.getString("msg"));
		
		System.out.println(MessageFormat.format(bundle.getString("msg"), "Jack", new SimpleDateFormat("YYYY-MM-dd").format(new Date())));
		System.out.println(MessageFormat.format(bundle2.getString("msg"), "Jack", new SimpleDateFormat("YYYY-MM-dd").format(new Date())));
		
	}
	
	
	public static void test08() {

		// UTC
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		// Local
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");

		// GMT
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT+11"));

		try {
			Date d1 = sdf1.parse("2015-03-04T03:55:26");
			Date d2 = sdf2.parse("2015-03-04T03:55:26");
			Date d3 = sdf3.parse("2015-03-04T03:55:26");
			System.out.println("UTC->LOCAL   :" + d1);
			System.out.println("LOCAL->LOCAL :" + d2);
			System.out.println("GMT+11->LOCAL:" + d3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			Date d1 = sdf1.parse("2015-06-04T03:55:26");
			Date d2 = sdf2.parse("2015-06-04T03:55:26");
			Date d3 = sdf3.parse("2015-06-04T03:55:26");
			System.out.println("UTC->LOCAL   :" + d1);
			System.out.println("LOCAL->LOCAL :" + d2);
			System.out.println("GMT+11->LOCAL:" + d3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
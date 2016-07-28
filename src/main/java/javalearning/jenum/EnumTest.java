package javalearning.jenum;

import static javalearning.jenum.RainbowColor.*;

public class EnumTest {

	public static void main(String[] args) {
		// test01();
		// test02();
		// test04();
		// test05();
		// test06();
		test07();
	}

	private static void test01() {
		RainbowColor c1 = RainbowColor.RED;
		// RainbowColor c2 = YELLOW; Here's a compile error
		System.out.println(c1.name());
		System.out.println(c1.ordinal());
		System.out.println(c1.toString());
		System.out.println(c1.getClass().getName());
	}

	private static void test02() {
		RainbowColor c1 = RainbowColor.RED;
		RainbowColor c2 = RainbowColor.RED;
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
	}

	private static void test03() {
		// following cannot pass compile
		// RainbowColor c1 = "RED";
		// RainbowColor c1 = 0;
	}

	private static void test04() {
		// RainbowColor c = null;
		// System.out.println(c);
		// RainbowColor c = RainbowColor.RED;
		// RainbowColor c1 = RainbowColor.RED;
		try {
			Class.forName("javalearning.jenum.RainbowColor");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void test05() {
		RainbowColor c = RainbowColor.ORANGE;

		switch (c) {
		case ORANGE:
			System.out.println("It's orange");
			break;
		case RED:
			System.out.println("It's red");
			break;
		default:
		}
	}
	
	private static void test06() {
		RainbowColor[] clrs = RainbowColor.values();
		
		for (int i = 0; i < clrs.length; i++) {
			System.out.println(clrs[i].name());
		}

		RainbowColor c1 = RainbowColor.valueOf("RED");
		System.out.println(c1.name());

//		RainbowColor c2 = RainbowColor.valueOf("TEST");
//		System.out.println(c2.name());
		
		RainbowColor c3 = Enum.valueOf(RainbowColor.class, "RED");
		System.out.println(c3.name());

	}
	
	private static void test07() {
		RainbowColor c1 = RED;
		System.out.println(c1.getColor());
	}
}

enum RainbowColor {
	RED(1, "Red"), ORANGE(2, "Orange");

	private Integer id;
	private String color;

	private RainbowColor(Integer _id, String _color) {
		id = _id;
		color = _color;
		// System.out.println(this.name() + " created, id=" + id + ", color=" +
		// color);
	}

	public String getColor() {
		return color;
	}

	public Integer getId() {
		return id;
	}

}

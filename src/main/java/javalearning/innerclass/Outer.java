package javalearning.innerclass;

public class Outer {
	
	String name;

	public static void main(String[] args) {
		
		TestClass t = new TestClass();
		t = new TestClass();
		
		Outer outer = new Outer();
		outer.setName("Jack");
		System.out.println(outer.getName());
		
		Outer.Inner inner1 = outer.new Inner();
		System.out.println(inner1.getName());

		Outer.Inner inner2 = outer.new Inner();
		System.out.println(inner1.getName());
		
		inner1.setName("Tom");
		System.out.println(outer.getName());
		System.out.println(inner1.getName());
		System.out.println(inner1.getName());
		
		inner2.setName("Thomas");
		System.out.println(outer.getName());
		System.out.println(inner1.getName());
		System.out.println(inner1.getName());

		outer.setName("John");
		System.out.println(outer.getName());
		System.out.println(inner1.getName());
		System.out.println(inner1.getName());
	}
	
	public void setName(String _name) {
		this.name = _name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public class Inner {
		
		
		public Inner() {
			System.out.println("In constructor");
			
		}
		
		public void setName(String _name) {
			Outer.this.name = _name;
		}
		
		public String getName() {
			return Outer.this.name;
		}
	}
}

class TestClass {
	{
		System.out.println("In non-static block");
	}
	
	static {
		System.out.println("In static block");
	}
	
	public TestClass() {
		System.out.println("In constructor");
		
	}
}

package javalearning.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class LambdaTest {

	public static void main(String[] args) {

		// https://wizardforcel.gitbooks.io/java8-tutorials/content/Java%208%20%E6%96%B0%E7%89%B9%E6%80%A7%E7%BB%88%E6%9E%81%E6%8C%87%E5%8D%97.html
		
//		test01();
		
		test02();

	}
	
	
	private static void test01() {
		Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));
		
//		Arrays.asList(1, 2, 4).forEach(i -> System.out.println(i));
		
		List <Integer> l =  Arrays.asList(1, 2, 4);
		
		l.sort((i1, i2) -> { return i2 - i1;});
		
		l.forEach(i -> System.out.println(i));
		
		
	}
	
	
	private static void test02() {
		
		Defaultable d1 = DefaultableFactory.create(DefaultableImpl::new);
		Defaultable d2 = DefaultableFactory.create(OverridableImpl::new);
		System.out.println(d1.notRequired());
		System.out.println(d2.notRequired());
		
	}
	
	
	private interface DefaultableFactory {
		static Defaultable create(Supplier <Defaultable> supplier) {
			return supplier.get();
		}
	}
	
	private interface Defaultable {
		
		default String notRequired() {
			return "Default implementation";
		}
	}
	
	private static class DefaultableImpl implements Defaultable {
		
	}
	
	private static class OverridableImpl implements Defaultable {
		
		@Override
		public String notRequired() {
			return "Overridden implementation";
		}
		
	}
	

}

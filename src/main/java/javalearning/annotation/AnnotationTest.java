package javalearning.annotation;

import java.lang.annotation.Annotation;

@MyTest(name = "AnnotationTest")
public class AnnotationTest {

	public static void main(String[] args) {


		try {
			new AnnotationTest().test01();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@MyTest(name = "test01")
	public void test01() throws NoSuchMethodException, SecurityException {

		
		Annotation[] annotations = AnnotationTest.class.getAnnotations();
		for (int i = 0; i < annotations.length; i++) {
			System.out.println(annotations[i]);
		}
		Annotation[] methodAnnotations = this.getClass().getMethod("test01").getAnnotations();
		for (int i = 0; i < methodAnnotations.length; i++) {
			System.out.println(methodAnnotations[i]);
		}
	}

}


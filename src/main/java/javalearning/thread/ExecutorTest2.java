package javalearning.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest2 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		List<Future<String>> fs = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			fs.add(exec.submit(new Task2()));
		}

		fs.forEach(f -> {
			try {
				System.out.println("Got result: " + f.get());
			} catch (Exception e) {
				System.out.println("Got exception");
				e.printStackTrace();
			}
		});
		exec.shutdown();
	}
}

class Task2 implements Callable<String> {

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " is running " + i);
			Thread.sleep(1000);
//			if (i == 3) {
//				throw new RuntimeException(Thread.currentThread().getName() + " is broken");
//			}
		}
		return Thread.currentThread().getName() + " call result";
	}

}

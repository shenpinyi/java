package javalearning.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest3 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		List<Future<String>> fs = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			fs.add(exec.submit(new Task3()));
		}
		
		boolean isDone = false;
		while (!isDone) {
			isDone = true;
			for (int i = 0; i < fs.size(); i ++) {
				if (!fs.get(i).isDone()) {
					System.out.println("Thread is not done:" + i);
					isDone = false;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		exec.shutdown();
	}
}

class Task3 implements Callable<String> {

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " is running " + i);
			Thread.sleep(1000);
		}
		return Thread.currentThread().getName() + " call result";
	}

}

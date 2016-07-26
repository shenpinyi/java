package javalearning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

	public static void main(String[] args) {
		ExecutorService  exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i ++) {
			exec.execute(new Task1());
		}
		exec.shutdown();
	}
}



class Task1 implements Runnable {

	@Override
	public void run() {
		final int count = 5;
		for (int i = 0; i < count; i ++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
//			if (i == 3) {
//				throw new RuntimeException(Thread.currentThread().getName() + " is broken");
//			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
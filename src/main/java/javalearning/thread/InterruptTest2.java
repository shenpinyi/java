package javalearning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterruptTest2 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.submit(new Task());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec.shutdownNow();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		exec.shutdownNow();
	}

	static class Task implements Runnable {
		@Override
		public void run() {
			while (true) {
				System.out.println(Thread.currentThread().getName() + " is running...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " is interrupted. Oops");
				}
			}
		}
	}
}

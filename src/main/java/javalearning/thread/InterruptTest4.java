package javalearning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterruptTest4 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.submit(new Task());
		for (int i = 0; i < 5; i ++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			exec.shutdownNow();
		}
	}

	static class Task implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running...");
			int count = 3;
			while (true) {
				if (Thread.currentThread().interrupted()) {
					System.out.println(Thread.currentThread().getName() + " is interrupted");
					System.out.println("Now the interrupt flag is " + Thread.currentThread().isInterrupted());
					if (count -- == 0) {
						System.out.println(Thread.currentThread().getName() + " is exiting");
						break;
					}
				}
			}
		}
	}
}

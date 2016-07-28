package javalearning.thread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorTest4 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactory1());
		exec.execute(new Task());
		exec.shutdown();
	}
}


class Task implements Runnable {
	@Override
	public void run() {
		System.out.println("Task begin to run. name=" + Thread.currentThread().getName());
		throw new RuntimeException("Throws an exception");
	}
}

class ThreadFactory1 implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		System.out.println("An new thread created.");
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Caught and ate an exception. e=" + e.getMessage());
			}
		});
		return t;
	}
}


package javalearning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentTest {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			exec.submit(new Checker());
		}
		exec.shutdown();
	}
}

class Checker implements Runnable {
	@Override
	public void run() {
		while (true) {
			int current = Provider.nextBad();
			if(current % 2 == 1) {
				System.out.println("Got an odd number " + current +
						", Thread=" + Thread.currentThread().getName());
				break;
			}
		}
	}
}

class Provider {
	static Integer current = 0;
	static Lock lock = new ReentrantLock();
	public static int nextGood() {
		lock.lock();
		try {
			current ++;
			Thread.yield();
			current ++;
			return current;
		} finally {
			lock.unlock();
		}
	}
	public static int nextBad() {
		current ++;
		Thread.yield();
		current ++;
		return current;
	}
	public static int next3() {
		synchronized (Provider.current) {
			current ++;
			Thread.yield();
			current ++;
			return current;
		}
	}
}
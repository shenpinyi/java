package javalearning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentTest1 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
//		exec.submit(new Task5());
//		exec.submit(new Task5());
		exec.submit(new Task6());
		exec.submit(new Task6());
		exec.shutdown();
	}
}

class Task5 implements Runnable {
	static Lock lock = new ReentrantLock();
	static int current = 0;
	@Override
	public void run() {
		while (true) {
			boolean isCatch = lock.tryLock();
			try {
				if (isCatch) {
					System.out.println(Thread.currentThread().getName() + " got lock, will running 10 seconds...");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(Thread.currentThread().getName() + " failed get lock, will sleep 5 seconds...");
					for (int i = 0; i < 5; i ++) {
						try {
							System.out.println(Thread.currentThread().getName() + " is sleeping");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			} finally {
				if (isCatch) {
					System.out.println(Thread.currentThread().getName() + " released lock.");
					lock.unlock();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

class Task6 implements Runnable {
	static Lock lock = new ReentrantLock();
	static int current = 0;
	@Override
	public void run() {
		while (true) {
			boolean isCatch;
			try {
				isCatch = lock.tryLock(5, TimeUnit.SECONDS);
				try {
					if (isCatch) {
						System.out.println(Thread.currentThread().getName() + " got lock, will running 10 seconds...");
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println(Thread.currentThread().getName() + " failed get lock.");
					}
				} finally {
					if (isCatch) {
						System.out.println(Thread.currentThread().getName() + " released lock.");
						lock.unlock();
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
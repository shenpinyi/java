package javalearning.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptTest3 {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Task1 task1 = new Task1();
		Task2 task2 = new Task2();
		task1.lock = lock;
		task2.lock = lock;
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		t1.start();
		t2.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.interrupt();
		System.out.println("Interrupt sent");
	}

	static class Task1 implements Runnable {
		static Lock  lock;
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running...");
			lock.lock();
			System.out.println(Thread.currentThread().getName() + " got lock");
			while (true) {
			}
		}
	}
	
	static class Task2 implements Runnable {
		static Lock  lock;
		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is running...");
				try {
					lock.lockInterruptibly();
					System.out.println(Thread.currentThread().getName() + " got lock");
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " got interrupted");
				}
			} finally {
				System.out.println(Thread.currentThread().getName() + " quit");
			}
		}
	}
}

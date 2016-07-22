package javalearning.thread;

import java.util.Date;

public class SynTest1 {

	public static void main(String[] args) {
		/* What we want to test is if only one method is protected
		 * by synchronized, is only this method protected or 
		 * the whole object is protected.*/
		
		/* Create 6 threads:
		 * Thread 1-2: deposit 20 times
		 * Thread 3-4: draw 20 times
		 * Thread 5-6: query 20 times
         */
		
		/* Expectation:
		 * Because only draw has synchronized, deposit hasn't.
		 * So, if:
		 * A: Only method itself is protected.
		 * The whole draw of 2 threads will cost 40 seconds.
		 * The whole deposit of 2 threads will cost 20 seconds.
		 * The whole query will cost 20 seconds.
		 * 
		 * B: The whole account object is protected.
		 * The whole process will last 100 seconds
		 * The draw, deposit and query will not extraordinary different 
		 * */
		
		Account account = new Account();
		int count = 5;
		long base = new Date().getTime();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < count; i++) {
					long start = new Date().getTime() - base;
					account.deposit(100);
					long end = new Date().getTime() - base;
					System.out.println(Thread.currentThread().getName() + 
					                       ", start=" + start +
					                       ", end=" + end + 
					                       ", balance=" + account.query());
				}
			}
		}, "Deposit-1"); 
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < count; i++) {
					long start = new Date().getTime() - base;
					account.deposit(100);
					long end = new Date().getTime() - base;
					System.out.println(Thread.currentThread().getName() + 
		                       ", start=" + start +
		                       ", end=" + end + 
		                       ", balance=" + account.query());
				}
			}
		}, "Deposit-2"); t2.start();

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < count; i++) {
					long start = new Date().getTime() - base;
					account.draw(100);
					long end = new Date().getTime() - base;
					System.out.println(Thread.currentThread().getName() + 
		                       ", start=" + start +
		                       ", end=" + end + 
		                       ", balance=" + account.query());
				}
			}
		}, "Draw-1"); t3.start();

		Thread t4 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < count; i++) {
					long start = new Date().getTime() - base;
					account.draw(100);
					long end = new Date().getTime() - base;
					System.out.println(Thread.currentThread().getName() + 
		                       ", start=" + start +
		                       ", end=" + end + 
		                       ", balance=" + account.query());
				}
			}
		}, "Draw-2"); t4.start();

//		Thread t5 = new Thread(new Runnable() {
//			public void run() {
//				for (int i = 0; i < count; i++) {
//					long start = new Date().getTime() - base;
//					int blnc = account.query();
//					long end = new Date().getTime() - base;
//					System.out.println(Thread.currentThread().getName() + " balance=" + blnc + 
//		                       ", start=" + start +
//		                       ", ent=" + end);
//				}
//			}
//		}, "Query-1"); t5.start();
//
//		Thread t6 = new Thread(new Runnable() {
//			public void run() {
//				for (int i = 0; i < count; i++) {
//					long start = new Date().getTime() - base;
//					int blnc = account.query();
//					long end = new Date().getTime() - base;
//					System.out.println(Thread.currentThread().getName() + " balance=" + blnc + 
//		                       ", start=" + start +
//		                       ", ent=" + end);
//				}
//			}
//		}, "Query-2"); t6.start();

        try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
//			t5.join();
//			t6.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("Finally, the balance is " + account.query());
	}

}

class Account {
	private int balance = 0;

	public synchronized void deposit(int amount) {
		int current = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		balance = current + amount;
		this.notifyAll();
	}
	
	public synchronized void draw(int amount) {
		try {
			if (balance <= 0) {
				this.wait();
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		balance = balance - amount;
	}
	
	public int query() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return balance;
	}
	
}


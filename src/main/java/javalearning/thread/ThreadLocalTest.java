package javalearning.thread;

import java.util.Date;

public class ThreadLocalTest {

	public static void main(String[] args) {
		
		AccountB account = new AccountB();
		int count = 10;
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < count; i++) {
					if (i == 3) {
						account.setName("Tom");
					}
					System.out.println(Thread.currentThread().getName() + i + ":" + account.getName());
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "A:"); 
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < count; i++) {
					if (i == 6) {
						account.setName("Thomas");
					}
					System.out.println(Thread.currentThread().getName() + i + ":" + account.getName());
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "B:"); 
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        System.out.println("Finally, the name is " + account.getName());
	}

}

class AccountB {
	private ThreadLocal<String> name = new ThreadLocal<>();

	{
		name.set("Jack");
		
	}
	
	public String getName() {
		return this.name.get();
	}
	
	public void setName(String _name) {
		this.name.set(_name);
	} 
}


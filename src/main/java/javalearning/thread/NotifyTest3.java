package javalearning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotifyTest3 {

	public static void main(String[] args) {
		Resturant resturant = new Resturant();
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 2; i++) {
			Chef chef = new Chef(resturant);
			exec.submit(chef);
		}
		for (int i = 0; i < 5; i++) {
			Customer cust = new Customer(resturant);
			exec.submit(cust);
		}
//		exec.shutdown();
	}

	static class Resturant {
		volatile Integer food = 0;
		Integer total = 0;
		Object chefs = new Object();
		Object customers = new Object();

		public Resturant() {
		}
		
		public synchronized void increaseFood() {
			food++;
			total++;
		}
		
		public synchronized void decreaseFood() {
			food--;
		}
		
		
	}
	static class Chef implements Runnable {
		private Resturant resturant;
		public Chef(Resturant _resturant) {
			this.resturant = _resturant;
		}
		@Override
		public void run() {
			while (true) {
				synchronized (resturant) {
					if (resturant.food > 5) {
						System.out.println(Thread.currentThread().getName() + 
								", CHEF: foods are too much, have a rest. food=" + resturant.food);
						try {
							resturant.wait(); //wait for someone call me
							//System.out.println(Thread.currentThread().getName() + ", CHEF: someone is calling, let me work!");
							continue;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				// needs to make some food
				try {
					//System.out.println(Thread.currentThread().getName() + ", CHEF: it takes me 1 seconds to make a food...");
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} // I'm making food...
				System.out.println(Thread.currentThread().getName() + ", CHEF: food is ready!");
				synchronized (resturant) {
					resturant.increaseFood(); // put food out
					resturant.notifyAll();
				}
			}
		}
	}
	
	static class Customer implements Runnable {
		private Resturant resturant;
		
		public Customer(Resturant _resturant) {
			this.resturant = _resturant;
		}
		
		@Override
		public void run() {
			while (true) {
				// take food
				synchronized (resturant) {
					try {
						if (resturant.food <= 0 ) {
							System.out.println(Thread.currentThread().getName() + 
									", CUSTOMER: no food, have a rest. food=" + resturant.food);
							resturant.wait(); // no food? I have to wait
							//System.out.println(Thread.currentThread().getName() + ", CUSTOMER: chefs are calling, let me try to get food!");
							continue; // food has been changed, I can go for one
						}
						resturant.decreaseFood();
						System.out.println(Thread.currentThread().getName() + ", CUSTOMER: got a food");
						resturant.notifyAll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					//System.out.println(Thread.currentThread().getName() + ", CUSTOMER: it would take me 5 seconds to eat the food");
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

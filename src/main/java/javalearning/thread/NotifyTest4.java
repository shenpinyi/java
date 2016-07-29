package javalearning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotifyTest4 {
	public static void main(String[] args) {
		
		Restaurant restaurant = new Restaurant();
		Customer cust = new Customer(restaurant);
		Chef chef = new Chef(restaurant);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.submit(cust);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec.submit(chef);
		exec.shutdown();
	}
	
	static class Restaurant {
		public Restaurant() {
			customers = new Object();
			chefs = new Object();
		}
		Object customers;
		Object chefs;
	}
	
	static class Customer implements Runnable {
		Restaurant restaurant;
		public Customer(Restaurant restaurant) {
			super();
			this.restaurant = restaurant;
		}
		@Override
		public void run() {
			synchronized (restaurant) {
				synchronized (restaurant.chefs) {
					try {
						System.out.println(Thread.currentThread().getName() + ", ask for a chef.");
						restaurant.chefs.wait();
						System.out.println(Thread.currentThread().getName() + ", chef is responsing me.");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}

	static class Chef implements Runnable {
		Restaurant restaurant;
		public Chef(Restaurant restaurant) {
			super();
			this.restaurant = restaurant;
		}
		@Override
		public void run() {
			synchronized (restaurant.chefs) {
				System.out.println(Thread.currentThread().getName() + ", chef is here...");
				restaurant.chefs.notifyAll();
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ", chef has responded...");
			}
		}
	}
}

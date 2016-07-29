package javalearning.thread;

public class NotifyTest {
	public static void main(String[] args) {
		Task task1 = new Task();
		task1.o = new Object();
		task1.o2 = new Object();
		Thread t = new Thread(task1);
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (task1.o) {
			task1.o.notify();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt();
	}
	
	static class Task implements Runnable{
		static Object o;
		static Object o2;
		@Override
		public void run() {
			while (true) {
				System.out.println("Before wait");
				try {
					synchronized (o) {
						o.wait();
					}
				} catch (InterruptedException e) {
					System.out.println("Interrupt caught");
					break;
				}
				System.out.println("After wait");
			}
		}
	}

}

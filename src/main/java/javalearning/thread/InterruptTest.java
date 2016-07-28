package javalearning.thread;

public class InterruptTest {

	public static void main(String[] args) {

		Thread t = new Thread(new Task());
		t.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt();
	}

	
	static class Task implements Runnable{

		@Override
		public void run() {
			while(true) {
				System.out.println(Thread.currentThread().getName() + " is running");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " is interrupted. Oops...");
				}
			}
		}
		
	}
	
}


package javalearning.thread;

public class NotifyTest2 {
	public static void main(String[] args) {
		
		Object o = new Object();
		for (int i = 0; i < 3; i ++) {
			Task task = new Task();
			task.o = o;
			Thread t = new Thread(task);
			t.start();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (o) {
			o.notify();
		}
	}
	
	static class Task implements Runnable{
		static Object o;
		@Override
		public void run() {
			{
				System.out.println(Thread.currentThread().getName() + " Before wait");
				try {
					synchronized (o) {
						o.wait();
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + " After wait");
						o.notify();
					}
				} catch (InterruptedException e) {
					System.out.println("Interrupt caught");
				}
			}
		}
	}

}

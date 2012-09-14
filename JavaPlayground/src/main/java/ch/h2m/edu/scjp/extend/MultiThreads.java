package ch.h2m.edu.scjp.extend;

public class MultiThreads {

	private Object lock = new Object();
	private int count;
	
	class InnerClassOne implements Runnable{
		
		public void run(){
			for (int i = 0; i < 20; i++) {
				synchronized (lock) {
					System.out.println("innerclassOne:" + count++);
					try {
						Thread.sleep(10);
						lock.notify();
					} catch (InterruptedException e) {}

				}
				System.out.println("innerclassOne:" + count);
			}
		}	
	}
	
	class InnerClassTwo extends Thread{
		public void run(){
			for (int i = 0; i < 10; i++) {
				
				synchronized (lock) {
					try {
						lock.wait();
						System.out.println("innerclassTwo " + count++);
						Thread.sleep(1000);
					} catch (InterruptedException e) {}

				}
				System.out.println("innerclassTwo " + count);
				throw new RuntimeException();
			}
		}
	}
	
	public static void main(String [] arg){
		MultiThreads mt = new MultiThreads();
		InnerClassOne ico = mt.new InnerClassOne();
		InnerClassTwo ict = mt.new InnerClassTwo();
		
		Thread t1 = new Thread(ico);
		Thread t2 = new Thread(ict);
		t1.start();
		t2.start();
		
	}
	
}

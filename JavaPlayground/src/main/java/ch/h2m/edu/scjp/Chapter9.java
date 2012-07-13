package ch.h2m.edu.scjp;

import java.util.HashSet;
import java.util.Set;

/**
 * Threads
 * 
 * <ul>
 * <li>in Java a thread is a instance of java.lang.Thread and a thread of execution</li>
 * <li>methods of a thread: <code>start()</code>;<code>yields()</code>;<code>sleep()</code>;<code>run()</code>;</li>
 * <li>Thread class for the thread specific code</li>
 * <li>Runnable interface for a job that should be run by a thread code</li>
 * <li></li>
 * </ul>
 * 
 * @author Heinz
 */
public class Chapter9 {
	
	int x = 0;
	
	public void calculate(){
		Thread t1 = new Thread(new Worker(this));
		Thread t2 = new Thread(new Worker(this));
		t1.start();
		t2.start();
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {}
			x += i;
			System.out.println(x);
		}
		synchronized (this) {
			this.notify();
//			this.notifyAll();
			System.out.println("notify was called");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("look was not released - hehe");
		}
	}
	
	
	
	public class Worker extends Thread {
		
		private Chapter9 c9;
		
		public Worker(Chapter9 c9) {
			this.c9 = c9;
		}
		
		@Override
		public void run() {
			synchronized (c9) {
				System.out.println("worker started");
				try {
					c9.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Total="+c9.x);
			}
		}
		
		
		
	}


	
}

package ch.h2m.edu.scjp;


import static ch.h2m.edu.scjp.Foo.*;

public class ExamClass extends Thread implements ExamInterface, java.io.Serializable {
	int x = 0;
	
	public void bla(){
		printttt();
		System.out.println( blaStringFinal );
	}
	
	@Override
	public void methodWithException() {
		throw new IllegalArgumentException("blabla");
	}

	public static void main(String[] args) {
		Runnable r1 = new ExamClass();
		Thread t1 = new ExamClass();
		new Thread(r1).start();
		new Thread(t1).start();
		new Thread(new ExamClass()).start();
	}
	
	public void run() {
		for(int j = 0; j < 3; j++) {
			x = x + 1;
			x = x + 10;
			System.out.println(Thread.currentThread().getName() + "  x=" +x);
			x = x + 100;
		}
	}
}
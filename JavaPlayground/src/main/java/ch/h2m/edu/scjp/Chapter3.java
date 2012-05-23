package ch.h2m.edu.scjp;

public class Chapter3 {

	/**
	 * Key Points:
	 *   - Shadowing Variables
	 *   
	 */
	
	Bar bar = new Bar();
	
	public void changeIt(Bar bar){
		bar.bar = 99;
		System.out.println("changeIt [bar.bar="+bar.bar+"]");
		bar = new Bar();
		bar.bar = 44;
		System.out.println("changeIt [bar.bar="+bar.bar+"]");
	}
	
	
	
	
	public class Bar {
		int  bar = 28;
	}
	
	
}

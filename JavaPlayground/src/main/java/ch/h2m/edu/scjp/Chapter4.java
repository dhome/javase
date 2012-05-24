package ch.h2m.edu.scjp;
/**
 * Topic: Operators
 * 
 * @author Heinz
 *
 */


public class Chapter4 implements Chap4{

	/**
	 * Key Points:
	 * 		- an array can not compare a primitiv (syntax error)
	 * 
	 */
	
	public void equalsOper(){
		Boolean b1 = false;
		Boolean b2 = true;
		if (b2 = false || b1 == true){
			System.out.println("b2 = false || b1 == true");
		}
		if (b2 == false){
			System.out.println("b2 == false");			
		}
	}
	

}


class Chapter4Sub extends Chapter4{
	

	
}

interface Chap4 {
	
}

package ch.h2m.edu.scjp;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter3Test {

	@Test
	public void shadowVar() {
		System.out.println("--shadowVar");
		Chapter3 c = new Chapter3();
		System.out.println("shadowVar before [c.bar.bar="+c.bar.bar+"]");
		c.shadowingChangeIt(c.bar);
		System.out.println("shadowVar after [c.bar.bar="+c.bar.bar+"]");
	}
	
	@Test
	public void printArrays(){
		System.out.println("--printArrays");
		Chapter3 c = new Chapter3();
		for (int i = 0; i < c.dots.length; i++) {
			for (int j = 0; j < c.dots[i].length; j++) {
				System.out.println("c.dots["+i+"]["+j+"]="+c.dots[i][j]);
			}
			
		}
	}
	

	@Test
	public void arrayCreationInParameter(){
		System.out.println("--arrayCreationInParameter");
		Chapter3 c = new Chapter3();
		c.methodWithArrayParam(new int[] {1, 2, 3});
//		c.methodWithArrayParam(new int[3] {1, 2, 3}); <-- Not possible
	}
	
	@Test
	public void magicComparition(){
		System.out.println("--magicComparition");
		Chapter3 c = new Chapter3();
		c.magicComparition();
	}

}

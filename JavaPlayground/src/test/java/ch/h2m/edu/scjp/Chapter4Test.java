package ch.h2m.edu.scjp;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter4Test {


	@Test
	public void equalsOper() {
		System.out.println("--equalsOper");
		Chapter4 chapter4 = new Chapter4();
		chapter4.equalsOper();
	}
	@Test
	public void instanceOf() {
		System.out.println("--instanceOf");
		Chapter4 chapter4 = new Chapter4();
		Chapter4Sub chapter4Sub = new Chapter4Sub();
		
		if (chapter4 instanceof Chap4) {
			System.out.println("chapter4 instanceof Chap4");
		}else {
				System.out.println("NOT chapter4 instanceof Chap4");
		}
		if (chapter4Sub instanceof Chap4) {
			System.out.println("chapter4Sub instanceof Chap4");
		} else {
			System.out.println("NOT chapter4Sub instanceof Chap4");			
		}
		if (chapter4Sub instanceof Chapter4) {
			System.out.println("chapter4Sub instanceof Chapter4)");
		}else{
			System.out.println("NOT chapter4Sub instanceof Chapter4)");
		}
	}

}

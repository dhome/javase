package ch.h2m.edu.scjp;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter5Test {

	@Test
	public void test() {
		Chapter5 chp5 = new Chapter5();
		chp5.forExample2();
	}
	
	@Test
	public void whatsAboutAsserts() {
		Chapter5 chp5 = new Chapter5();
		chp5.assertExamples(2);
		chp5.assertExamples(-1);
	}

}

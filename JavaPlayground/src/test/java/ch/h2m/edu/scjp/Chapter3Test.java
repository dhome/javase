package ch.h2m.edu.scjp;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter3Test {

	@Test
	public void shadowVar() {
		Chapter3 c = new Chapter3();
		System.out.println("shadowVar before [c.bar.bar="+c.bar.bar+"]");
		c.changeIt(c.bar);
		System.out.println("shadowVar after [c.bar.bar="+c.bar.bar+"]");
	}

}

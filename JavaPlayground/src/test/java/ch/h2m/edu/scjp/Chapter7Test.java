package ch.h2m.edu.scjp;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ch.h2m.edu.scjp.Chapter7.MyClassEquals;
import ch.h2m.edu.scjp.Chapter7.MyClassEqualsHashCode;
import ch.h2m.edu.scjp.Chapter7.MyClassHashCode;

public class Chapter7Test {

	@Test
	public void test() {
		Chapter7 c = new Chapter7();
		assertEquals("setsWithHashCode", 3, c.setsWithHashCode());
		assertEquals("setsWithEquals", 3, c.setsWithEquals());
		assertEquals("setsWithEqualsHashcode", 2, c.setsWithEqualsHashcode());
	}

}

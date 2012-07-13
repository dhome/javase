package ch.h2m.edu.scjp;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ch.h2m.edu.scjp.Chapter7.MyClassEquals;
import ch.h2m.edu.scjp.Chapter7.MyClassEqualsHashCode;
import ch.h2m.edu.scjp.Chapter7.MyClassHashCode;
import ch.h2m.edu.scjp.Chapter8.InnerChapter8;

public class Chapter8Test {

	@Test
	public void innerClassReferences() {
		Chapter8 c = new Chapter8();
		
		InnerChapter8 ic = c.new InnerChapter8();
		ic.printX();
	}

	@Test
	public void innerClassMethode(){
		Chapter8 c = new Chapter8();
		c.innerclassCall();
		
	}
}

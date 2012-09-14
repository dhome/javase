package ch.h2m.edu.scjp;

import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import ch.h2m.edu.scjp.Chapter7.MyClassEquals;
import ch.h2m.edu.scjp.Chapter7.MyClassEqualsHashCode;
import ch.h2m.edu.scjp.Chapter7.MyClassHashCode;
import ch.h2m.edu.scjp.Chapter8.InnerChapter8;

public class Chapter9Test {

	@Test
	public void waitNotify() {
		Chapter9 c = new Chapter9();
		c.calculate();
	}
	
	@Test
	public void tailheadfloorceiling(){
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(1);
		ts.add(5);
		ts.add(3);
		System.out.println(ts);
		System.out.println(ts.tailSet(5, true));  //5
		System.out.println(ts.headSet(5, true));  //1,3,5
		System.out.println(ts.floor(3));
		System.out.println(ts.ceiling(3));
		bla("afddf", new Integer("123"), this);
		int x = 0;
		for (int i = 0; i < 5; ++i, ++x) {
			System.out.println(i + "   " + x);
			
		}
	}
	
	
	private void bla(Object ... objs){
		first:
		for (int i = 0; i < 10; i++) {
			for (Object object : objs) {
				if (object instanceof String){
					System.out.println("im a String");
					break first;
				}
			}
		}
	}
	
	enum volts {eins, zwei, drei}
	
	
	@Test
	public void testFoorLoop() {
		
		volts v = volts.eins;
		switch(v){
		case eins: System.out.println("blasdf");
		default: break;
		}
		
		Integer valueOf = Integer.valueOf("0001000");
		if (Integer.valueOf("0001000") == 1000) {
			System.out.println("00010 = 10");
		}
	}
	

	public class InnerClass extends Thread {
		int bla = 123;
		
		InnerClass getInnterClass(){
			return new InnerClass();
		}
		
		public void run(){
			
		}
		
	}
	
	@Test
	public void balbal(){
		Integer i1 = 2001; // set 1
		Integer i2 = 2001;
		System.out.println((i1 == i2) + " " + i1.equals(i2)); // output 1
		Integer i3 = 21; // set 2
		Integer i4 = new Integer(21);
		System.out.println((i3 == i4) + " " + i3.equals(i4)); // output 2
		Integer i5 = 21; // set 3
		Integer i6 = 21;
		System.out.println((i5 == i6) + " " + i5.equals(i6)); // output 3
		i5 = 5000;
		System.out.println("i5=" + i5 +" i6="+ i6);
		
	}
}

class BlaBal {
	Chapter9Test c = new Chapter9Test();
	Chapter9Test.InnerClass i = c.new InnerClass();
	
	
}
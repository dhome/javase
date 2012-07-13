package ch.h2m.edu.scjp;

import java.util.HashSet;
import java.util.Set;

/**
 * Inner Classes
 * 
 * <ul>
 * <li>Access to instance var from innerclass by ClassName.this.varNameS</li>
 * <li>Access to local variable inside a "method"innerclass only works, if variable is final</code></li>
 * <li>A "method"innerclass  has only the modifiers are abstract or final</code></li>
 * </ul>
 * 
 * @author Heinz
 */
public class Chapter8 {

	int x = 12;
	int y = 10;
	
	InnerChapter8 ic8 = new InnerChapter8(){
		public void printX(){
			System.out.println("XXXXXXXXXXXXX");
		}
		public void printZ(){
			System.out.println("ZZZZZZZZZZZ");
		}
	};
	
	public void innerclassCall(){
		ic8.printX();
//		ic8.printZ();  -> not possible!
	}
	
	public class InnerChapter8{
		int x = 13;
		
		public void printX(){
			System.out.println("x="+x);
			System.out.println("this.x="+this.x);
			System.out.println("Chapter8.this.x="+Chapter8.this.x);
			System.out.println("y="+y);
		}
	}
	
}

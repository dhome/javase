package ch.h2m.edu.scjp.extend;

import com.sun.research.ws.wadl.Doc;

public class Cat extends Animal {
	
	public int a = 8;
	
	public void addFive(){
		a += 5;
		System.out.println("b");
	}
	
	public static void main(String... args){
		
		String s = "x1 23 y #";
		String[] split = s.split("\\w");
		System.out.println(s.length());
		for (String string : split) {
			System.out.println(string);
		}
		
//		Animal a = new Cat();
//		Cat c = new Cat();
//		
//		Cat c2 = (Cat) a;
//		Animal a2 = c2;
//		
//		a2.addFive();
//		System.out.println(a2.a);
//		
//		StringBuffer sb = new StringBuffer("123456789");
//		sb.delete(0, 3);  		 //456789
//		sb.replace(1, 3, "24");  //424789
//		sb.delete(4, 6);         //4247
//		System.out.println(sb);
		
	}

}

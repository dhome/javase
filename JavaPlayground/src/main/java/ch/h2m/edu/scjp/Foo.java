package ch.h2m.edu.scjp;

public class Foo implements Dummy {
	
	public static void printttt(){
		System.out.println("asdjf");
	}
	public static String sdf = "dsf";
	public static final String blaStringFinal = "dsfds";
	
	enum Lampe{
		ON, 
		OFF{
			@Override
			public String toString() {
				return "dunkel";
			};
		}
	}

	@Override
	public void method1() {
		long asdf = 123L;
		Integer i1 = 123;
		Integer i2 = 234;
		while(true);
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public class Bar extends Foo{
		public Bar() {
			// TODO Auto-generated constructor stub
		}
		
		boolean test(Integer[] bla[]) {
			return false;
		}
		
		public void go(){
			super.method1();
		}
	}
	
	

	
}

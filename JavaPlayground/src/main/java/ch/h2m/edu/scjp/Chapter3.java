package ch.h2m.edu.scjp;

/**
 * Topic: Assignement
 * 
 * @author Heinz
 *
 */
public class Chapter3 {

	/**
	 * Key Points:
	 *   - Shadowing Variables
	 *   - widening, boxing, var-args
	 *   	> primitive widening use the smallest method arguments possible
	 *      > Used individually, boxing and var-args are compativle with overloading
	 *      > you cannot widen from one wrapper type to another
	 *      > you cannot widen and then box (f.e. int -> Long)
	 *      > you can box and then widen (int -> Integer -> Object)
	 *      > you can combine var-args with either widening or boxing
	 *   
	 */
	
	static int intStatic;	
	int intInstance;
	
	int [] key_1;
	int key_2 [];
	int [] [] multiDimension;
	int [] [] dots = {{6, intInstance, 8}, {intStatic, 12}};
	
	//initialize Blocks run after the constructor's call super()
	{intInstance = 7;}
	static {intStatic = 11;}
	
	Bar bar = new Bar();
	
	public Chapter3() {
		multiDimension = new int [2] [];
		multiDimension[0] = new int[2];
		multiDimension[0][0] = 1;
		multiDimension[0][1] = 2;
		multiDimension[1] = new int[1];
		multiDimension[1][0] = 3;
		
	}
	
	public void shadowingChangeIt(Bar bar){
		bar.bar = 99;
		System.out.println("changeIt [bar.bar="+bar.bar+"]");
		bar = new Bar();
		bar.bar = 44;
		System.out.println("changeIt [bar.bar="+bar.bar+"]");
	}
	
	public void methodWithArrayParam(int [] someArray){
		System.out.println("[someArray.length="+someArray.length+"]");
	}
	
	public void magicComparition(){
		//int from -128 to 127 are stored the same way
		Integer i1 = 1200;
		Integer i2 = 1200;
		if (i1 != i2) {
			System.out.println("i1 != i2");
		}
		i1 = 12;
		i2 = 12;
		if (i1 == i2) {
			System.out.println("i1 == i2");
		}
		
	}
	
	
	public class Bar {
		int  bar = 28;
	}
	
	public enum Suits{
		CLUBS(20), DIAMONDS(20), HEARTS(30), SPADES(30), NOTRUMP(40) {
			public int getValue(int bid){
				return((bid-1)*30) +40;}
			};
				Suits(int points) {
					this.points = points;
			}
				private int points;
				public int getValue(int bid) {
					return points * bid;
		}
	}
	
}

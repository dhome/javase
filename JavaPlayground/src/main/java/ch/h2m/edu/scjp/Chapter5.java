package ch.h2m.edu.scjp;

/**
 * Flow Control, Exception and Assertions
 * 
 * Switch
 * <ul>
 * <li>A switch expression must encapsulate to a <code>char</code>,
 * <code>byte</code>, <code>short</code>, <code>int</code> or <code>enum</code></li>
 * </ul>
 * 
 * Exceptions
 * <ul>
 * <li>Object -> Throwable -> Error -> ...</li>
 * <li>Object -> Thorwable -> Exception -> RuntimeException -> ..</li>
 * <li>Object -> Thorwable -> Exception -> ...</li>
 * <li>The Exception handlers (<code>catch(...)</code>) for the most specific
 * exceptions must always be placed above those for more general exceptions.</li>
 * <li>All non <code>RuntimeExceptions</code> or <code>Error</code> are
 * considered "checked" exceptions, and must be catch (or re-throw)</li>
 * </ul>
 * 
 * Assert
 * <ul>
 * <li>Check at development and debug-time variable for not allowed values.</li>
 * <li>At Production, the statements are deactivated (performance)</li>
 * <li><code>assert(false): "message" + methodWithReturn() + integer;</code></li>
 * </ul>
 * 
 * @author Heinz
 * 
 */
public class Chapter5 {

	public void ifExamples() {

		if (true)
			if (1 < 0)
				System.out.println("1<0");
			else
				System.out.println("else");

		int x = 5;
		int y = 2;
		if ((x > 3 && y < 2) | true) {
			System.out.println("true");
		}
	}

	public void switchExamples() {
		switch (new Integer(4)) {
		case 4:
			System.out.println("boxing is OK");
		}

		int x = 7;
		switch (x) {
		case 2:
			System.out.println("never printed");
		default:
			System.out.println("will be printed");
		case 3:
			System.out.println("printed too");
		case 4:
			System.out.println("printed too");
		}
	}

	public void forExample1() {
		for (/* Initialization */int i = 0; /* Condition */i < 2; /* Iteration */i++) {

		}
		for (int i = 0, y = 10; i < y; i++, y++) {
			System.out.println("[i=" + i + ", y=" + y + "]");
		}
	}

	public void forExample2() {
		outer: for (int i = 0; i < 10; i++) {
			int j = 0;
			for (; j < 10; j++) {
				System.out.println("i-for");
				break outer;
			}
			System.out.println("j-for [i=" + i + " j=" + j + "]");
		}

	}

	public void assertExamples(int x) {
		assert (x > 0) : "don't check variable in public method with assert";
		assert (true);
		assert (false) : x++;
		assert (false) : "I will print all the time";
		System.out.println("finished [x=" + x + "]");

	}

}

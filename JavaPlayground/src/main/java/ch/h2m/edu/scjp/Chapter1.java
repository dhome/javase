package ch.h2m.edu.scjp;

/**
 * Declaration and Access Control
 * 
 * Interface
 * <ul>
 * <li>All methods are <code>public abstract</code></li>
 * <li>Interface define instance methods</li>
 * <li>Constants are always <code>public static final ...</code></li>
 * </ul>
 * 
 * Access Control
 * <ul>
 * <li>The reference <code>this</code> always refers to the current executing
 * object</li>
 * <li><code>protected</code> - for a subclass outside the package, the
 * <code>protected</code> member can be accessed only through inheritance.
 * <code>default</code> members can only accessed by classes in the same package
 * </li>
 * </ul>
 * 
 * Declaration
 * <ul>
 * <li>var-args must specify the type (primitv or object)</li>
 * <li>it's the last paramter</li>
 * <li>looks like<code>void doStuff(int... x)</code></li>
 * </ul>
 * 
 * Constructor
 * <ul>
 * <li>Cannot be marked as <code>final</code> or <code>abstract</code> or
 * <code>static</code></li>
 * </ul>
 * 
 * Enum Declaration
 * <ul>
 * <li>Outside a class <code>public</code> or <code>default</code></li>
 * <li>Inside a class, No semicolon is needed</li>
 * <li>the enummerated values are constants (<code>static final</code>)</li>
 * </ul>
 * 
 * Legal Identifier starts with
 * <ul>
 * <li>letter</li>
 * <li>currency character</li>
 * <li>connection character</li>
 * </ul>
 * 
 * @author Heinz
 * 
 */
public class Chapter1 {

	enum CoffeeSize {
		BIG(8), HUGE(10), OVERHELMING(16);
		CoffeeSize(int ounces) {
			this.ounces = ounces;
		}

		private int ounces;

		public int getOunces() {
			return ounces;
		}
	}

}

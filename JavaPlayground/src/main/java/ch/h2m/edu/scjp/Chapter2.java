package ch.h2m.edu.scjp;

/**
 * Object Orientation
 * 
 * @author Heinz
 *
 */
public class Chapter2 {
	
	/**
	 * OO<ul>
	 * <li>IS_A: this thing is a type of that thing</li>
	 * <li>HAS_A: based on usage</li>
	 * </ul>
	 * 
	 * Override<ul>
	 * <li>Compiler looks only at the referenceType, not instance types. The method in the reference type will be executed</li>
	 * <li>Access level can be less restrective</li>
	 * <li>The override method can throw any unchecked (runtime) exception, regardless of whether the overridden method declares the exception, but cannot thrwo checkt exception</li>
	 * <li><code>static</code> and <code>final</code> can not be overridden </li>
	 * </ul>
	 * 
	 * Overload<ul>
	 * <li>must change the argument list</li>
	 * </ul>
	 * 
	 * Constructor<ul>
	 * <li>chaining: every constructor is invoked of its superclass</li>
	 * <li>sorting: example: Object -> Animal -> Horse</li>
	 * <li>the first line in a constructor must be a call to <code>super()</code) or a call to <code>this()</code></li>
	 * </ul>
	 * 
	 * Else<ul>
	 * <li>Polymorphism is only for instance methods</li>
	 * <li>Overload var-args methods are choosen last</li>
	 * </ul>
	 * 
	 */

}

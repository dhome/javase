package ch.h2m.edu.scjp;

/**
 * Generics and Collections
 * 
 * Overriding hasCode/equals
 * <ul>
 * <li>The equals contract says, it is...
 * <ul>
 * <li>reflexive -> <code>x.equals(x)</code> returns true</li>
 * <li>symmetric -> <code>x.equals(y) == y.equals(x)</code></li>
 * <li>transitiv -> <code>x.equals(y) == y.equals(z) == x.equals(z)</code></li>
 * <li>consistent -> all time the same result</li>
 * <li>for any non-null reference value x, <code>x.equals(null)</code> should
 * return null</li>
 * </ul>
 * </li>
 * <li>hashCode contract says, it is
 * <ul>
 * <li>whenever it is invoked on the same object more than once during an
 * execution of a Java application, the hashCode() method must consitently
 * return the same integer, privided no information used in equals comparisons
 * on the object is modified</li>
 * <li><code>obj.equals(obj2) && obj.hashCode()== obj2.hashCode()</code></li>
 * </ul>
 * It is NOT required that if two objects are unequal according to the <code>
 * equals()</code> method, then calling the hasCode() method on each of the two
 * object must produce distinct integer result.</li>
 * </ul>
 * 
 * 
 * Collections
 * <ul>
 * <li>Core Interface -> Collection, List (ArrayList, Vector, LinkedList), Queue
 * (PriorityQueue), Set (HashSet, Linked HashSet, TreeSet), Map (HashMap,
 * Hashtable , TreeMap, LinkedHashMap), NavigableSet, SortedSet, SortedMap,
 * NavigableMap</li>
 * <li>ordered vs. sorted. Sorted by the interface Comparable/Comparator</li>
 * <li>sorting by comparable (interface) or Comparator (class)
 * <ul>
 * <li>comparable: int obj1.compareTo(obj2) -> Collections.sort(myClass)</li>
 * <li>comparator: int compare(obj1, obj2) -> Colelctions.sort(myClass,
 * myComparator)</li>
 * </ul>
 * </li>
 * <li></li>
 * <li></li>
 * 
 * @author Heinz
 */
public class Chapter7 {

}

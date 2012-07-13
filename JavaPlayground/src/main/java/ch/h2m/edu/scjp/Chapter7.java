package ch.h2m.edu.scjp;

import java.util.HashSet;
import java.util.Set;

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
 * <li>It is NOT required that if two objects are unequal according to the <code>
 * equals()</code> method, then calling the hasCode() method on each of the two
 * object must produce distinct integer result.</li>
 * <li>is hashcode not overriden, each object as a unique hashcode</li>
 * <li>Set's based on hashcode. is hashcode equal, then the equal method is called</li>
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
 * </ul>
 * 
 * Generics
 * <ul>
 * <li>Method parameter as a List<? ..> can not add any object into it</li>
 * </ul>
 * 
 * @author Heinz
 */
public class Chapter7 {
	
	
	public int setsWithHashCode(){
		Set<MyClassHashCode> s = new HashSet<MyClassHashCode>();
		s.add(new MyClassHashCode("bla", 12));
		s.add(new MyClassHashCode("bla", 12));
		s.add(new MyClassHashCode("asdf", 13));
		return s.size();
	}
	public int setsWithEquals(){
		Set<MyClassEquals> s = new HashSet<MyClassEquals>();
		s.add(new MyClassEquals("bla", 12));
		s.add(new MyClassEquals("bla", 12));
		s.add(new MyClassEquals("asdf", 13));
		return s.size();
	}
	public int setsWithEqualsHashcode(){
		Set<MyClassEqualsHashCode> s = new HashSet<MyClassEqualsHashCode>();
		s.add(new MyClassEqualsHashCode("bla", 12));
		s.add(new MyClassEqualsHashCode("bla", 12));
		s.add(new MyClassEqualsHashCode("asdf", 13));
		return s.size();
	}
	

	public class MyClassHashCode{
		private String name;
		private int i;

		public MyClassHashCode(String name, int i) {
			super();
			this.name = name;
			this.i = i;
		}
		
		public String getName() {
			return name;
		}
		
		public int getI() {
			return i;
		}

		@Override
		public int hashCode() {
			return 2;
		}
	}
	
	public class MyClassEquals{
		private String name;
		private int i;
		
		public MyClassEquals(String name, int i) {
			super();
			this.name = name;
			this.i = i;
		}
		
		public String getName() {
			return name;
		}
		
		public int getI() {
			return i;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MyClassEquals other = (MyClassEquals) obj;
			if (i != other.i)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		
	}
	
	public class MyClassEqualsHashCode{
		private String name;
		private int i;
		
		public MyClassEqualsHashCode(String name, int i) {
			super();
			this.name = name;
			this.i = i;
		}
		
		public String getName() {
			return name;
		}
		
		public int getI() {
			return i;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MyClassEqualsHashCode other = (MyClassEqualsHashCode) obj;
			if (i != other.i)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		
	}
	
}

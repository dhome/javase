package ch.h2m.edu.scjp;

/**
 * Strings, I/O, Formatting, Parsing
 * 
 * String
 * <ul>
 * <li>Strings are immutable. A String object can never change. It creates a new
 * one.</li>
 * <li>StringBuilder has the same API as StringBuffer, but is not thread safe</li>
 * <li>StringBuilder and StringBuffer can be changed</li>
 * </ul>
 * 
 * File Navigation & I/O
 * <ul>
 * <li><code>File</code> is an abstract representation of file and directory
 * pathnames. The file class isn't used to actually read or write data</li>
 * <li><code>FileReader</code> or <code>FileWriter</code> is used to read
 * character files. The <code>read()</code> methods are low-level, which allow
 * read single-, the whole stream of - or a fixed number of characters</li>
 * <li><code>BufferedReader</code> or <code>BufferedWriter</code> Make
 * lower-level Reader class more efficient and easier to use. (f.e.
 * <code>readLine()</code>)</li>
 * <li><code>PrintWriter</code> wrap <code>Writer</code> and/or
 * <code>BufferedWriter</code> and add new methods like
 * <code>format(), printf(), append()</code></li>
 * <li>Stream Classes read and write bytes.</li>
 * <li>Reader and Writer Classes read and write characters.</li>
 * <li><code>File f = new File("myFile.txt");</code> don't create a file. Only
 * the method <code>file.createNewFile();</code> or creating a Writer / Stream
 * based on this <code>file</code>, creates the file</li>
 * </ul>
 * 
 * 
 * Serialization & I/O
 * <ul>
 * <li>When an instance of a serializable class is deserialized, the constructor
 * does not run, and instance variables are NOT given their initially assigned
 * values.</li>
 * <li>static or transient variables are never saved</li>
 * <li>Any attempt to serialize an instance of an object with a non transient, 
 * non serializable field throw an exception in runtime</li>
 * <li>to alter the standard deserialization process you would implement the 
 * <code>readObject()</code> method in this class</li>
 * </ul>
 * 
 * Dates, Numbers and Currency
 * <ul>
 * <li><code>java.util.Date</code> Most are deprecated. Is usefull to bridge
 * between the <code>Calendar</code> and <code>DateFormat</code>; easy to use
 * for quick and dirty way to get the current date and time; it is good when you
 * want a universal time that is not affected by time zones.</li>
 * <li><code>java.util.Calendar</code> convert and manipulate dates and times</li>
 * <li><code>java.text.DateFormat</code> format dates. Can set only at the time
 * of instantiation. (<code>DateForamt.getDateInstance(DateFormat, Locale)</code> or <code>DateForamt.getInstance(DateFormat)</code>)</li>
 * <li><code>java.text.NumberFormat</code> format numbers and currencies. Can set
 * only at the time of instantiation.</li>
 * <li><code>java.util.Local</code> Is used in conjuction with
 * <code>DateFormat</code> and <code>NumberFormat</code> to format dates,
 * numbers and currency for specific locals;
 * <code>Local(String language, String country)</code>, the language argument
 * represents an ISO 639 Language Code.</li>
 * </ul>
 * 
 * 
 * Parsing, Tokenizing and Formatting
 * <ul>
 * <li>In general a regex search runs from left ot right, and once a source's
 * character has been used in a match, it cannot be reused</li>
 * <li>Regex
 * <ul>
 * <li>metacharacters:<ul>
 *  <li>\d -> A digit;</li>
 *  <li>\s -> a whitespace character;</li>
 *  <li>\w -> a word character (letters, digits, or underscore</li></ul></li>
 * <li>[a-fA-F]: Search for the first 6 letters of the alphabet, both case</li>
 * <li>+ means "one or more"</li>
 * <li>0[xX]([0-9a-fA-F])+ looks for hex-numbers</li>
 * <li>* means "Zero or more occurrences"</li>
 * <li>? means "Zero or one occurrence"</li>
 * <li>. means "any character can serve here"</li>
 * <li>"ab.cde.fg".split("\\.");</li>
 * <li>The greedy quantifier (?) does in fact read the entire source data, and
 * then it works backward (from the right) until it finds the rightmost match.
 * At the point, it includes everything from earlier in the source data up to
 * and including the data that is part of the right most match.</li>
 * </ul></li>
 * <li>Regex usage:<br/>
 * <code>Pattern p = new Pattern.compile(MyRegexPattern);
 * Matcher m = p.matcher(textToParse);
 * m.find(); m.start(); m.group();</code></li>
 * <li>Scanner Class can also used for regex search: 
 * <code>Scanner s = new Scanner(System.in);
 * String token; do {token=s.findInLIne(MyRegexPattern); System.out.println(token);}
 * while(token != null);</code></li>
 * <li>Formatting with <code>printf()</code> and <code>format()</code>. The syntax lookslike: 
 * <code>%[arg_index$][flags][width][.precision] conversion char</code><ul>
 * <li>arg_index: An integer followed directly by a $ which indicates the argument should be printed.</li>
 * <li>flags: "-" -> Left justify; "+" -> Include a sign (+ or -); "0" -> Pad with zeroes; "," locale-spef. grouping separators; "(" -> negative numbers in parenthese</li>
 * <li>width: minimum number of characters to print</li>
 * <li>precision: number of digits to print after the decimal point</li>
 * <li>conversion: "b" -> boolean; "c" -> char; "d" -> integer; "f" -> floating point; "s" -> string</li>
 * </ul></li>
 * </ul>
 * 
 * @author Heinz
 * 
 */
public class Chapter6 {

	public void stringRef() {
		String s1 = "Hallo";
		String s2 = s1;

		s1 += " Heinz";

		System.out.println("[s1=" + s1 + ", s2=" + s2 + "]");
		System.out.println("[s1.toString=" + s1.toString() + "]");
	}

}

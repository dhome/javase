package ch.h2m.edu.scjp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class Chapter6Test {

	@Test
	public void stringRefs() {
            System.out.println("stringRefs-----");
		Chapter6 chp6 = new Chapter6();
		chp6.stringRef();
	}

        @Test
        public void regexTest(){
            System.out.println("regexText----");
        String myRegex = "\\d*";
        String myText = "ab34ef";
            Pattern p = Pattern.compile(myRegex);
            Matcher m = p.matcher(myText);
            boolean b = false;
            while(b = m.find()){
                System.out.print(m.start() + m.group());
            }
        }
}

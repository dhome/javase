/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.h2m.edu.scjp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author hem
 */
public class ExameQuestion {

    private Set<Integer> numbers = new TreeSet<Integer>();

    public ExameQuestion(int... nums) {
        for (int n : nums) {
            numbers.add(n);
        }
    }
    
    public void serialiazObject() throws IOException {
    	Pattern pattern = Pattern.compile("\\.");
    	Matcher matcher = pattern.matcher("my long string with . withspace . and points");
    	while(matcher.find()){
    		int start = matcher.start();
    	}
    	
    	Locale ch = Locale.getDefault();
    	DateFormat df = DateFormat.getInstance();
    	ExamClass ec = new ExamClass();
    	File f = new File("Exam");
    	FileOutputStream fos = new FileOutputStream(f);
    	OutputStream out = new ObjectOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(ec);
		
    }

    public ExameQuestion negate() {
        ExameQuestion negatives = new ExameQuestion();
        for (int n : numbers) {
            negatives.numbers.add(-n);
        }
        return negatives;
    }

    public void show() {
        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        new ExameQuestion(1, 3, -5).negate().show();
    }
}

package ch.h2m.edu.patternplayground.interpreter;

import java.util.HashMap;

/**
 * Number.java
 *
 * Created on 09.11.2011, 16:06:25
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Number implements Expression {

    private int number;

    public Number(int number) {
        this.number = number;
    }
    
    @Override
    public int interpret(HashMap<String, Expression> variables) {
        return number;
    }
    
}

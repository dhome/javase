package ch.h2m.edu.patternplayground.interpreter;

import java.util.HashMap;

/**
 * Minus.java
 *
 * Created on 09.11.2011, 16:10:50
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Minus implements Expression {

    private Expression minuend;
    private Expression subtrahend;

    public Minus(Expression minuend, Expression subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }

    @Override
    public int interpret(HashMap<String, Expression> variables) {
        return minuend.interpret(variables) - subtrahend.interpret(variables);
    }
    
}

package ch.h2m.edu.patternplayground.interpreter;

import java.util.HashMap;

/**
 * Plus.java
 *
 * Created on 09.11.2011, 16:08:12
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Plus implements Expression {
    
    private Expression leftSummand;
    private Expression rightSummand;

    public Plus(Expression leftSummand, Expression rightSummand) {
        this.leftSummand = leftSummand;
        this.rightSummand = rightSummand;
    }

    @Override
    public int interpret(HashMap<String, Expression> variables) {
        return leftSummand.interpret(variables) + rightSummand.interpret(variables);
    }
    
}

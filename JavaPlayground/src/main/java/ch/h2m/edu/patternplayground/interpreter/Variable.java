package ch.h2m.edu.patternplayground.interpreter;

import java.util.HashMap;

/**
 * Variable.java
 *
 * Created on 09.11.2011, 16:12:40
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Variable implements Expression {

    private String name;

    public Variable(String name) {
        this.name = name;
    }
    
    @Override
    public int interpret(HashMap<String, Expression> variables) {
        return (variables.get(name) == null) 
                ? 0 
                : variables.get(name).interpret(variables);
    }
}

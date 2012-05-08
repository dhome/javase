package ch.h2m.edu.patternplayground.interpreter;

import java.util.HashMap;

/**
 * NewClass.java
 *
 * Created on 09.11.2011, 16:05:00
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public interface Expression {
    public int interpret(HashMap<String, Expression> variables);
}

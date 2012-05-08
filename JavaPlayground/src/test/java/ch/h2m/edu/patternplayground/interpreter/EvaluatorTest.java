package ch.h2m.edu.patternplayground.interpreter;


import java.util.HashMap;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Testing interpreter pattern with the "Reverse Polish notation"
 * 
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class EvaluatorTest {
    
    public EvaluatorTest() {
    }

    
    @Test
    public void interpretterPattern1() {
        String expression = "x z +";
        Evaluator sentence = new Evaluator(expression);
        HashMap<String,Expression> variables = new HashMap<>();
        variables.put("x", new Number(21));
        variables.put("z", new Number(43));
        int result = sentence.interpret(variables);
        assertTrue(result == 64);
    }
    
    @Test
    public void interpretterPattern2() {
        String expression = "w x z - +";
        Evaluator sentence = new Evaluator(expression);
        HashMap<String,Expression> variables = new HashMap<>();
        variables.put("w", new Number(5));
        variables.put("x", new Number(10));
        variables.put("z", new Number(42));
        int result = sentence.interpret(variables);
        assertTrue(result == 57);
    }
}

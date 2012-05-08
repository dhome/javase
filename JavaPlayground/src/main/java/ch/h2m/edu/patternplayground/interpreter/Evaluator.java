package ch.h2m.edu.patternplayground.interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * Evaluator.java
 *
 * Created on 09.11.2011, 16:15:49
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Evaluator implements Expression {

    private Expression syntaxTree;

    public Evaluator(String expression) {
        Stack<Expression> expressionStack = new Stack<>();
        for (String token : expression.split(" ")) {
            switch (token) {
                case "+":
                    {
                        Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
                        expressionStack.push(subExpression);
                        break;
                    }
                case "-":
                    {
                        // it's necessary remove first the right operand from the stack
                        Expression right = expressionStack.pop();
                        // ..and after the left one
                        Expression left = expressionStack.pop();
                        Expression subExpression = new Minus(left, right);
                        expressionStack.push(subExpression);
                        break;
                    }
                default:
                    expressionStack.push( new Variable(token));
                    break;
            }
        }
        this.syntaxTree = expressionStack.pop();
    }

    @Override
    public int interpret(HashMap<String, Expression> context) {
        return syntaxTree.interpret(context);
    }
}

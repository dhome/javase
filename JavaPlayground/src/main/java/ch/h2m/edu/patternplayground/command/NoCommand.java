package ch.h2m.edu.patternplayground.command;

/**
 * NoCommand.java
 *
 * Created on 29.11.2011, 12:32:07
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class NoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("dump");
    }

    @Override
    public void undo() {
        System.out.println("dump");
    }
    
}

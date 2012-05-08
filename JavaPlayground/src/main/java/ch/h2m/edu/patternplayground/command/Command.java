package ch.h2m.edu.patternplayground.command;

/**
 * Command.java
 *
 * Created on 09.11.2011, 14:34:06
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public interface Command {
    public void execute();
    public void undo();
}

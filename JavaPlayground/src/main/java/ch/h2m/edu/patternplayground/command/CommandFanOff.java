package ch.h2m.edu.patternplayground.command;

/**
 * CommandFanOff.java
 *
 * Created on 09.11.2011, 14:35:29
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class CommandFanOff implements Command {

    private Fan fan;

    public CommandFanOff(Fan fan) {
        this.fan = fan;
    }
    
    @Override
    public void execute() {
        fan.stopRotate();
    }

    @Override
    public void undo() {
        fan.undoRotate();
    }
    
}

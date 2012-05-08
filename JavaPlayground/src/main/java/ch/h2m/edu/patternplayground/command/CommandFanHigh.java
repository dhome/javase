package ch.h2m.edu.patternplayground.command;

/**
 * CommandFanOn.java
 *
 * Created on 09.11.2011, 14:35:29
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class CommandFanHigh implements Command {

    private Fan fan;

    public CommandFanHigh(Fan fan) {
        this.fan = fan;
    }
    
    @Override
    public void execute() {
        fan.startRotateHigh();
    }

    @Override
    public void undo() {
        fan.undoRotate();
    }
    
}

package ch.h2m.edu.patternplayground.command;

/**
 * CommandLightOff.java
 *
 * Created on 09.11.2011, 14:35:29
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class CommandLightOff implements Command {

    private Light light;

    public CommandLightOff(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
    
}

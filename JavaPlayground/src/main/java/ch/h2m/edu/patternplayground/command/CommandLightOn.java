package ch.h2m.edu.patternplayground.command;

/**
 * CommandLightOn.java
 *
 * Created on 09.11.2011, 14:35:29
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class CommandLightOn implements Command {

    private Light light;

    public CommandLightOn(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
    
}

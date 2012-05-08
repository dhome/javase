package ch.h2m.edu.patternplayground.command;

/**
 * RemoteControl.java
 *
 * Created on 27.11.2011, 16:49:33
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class RemoteControl {
    
    Command[] switches;
    Command noCommand;
    Command undoCommand;

    public RemoteControl() {
        switches = new Command[8];
        noCommand = new NoCommand();
        for(int i = 0; i < switches.length; i++){
            switches[i] = noCommand;
        }
        undoCommand = noCommand;
    }
    
    public void setCommand(int i, Command cmd) {
        switches[i] = cmd;
    }
    
    public void buttonPressed(int i) {
        switches[i].execute();
        undoCommand = switches[i];
    }
    
    public void buttonUndoPressed() {
        undoCommand.undo();
    }
    
}

package ch.h2m.edu.patternplayground.command;

/**
 * Switch.java
 *
 * Created on 09.11.2011, 14:33:43
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Switch {

    private Command UpCommand, DownCommand;

    public Switch(Command Up, Command Down) {
        UpCommand = Up; // concrete Command registers itself with the invoker 
        DownCommand = Down;
    }

    void flipUp() { // invoker calls back concrete Command, which executes the Command on the receiver 
        UpCommand.execute();
    }

    void flipDown() {
        DownCommand.execute();
    }
}

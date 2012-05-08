package ch.h2m.edu.patternplayground.command;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class CommandTest {

    public CommandTest() {
    }

    /**
     * Test of execute method, of class Command.
     */
    @Test
    public void commandPatternLightSwitch() {
        Light testLight = new Light();
        CommandLightOn testLOC = new CommandLightOn(testLight);
        CommandLightOff testLFC = new CommandLightOff(testLight);
        
        Switch testSwitch = new Switch(testLOC, testLFC);
        testSwitch.flipUp();
        testSwitch.flipDown();
    }
    
    @Test
    public void commandPatternFanSwitch() {
        Fan testFan = new Fan();
        CommandFanHigh foc = new CommandFanHigh(testFan);
        CommandFanOff ffc = new CommandFanOff(testFan);
        Switch ts = new Switch(foc, ffc);
        ts.flipUp();
        ts.flipDown();
    }
    
    @Test
    public void remoteControl(){
        System.out.println("-----remoteControl-----");
        Fan fan = new Fan();
        Light light = new Light();
        RemoteControl remoteControl = new RemoteControl();
        CommandFanOff cfOff = new CommandFanOff(fan);
        CommandFanHigh cfH = new CommandFanHigh(fan);
        CommandFanLow cfL = new CommandFanLow(fan);
        CommandFanMedium cfM = new CommandFanMedium(fan);
        CommandLightOn clOn = new CommandLightOn(light);
        CommandLightOff clOff = new CommandLightOff(light);
        
        remoteControl.setCommand(0, cfOff);
        remoteControl.setCommand(1, cfH);
        remoteControl.setCommand(2, cfL);
        remoteControl.setCommand(3, cfM);
        remoteControl.setCommand(4, clOn);
        remoteControl.setCommand(5, clOff);
        
        remoteControl.buttonPressed(1);
        int currentSpeed = fan.currentSpeed;
        remoteControl.buttonPressed(0);
        remoteControl.buttonUndoPressed();
        assertTrue(currentSpeed == fan.currentSpeed);
        remoteControl.buttonPressed(3);
        remoteControl.buttonUndoPressed();   
        assertTrue(currentSpeed == fan.currentSpeed);
        
        remoteControl.buttonPressed(5);
        remoteControl.buttonUndoPressed(); 
    }
}

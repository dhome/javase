package ch.h2m.edu.patternplayground.command;

/**
 * Fan.java
 *
 * Created on 09.11.2011, 14:32:39
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Fan {
    
    static final int HIGH = 3;
    static final int MEDIUM = 2;
    static final int SLOW = 1;
    static final int OFF = 0;

    int currentSpeed;
    int undoSpeed;

    public Fan() {
    }
    
    public void startRotateHigh() {
        undoSpeed = currentSpeed;
        currentSpeed = HIGH;
        System.out.println("Fan is rotating high");
    }
    public void startRotateMedium() {
        undoSpeed = currentSpeed;
        currentSpeed = MEDIUM;
        System.out.println("Fan is rotating medium");
    }
    public void startRotateLow() {
        undoSpeed = currentSpeed;
        currentSpeed = SLOW;
        System.out.println("Fan is rotating slow");
    }

    public void stopRotate() {
        undoSpeed = currentSpeed;
        currentSpeed = OFF;
        System.out.println("Fan is not rotating");
    }
        
    public void undoRotate() {
        switch(undoSpeed) {
            case 0:
                stopRotate();
                break;
            case 1:
                startRotateLow();
                break;
            case 2:
                startRotateMedium();
                break;
            case 3:
                startRotateHigh();
                break;
            default:
                System.out.println("No speed was set!");
        }
    }
}

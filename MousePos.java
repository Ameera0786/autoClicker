package autoClicker;

import java.awt.*;
import java.awt.event.InputEvent;

public class MousePos {
    public static void main(String[] args) throws AWTException, InterruptedException {
        // Create Robot object
        Robot robot = new Robot();
        while(true) {
            Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
            System.out.println("Mouse Position: X = " + mouseLocation.x + ", Y = " + mouseLocation.y);
//            System.out.println("Clicked");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(5000);
        }
    }
}

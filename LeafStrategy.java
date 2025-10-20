/*
 * Course: SWE2410-121
 * Fall 2025-2026
 * File header contains class LeafStrategy
 * Name: syeda
 * Created 10/1/2025
 */
package autoClicker;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.LocalDateTime;

/**
 * Course SWE2410-121
 * Fall 2025-2026
 * Class LeafStrategy Purpose: leaf strat
 *
 * @author syeda
 * @version created on 10/1/2025 10:28 AM
 */
public class LeafStrategy implements ModeStrategy{
    @Override
    public void execute(Robot robot) throws Exception {
        while (true) {
            LocalDateTime now = LocalDateTime.now();
            if (now.getMinute() == 16 && now.getSecond() < 40 ) {
                robot.mouseMove(850, 160);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.delay(1000);
            }
            robot.mouseMove(893, 520);
//            robot.mouseMove(500, 340);    //reward button
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(5000);
        }
    }
}
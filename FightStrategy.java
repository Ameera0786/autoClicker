/*
 * Course: SWE2410-121
 * Fall 2025-2026
 * File header contains class FightStrat
 * Name: syeda
 * Created 10/1/2025
 */
package autoClicker;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Course SWE2410-121
 * Fall 2025-2026
 * Class FightStrat Purpose: Fight strat
 *
 * @author syeda
 * @version created on 10/1/2025 10:07 AM
 */
public class FightStrategy extends Helper implements ModeStrategy{
    private static final int DURATION = 60 * 10_000;
    private static final int CLICK_DURATION = 4_000;

    @Override
    public void execute(Robot robot) throws Exception {
        while (true) {
            // Save the current mouse position
            Point originalPosition = MouseInfo.getPointerInfo().getLocation();

            // Move to input and type command
            robot.mouseMove(1040, 700);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            typeCommand(robot, "!fight-mob");
            robot.delay(2000); // Let the command register

            // Click for 5 seconds
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < CLICK_DURATION) {
                robot.mouseMove(1020, 560);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.delay(50); // Simulate rapid clicking
            }

            // Move mouse back to original position
            robot.mouseMove(originalPosition.x, originalPosition.y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            // Wait the rest of the duration
            long remaining = DURATION - CLICK_DURATION;
            if (remaining > 0) {
                //Mine or wait
                mineHelper(robot, remaining);
                //robot.delay(remaining);
            }
        }
    }
}
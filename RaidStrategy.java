/*
 * Course: SWE2410-121
 * Fall 2025-2026
 * File header contains class RaidStrategy
 * Name: syeda
 * Created 10/1/2025
 */
package autoClicker;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Course SWE2410-121
 * Fall 2025-2026
 * Class RaidStrategy Purpose: Raid strat
 *
 * @author syeda
 * @version created on 10/1/2025 10:05 AM
 */
public class RaidStrategy implements ModeStrategy {
    private void raidExit(Robot robot) {
        robot.delay(150000);        //Time to run raid. 1000 = 1 sec
        robot.mouseMove(778, 75);      //exit button
        robot.delay(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(3000);
    }

    @Override
    public void execute(Robot robot) {
        while (true) {
            robot.mouseMove(833,517);           // enter button
            robot.delay(1000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(50);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(50);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            robot.mouseMove(497, 342);
            robot.delay(1000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(50);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(50);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


            // x = 497, y = 342  ---> reward button
            //end
            boolean endRaid = true;             //TRUE IF WANTING TO EXIT RAID AFTER TIME.
            if (endRaid) {raidExit(robot); }
        }
    }
}
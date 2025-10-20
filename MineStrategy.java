/*
 * Course: SWE2410-121
 * Fall 2025-2026
 * File header contains class MineStrategy
 * Name: syeda
 * Created 10/1/2025
 */
package autoClicker;

import java.awt.*;
import java.awt.event.InputEvent;


/**
 * Course SWE2410-121
 * Fall 2025-2026
 * Class MineStrategy Purpose: Strategy for mining
 *
 * @author syeda
 * @version created on 10/1/2025 9:48 AM
 */
public class MineStrategy extends Helper implements ModeStrategy {
    private static final int MINE_CYCLE_DURATION = 20 * 60_000;  // 1000 = 1 sec

    @Override
    public void execute(Robot robot) throws Exception {
        while (true) {
            mineHelper(robot, MINE_CYCLE_DURATION);
            robot.mouseMove(1040, 700);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            typeCommand(robot, "!sell");
        }
    }
}
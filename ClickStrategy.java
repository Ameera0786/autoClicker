/*
 * Course: SWE2410-121
 * Fall 2025-2026
 * File header contains class ClickStrategy
 * Name: syeda
 * Created 10/1/2025
 */
package autoClicker;

import java.awt.*;

/**
 * Course SWE2410-121
 * Fall 2025-2026
 * Class ClickStrategy Purpose: Click
 *
 * @author syeda
 * @version created on 10/1/2025 10:29 AM
 */
public class ClickStrategy extends Helper implements ModeStrategy{
    private static final int DURATION = 10 * 60_000 * 24;
    @Override
    public void execute(Robot robot) throws Exception {
        clickSpot(robot, DURATION);
    }
}
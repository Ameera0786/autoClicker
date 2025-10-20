/*
 * Course: SWE2410-121
 * Fall 2025-2026
 * File header contains class Helper
 * Name: syeda
 * Created 10/1/2025
 */
package autoClicker;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Course SWE2410-121
 * Fall 2025-2026
 * Class Helper Purpose: Helper methods
 *
 * @author syeda
 * @version created on 10/1/2025 9:58 AM
 */
public abstract class Helper {
    public static void typeCommand(Robot robot, String command) {
        for (char c : command.toCharArray()) {
            typeChar(robot, c);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void typeChar(Robot robot, char c) {
        switch (c) {
            case '!':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case ' ':
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyRelease(KeyEvent.VK_SPACE);
                break;
            default:
                boolean upperCase = Character.isUpperCase(c);
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

                if (keyCode == KeyEvent.VK_UNDEFINED) {
                    System.out.println("Cannot type character: " + c);
                    return;
                }

                if (upperCase) robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                if (upperCase) robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
        }
    }

    public static void clickSpot(Robot robot, long clickDuration) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < clickDuration) {
            Point pos = MouseInfo.getPointerInfo().getLocation();
            int x = pos.x;
            int y = pos.y;
            robot.mouseMove(1040, 640);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(3000); // click every 6 seconds (same as your original code)
        }
    }

    public static void mineHelper(Robot robot, long mineCycleDuration) throws InterruptedException {
        robot.mouseMove(1040, 700);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        typeCommand(robot, "!mine");
        clickSpot(robot, mineCycleDuration);
    }
}

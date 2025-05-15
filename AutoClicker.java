package autoClicker;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class AutoClicker {
    enum Mode { NONE, MINE, FIGHT, CLICK }

    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        Mode currentMode;
        System.out.println("AutoClicker started. Type 'm' for mining, 'f' for fighting, or " +
                ",'c' to click, to q' to quit.");


        switch (input) {
            case "m":
                currentMode = Mode.MINE;
                System.out.println("Switched to MINE mode.");
                break;
            case "f":
                currentMode = Mode.FIGHT;
                System.out.println("Switched to FIGHT mode.");
                break;
            case "c":
                currentMode = Mode.CLICK;
                System.out.println("Switched to CLICK mode.");
                break;
            case "q":
                return;
            default:
                currentMode = Mode.NONE;
                System.out.println("Invalid input. Type 'm' (mine), 'f' (fight), or 'q' (quit).");
        }



        long lastMineTime = System.currentTimeMillis();
        while (true) {
            switch (currentMode) {
                case MINE:
                    mine(robot, 20 * 60_000);
                    break;
                case FIGHT:
                    fightMob(robot, 60 * 1000);
                    break;
                case CLICK:
                    click(robot);
                    break;
                default:
                    Thread.sleep(100); // idle briefly if no mode is selected
            }
        }
    }

    public static void mine(Robot robot, long mineCycleDuration) throws InterruptedException {
        while (true) {
            mineHelper(robot, mineCycleDuration);
            robot.mouseMove(1040, 700);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            typeCommand(robot, "!sell");
        }
    }
    public static void mineHelper(Robot robot, long mineCycleDuration) throws InterruptedException {
        robot.mouseMove(1040, 700);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        typeCommand(robot, "!mine");
        clickSpot(robot, mineCycleDuration);
    }


    public static void fightMob(Robot robot, long duration) throws InterruptedException {
        long clickDuration = 4000; // Click for 5 seconds

        while (true) {
            // Save the current mouse position
            Point originalPosition = MouseInfo.getPointerInfo().getLocation();

            // Move to input and type command
            robot.mouseMove(1040, 700);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            typeCommand(robot, "!fight-mob");
            Thread.sleep(2000); // Let the command register

            // Click for 5 seconds
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < clickDuration) {
                robot.mouseMove(1020, 560);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                Thread.sleep(50); // Simulate rapid clicking
            }

            // Move mouse back to original position
            robot.mouseMove(originalPosition.x, originalPosition.y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            // Wait the rest of the duration
            long remaining = duration - clickDuration;
            if (remaining > 0) {
                //Mine or wait 
                mineHelper(robot, remaining);
                //Thread.sleep(remaining);
            }
        }
    }

    public static void click(Robot robot) throws InterruptedException {
        long clickDuration = 10 * 60_000;
        clickSpot(robot, clickDuration);
    }

    private static void clickSpot(Robot robot, long clickDuration) throws InterruptedException {
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
            Thread.sleep(3000); // click every 6 seconds (same as your original code)
        }
    }

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
}

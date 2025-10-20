//package autoClicker;
//
//import java.awt.*;
//import java.awt.event.InputEvent;
//import java.awt.event.KeyEvent;
//import java.time.LocalDateTime;
//import java.util.Scanner;
//
//public class AutoClicker {
//    enum Mode { NONE, MINE, FIGHT, CLICK, LEAF, RAID }
//
//    public static void main(String[] args) throws Exception {
//        AutoClicker ac = new AutoClicker();
//        Robot robot = new Robot();
//        Scanner scanner = new Scanner(System.in);
//        Mode currentMode;
//        System.out.println("AutoClicker started. Type 'm' for mining, 'f' for fighting, or " +
//                ",'c' to click, 'l' for leaf, 'r' for raid, q' to quit.");
//        String input = scanner.nextLine().toLowerCase();
//
//
//        switch (input) {
//            case "m":
//                currentMode = Mode.MINE;
//                System.out.println("Switched to MINE mode.");
//                break;
//            case "f":
//                currentMode = Mode.FIGHT;
//                System.out.println("Switched to FIGHT mode.");
//                break;
//            case "c":
//                currentMode = Mode.CLICK;
//                System.out.println("Switched to CLICK mode.");
//                break;
//            case "l":
//                currentMode = Mode.LEAF;
//                System.out.println("Switched to LEAF mode");
//                break;
//            case "r":
//                currentMode = Mode.RAID;
//                System.out.println("Switched to RAID mode");
//                break;
//            case "q":
//                return;
//            default:
//                currentMode = Mode.NONE;
//                System.out.println("Invalid input. Type 'm' (mine), 'f' (fight), or 'q' (quit).");
//        }
//
//
//
//        while (true) {
//            switch (input) {
//                case "m":
//                    ac.mine(robot, 20 * 60_000);
//                    break;
//                case "f":
//                    ac.fightMob(robot, 60 * 1000);
//                    break;
//                case "c":
//                    ac.clickSpot(robot, 10 * 60_000);
//                    break;
//                case "l":
//                    ac.leaf(robot);
//                    break;
//                case "r":
//                    ac.raid(robot);
//                    break;
//                default:
//                    robot.delay(100); // idle briefly if no mode is selected
//            }
//        }
//    }
//
//    private void raidExit(Robot robot) throws InterruptedException {
//        robot.delay(150000);        //Time to run raid. 1000 = 1 sec
//        robot.mouseMove(778, 75);      //exit button
//        robot.delay(2000);
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.delay(50);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        robot.delay(2000);
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.delay(50);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        robot.delay(3000);
//    }
//
//    private void raid(Robot robot) throws InterruptedException{
//        while (true) {
//            robot.mouseMove(833,517);           // enter button
//            robot.delay(1000);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.delay(50);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.delay(50);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//            robot.mouseMove(497, 342);
//            robot.delay(1000);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.delay(50);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.delay(50);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//
//            // x = 497, y = 342  ---> reward button
//            //end
//            boolean endRaid = true;             //TRUE IF WANTING TO EXIT RAID AFTER TIME.
//            if (endRaid) {raidExit(robot); }
//        }
//    }
//
//    private void leaf(Robot robot) throws InterruptedException {
//        while (true) {
//            LocalDateTime now = LocalDateTime.now();
//            if (now.getMinute() == 16 && now.getSecond() < 40 ) {
//                robot.mouseMove(850, 160);
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                robot.delay(1000);
//            }
//            robot.mouseMove(893, 520);
////            robot.mouseMove(500, 340);    //reward button
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            robot.delay(10000);
//        }
//    }
//
//
//
//    private void fightMob(Robot robot, long duration) throws InterruptedException {
//        long clickDuration = 4000; // Click for 5 seconds
//
//        while (true) {
//            // Save the current mouse position
//            Point originalPosition = MouseInfo.getPointerInfo().getLocation();
//
//            // Move to input and type command
//            robot.mouseMove(1040, 700);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            typeCommand(robot, "!fight-mob");
//            robot.delay(2000); // Let the command register
//
//            // Click for 5 seconds
//            long startTime = System.currentTimeMillis();
//            while (System.currentTimeMillis() - startTime < clickDuration) {
//                robot.mouseMove(1020, 560);
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                robot.delay(50); // Simulate rapid clicking
//            }
//
//            // Move mouse back to original position
//            robot.mouseMove(originalPosition.x, originalPosition.y);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//            // Wait the rest of the duration
//            long remaining = duration - clickDuration;
//            if (remaining > 0) {
//                //Mine or wait
//                mineHelper(robot, remaining);
//                //robot.delay(remaining);
//            }
//        }
//    }
//
//    private void clickSpot(Robot robot, long clickDuration) throws InterruptedException {
//        long startTime = System.currentTimeMillis();
//
//        while (System.currentTimeMillis() - startTime < clickDuration) {
//            Point pos = MouseInfo.getPointerInfo().getLocation();
//            int x = pos.x;
//            int y = pos.y;
//            robot.mouseMove(1040, 640);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseMove(x, y);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            robot.delay(3000); // click every 6 seconds (same as your original code)
//        }
//    }
//
//    private void typeCommand(Robot robot, String command) {
//        for (char c : command.toCharArray()) {
//            typeChar(robot, c);
//        }
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//    }
//
//    private void typeChar(Robot robot, char c) {
//        switch (c) {
//            case '!':
//                robot.keyPress(KeyEvent.VK_SHIFT);
//                robot.keyPress(KeyEvent.VK_1);
//                robot.keyRelease(KeyEvent.VK_1);
//                robot.keyRelease(KeyEvent.VK_SHIFT);
//                break;
//            case ' ':
//                robot.keyPress(KeyEvent.VK_SPACE);
//                robot.keyRelease(KeyEvent.VK_SPACE);
//                break;
//            default:
//                boolean upperCase = Character.isUpperCase(c);
//                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
//
//                if (keyCode == KeyEvent.VK_UNDEFINED) {
//                    System.out.println("Cannot type character: " + c);
//                    return;
//                }
//
//                if (upperCase) robot.keyPress(KeyEvent.VK_SHIFT);
//                robot.keyPress(keyCode);
//                robot.keyRelease(keyCode);
//                if (upperCase) robot.keyRelease(KeyEvent.VK_SHIFT);
//                break;
//        }
//    }
//}

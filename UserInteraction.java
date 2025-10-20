/*
 * Course: SWE2410-121
 * Fall 2025-2026
 * File header contains class userInteraction
 * Name: syeda
 * Created 10/1/2025
 */
package autoClicker;

import java.awt.*;
import java.util.Scanner;

/**
 * Course SWE2410-121
 * Fall 2025-2026
 * Class userInteraction Purpose: interact with user and give input on what autoclicker will do
 *
 * @author syeda
 * @version created on 10/1/2025 9:45 AM
 */
public class UserInteraction {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        Scanner scanner = new Scanner(System.in);

        System.out.println("AutoClicker started.");
        System.out.println("Commands: ");
        System.out.println("  m = Mine");
        System.out.println("  f = Fight");
        System.out.println("  c = Click");
        System.out.println("  l = Leaf");
        System.out.println("  r = Raid");
        System.out.println("  q = Quit");
        String input = "";
        ModeStrategy currStrat;
        while (true) {
            if (scanner.hasNextLine()) {
                input = scanner.nextLine().toLowerCase();
                break;
            }
        }
        currStrat = ModeFactory.getStrategy(input);
        currStrat.execute(robot);
    }
}
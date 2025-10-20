/*
 * Course: SWE2410-121
 * Fall 2025-2026
 * File header contains class ModeStrategy
 * Name: syeda
 * Created 10/1/2025
 */
package autoClicker;

import java.awt.*;

/**
 * Course SWE2410-121
 * Fall 2025-2026
 * Interface ModeStrategy Purpose: Defines what to do for each strategy
 *
 * @author syeda
 * @version created on 10/1/2025 9:47 AM
 */
public interface ModeStrategy {
    void execute(Robot robot) throws Exception;
}
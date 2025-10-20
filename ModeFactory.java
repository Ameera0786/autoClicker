/*
 * Course: SWE2410-121
 * Fall 2025-2026
 * File header contains class ModeFactory
 * Name: syeda
 * Created 10/1/2025
 */
package autoClicker;

import java.util.HashMap;
import java.util.Map;

/**
 * Course SWE2410-121
 * Fall 2025-2026
 * Class ModeFactory Purpose: Return correct modestrat
 *
 * @author syeda
 * @version created on 10/1/2025 10:25 AM
 */
public class ModeFactory {
    public static final Map<String, ModeStrategy> strategies = new HashMap<String, ModeStrategy>();
    static {
        strategies.put("m", new MineStrategy());
        strategies.put("f", new FightStrategy());
        strategies.put("r", new RaidStrategy());
        strategies.put("l", new LeafStrategy());
        strategies.put("c", new ClickStrategy());
    }

    public static ModeStrategy getStrategy(String name) {
        return strategies.getOrDefault(name, null);
    }
}
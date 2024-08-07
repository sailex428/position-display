package io.sailex.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class that calculates the current clicks per second.
 *
 * @author sailex
 */
public class CPSCalculator {

    private static final CPSCalculator INSTANCE = new CPSCalculator();
    private static final long TIMES_SECOND = 1000L;

    private long lastUpdateTime = System.currentTimeMillis();
    private final List<Long> clicks = new ArrayList<>();
    private int clicksPerSecond;

    private CPSCalculator() {}

    /**
     * Gets called on key press.
     */
    public void onKeyPress() {
        this.clicks.add(System.currentTimeMillis());
    }

    /**
     * Calculates and updates the cps.
     */
    private void updateCPS() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdateTime >= 250L) {
            lastUpdateTime = currentTime;
            clicksPerSecond = clicks.size();
        }
        this.clicks.removeIf(click -> (click + TIMES_SECOND < currentTime));
    }

    /**
     * Gets the current cps.
     *
     * @return the current cps
     */
    public int getCPS() {
        updateCPS();
        return clicksPerSecond;
    }

    /**
     * Gets the CPSCalculator instance.
     * @return the CPSCalculator instance.
     */
    public static CPSCalculator getInstance() {
        return INSTANCE;
    }
}

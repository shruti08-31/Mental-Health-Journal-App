package services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class StressLevelMonitor {
    private Map<LocalDate, Integer> stressLevels = new HashMap<>();

    // Record stress level between 1 to 10
    public void recordStress(LocalDate date, int level) {
        if (level < 1) level = 1;
        if (level > 10) level = 10;
        stressLevels.put(date, level);
    }

    // Calculate average stress level
    public double getAverageStress() {
        if (stressLevels.isEmpty()) {
            return 0;
        }

        int total = 0;
        for (int value : stressLevels.values()) {
            total += value;
        }

        return (double) total / stressLevels.size();
    }
}

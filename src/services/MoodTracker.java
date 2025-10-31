package service;

import model.JournalEntry;
import java.util.*;

public class MoodTracker {

    public String getMostCommonMood(List<JournalEntry> entries) {
        if (entries == null || entries.size() == 0) return "No data";

        // Count frequency of each mood
        Map<String, Integer> moodCount = new HashMap<>();
        for (JournalEntry entry : entries) {
            String mood = entry.getMood();
            if (mood == null) continue;
            moodCount.put(mood, moodCount.getOrDefault(mood, 0) + 1);
        }

        // Find most common mood
        String mostCommon = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> pair : moodCount.entrySet()) {
            if (pair.getValue() > maxCount) {
                maxCount = pair.getValue();
                mostCommon = pair.getKey();
            }
        }
        return mostCommon != null ? mostCommon : "No data";
    }

    public double getPositiveMoodPercentage(List<JournalEntry> entries) {
        if (entries == null || entries.size() == 0) return 0;

        // Count positive moods
        int positiveCount = 0;
        for (JournalEntry entry : entries) {
            String mood = entry.getMood();
            if (mood == null) continue;
            if (mood.equalsIgnoreCase("happy") || 
                mood.equalsIgnoreCase("grateful") || 
                mood.equalsIgnoreCase("calm")) {
                positiveCount++;
            }
        }
        return (positiveCount * 100.0) / entries.size();
    }
}

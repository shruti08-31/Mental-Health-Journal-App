package service;

import model.JournalEntry;
import java.util.*;
import java.util.stream.Collectors;

public class MoodTracker {

    public String getMostCommonMood(List<JournalEntry> entries) {
        if (entries.isEmpty()) return "No data";
        Map<String, Long> freq = entries.stream()
                .collect(Collectors.groupingBy(JournalEntry::getMood, Collectors.counting()));
        return Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public double getPositiveMoodPercentage(List<JournalEntry> entries) {
        if (entries.isEmpty()) return 0;
        long positive = entries.stream()
                .filter(e -> e.getMood().equalsIgnoreCase("happy") ||
                             e.getMood().equalsIgnoreCase("grateful") ||
                             e.getMood().equalsIgnoreCase("calm"))
                .count();
        return (positive * 100.0) / entries.size();
    }
}

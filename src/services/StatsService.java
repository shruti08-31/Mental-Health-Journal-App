package services;

import model.JournalEntry;
import java.time.LocalDate;
import java.util.*;

public class StatsService {
    public long getEntryStreak(List<JournalEntry> entries) {
        if (entries.size() == 0) {
            return 0;
        }
        Set<LocalDate> dates = new HashSet<LocalDate>();
        for (int i = 0; i < entries.size(); i++) {
            LocalDate date = LocalDate.parse(entries.get(i).getDate());
            dates.add(date);
        }
        long streak = 0;
        LocalDate today = LocalDate.now();
        while (dates.contains(today.minusDays(streak))) {
            streak = streak + 1;
        }
        return streak;
    }

    public String getMostActiveDay(List<JournalEntry> entries) {
        if (entries.size() == 0) {
            return "No data";
        }
        Map<String, Long> freq = new HashMap<String, Long>();
        for (int i = 0; i < entries.size(); i++) {
            String date = entries.get(i).getDate();
            if (freq.containsKey(date)) {
                long value = freq.get(date);
                freq.put(date, value + 1);
            } else {
                freq.put(date, 1L);
            }
        }
        String mostActiveDay = null;
        long maxCount = 0;
        for (Map.Entry<String, Long> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostActiveDay = entry.getKey();
            }
        }
        return mostActiveDay;
    }
}

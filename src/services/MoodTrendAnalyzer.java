package services;

import model.JournalEntry;
import java.util.*;

public class MoodTrendAnalyzer {
    // mood scale from lowest to highest
    private static final List<String> moodScale = List.of(
            "very sad",   // 0
            "sad",        // 1
            "neutral",    // 2
            "happy",      // 3
            "very happy"  // 4
    );

    private int getMoodScore(String mood) {
        if (mood == null)
            return -1;
        return moodScale.indexOf(mood.toLowerCase());
    }

    //analyze the last 3 mood entries to find a trend
    public String analyzeTrend(List<JournalEntry> entries) {
        if (entries == null || entries.size() < 3)
            return "";

        int last = entries.size() - 1;

        JournalEntry lastEntry = entries.get(last);
        JournalEntry secondLastEntry = entries.get(last - 1);
        JournalEntry thirdLastEntry = entries.get(last - 2);

        int m1 = getMoodScore(lastEntry.getMood());
        int m2 = getMoodScore(secondLastEntry.getMood());
        int m3 = getMoodScore(thirdLastEntry.getMood());


        if (m1 == -1 || m2 == -1 || m3 == -1)
            return "";

        // consistent up mood trend
        if (m1 >= m2 && m2 >= m3 && m1 > m3) {
            return "You’ve been feeling progressively better these past days — great job staying positive!";
        }
        //consistent downmood trend
        else if (m1 <= m2 && m2 <= m3 && m1 < m3) {
            return "Your mood seems to be declining lately. Take time to rest or do something that comforts you.";
        }
        // stable mood
        else if (m1 == m2 && m2 == m3) {
            return "Your mood has been steady for a while — consistency is good!";
        }
        // Mixed trend
        else {
            return "Your mood has been fluctuating. Try reflecting on what’s been influencing these changes.";
        }
    }

}

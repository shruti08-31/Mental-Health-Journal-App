package service;

import model.JournalEntry;
import java.util.*;

public class MoodTrendAnalyzer {

    private static final List<String> moodScale = List.of("sad", "neutral", "happy");
  
    private int getMoodScore(String mood) {
    if (mood == null) 
      return -1;
    return moodScale.indexOf(mood.toLowerCase());
    }


    public String analyzeTrend(List<JournalEntry> entries) {
        if (entries.size() < 3) 
          return "";

        int last = entries.size() - 1;
        int m1 = getMoodScore(entries.get(last).getMood());
        int m2 = getMoodScore(entries.get(last - 1).getMood());
        int m3 = getMoodScore(entries.get(last - 2).getMood());

        if (m1 >= m2 && m2 >= m3 && m1 > m3) {
            return "You’ve felt happier 3 days in a row!";
        } else if (m1 <= m2 && m2 <= m3 && m1 < m3) {
            return "You’ve been feeling lower the last few days. Maybe take a moment for yourself.";
        }
        return " ";
    }
}

package service;

import model.JournalEntry;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilterService {

    public List<JournalEntry> filterByDateRange(List<JournalEntry> entries, LocalDate start, LocalDate end) {
        List<JournalEntry> result = new ArrayList<>();
        for (int i = 0; i < entries.size(); i++) {
            JournalEntry entry = entries.get(i);
            LocalDate d = LocalDate.parse(entry.getDate());
            if ((d.equals(start) || d.isAfter(start)) && (d.isBefore(end) || d.equals(end))) {
                result.add(entry);
            }
        }
        return result;
    }

    public List<JournalEntry> filterByMood(List<JournalEntry> entries, String mood) {
        List<JournalEntry> result = new ArrayList<>();
        for (int i = 0; i < entries.size(); i++) {
            JournalEntry entry = entries.get(i);
            if (entry.getMood().toLowerCase().equals(mood.toLowerCase())) {
                result.add(entry);
            }
        }
        return result;
    }
}

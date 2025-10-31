package service;

import model.JournalEntry;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilterService {

    // Filter by date range using simple for loop and direct comparisons
    public List<JournalEntry> filterByDateRange(List<JournalEntry> entries, LocalDate start, LocalDate end) {
        List<JournalEntry> filteredEntries = new ArrayList<>();
        for (int i = 0; i < entries.size(); i++) {
            JournalEntry entry = entries.get(i);
            LocalDate date = LocalDate.parse(entry.getDate()); //entry.getDate() returns  "2025-10-31"  .parse("2025-10-31") creates a LocalDate object representing October 31, 2025.
            if (date.equals(start) || date.equals(end) || (date.isAfter(start) && date.isBefore(end))) {
                filteredEntries.add(entry);
            }
        }
        return filteredEntries;
    }

    // Filter by mood using lower case matching with simple loop
    public List<JournalEntry> filterByMood(List<JournalEntry> entries, String mood) {
        List<JournalEntry> filteredEntries = new ArrayList<>();
        String moodLower = mood.toLowerCase();
        for (int i = 0; i < entries.size(); i++) {
            JournalEntry entry = entries.get(i);
            String entryMood = entry.getMood();
            if (entryMood != null && entryMood.toLowerCase().equals(moodLower)) {
                filteredEntries.add(entry);
            }
        }
        return filteredEntries;
    }
}

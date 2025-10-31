package service;

import model.JournalEntry;
import java.util.*;

public class SearchService {

    public List<JournalEntry> searchByKeyword(List<JournalEntry> entries, String keyword) {
        List<JournalEntry> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (JournalEntry entry : entries) {
            // Check if notes contain keyword
            if (entry.getNotes() != null && entry.getNotes().toLowerCase().contains(lowerKeyword)) {
                result.add(entry);
            }
        }
        return result;
    }

    public List<JournalEntry> searchByMood(List<JournalEntry> entries, String mood) {
        List<JournalEntry> result = new ArrayList<>();
        for (JournalEntry entry : entries) {
            // Check if mood matches 
            if (entry.getMood() != null && entry.getMood().equalsIgnoreCase(mood)) {
                result.add(entry);
            }
        }
        return result;
    }
}

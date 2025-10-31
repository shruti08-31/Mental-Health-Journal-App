package services;

import model.JournalEntry;
import java.util.ArrayList;
import java.util.List;

public class SearchService {

    public List<JournalEntry> searchByKeyword(List<JournalEntry> entries, String keyword) {
        List<JournalEntry> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (JournalEntry entry : entries) {
            if (entry.getContent().toLowerCase().contains(lowerKeyword)) {
                result.add(entry);
            }
        }
        return result;
    }

    public List<JournalEntry> searchByMood(List<JournalEntry> entries, String mood) {
        List<JournalEntry> result = new ArrayList<>();
        for (JournalEntry entry : entries) {
            if (entry.getMood().equalsIgnoreCase(mood)) {
                result.add(entry);
            }
        }
        return result;
    }
}

package services;

import model.JournalEntry;
import java.util.ArrayList;
import java.util.List;
public class SearchService {

    public List<JournalEntry> searchByKeyword(List<JournalEntry> entries, String keyword) {
        List<JournalEntry> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        int size = entries.size();
        for (int i = 0; i < size; i++) {
            JournalEntry entry = entries.get(i);
            if (entry.getContent().toLowerCase().contains(lowerKeyword)) {
                result.add(entry);
            }
        }
        return result;
    }

    public List<JournalEntry> searchByMood(List<JournalEntry> entries, String mood) {
        List<JournalEntry> result = new ArrayList<>();
        int size = entries.size();
        for (int i = 0; i < size; i++) {
            JournalEntry entry = entries.get(i);
            if (entry.getMood().equalsIgnoreCase(mood)) {
                result.add(entry);
            }
        }
        return result;
    }
}

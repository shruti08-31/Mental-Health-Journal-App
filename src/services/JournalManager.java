package services;

import model.JournalEntry;
import java.util.*;

public class JournalManager {
    private List<JournalEntry> entries = new ArrayList<>();

    public JournalEntry createEntry(String mood, String content) {
        JournalEntry entry = new JournalEntry(mood, content);
        entries.add(entry);
        return entry;
    }

    public List<String> getRecentMoods(int count) {
        List<String> moods = new ArrayList<>();
        int start = Math.max(0, entries.size() - count);
        for (int i = start; i < entries.size(); i++) {
            moods.add(entries.get(i).getMood());
}

        return moods;
    }

    public List<JournalEntry> getAllEntries() {
        return entries;
    }
}

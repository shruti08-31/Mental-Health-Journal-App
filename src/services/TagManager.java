package services;

import java.time.LocalDate;
import java.util.*;
import model.JournalEntry;


public class TagManager {

    public void addTag(List<JournalEntry> entries, LocalDate date, String tag) {
        for (int i = 0; i < entries.size(); i++) {
            JournalEntry entry = entries.get(i);
            if (entry.getDate().equals(date)) {
                entry.addTag(tag.toLowerCase());
                System.out.println("tag" + tag + " entry dated " + date);
                return;
            }
        }
        System.out.println("No entry found" + date);
    }

    public List<JournalEntry> getEntriesByTag(List<JournalEntry> entries, String tag) {
        List<JournalEntry> taggedEntries = new ArrayList<>();
        String tagLower = tag.toLowerCase();
        for (int i = 0; i < entries.size(); i++) {
            JournalEntry entry = entries.get(i);
            if (entry.getTags().contains(tagLower)) {
                taggedEntries.add(entry);
            }
        }
        return taggedEntries;
    }
}

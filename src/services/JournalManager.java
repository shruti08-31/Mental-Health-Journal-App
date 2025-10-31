package services;

import model.JournalEntry;
import java.time.LocalDate;
import java.util.*;

public class JournalManager {
    private List<JournalEntry> entries = new ArrayList<>();

    public void addEntry(JournalEntry e) {
        entries.add(e);
    }

    public boolean deleteEntry(int id) {
        return entries.removeIf(e -> e.getId() == id);
    }

    public List<JournalEntry> getAllEntries() {
        return new ArrayList<>(entries);
    }
}


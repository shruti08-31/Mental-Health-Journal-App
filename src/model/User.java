package model;

import java.util.ArrayList;
import java.util.List;
public class User {
    private int id;
    private String username;
    private List<JournalEntry> journalEntries;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.journalEntries = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void addJournalEntry(JournalEntry entry) {
        journalEntries.add(entry);
    }
}


package model;

import java.util.*;

public class User {
    private String username;
    private String password;
    private String personalityType;
    private int moodScore;
    private int streakCount;
    private List<JournalEntry> entries = new ArrayList<>();
    private Date lastJournalDate;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.moodScore = 50;
        this.streakCount = 0;
        this.lastJournalDate = null;
    }

    public String getUsername() { return username; }
    public String getPersonalityType() { return personalityType; }
    public void setPersonalityType(String type) { this.personalityType = type; }

    public void addEntry(JournalEntry entry) {
        entries.add(entry);
        lastJournalDate = new Date();
    }

    public List<JournalEntry> getEntries() { return entries; }
    public int getMoodScore() { return moodScore; }
    public void setMoodScore(int moodScore) { this.moodScore = moodScore; }

    public int getStreakCount() { return streakCount; }
    public void setStreakCount(int streakCount) { this.streakCount = streakCount; }

    public Date getLastJournalDate() { return lastJournalDate; }
}

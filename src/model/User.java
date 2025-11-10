package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String personalityType;
    private int moodScore;
    private int streakCount;            // renamed for consistency
    private LocalDate lastJournalDate;  // renamed for consistency
    private List<JournalEntry> journalEntries;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.personalityType = "Unknown";
        this.moodScore = 0;
        this.streakCount = 0;
        this.journalEntries = new ArrayList<>();
    }

    // --- Getters & Setters ---
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalityType() {
        return personalityType;
    }

    public void setPersonalityType(String personalityType) {
        this.personalityType = personalityType;
    }

    public int getMoodScore() {
        return moodScore;
    }

    public void setMoodScore(int moodScore) {
        this.moodScore = moodScore;
    }

    public int getStreakCount() {
        return streakCount;
    }

    public void setStreakCount(int streakCount) {
        this.streakCount = streakCount;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void addJournalEntry(JournalEntry entry) {
        this.journalEntries.add(entry);
        this.lastJournalDate = entry.getDate();  // update last journal date
    }

    public LocalDate getLastJournalDate() {
        return lastJournalDate;
    }

    public void setLastJournalDate(LocalDate lastJournalDate) {
        this.lastJournalDate = lastJournalDate;
    }

    
    public LocalDate getLastEntryDate() {
        if (journalEntries.isEmpty()) {
            return null;
        }
        return journalEntries.get(journalEntries.size() - 1).getDate();
    }

    public void increaseStreak() {
        this.streakCount++;
    }

    public void resetStreak() {
        this.streakCount = 0;
    }

    public void updateMoodScore(int value) {
        this.moodScore += value;
    }

    @Override
    public String toString() {
        return "User: " + username
                + "\nPersonality Type: " + personalityType
                + "\nMood Score: " + moodScore
                + "\nStreak Count: " + streakCount
                + "\nLast Journal Date: " + (lastJournalDate != null ? lastJournalDate : "None");
    }
}

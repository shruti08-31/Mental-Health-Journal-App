package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
   private String username;
    private String password;
    private String personalityType;
    private int moodScore;         
    private int streak;             
    private LocalDate lastEntryDate;
    private List<JournalEntry> journalEntries;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.personalityType = "Unknown";
        this.moodScore = 0;
        this.streak = 0;
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

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void addJournalEntry(JournalEntry entry) {
        this.journalEntries.add(entry);
        this.lastEntryDate = entry.getDate(); 
    }
    public LocalDate getLastEntryDate() {
        return lastEntryDate;
    }

    public void setLastEntryDate(LocalDate lastEntryDate) {
        this.lastEntryDate = lastEntryDate;
    }

    public void increaseStreak() {
        this.streak++;
    }

    public void resetStreak() {
        this.streak = 0;
    }

    public void updateMoodScore(int value) {
        this.moodScore += value;
    }

    public String toString() {
        return "User: " + username + "\nPersonality Type: " + personalitytype + "\nmood score: " + moodScore + "\nstreak: " + streak + "\nLast entry date: " + (lastEntryDate != null ? lastEntryDate : "None");
    }
}

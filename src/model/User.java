package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String personalityType;
    private int moodScore;
    private int streakCount;            
    private LocalDate lastJournalDate;  
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
        return moo

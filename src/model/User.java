package model;

import java.time.LocalDate;
import java.util.*;

public class User {
    private final String username;
    private String password; 
    private String personalityType;
    private double moodScore = 0.0;
    private int currentStreak = 0;
    private LocalDate lastJournalDate;
    private List<String> achievements = new ArrayList<>();
    private Map<String, Object> metadata = new HashMap<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { 
        return username; 
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

    public double getMoodScore() { 
        return moodScore; 
    }
    public void setMoodScore(double moodScore) { 
        this.moodScore = moodScore; 
    }

    public int getCurrentStreak() { 
        return currentStreak; 
    }
    public void setCurrentStreak(int currentStreak) { 
        this.currentStreak = currentStreak; 
    }

    public LocalDate getLastJournalDate() { 
        return lastJournalDate; 
    }
    public void setLastJournalDate(LocalDate lastJournalDate) { 
        this.lastJournalDate = lastJournalDate; 
    }

    public List<String> getAchievements() { 
        return achievements; 
    }
    public void addAchievement(String a) { 
        if (!achievements.contains(a)) achievements.add(a); 
    }

    public Map<String, Object> getMetadata() { 
        return metadata; 
    }

    @Override
    public String toString() {
        return String.format("user(%s, personality=%s, score=%.2f, streak=%d)",
                username, personalityType, moodScore, currentStreak);
    }
}


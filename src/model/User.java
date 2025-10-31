package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private List<JournalEntry> journalEntries;
    private List<Goal> goals;
    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.journalEntries = new ArrayList<>();
        this.goals = new ArrayList<>();
    }


    public int getId() { 
      
      return id;
      
    }
    public String getUsername() { 
      
      return username; 
      
    }
    public String getEmail() { 
      
      return email;
      
    }
    public String getPassword() { 
      
      return password;
      
    }

    public List<JournalEntry> getJournalEntries() { 
      return journalEntries; 
    }
    public List<Goal> getGoals() { 
      
      return goals; 
      
    }

    public void addJournalEntry(JournalEntry entry) {
        journalEntries.add(entry);
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    @Override
    public String toString() {
        return "user: " + username + " -   " + email + "     ";
    }
}

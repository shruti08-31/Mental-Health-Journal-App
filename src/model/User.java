package model;

import java.util.LinkedList;

public class User {
    private String name;
    private LinkedList<JournalEntry> entries = new LinkedList<>();
    private int moodScore; //track overall mood score

    public User(String name) {
        this.name = name;
        this.moodScore = 5; // neutral start (1–10 scale)
    }

    public String getName() {
        return name;
    }

    public LinkedList<JournalEntry> getEntries() {
        return entries;
    }

    public void addEntry(JournalEntry entry) {
        entries.add(entry);
    }

    //Add getLastEntry()
    public JournalEntry getLastEntry() {
        if (entries.isEmpty())
            return null;
        JournalEntry El = entries.getLast();
        return El;
    }

    public int getMoodScore() {
        return moodScore;
    }

    public void setMoodScore(int moodScore) {
        if (moodScore < 1) {
                this.moodScore = 1;
        }
        else if (moodScore > 10) {
                this.moodScore = 10;
        }
        else {
                this.moodScore = moodScore;
            }
        }

    }



package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JournalEntry {
    private String title;     // Tag (mood + date)
    private String content;   // Reflection answer
    private LocalDate date;
    private String mood;

    public JournalEntry(String title, String content, String mood, LocalDate date) {
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMood() {
        return mood;
    }

    @Override
    public String toString() {
        return "Entry{" + " title='" + title + '\'' + ", mood='" + mood + '\'' + ", date=" + date + ", content='" + content + '\'' + '}';
    }
}

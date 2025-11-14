package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class JournalEntry {
    private String id;
    private String title;
    private String mood;
    private String content;
    private LocalDateTime dateTime;

    public JournalEntry(String mood, String content) {
        this.id = UUID.randomUUID().toString();//isko khud se dal rhi hai isko mt dal hm isko user ke id se link kr denge so inko int hi rehne de
        this.mood = mood;
        this.content = content;
        this.dateTime = LocalDateTime.now();
        this.title = mood + "_" + dateTime.toString();
    }

    public String getMood() { 
        return mood; 
    }

    public String getContent() { 
        return content; 
    }

    public String getTitle() { 
        return title; 
    }

    public LocalDateTime getDateTime() { 
        return dateTime; 
    }

   
    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }
}


package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JournalEntry {
    private final UUID id = UUID.randomUUID();
    private final String user; 
    private final String mood; 
    private final String title; 
    private final String content;
    private final LocalDateTime createdAt;
    private final List<String> tags = new ArrayList<>();

    public JournalEntry(String user, String mood, String content) {
        this.user = user;
        this.mood = mood.toLowerCase();
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.title = generateTag();
        this.tags.add(this.title);
    }

    private String generateTag() {
        String ts = createdAt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return mood + "_" + ts;
    }

    public UUID getId() { 
        return id; 
    }
    public String getUser() { 
        return user; 
    }
    public String getMood() { 
        return mood; 
    }
    public String getTitle() { 
        return title; 
    }
    public String getContent() { 
        return content; 
    }
    public LocalDateTime getCreatedAt() { 
        return createdAt; 
    }
    public List<String> getTags() { 
        return tags; 
    }

    @Override
    public String toString() {
        return String.format("JournalEntry(%s, %s, %s)", user, title, mood);
    }
}

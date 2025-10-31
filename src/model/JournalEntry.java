package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JournalEntry {
    private int id;
    private LocalDate date;
    private String title;
    private String content;
    private String mood;
    private List<String> tags;
    public JournalEntry(int id, LocalDate date, String title, String content, String mood) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.tags = new ArrayList<>();
    }
    public int getId() { 
      return id; 
    }
    public void setId(int id) { 
      
      this.id = id; 
      
    }

    public LocalDate getDate() { 
      
      return date; 
      
    }
    public void setDate(LocalDate date) { 
      
      this.date = date; 
      
    }

    public String getTitle() { 
      
      return title; 
      
    }
    public void setTitle(String title) { 
      
      this.title = title; 
      
    }

    public String getContent() { 
      
      return content; 
      
    }
    public void setContent(String content) { 
      
      this.content = content; 
      
    }

    public String getMood() { 
      return mood; 
    }
    public void setMood(String mood) { 
      this.mood = mood; 
    }

    public List<String> getTags() { 
      
      return tags; 
    }

    public void addTag(String tag) {
      if (!tags.contains(tag)) {
        tags.add(tag);
      }
    }

    @Override
    public String toString() {
        return "entry [ " + date + " ] " + title + " | mood: " + mood + "\n" + content;
    }
}

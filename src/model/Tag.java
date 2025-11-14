package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tag {
    private String mood;
    private LocalDate date;
    private LocalTime time;
    private String tagText;

    public Tag(String mood) {
        this.mood = mood;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.tagText = generateTagText();
    }

    private String generateTagText() {
        return mood.toLowerCase() + "-" + date + "-" + time.toString().substring(0,5);
    }

    public String getMood() {
        
        return mood;
    }
    public LocalDate getDate() {
        
        return date;
    }
    public LocalTime getTime() {
        
        return time;
    }
    public String getTagText() {
        
        return tagText;
    }

    @Override
    public String toString() {
        
        return tagText;
    }
}


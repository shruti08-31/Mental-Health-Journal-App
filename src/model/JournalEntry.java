package model;

public class JournalEntry {
    private String mood;
    private String content;
    private String intensity; // NEW FIELD
    private Tag tag;

    public JournalEntry(String mood, String content, String intensity) {
        this.mood = mood;
        this.content = content;
        this.intensity = intensity;
    }

    public String getMood() {
        return mood;
    }
    public String getContent() {
        return content;
    }
    public String getIntensity() {
        return intensity;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "Mood: " + mood + "\nIntensity: " + intensity + "\nTag: " + tag.getTagText() + "\nContent: " + content + "\n";
    }
}


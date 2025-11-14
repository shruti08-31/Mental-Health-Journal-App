package services;

import model.Tag;
import java.util.*;

public class TagManager {
    private List<Tag> tags = new ArrayList<>();

    //create and store a new tag
    public Tag createTag(String mood) {
        Tag tag = new Tag(mood);
        tags.add(tag);
        return tag;
    }

    //retrieve all tags
    public List<Tag> getAllTags() {
        return tags;
    }

    //search tags by mood
    public List<Tag> getTagsByMood(String mood) {
        List<Tag> result = new ArrayList<>();
        for (Tag t : tags) {
            if (t.getMood().equalsIgnoreCase(mood)) {
                result.add(t);
            }
        }
        return result;
    }
}

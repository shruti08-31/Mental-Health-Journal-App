package services;

import java.time.LocalDate;
import java.util.*;
import model.Tag;

public class TagManager {
    public Tag createTag(String mood) {
        LocalDate today = LocalDate.now();
        Tag tag = new Tag(mood, today);
        System.out.println("Created tag: " + tag);
        return tag;
    }
}

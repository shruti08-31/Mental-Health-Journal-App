package service;

import java.time.LocalDate;
import java.util.*;

public class TagManager {
    private Map<LocalDate, Set<String>> tags = new HashMap<>();

    public void addTag(LocalDate date, String tag) {
      
        String lowerTag = tag.toLowerCase();
        if (!tags.containsKey(date)) {
            tags.put(date, new HashSet<String>());
        }
        tags.get(date).add(lowerTag);
    }

}


package service;

import java.time.LocalDate;
import java.util.*;

public class TagManager {
    private Map<LocalDate, Set<String>> tags = new HashMap<>();

    public void addTag(LocalDate date, String tag) {
        // Always store tags in lowercase for consistency
        String lowerTag = tag.toLowerCase();
        if (!tags.containsKey(date)) {
            tags.put(date, new HashSet<String>());
        }
        tags.get(date).add(lowerTag);
    }

    public List<LocalDate> getEntriesByTag(String tag) {
        String lowerTag = tag.toLowerCase();
        List<LocalDate> result = new ArrayList<>();
        for (Map.Entry<LocalDate, Set<String>> entry : tags.entrySet()) {
            if (entry.getValue().contains(lowerTag)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}


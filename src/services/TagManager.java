package service;

import java.time.LocalDateTime;

public class TagManager {
    public String makeTag(String mood) {
        return mood + "_" + LocalDateTime.now();
    }
}

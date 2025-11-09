package services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TagManager {

    public String createTag(String mood) {
        String ts = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return mood.toLowerCase() + "_" + ts;
    }
}

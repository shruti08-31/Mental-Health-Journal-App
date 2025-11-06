package model;

import java.time.LocalDate;

public class Tag {
    private String name;
    private LocalDate date;

    public Tag(String name, LocalDate date) {
        this.name = name.toLowerCase();
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name + " ( " + date + " ) ";
    }
}

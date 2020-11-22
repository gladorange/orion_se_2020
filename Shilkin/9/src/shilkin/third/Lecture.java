package shilkin.third;

import java.time.LocalDate;

public class Lecture {
    private final String name;
    private final LocalDate date;

    public Lecture(String name, LocalDate date) {
        this.name = name;
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
        return "Lecture{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}

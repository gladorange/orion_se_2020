package lesson11.task3;

import java.time.LocalDate;
import java.util.Objects;

public class Lection {
    LectionEnum name;
    LocalDate date;

    public Lection(LectionEnum name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public LectionEnum getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lection lection = (Lection) o;
        return name.equals(lection.name) &&
                date.equals(lection.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }

    @Override
    public String toString() {
        return "Lection{" +
                "name=" + name +
                ", date=" + date +
                '}';
    }
}

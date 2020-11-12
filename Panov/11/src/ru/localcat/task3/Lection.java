package ru.localcat.task3;

import java.time.LocalDate;

public class Lection {
    private Lections title;
    private LocalDate date = null;

    public Lection(Lections title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    public Lections getTitle() {
        return title;
    }

    public void setTitle(Lections title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Lection{" +
                "title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}

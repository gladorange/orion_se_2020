package maxfomtaskeleven.thirdtask;

import java.time.LocalDate;
import java.util.Random;

public class Lection {
    private String name;
    private LocalDate date;

    public Lection(String name) {
        this.name = name;
        this.date = LocalDate.of(2008, 8, new Random().nextInt(8) + 1);
    }

    @Override
    public String toString() {
        return "lection={'" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

}

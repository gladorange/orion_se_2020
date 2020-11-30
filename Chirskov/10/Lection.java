import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class Lection {

    final static int START_YEAR = 2019;
    enum Lections { матанализ, философия, английкий, история, физкультура }
    String name;
    LocalDate date;

    Lection(String name) {
        this.name = name;
        date = randomDate();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Lection{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    static String getRandomLection() {
        int lectionNumber = ThreadLocalRandom.current().nextInt(0, Lection.Lections.values().length);
        return Lections.values()[lectionNumber].name();
    }

    static LocalDate randomDate() {
        LocalDate start = LocalDate.of(START_YEAR, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        return start.plusDays(ThreadLocalRandom.current().nextInt((int) days + 1));
    }

}

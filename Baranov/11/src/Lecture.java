import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Lecture {
    String name;
    LocalDate date;
    static String[] lectures = {"матанализ", "философия", "английкий язык", "история", "физкультура"};

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
        return new StringJoiner(", ", Lecture.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("date=" + date)
                .toString();
    }

    static String getRandomLecture() {
        return Lecture.lectures[ThreadLocalRandom.current().nextInt(0, Lecture.lectures.length)];
    }

    static LocalDate getRnLocalDate() {
        long minDay = LocalDate.of(2010, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2020, 11, 11).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    static Set<Lecture> getRnLectures() {
        Set<Lecture> lectures = new HashSet<>();
        for (int i = 0; i < ThreadLocalRandom.current().nextLong(3, 8); i++) {
            lectures.add(new Lecture(getRandomLecture(), Lecture.getRnLocalDate()));
        }
        return lectures;
    }

    static class Student {
        String name;
        Set<Lecture> lectures;

        public Student(String name, Set<Lecture> lecture) {
            this.name = name;
            this.lectures = new HashSet<>(lecture);
        }

        public String getName() {
            return name;
        }

        public Set<Lecture> getLectures() {
            return lectures;
        }

        public Integer getLectureSize() {
            return this.lectures.size();
        }

        @Override
        public String toString() {
            String str = new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("lectures=" + lectures)
                    .toString();
            return str + "\n";
        }

    }

    static class Pair<T, V> {
        T first;
        V second;

        public Pair(T nameLecture, V nameStudent) {
            this.first = nameLecture;
            this.second = nameStudent;
        }

        public T getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Pair.class.getSimpleName() + "", "")
                    .add("first='" + first + "'")
                    .add("second='" + second + "'")
                    .toString();
        }
    }

    static class Triple<T, V, B> {
        T first;
        V second;
        B third;

        public Triple(T first, V second, B third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public T getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

        public B getThird() {
            return third;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Pair.class.getSimpleName() + "", "")
                    .add("first='" + first + "'")
                    .add("second='" + second + "'")
                    .toString();
        }
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Dmitriy", getRnLectures()),
                new Student("Valera", getRnLectures()),
                new Student("Lana", getRnLectures()),
                new Student("Dasha", getRnLectures()),
                new Student("Masha", getRnLectures()),
                new Student("Eugene", getRnLectures()),
                new Student("Liam", getRnLectures()),
                new Student("Noah", getRnLectures()),
                new Student("Oliver", new HashSet<>(Arrays.asList(
                        new Lecture(Lecture.getRandomLecture(), LocalDate.of(2020, 1, 1)),
                        new Lecture(Lecture.getRandomLecture(), LocalDate.of(2020, 1, 1)),
                        new Lecture(Lecture.getRandomLecture(), LocalDate.of(2020, 1, 1)),
                        new Lecture(Lecture.getRandomLecture(), LocalDate.of(2020, 1, 1)),
                        new Lecture(Lecture.getRandomLecture(), LocalDate.of(2020, 1, 1))
                ))),
                new Student("Din", new HashSet<>(Arrays.asList(
                        new Lecture(Lecture.getRandomLecture(), LocalDate.of(2020, 2, 1)),
                        new Lecture(Lecture.getRandomLecture(), LocalDate.of(2020, 2, 1)),
                        new Lecture(Lecture.getRandomLecture(), LocalDate.of(2020, 2, 1)),
                        new Lecture(Lecture.getRandomLecture(), LocalDate.of(2020, 2, 1)),
                        new Lecture(Lecture.getRandomLecture(), LocalDate.of(2020, 2, 1))
                )))
        ));

        System.out.println("1. Выведите список студентов, которые хоть раз посещали матанализ.");

        List<String> collect = students.stream()
                .filter(student -> student.getLectures().stream()
                .anyMatch(lecture -> lecture.getName().equals("матанализ")))
                .map(Student::getName)
                .collect(toList());

        System.out.println(collect);

        System.out.println("2. Выведите статистику посещений для каждого студентам в формате: имя - количество посщенных лекций.");

        students.stream()
                .map(student -> student.getName() + " - " + student.getLectures().size())
                .forEach(System.out::println);

        System.out.println("-- 3. Выведите название дисциплин, имеющих наибольшее количество посещений. --");

        Map<String, Long> numberVisitsLectures = students.stream()
                .flatMap(student -> student.getLectures().stream().map(lecture -> new Pair<>(lecture.getName(), lecture.getDate())))
                .collect(
                        groupingBy(
                                Pair::getFirst,
                                counting()));

        Long maxNumberVisitsLectures = Collections.max(numberVisitsLectures.entrySet(), Comparator.comparingLong(Map.Entry::getValue)).getValue();

        numberVisitsLectures.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxNumberVisitsLectures))
                .forEach(System.out::println);

        System.out.println("-- 4. Выведите имена студентов, которые посетили наибольшее количество лекций в день. --");

        // Очень плохое решение

        Map<String, Map<LocalDate, Long>> lectionPerDay = students.stream()
                .flatMap(student -> student.getLectures().stream().map(lecture -> new Triple<>(student.getName(), lecture.getDate(), lecture.getName())))
                .collect(
                        groupingBy(
                                Triple::getFirst,
                                groupingBy(Triple::getSecond, counting())
                        )
                );

        Long maxi = 0L;

        for (Map.Entry<String, Map<LocalDate, Long>> entry : lectionPerDay.entrySet()) {
            for (Map.Entry<LocalDate, Long> innerEntry : entry.getValue().entrySet()) {
                if (innerEntry.getValue() > maxi) {
                    maxi = innerEntry.getValue();
                }
            }
        }

        for (Map.Entry<String, Map<LocalDate, Long>> entry : lectionPerDay.entrySet()) {
            for (Map.Entry<LocalDate, Long> innerEntry : entry.getValue().entrySet()) {
                if (innerEntry.getValue().equals(maxi)) {
                    System.out.println(entry.getKey());
                }
            }
        }

        System.out.println("5. Выведите статистику по курсам в формате:");

        students.stream()
                .flatMap(student -> student.getLectures().stream().map(lecture -> new Pair<>(lecture.getName(), student.getName())))
                .collect(
                        Collectors.groupingBy(
                                Pair::getFirst,
                                mapping(Pair::getSecond, toSet())))
                .forEach((key, value) -> System.out.println(key + " - " + value));

        // вариант чере reducing
        /*students.stream()
                .flatMap(student -> student.getLectures().stream().map(lecture -> new Pair<>(lecture.getName(), student.getName())))
                .collect(
                        Collectors.groupingBy(
                                Pair::getNameLecture,
                                Collectors.reducing("", Pair::getNameStudent, (a, b) -> {
                                    if (a.contains(b)) {
                                        return a;
                                    } else if (a.equals("")) {
                                        return b;
                                    }
                                    return a + ", " + b;
                                })))
                .forEach((key, value) -> System.out.println(key + " - " + value));*/

        // Матанализ - Дмитрий, Влад, Максим, Андрюша
    }
}


package lesson10.task3;

import java.rmi.StubNotFoundException;
import java.security.cert.CollectionCertStoreParameters;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vasya",
                new HashSet<>(Arrays.asList(
                        new Lection(LectionEnum.CALCULUS, LocalDate.of(2019, Month.DECEMBER, 15)),
                        new Lection(LectionEnum.ENGLISH, LocalDate.of(2019, Month.DECEMBER, 15)),
                        new Lection(LectionEnum.CALCULUS, LocalDate.of(2019, Month.DECEMBER, 17))
                ))));
        students.add(new Student("Katya",
                new HashSet<>(Arrays.asList(
                        new Lection(LectionEnum.ENGLISH, LocalDate.of(2019, Month.DECEMBER, 15)),
                        new Lection(LectionEnum.PHYSICAL_CULTURE, LocalDate.of(2019, Month.DECEMBER, 26))
                ))));
        students.add(new Student("Misha",
                new HashSet<>(Arrays.asList(
                        new Lection(LectionEnum.CALCULUS, LocalDate.of(2019, Month.DECEMBER, 25)),
                        new Lection(LectionEnum.ENGLISH, LocalDate.of(2019, Month.DECEMBER, 26)),
                        new Lection(LectionEnum.PHILOSOPHY, LocalDate.of(2019, Month.DECEMBER, 26))
                ))));
        students.add(new Student("Vitya",
                new HashSet<>(Arrays.asList(
                        new Lection(LectionEnum.CALCULUS, LocalDate.of(2019, Month.DECEMBER, 17)),
                        new Lection(LectionEnum.ENGLISH, LocalDate.of(2019, Month.DECEMBER, 26)),
                        new Lection(LectionEnum.PHYSICAL_CULTURE, LocalDate.of(2019, Month.DECEMBER, 15))
                ))));
        students.add(new Student("Masha",
                new HashSet<>(Arrays.asList(
                        new Lection(LectionEnum.CALCULUS, LocalDate.of(2019, Month.DECEMBER, 15)),
                        new Lection(LectionEnum.PHILOSOPHY, LocalDate.of(2019, Month.DECEMBER, 25)),
                        new Lection(LectionEnum.HISTORY, LocalDate.of(2019, Month.DECEMBER, 25))
                ))));
        students.add(new Student("Petya",
                new HashSet<>(Arrays.asList(
                        new Lection(LectionEnum.ENGLISH, LocalDate.of(2019, Month.DECEMBER, 25)),
                        new Lection(LectionEnum.CALCULUS, LocalDate.of(2019, Month.DECEMBER, 25)),
                        new Lection(LectionEnum.PHYSICAL_CULTURE, LocalDate.of(2019, Month.DECEMBER, 16))
                ))));
        students.add(new Student("Anya",
                new HashSet<>(Arrays.asList(
                        new Lection(LectionEnum.CALCULUS, LocalDate.of(2019, Month.DECEMBER, 14)),
                        new Lection(LectionEnum.PHYSICAL_CULTURE, LocalDate.of(2019, Month.DECEMBER, 16)
                )))));
        students.add(new Student("Alex",
                new HashSet<>(Arrays.asList(
                        new Lection(LectionEnum.CALCULUS, LocalDate.of(2019, Month.DECEMBER, 25)),
                        new Lection(LectionEnum.ENGLISH, LocalDate.of(2019, Month.DECEMBER, 16))
                ))));
        students.add(new Student("Vanya",
                new HashSet<>(Arrays.asList(
                        new Lection(LectionEnum.PHYSICAL_CULTURE, LocalDate.of(2019, Month.DECEMBER, 16)),
                        new Lection(LectionEnum.HISTORY, LocalDate.of(2019, Month.DECEMBER, 16))
                ))));
        students.add(new Student("Nastya",
                new HashSet<>(Arrays.asList(
                        new Lection(LectionEnum.HISTORY, LocalDate.of(2019, Month.DECEMBER, 22)),
                        new Lection(LectionEnum.PHYSICAL_CULTURE, LocalDate.of(2019, Month.DECEMBER, 16)),
                        new Lection(LectionEnum.PHILOSOPHY, LocalDate.of(2019, Month.DECEMBER, 17))
                ))));

        System.out.println("\n1)");
        List<Student> calculusVisits = students.stream().filter(student -> student.getLections().stream()
                .anyMatch(lection -> lection.getName() == LectionEnum.CALCULUS)).collect(Collectors.toList());
        calculusVisits.forEach(System.out::println);

        System.out.println("\n2)");
        Map<String, Integer> studentStatistics = students.stream().collect(Collectors.toMap(Student::getName, student -> student.getLections().size()));
        System.out.println(studentStatistics);

        System.out.println("\n3)");
        Map<LectionEnum, Integer> visits = new HashMap<>();
        for (Student student : students) {
            student.getLections().forEach(lection -> visits.put(lection.name, visits.getOrDefault(lection.name, 0) + 1));
        }
        Integer maxLectionVisits = visits.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        List<LectionEnum> maxVisitLections = visits.entrySet().stream().filter(entry -> entry.getValue().equals(maxLectionVisits)).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(visits);
        System.out.println(maxVisitLections);

        System.out.println("\n4)");
        Map<String, Long> studentVisits = students.stream().collect(
                Collectors.toMap(Student::getName, student -> student.getLections().stream().collect(
                        Collectors.groupingBy(Lection::getDate, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue()));
        System.out.println(studentVisits);
        Long maxStudentVisits = studentVisits.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        List<String> studentMaxLectionVisits = studentVisits.entrySet().stream().filter(entry -> entry.getValue().equals(maxStudentVisits)).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(studentMaxLectionVisits);

        System.out.println("\n5)");
        Map<LectionEnum, Set> visitsStudents = new HashMap<>();
        for (Student student : students) {
            student.getLections().stream().map(Lection::getName)
                    .forEach(name -> visitsStudents.computeIfAbsent(name, v -> new HashSet<>()).add(student));
        }
        Map<LectionEnum, Integer> collect = visitsStudents.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
        System.out.println(collect);
    }
}

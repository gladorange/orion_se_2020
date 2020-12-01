package com.druzhinin;

import com.druzhinin.extendedcalculator.Calculator;
import com.druzhinin.first.NameComparator;
import com.druzhinin.first.Person;
import com.druzhinin.streamslections.Lection;
import com.druzhinin.streamslections.Lections;
import com.druzhinin.streamslections.Student;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("\n######-------Person comparator------######\n");
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Вася", 23));
        persons.add(new Person("Петя", 33));
        persons.add(new Person("Лена", 19));
        persons.add(new Person("Света", 42));
        persons.add(new Person("Кирилл", 13));
        persons.add(new Person("Маша", 27));
        persons.add(new Person("Витя", 9));

        Comparator<Person> personNameComparator = Comparator.comparing(
                Person::getName, (s1, s2) -> {
                    return s1.compareTo(s2);
                });

        Collections.sort(persons, personNameComparator);
        System.out.println(persons);

        Comparator<Person> personAgeComparator = Comparator.comparing(
                Person::getAge, (n1, n2) -> {
                    return n1.compareTo(n2);
                });
        Collections.sort(persons, personAgeComparator);
        System.out.println(persons);

        System.out.println("\n######-------Calculator------######\n");

        Calculator calculator = new Calculator();

        double a;
        double b;
        double result;

        calculator.addOperation("sum", (x,y) -> x + y);
         a = 5.0;
         b = 6.0;
        result = calculator.calculate("sum", a, b);
        System.out.printf("%s + %s = %s\n", a, b, result);

        calculator.addOperation("multiplication", (x,y) -> x * y);
        a = 14.0;
        b = 6.0;
        result = calculator.calculate("multiplication", a, b);
        System.out.printf("%s * %s = %s\n", a, b, result);

        calculator.addOperation("division", (x,y) -> x / y);
        a = 14.0;
        b = 6.0;
        result = calculator.calculate("division", a, b);
        System.out.printf("%s / %s = %s\n", a, b, result);

        calculator.addOperation("subtraction", (x,y) -> x - y);
        a = 5.0;
        b = 2.0;
        result = calculator.calculate("subtraction", a, b);
        System.out.printf("%s - %s = %s\n", a, b, result);

        calculator.addOperation("pow", (x,y) -> Math.pow(x, y));
        a = 5.0;
        b = 2.0;
        result = calculator.calculate("pow", a, b);
        System.out.printf("%s ^ %s = %s\n", a, b, result);

        calculator.addOperation("root", (x,y) -> Math.pow(x, 1.0 / y));
        a = 25.0;
        b = 2.0;
        result = calculator.calculate("root", a, b);
        System.out.printf("%s root %s = %s\n", a, b, result);

        System.out.println("\n######-------Stream's lections------######\n");

        List<Student> students = new ArrayList<Student>();

        Set<Lection> vasiasLection = new HashSet<Lection>();
        vasiasLection.add(new Lection(Lections.MATH.toString(), LocalDate.of(2020, 11, 14)));
        vasiasLection.add(new Lection(Lections.PHIL.toString(), LocalDate.of(2020, 11, 14)));
        vasiasLection.add(new Lection(Lections.ENG.toString(), LocalDate.of(2020, 11, 15)));

        Set<Lection> petiasLection = new HashSet<Lection>();
        petiasLection.add(new Lection(Lections.MATH.toString(), LocalDate.of(2020, 11, 14)));
        petiasLection.add(new Lection(Lections.PHIL.toString(), LocalDate.of(2020, 11, 14)));
        petiasLection.add(new Lection(Lections.PHISC.toString(), LocalDate.of(2020, 11, 15)));
        petiasLection.add(new Lection(Lections.HIST.toString(), LocalDate.of(2020, 11, 16)));

        Set<Lection> lenasLection = new HashSet<Lection>();
        lenasLection.add(new Lection(Lections.MATH.toString(), LocalDate.of(2020, 11, 14)));
        lenasLection.add(new Lection(Lections.PHIL.toString(), LocalDate.of(2020, 11, 14)));
        lenasLection.add(new Lection(Lections.PHISC.toString(), LocalDate.of(2020, 11, 15)));
        lenasLection.add(new Lection(Lections.HIST.toString(), LocalDate.of(2020, 11, 16)));
        lenasLection.add(new Lection(Lections.ENG.toString(), LocalDate.of(2020, 11, 17)));

        Set<Lection> vitiasLection = new HashSet<Lection>();
        vitiasLection.add(new Lection(Lections.PHISC.toString(), LocalDate.of(2020, 11, 15)));

        Set<Lection> mashaLection = new HashSet<Lection>();
        mashaLection.add(new Lection(Lections.PHIL.toString(), LocalDate.of(2020, 11, 14)));
        mashaLection.add(new Lection(Lections.HIST.toString(), LocalDate.of(2020, 11, 16)));
        mashaLection.add(new Lection(Lections.ENG.toString(), LocalDate.of(2020, 11, 17)));

        Set<Lection> zhenyasLection = new HashSet<Lection>();
        zhenyasLection.add(new Lection(Lections.MATH.toString(), LocalDate.of(2020, 11, 14)));
        zhenyasLection.add(new Lection(Lections.PHIL.toString(), LocalDate.of(2020, 11, 14)));
        zhenyasLection.add(new Lection(Lections.PHISC.toString(), LocalDate.of(2020, 11, 15)));
        zhenyasLection.add(new Lection(Lections.HIST.toString(), LocalDate.of(2020, 11, 16)));
        zhenyasLection.add(new Lection(Lections.ENG.toString(), LocalDate.of(2020, 11, 17)));

        Set<Lection> katyasLection = new HashSet<Lection>();
        katyasLection.add(new Lection(Lections.PHIL.toString(), LocalDate.of(2020, 11, 14)));
        katyasLection.add(new Lection(Lections.ENG.toString(), LocalDate.of(2020, 11, 17)));

        Set<Lection> pashasLection = new HashSet<Lection>();
        pashasLection.add(new Lection(Lections.MATH.toString(), LocalDate.of(2020, 11, 14)));

        Set<Lection> verasLection = new HashSet<Lection>();
        verasLection.add(new Lection(Lections.MATH.toString(), LocalDate.of(2020, 11, 14)));
        verasLection.add(new Lection(Lections.PHIL.toString(), LocalDate.of(2020, 11, 14)));
        verasLection.add(new Lection(Lections.ENG.toString(), LocalDate.of(2020, 11, 17)));
        verasLection.add(new Lection(Lections.HIST.toString(), LocalDate.of(2020, 11, 16)));

        Set<Lection> kolyasLection = new HashSet<Lection>();
        kolyasLection.add(new Lection(Lections.MATH.toString(), LocalDate.of(2020, 11, 14)));
        kolyasLection.add(new Lection(Lections.ENG.toString(), LocalDate.of(2020, 11, 17)));

        students.add(new Student("Вася", vasiasLection));
        students.add(new Student("Петя", petiasLection));
        students.add(new Student("Лена", lenasLection));
        students.add(new Student("Витя", vitiasLection));
        students.add(new Student("Маша", mashaLection));
        students.add(new Student("Женя", zhenyasLection));
        students.add(new Student("Катя", katyasLection));
        students.add(new Student("Паша", pashasLection));
        students.add(new Student("Вера", verasLection));
        students.add(new Student("Коля", kolyasLection));


//        1. Выведите список студентов, которые хоть раз посещали матанализ.
        System.out.println("----1----");
        students
                .stream()
                .filter(student -> student.getLections().stream().anyMatch(lection -> lection.getName().contains(Lections.MATH.toString())))
                .map(student -> student.getName())
                .forEach(System.out::println);

//        2. Выведите статистику посещений для каждого студентам в формате: имя - количество посщенных лекций.
        System.out.println("----2----");
        Map<String, Integer> statisticOfVisits = students
                .stream()
                .collect(Collectors.toMap(student -> student.getName(), student -> student.getLections().size()));

        System.out.println(statisticOfVisits);

//        3. Выведите название дисциплин, имеющих наибольшее количество посещений.
//                Если два разных студента посещают одну лекцию в один день, то это считается как два посещения.
        System.out.println("----3----");
        Map<String, Long> lectionRating = students
                .stream()
                .flatMap(student -> student.getLections()
                        .stream())
                .collect(Collectors.groupingBy(lection -> lection.getName(), Collectors.counting()));

        Long max = Collections.max(lectionRating.values());
        lectionRating
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .forEach(System.out::println);

//        4. Выведите имена студентов, которые посетили наибольшее количество лекций в день.
        System.out.println("----4----");
        Map<String, List<LocalDate>> studentsDateOfLection = students
                .stream()
                .collect(Collectors.toMap(student -> student.getName(), student -> student.getLections()
                        .stream()
                        .map(lection -> lection.getDate())
                        .collect(Collectors.toList())));

        Map<String, Map<LocalDate, Long>> studentsNumberOfDayLections = studentsDateOfLection
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()
                        .stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))));

        Map<String, Long> maxVisites = studentsNumberOfDayLections
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()
                        .entrySet()
                        .stream()
                        .map(entry1 -> entry1.getValue()).max(Comparator.naturalOrder()).get()));

        Long maxVisitesAtDay = Collections.max(maxVisites.values());
        maxVisites
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxVisitesAtDay)
                .forEach(System.out::println);

//        5. Выведите статистику по курсам в формате:
//        название курсов - количество разных студентов, которые посетили хотя бы одно занятие. (т.е. в лучше случае это будет 10)
        System.out.println("----5----");

        List<Lection> visitedLections = students
                .stream()
                .flatMap(student -> student.getLections()
                        .stream())
                .collect(Collectors.toList());

        Map<String, Long> collect = visitedLections
                .stream()
                .collect(Collectors.groupingBy(lection -> lection.getName(), Collectors.counting()));
        System.out.println(collect);

    }
}

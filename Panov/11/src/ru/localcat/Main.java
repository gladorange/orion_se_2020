package ru.localcat;

import ru.localcat.task1.Person;
import ru.localcat.task2.Calculator;
import ru.localcat.task3.Lection;
import ru.localcat.task3.Lections;
import ru.localcat.task3.Student;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //task1

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Vasya", 16));
        personList.add(new Person("Ibrahim", 26));
        personList.add(new Person("Alex", 43));
        personList.add(new Person("Alex", 19));
        personList.add(new Person("Anna", 34));
        personList.add(new Person("Vika", 24));
        personList.add(new Person("Ella", 27));

        System.out.println(personList);

        Collections.sort(personList, (person, t1) -> person.getName().compareTo(t1.getName()));
        System.out.println(personList);

        Collections.sort(personList, (person, t1) -> person.getAge().compareTo(t1.getAge()));
        System.out.println(personList);

        // не понимаю как сделать в стиле лямбды без методов, а может и не надо атк делать ?
        Collections.sort(personList,
                Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge));
        System.out.println(personList);
        System.out.println("________________________________________________");

        //task2

        Calculator calculator = new Calculator();
        calculator.addOperation("mult", (a, b) -> a * b);
        calculator.addOperation("div", (a, b) -> a / b);
        calculator.addOperation("sum", Double::sum);
        calculator.addOperation("sub", (a, b) -> a - b);
        calculator.addOperation("pow", Math::pow);
        calculator.addOperation("root", (a, b) -> Math.pow(a, 1 / b));

        System.out.println(calculator.calculate("pow", 2., 8.));

        System.out.println("________________________________________________");


        //task3


/*

  _____               _____   _   _     _   _   _
 |  __ \      /\     |_   _| | \ | |   | | | | | |
 | |__) |    /  \      | |   |  \| |   | | | | | |
 |  ___/    / /\ \     | |   | . ` |   | | | | | |
 | |       / ____ \   _| |_  | |\  |   |_| |_| |_|
 |_|      /_/    \_\ |_____| |_| \_|   (_) (_) (_)


*/


        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alex",
                        new HashSet<Lection>(
                                Arrays.asList(
                                        new Lection(Lections.MATAN, LocalDate.of(2020, 10, 4)),
                                        new Lection(Lections.PHIL, LocalDate.of(2020, 10, 4)),
                                        new Lection(Lections.ENGLISH, LocalDate.of(2020, 10, 5)),
                                        new Lection(Lections.HISTORY, LocalDate.of(2020, 10, 6)),
                                        new Lection(Lections.BEERLUNCH, LocalDate.of(2020, 10, 7))
                                )
                        )
                )
        );

        studentList.add(new Student("Boris",
                        new HashSet<Lection>(
                                Arrays.asList(
                                        new Lection(Lections.MATAN, LocalDate.of(2020, 10, 3)),
                                        new Lection(Lections.PHIL, LocalDate.of(2020, 11, 4)),
                                        new Lection(Lections.ENGLISH, LocalDate.of(2020, 11, 5))
                                )
                        )
                )
        );

        studentList.add(new Student("Vicktor",
                        new HashSet<Lection>(
                                Arrays.asList(
                                        new Lection(Lections.ENGLISH, LocalDate.of(2020, 10, 5)),
                                        new Lection(Lections.HISTORY, LocalDate.of(2020, 10, 6))
                                )
                        )
                )
        );

        studentList.add(new Student("Mary",
                        new HashSet<Lection>(
                                Arrays.asList(
                                        new Lection(Lections.MATAN, LocalDate.of(2020, 10, 3)),
                                        new Lection(Lections.PHIL, LocalDate.of(2020, 10, 4)),
                                        new Lection(Lections.ENGLISH, LocalDate.of(2020, 10, 5))
                                )
                        )
                )
        );

        studentList.add(new Student("Asya",
                        new HashSet<Lection>(
                                Arrays.asList(
                                        new Lection(Lections.PHIL, LocalDate.of(2020, 10, 4)),
                                        new Lection(Lections.ENGLISH, LocalDate.of(2020, 10, 5)),
                                        new Lection(Lections.HISTORY, LocalDate.of(2020, 10, 6))
                                )
                        )
                )
        );


        //1. Выведите список студентов, которые хоть раз посещали матанализ.

        List<Student> case1 = studentList
                .stream()
                .filter(student -> student.getLectionsList()
                        .stream()
                        .anyMatch(lection -> lection.getTitle().equals(Lections.MATAN))
                )
                .collect(Collectors.toList());

        System.out.println(case1);

        System.out.println("            -----------------------------          ");

        //2. Выведите статистику посещений для каждого студентам в формате: имя - количество посщенных лекций.

        //TODO Вывел... но морального удолетворения нет. Как это вернуть в мапе пока не придумал
        List<String> case2 = studentList
                .stream()
                .map(student -> student.getName() + " = " + student.getLectionsList().size())
                .collect(Collectors.toList());

        System.out.println(case2);

        System.out.println("            -----------------------------          ");


        //3. Выведите название дисциплин, имеющих наибольшее количество посещений.
        //       Если два разных студента посещают одну лекцию в один день, то это считается как два посещения.

        Map<Lections, Integer> lecCounter = new HashMap<>();

        //TODO  читинг через идею, написал формами ,а идея уже помгла свернуть

        studentList.
                forEach(student -> student.getLectionsList().
                        forEach(lection -> {
                            lecCounter.putIfAbsent(lection.getTitle(), 0);
                            lecCounter.forEach((key, value) -> {
                                if (lection.getTitle().equals(key)) {
                                    lecCounter.computeIfPresent(key, (k, v) -> v + 1);
                                }
                            });
                        }));


        System.out.println(lecCounter);


        System.out.println("            -----------------------------          ");


        //4. Выведите имена студентов, которые посетили наибольшее количество лекций в день.

        Map<String, Map<LocalDate, Integer>> localDateListMap = new HashMap<>();

        studentList.
                forEach(student -> student.getLectionsList().
                        forEach(lection -> {
                            localDateListMap.putIfAbsent(student.getName(), new HashMap<>());
                            localDateListMap.computeIfPresent(student.getName(),
                                    (k, v) -> {
                                        v.putIfAbsent(lection.getDate(), 0);
                                        v.computeIfPresent(lection.getDate(), (k1, v1) -> v1 + 1);
                                        return v;
                                    }
                            );
                        }));

        Map<String, Integer> stringIntegerMap = new HashMap<>();

        localDateListMap
                .forEach((key, value) -> stringIntegerMap.put(key, Collections.max(value.values())));


        System.out.println(stringIntegerMap);

        System.out.println("            -----------------------------          ");

        //5. Выведите статистику по курсам в формате:
        //название курсов - количество разных студентов, которые посетили хотя бы одно занятие. (т.е. в лучше случае это будет 10)

        //TODO Вообще никак не могу свернуть в стримы ((((

        Map<Lections, Set<String>> lectionsSetMap = new HashMap<>();
        Set<String> tempSet;
        for (Student student : studentList) {
            for (Lection lection : student.getLectionsList()) {
                if (lectionsSetMap.get(lection.getTitle()) != null) {
                    tempSet = lectionsSetMap.get(lection.getTitle());
                } else {
                    tempSet = new HashSet<>();
                }
                tempSet.add(student.getName());
                lectionsSetMap.put(lection.getTitle(), tempSet);
            }
        }

        Map<Lections, Integer> lectionCount = new HashMap<>();

        for (Map.Entry<Lections, Set<String>> lectionsSetEntry : lectionsSetMap.entrySet()) {
            lectionCount.put(lectionsSetEntry.getKey(), lectionsSetEntry.getValue().size());
        }

        System.out.println(lectionCount);

    }
}

package com.orion.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

public class ArrayListExample {

    public static void main(String[] args) {


        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        numbers.remove((Integer) 3);

        System.out.println("Вывожу числа");
        System.out.println(numbers);

        final ListIterator<Integer> integerListIterator = numbers.listIterator();


        integerListIterator.next();
        integerListIterator.next();
        integerListIterator.next();
        System.out.println("Вывожу числа в обратном порядке");

        while (integerListIterator.hasPrevious()) {
            final Integer previous = integerListIterator.previous();

            if (previous == 2) {
                integerListIterator.add(42);
            }
            System.out.println(previous);
        }
        System.out.println(numbers);


        numbers.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });

        System.out.println("Удаляю четные");
        System.out.println(numbers);

    }
}

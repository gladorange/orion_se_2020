package com.orion.lesson11;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {


    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 5);


        final Integer sum = ints.stream().reduce(0, (accumulated, newElement) -> accumulated + newElement);


        final Integer multiplication = ints.stream().reduce(1, (accumulated, newElement) -> accumulated * newElement);
        final Integer multiplicationComplex = ints.stream().reduce(1, ReduceExample::handleMultiplcation);
        final Integer multiplicationComplexLambda
                = ints.stream().reduce(1,  (accumulated, newElement) -> ReduceExample.handleMultiplcation(accumulated, newElement));

        System.out.println("sum" + sum);
        System.out.println("multiplication " + multiplication);
        System.out.println("multiplicationComplex " + multiplicationComplex);


        final Optional<Integer> sumBinaryOperator = ints.stream().reduce(Integer::sum);

        if (sumBinaryOperator.isPresent()) {
            System.out.println(sumBinaryOperator.get());
        }

        // sumBinaryOperator.ifPresent(System.out::println); аналогично записи выше



    }


    public static int handleMultiplcation(int a, int b) {
        if (b == 2) {
            return a;
        }

        return a * b;

    }

}

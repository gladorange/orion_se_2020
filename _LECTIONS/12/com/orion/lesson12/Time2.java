package com.orion.lesson12;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class Time2 {


    public static void main(String[] args) throws InterruptedException {
        final LocalDateTime start = LocalDateTime.now();

        // some work

        Thread.sleep(3000);

        final LocalDateTime end = LocalDateTime.now();


        final Duration between = Duration.between(start, end);
        System.out.println("Прошло" + ChronoUnit.MILLIS.between(start, end ));
        System.out.println(between);


        Period p = Period.between(LocalDate.now(), LocalDate.now().minusYears(30));
        System.out.println(p);
    }
}

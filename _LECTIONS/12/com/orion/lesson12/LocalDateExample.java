package com.orion.lesson12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LocalDateExample {


    public static void main(String[] args) {
        LocalDate now = LocalDate.of(1990, Month.OCTOBER, 29);
        System.out.println(now);

        final LocalDate after10Centuries = now.plus(10, ChronoUnit.CENTURIES);
        System.out.println(after10Centuries);

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        final LocalDateTime lastDayOfMonth = now2.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfMonth " + lastDayOfMonth);


        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(OffsetDateTime.now()));

        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyy");
        System.out.println(dateTimeFormatter.format(now));






/*
        final Date date = new Date(90, 10, 29);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, 2020);
        System.out.println(date);

        final Date time = calendar.getTime();
        System.out.println("30 years later " + time);*/

    }
}

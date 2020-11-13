package com.orion.lesson12;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;

public class Timezones {


    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC+7"));
        System.out.println(zonedDateTime);
        final ZonedDateTime zonedDateTime1 = ZonedDateTime.from(zonedDateTime).withZoneSameInstant(ZoneId.of("UTC+3"));
        System.out.println(zonedDateTime1);


        OffsetDateTime offsetDateTime = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.UTC);
        System.out.println(offsetDateTime);
    }
}

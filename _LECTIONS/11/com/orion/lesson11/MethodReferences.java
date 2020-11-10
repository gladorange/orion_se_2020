package com.orion.lesson11;

import java.util.Arrays;
import java.util.List;

public class MethodReferences {


    public static void main(String[] args) {


        List<String> strings = Arrays.asList("Str1", "Apple", "Orange", "Вася");

       // strings.forEach(str -> printFormattedString(str));

        strings.forEach(MethodReferences::printFormattedString);


        final StringFormatter format = new StringFormatter("<",">");
        final StringFormatter format2 = new StringFormatter("\"","\"");

        strings.forEach(format::formatString);
        strings.forEach(format2::formatString);


    }

    public static void printFormattedString(String toPrint) {
        System.out.println("НАЧАЛО СТРОКИ " + toPrint + " КОНЕЦ СТРОКИ");
    }


    static class StringFormatter {

        private final String prefix;
        private final String suffix;

        public StringFormatter(String prefix, String suffix) {

            this.prefix = prefix;
            this.suffix = suffix;
        }

        void formatString(String str) {
            System.out.println(prefix + str + suffix);

        }
    }

}

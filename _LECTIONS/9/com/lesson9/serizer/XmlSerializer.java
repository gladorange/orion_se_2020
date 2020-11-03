package com.lesson9.serizer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class XmlSerializer {


    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.TYPE })
    public @interface XmlName {
        String value();
        boolean capitalize() default false;
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Prefixes {
        Prefix[] value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Prefixes.class)
    public @interface Prefix {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface XmlIgnore {}

    @XmlName(value = "Человек")
    static class Person {

        @XmlName(value = "Name", capitalize = true)

        @Prefix("com")
        @Prefix("orion")
        String name;

        String surname;

        @XmlIgnore
        String password;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
            password = "abcd";
        }
    }


    /*
    <Person>
    <name>Vasya</name>
    <surname>Pupkin</surname>
    </Person>




   */

    public static void main(String[] args) throws IllegalAccessException {
        Person vasya = new Person("Vasya","Pupkin");
        Person petya = new Person("Petya","Ivanov");

        System.out.println(serialize(vasya));
        System.out.println(serialize(petya));
    }

    public static String serialize(Object toSerialize) throws IllegalAccessException {
        StringBuilder output = new StringBuilder();
        final Class<?> aClass = toSerialize.getClass();
        final String objectName = getObjectName(aClass);
        output.append("<" + objectName + ">\n");

        for (Field declaredField : aClass.getDeclaredFields()) {

            if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }

            declaredField.setAccessible(true);
            final String fieldName = getFieldName(declaredField);
            output.append("<" + fieldName + ">" + declaredField.get(toSerialize).toString() + "</" + fieldName + ">\n");
        }
        output.append("</" + objectName + ">\n\n");

        return output.toString();

    }

    private static String getObjectName(Class<?> aClass) {
        final XmlName annotation = aClass.getAnnotation(XmlName.class);
        if (annotation != null) {
            return annotation.capitalize() ? annotation.value().toUpperCase() : annotation.value();
        }

        return aClass.getSimpleName();
    }

    private static String getFieldName(Field declaredField) {
        final XmlName annotation = declaredField.getAnnotation(XmlName.class);
        if (annotation != null) {


            String annotationValue = annotation.value();

            final Prefixes prefixes = declaredField.getAnnotation(Prefixes.class);
            if (prefixes != null) {
                for (Prefix prefix : prefixes.value()) {
                    annotationValue = prefix.value() + ":" + annotationValue;
                }
            }

            return annotation.capitalize() ? annotationValue.toUpperCase() : annotationValue;
        }

        return declaredField.getName();
    }
}

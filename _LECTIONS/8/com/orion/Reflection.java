package com.orion;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {


        final Class<Person> personClass = Person.class;
        final Person person = personClass.newInstance();

        final Method setName = personClass.getMethod("setName", String.class);
        setName.invoke(person, "Petya");
        System.out.println(person);



        final Method getName = personClass.getMethod("getName");
        final Object name = getName.invoke(person);
        System.out.println(name);


        final Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true);
        final Object nameFromField = nameField.get(person);
        System.out.println(nameFromField);


    }
}

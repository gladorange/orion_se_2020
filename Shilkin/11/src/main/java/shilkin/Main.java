package shilkin;

import shilkin.exceptions.NotAnnotatedWithSimpleComponentException;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, NotAnnotatedWithSimpleComponentException, IllegalAccessException, NoSuchMethodException {
        new SimpleDIFramework("shilkin");
    }
}

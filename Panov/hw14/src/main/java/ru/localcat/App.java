package ru.localcat;

import ru.localcat.fwcore.SimpleDIFramework;

import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println( "NanoFrameWork Start!" );
        SimpleDIFramework simpleDIFramework = new SimpleDIFramework("ru.localcat.examples");
        simpleDIFramework.run();
    }
}

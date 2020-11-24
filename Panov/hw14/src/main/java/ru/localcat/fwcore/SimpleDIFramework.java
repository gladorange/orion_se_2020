package ru.localcat.fwcore;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import ru.localcat.fwcore.annotations.AfterDependenciesInjected;
import ru.localcat.fwcore.annotations.AutowireSimpleComponent;
import ru.localcat.fwcore.annotations.SimpleComponent;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


public class SimpleDIFramework {
    private final String basePackagesToScan;
    private Set<Class<?>> componentsClassSet;
    private final Set<Object> componentsSet = new HashSet<>();
    private Reflections reflections;


    public SimpleDIFramework(String basePackagesToScanPath) {
        basePackagesToScan = basePackagesToScanPath;
    }

    public void run() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        reflections = new Reflections(basePackagesToScan,
                new TypeAnnotationsScanner(),
                new FieldAnnotationsScanner(),
                new MethodAnnotationsScanner());

        componentScan();
        autowiredComponentScanAnSet();
        executeMethod();
    }

    private void componentScan() throws IllegalAccessException, InstantiationException {
        componentsClassSet = reflections.getTypesAnnotatedWith(SimpleComponent.class, true);
        for (Class<?> aClass : componentsClassSet) {
            componentsSet.add(aClass.newInstance());
        }
        System.out.println("SimpleComponent scanned. Found = " + componentsSet.size());
    }

    private void autowiredComponentScanAnSet() throws IllegalAccessException, InstantiationException {
        Set<Field> autowiredFieldsSet =
                reflections.getFieldsAnnotatedWith(AutowireSimpleComponent.class);

        for (Field field : autowiredFieldsSet) {
            field.setAccessible(true);
            if (!componentsClassSet.contains(field.getType())) {
                throw new RuntimeException("Bean not found!");
            }
            for (Object component : componentsSet) {
                if (component.getClass() == field.getType()) {
                    for (Object componentTarget : componentsSet) {
                        if (componentTarget.getClass() == field.getDeclaringClass()) {
                            // helllllllllllllllllll ........... p)
                            field.set(componentTarget, component);
                        }
                    }
                }
            }
        }

        System.out.println("Autowired is complite. Setted fileds = " + autowiredFieldsSet.size());

    }

    private void executeMethod() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Set<Method> executeMethods =
                reflections.getMethodsAnnotatedWith(AfterDependenciesInjected.class);

        System.out.println("Execute methods scanned. Found = " + executeMethods.size());

        System.out.println("Framework Started!");
        System.out.println("******************************************");
        System.out.println();


        for (Method executeMethod : executeMethods) {
            executeMethod.setAccessible(true);
            if (!componentsClassSet.contains(executeMethod.getDeclaringClass())) {
                throw new RuntimeException("Class is not ititalize..... bla bal bla");
            }
            for (Object component : componentsSet) {
                if (component.getClass() == executeMethod.getDeclaringClass()) {
                    executeMethod.invoke(component);
                }
            }
        }
    }

}

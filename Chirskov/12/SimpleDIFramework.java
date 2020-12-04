import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class SimpleDIFramework {
    SimpleDIFramework(String basePackagesToScan) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Reflections reflections = new Reflections(basePackagesToScan);
        Set<Class<?>> objectSet = reflections.getTypesAnnotatedWith(SimpleComponent.class, true);
        Set<Method> methods = reflections.getMethodsAnnotatedWith(AfterDependenciesInjected.class);
        for (Method method : methods) {
            method.setAccessible(true);
            for (Class<?> clas : objectSet) {
                method.invoke(clas.newInstance());
            }
        }
    }
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        new SimpleDIFramework("com.example");// на экран выводится "Мяу" и "Гав-гав!"
    }

    @SimpleComponent
    class Cat {
        void meow() {
            System.out.println("Мяу");
        }
    }

    @SimpleComponent
    class Dog {
        void gav() {
            System.out.println("Гав-гав!");
        }
    }
    @SimpleComponent
    class Zoo {
        @AutowireSimpleComponent
        private Cat cat;

        @AutowireSimpleComponent
        private Dog dog;


        @AfterDependenciesInjected
        private void makeNoise() {
            cat.meow();
            dog.gav();
        }
    }
}

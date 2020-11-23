package shilkin;

import org.reflections.Reflections;
import shilkin.annotations.AfterDependenciesInjected;
import shilkin.annotations.AutowiredSimpleComponent;
import shilkin.annotations.SimpleComponent;
import shilkin.exceptions.NotAnnotatedWithSimpleComponentException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

public class SimpleDIFramework {
    public SimpleDIFramework(String basePackagesToScan) throws NotAnnotatedWithSimpleComponentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Set<Class<?>> classes = new Reflections(basePackagesToScan).getTypesAnnotatedWith(SimpleComponent.class);
        ArrayList<Object> fieldObjects = new ArrayList<>();
        for (Class<?> aClass : classes) {
            Object object = aClass.getDeclaredConstructor().newInstance();
            for (Field declaredField : aClass.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(AutowiredSimpleComponent.class)) {
                    if (!declaredField.getType().isAnnotationPresent(SimpleComponent.class)) {
                        throw new NotAnnotatedWithSimpleComponentException("Класс, не содержится в контейнере.");
                    }
                    declaredField.setAccessible(true);
                    Object fieldObject = declaredField.getType().getDeclaredConstructor().newInstance();
                    if (!fieldObjects.contains(fieldObject)) {
                        fieldObjects.add(fieldObject);
                        declaredField.set(object, fieldObject);
                    } else {
                        int index = fieldObjects.indexOf(fieldObject);
                        declaredField.set(object, fieldObjects.get(index));
                    }
                }
            }
            for (Method declaredMethod : aClass.getDeclaredMethods()) {
                if (declaredMethod.isAnnotationPresent(AfterDependenciesInjected.class)) {
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(object);
                }
            }
        }
    }
}

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
import java.util.List;
import java.util.Set;

public class SimpleDIFramework {
    public SimpleDIFramework(String basePackagesToScan) throws NotAnnotatedWithSimpleComponentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Set<Class<?>> classes = new Reflections(basePackagesToScan).getTypesAnnotatedWith(SimpleComponent.class);
        List<Object> savedObjects = new ArrayList<>();
        for (Class<?> aClass : classes) {
            Object object = aClass.getDeclaredConstructor().newInstance();
            for (Field declaredField : aClass.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(AutowiredSimpleComponent.class)) {
                    if (!declaredField.getType().isAnnotationPresent(SimpleComponent.class)) {
                        throw new NotAnnotatedWithSimpleComponentException("Класс, не содержится в контейнере.");
                    }
                    if (savedObjects.size() == 0) {
                        savedObjects.add(declaredField.getType().getDeclaredConstructor().newInstance());
                    } else {
                        boolean flag = false;
                        for (Object savedObject : savedObjects) {
                            if (declaredField.getType() == savedObject.getClass()) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            savedObjects.add(declaredField.getType().getDeclaredConstructor().newInstance());
                        }
                    }
                    for (Object savedObject : savedObjects) {
                        declaredField.setAccessible(true);
                        if (savedObject.getClass() == declaredField.getType()) {
                            declaredField.set(object, savedObject);
                        }
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

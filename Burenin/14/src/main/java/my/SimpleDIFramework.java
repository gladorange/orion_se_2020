package my;

import my.annotations.AfterDependenciesInjected;
import my.annotations.AutowireSimpleComponent;
import my.annotations.SimpleComponent;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class SimpleDIFramework {
    String basePackagesToScan;

    public SimpleDIFramework(String basePackagesToScan) {
        this.basePackagesToScan = basePackagesToScan;
    }

    public void startScanBasePackages() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        final Reflections reflections = new Reflections(basePackagesToScan);

        final Set<Class<?>> classes = reflections.getTypesAnnotatedWith(SimpleComponent.class, true);
        for (Class<?> clazz : classes) {
            Object obj = clazz.newInstance();
            final Set<Field> fieldsWithAnnotation = ReflectionUtils.getFields(clazz, ReflectionUtils.withAnnotation(AutowireSimpleComponent.class));
            for (Field field : fieldsWithAnnotation) {
                field.setAccessible(true);
                field.set(obj, field.getType().newInstance());
            }
            final Set<Method> methods = ReflectionUtils.getMethods(clazz, ReflectionUtils.withAnnotation(AfterDependenciesInjected.class));
            for (Method method : methods) {
                method.setAccessible(true);
                method.invoke(obj);
            }
        }
    }
}

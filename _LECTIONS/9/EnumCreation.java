import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumCreation {


    enum Fruits {
        ORANGE(Orange.class), APPLE(Apple.class);


        final Class<? extends Fruit> clazz;

        Fruits(Class<? extends Fruit> clazz) {
            this.clazz = clazz;
        }


        Fruit produce() {

            boolean hasZeroArgContructor = false;

            for (Constructor<?> constructor : clazz.getConstructors()) {
                if (constructor.getParameterCount() == 0) {
                    hasZeroArgContructor = true;
                    break;
                }
            }

            if (hasZeroArgContructor) {
                try {
                    return clazz.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


            final Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == 1 && constructor.getParameterTypes()[0] == String.class) {
                    try {
                        return (Fruit) constructor.newInstance("строковый параметр");
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

            }


            return null;
        }

    }



    static class Fruit{

    }

    static class Apple extends Fruit{
        final String appleProperty;


        Apple(String appleProperty) {
            this.appleProperty = appleProperty;
        }
    }
    static class Orange extends Fruit{}
}

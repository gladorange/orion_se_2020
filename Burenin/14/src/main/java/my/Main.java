package my;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        SimpleDIFramework simpleDI = new SimpleDIFramework("my.example");
        simpleDI.startScanBasePackages();
    }
}

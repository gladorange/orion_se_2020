package my.example;

import my.annotations.AfterDependenciesInjected;
import my.annotations.AutowireSimpleComponent;
import my.annotations.SimpleComponent;

@SimpleComponent
public class Zoo {
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
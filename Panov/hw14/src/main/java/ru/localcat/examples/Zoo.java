package ru.localcat.examples;

import ru.localcat.fwcore.annotations.AfterDependenciesInjected;
import ru.localcat.fwcore.annotations.AutowireSimpleComponent;
import ru.localcat.fwcore.annotations.SimpleComponent;

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

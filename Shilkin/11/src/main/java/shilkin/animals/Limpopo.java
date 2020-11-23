package shilkin.animals;

import shilkin.annotations.AfterDependenciesInjected;
import shilkin.annotations.AutowiredSimpleComponent;
import shilkin.annotations.SimpleComponent;

@SimpleComponent()
public class Limpopo {

    @AutowiredSimpleComponent
    private Cat cat;
    @AutowiredSimpleComponent
    private Dog dog;

    public Limpopo() {
    }

    @AfterDependenciesInjected
    private void makeNoise() {
        cat.meow();
        dog.woof();
    }
}
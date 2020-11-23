package shilkin.animals;

import shilkin.annotations.AfterDependenciesInjected;
import shilkin.annotations.AutowiredSimpleComponent;
import shilkin.annotations.SimpleComponent;

@SimpleComponent()
public class Zoo {

    @AutowiredSimpleComponent
    private Cat cat;
    @AutowiredSimpleComponent
    private Dog dog;

    public Zoo() {
    }

    @AfterDependenciesInjected
    private void makeNoise() {
        cat.meow();
        dog.woof();
    }
}

package shilkin.animals;

import shilkin.annotations.AfterDependenciesInjected;
import shilkin.annotations.AutowiredSimpleComponent;
import shilkin.annotations.SimpleComponent;

@SimpleComponent()
public class Madagascar {

    @AutowiredSimpleComponent
    private Cat cat;
    @AutowiredSimpleComponent
    private Dog dog;

    public Madagascar() {
    }

    @AfterDependenciesInjected
    private void makeNoise() {
        cat.meow();
        dog.woof();
    }
}
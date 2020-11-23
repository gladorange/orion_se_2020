package shilkin.animals;

import shilkin.annotations.AfterDependenciesInjected;
import shilkin.annotations.AutowiredSimpleComponent;
import shilkin.annotations.SimpleComponent;

@SimpleComponent()
public class Toronto {

    @AutowiredSimpleComponent
    private Cat cat;
    @AutowiredSimpleComponent
    private Dog dog;
    @AutowiredSimpleComponent
    private Bird bird;

    public Toronto() {
    }

    @AfterDependenciesInjected
    private void makeNoise() {
        cat.meow();
        dog.woof();
        bird.song();
    }
}

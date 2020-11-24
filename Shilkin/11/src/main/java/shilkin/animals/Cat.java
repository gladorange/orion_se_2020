package shilkin.animals;

import shilkin.annotations.SimpleComponent;

@SimpleComponent()
public class Cat {
    void meow() {
        System.out.println("Мурр");
    }
}

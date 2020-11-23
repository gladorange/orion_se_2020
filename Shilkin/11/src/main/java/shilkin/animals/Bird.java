package shilkin.animals;

import shilkin.annotations.SimpleComponent;

@SimpleComponent()
public class Bird {
    void song() {
        System.out.println("пи-пи-пи");
    }
}
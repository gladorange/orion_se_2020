package ru.localcat.examples;

import ru.localcat.fwcore.annotations.SimpleComponent;

@SimpleComponent
public class Cat {
    void meow() {
        System.out.println("Мяу");
    }
}

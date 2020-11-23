package shilkin.animals;

import shilkin.annotations.SimpleComponent;

@SimpleComponent()
public class Dog {
    void woof() {
        System.out.println("Вуф-вуф");
    }
}

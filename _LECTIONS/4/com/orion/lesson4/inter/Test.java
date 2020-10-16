package com.orion.lesson4.inter;

import java.util.Random;

public class Test {


    public static void main(String[] args) {
        RadioControllable[] smartHome = new RadioControllable[10];


        for (int i = 0; i < 10; i++) {
            smartHome[i] = new Random().nextBoolean() ? new Refrigerator() : new TV();
        }


        for (RadioControllable radioControllable : smartHome) {
            radioControllable.turnOn();
        }



        for (RadioControllable radioControllable : smartHome) {
            radioControllable.turnOff();
        }



    }
}

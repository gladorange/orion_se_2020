package com.orion.lesson4.inter;

public class Refrigerator implements RadioControllable{

    boolean isTunedOn;


    @Override
    public void turnOn() {
        isTunedOn = true;
        System.out.println("Начинаю морозить");
    }

    @Override
    public void turnOff() {
        isTunedOn = false;
        System.out.println("Наморозился");
    }
}

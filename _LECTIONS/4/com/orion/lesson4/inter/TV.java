package com.orion.lesson4.inter;

public class TV implements RadioControllable {

    boolean isTurnedOn = false;


    @Override
    public void turnOn() {
        System.out.println("Телевизор включился");
        isTurnedOn = true;
    }

    @Override
    public void turnOff() {
        System.out.println("Телевизор выключился");

        isTurnedOn = false;

    }


    public boolean isTurnedOn() {
        return isTurnedOn;
    }



    public void changeChannel(String newChannel) {
        if (!isTurnedOn) {
            System.out.println("Телевизор выключен, канал не переключается");
            return;
        }

        System.out.println("Включаю новый канал:" + newChannel);
    }


    public static void main(String[] args) {
        TV tv = new TV();
        tv.changeChannel("Сети-НН");
        tv.turnOn();
        tv.changeChannel("Сети-НН");

        RadioControllable object = tv;
        object.turnOff();

    }
}

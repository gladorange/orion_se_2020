package com.orion.lesson4.fabric;

public class CarFactory extends Fabric{
    @Override
    Item getItem() {
        final Car car = new Car();
        car.name = "Машина";
        return car;
    }

}

package com.orion.lesson4.fabric;

public class OrangeFactory extends Fabric {

    @Override
    Item getItem() {
        final Orange orange = new Orange();
        orange.name = "Апельсин";
        return orange;
    }
}

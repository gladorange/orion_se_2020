package ru.localcat.shopitems.goods;

import ru.localcat.shopitems.ElectronicItem;

public class Refrigerator extends ElectronicItem {
    private int freezerVolume;

    public int getFreezerVolume() {
        return freezerVolume;
    }

    public Refrigerator setFreezerVolume(int freezerVolume) {
        this.freezerVolume = freezerVolume;
        return this;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "power=" + power +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", freezerVolume=" + freezerVolume +
                '}';
    }
}

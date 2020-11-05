package ru.localcat.shopitems.goods;

import ru.localcat.shopitems.ElectronicItem;

public class TV extends ElectronicItem {
    private int volume;

    public int getVolume() {
        return volume;
    }

    public TV setVolume(int volume) {
        this.volume = volume;
        return this;
    }

    @Override
    public String toString() {
        return "TV{" +
                "power=" + power +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", volume=" + volume +
                '}';
    }
}

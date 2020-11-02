package ru.localcat.shopitems;

public abstract class ElectronicItem extends ShopItem{
    protected int power;

    public int getPower() {
        return power;
    }

    public ElectronicItem setPower(int power) {
        this.power = power;
        return this;
    }
}

package ru.localcat.shopitems;

public abstract class ShopItem {
    protected String name;
    protected int cost;

    public String getName() {
        return name;
    }

    public ShopItem setName(String name) {
        this.name = name;
        return this;
    }

    public int getCost() {
        return cost;
    }

    public ShopItem setCost(int cost) {
        this.cost = cost;
        return this;
    }
}

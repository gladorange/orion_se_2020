package com.company.lesson8.products;

import java.util.concurrent.ThreadLocalRandom;

public abstract class ShopItem {
    protected String name;
    protected double price;

    ShopItem(String name) {
        this.name = name;
        this.price = ThreadLocalRandom.current().nextDouble(50, 1000);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

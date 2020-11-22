package com.druzhinin;

public class TV extends ElectronicItem {
    int volume;

    public TV(String itemName, Double price, Double powerConsumption, int volume) {
        super(itemName, price, powerConsumption);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "TV{" +
                "volume=" + volume +
                ", powerConsumption=" + powerConsumption +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}

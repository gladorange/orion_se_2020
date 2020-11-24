package com.druzhinin;

public class Refrigerator extends ElectronicItem {
    double volume;

    public Refrigerator(String itemName, Double price, Double powerConsumption, double volume) {
        super(itemName, price, powerConsumption);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "volume=" + volume +
                ", powerConsumption=" + powerConsumption +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}

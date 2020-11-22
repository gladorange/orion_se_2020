package com.druzhinin;

public abstract class ElectronicItem extends ShopItem {
    Double powerConsumption;

    public ElectronicItem(String itemName, Double price, Double powerConsumption) {
        super(itemName, price);
        this.powerConsumption = powerConsumption;
    }

    public Double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}

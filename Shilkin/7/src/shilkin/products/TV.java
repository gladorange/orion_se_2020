package shilkin.products;

import shilkin.items.ElectronicItem;

public class TV extends ElectronicItem {

    private final int volume;

    public TV(String productName, int productPrice, int powerInput, int volume) {
        super(productName, productPrice, powerInput);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "телевизор " + productName + ", громкость: " + this.volume + ", потребляемая мощность: " + powerInput + ", цена: " + productPrice;
    }
}

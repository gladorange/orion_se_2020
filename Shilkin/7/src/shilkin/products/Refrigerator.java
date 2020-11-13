package shilkin.products;

import shilkin.items.ElectronicItem;

public class Refrigerator extends ElectronicItem {

    private final int freezerSize;

    public Refrigerator(String productName, int productPrice, int powerInput, int freezerSize) {
        super(productName, productPrice, powerInput);
        this.freezerSize = freezerSize;
    }

    @Override
    public String toString() {
        return "холодильник " + productName + ", размер морозилки: " + this.freezerSize + ", потребляемая мощность: " + powerInput + ", цена: " + productPrice;
    }
}

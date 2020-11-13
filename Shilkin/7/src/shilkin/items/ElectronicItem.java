package shilkin.items;

public class ElectronicItem extends ShopItem {

    protected final int powerInput;

    public ElectronicItem(String productName, int productPrice, int powerInput) {
        super(productName, productPrice);
        this.powerInput = powerInput;
    }

    public int getPowerInput() {
        return powerInput;
    }
}

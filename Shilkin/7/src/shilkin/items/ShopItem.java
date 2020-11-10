package shilkin.items;

public abstract class ShopItem {

    protected final String productName;
    protected final int productPrice;

    public ShopItem(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }
}

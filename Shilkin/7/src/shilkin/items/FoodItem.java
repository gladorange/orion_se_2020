package shilkin.items;

public class FoodItem extends ShopItem {

    protected final int calorific;
    protected final int storageTime;

    public FoodItem(String productName, int productPrice, int calorific, int storagedTime) {
        super(productName, productPrice);
        this.calorific = calorific;
        this.storageTime = storagedTime;
    }

}

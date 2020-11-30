package maxfomtaskeight;

public class FoodItem extends ShopItem {
    int calorific;
    int shelfLife;

    public FoodItem(String name, int price, int calorific, int shelfLife) {
        super(name, price);
        this.calorific = calorific;
        this.shelfLife = shelfLife;
    }

    public int getCalorific() {
        return calorific;
    }

    public int getShelfLife() {
        return shelfLife;
    }
}

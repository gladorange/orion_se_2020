package com.druzhinin;

public abstract class FoodItem extends ShopItem {
    int calories;
    int shelfLife;

    public FoodItem(String itemName, Double price, int calories, int shelfLife) {
        super(itemName, price);
        this.calories = calories;
        this.shelfLife = shelfLife;
    }
}

package ru.localcat.shopitems;

public abstract class FoodItem extends ShopItem{
    protected int calorieContent;
    protected int expirationDateInDays;

    public int getCalorieContent() {
        return calorieContent;
    }

    public FoodItem setCalorieContent(int calorieContent) {
        this.calorieContent = calorieContent;
        return this;
    }

    public int getExpirationDateInDays() {
        return expirationDateInDays;
    }

    public FoodItem setExpirationDateInDays(int expirationDateInDays) {
        this.expirationDateInDays = expirationDateInDays;
        return this;
    }
}

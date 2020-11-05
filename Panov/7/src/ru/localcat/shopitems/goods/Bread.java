package ru.localcat.shopitems.goods;

import ru.localcat.shopitems.FoodItem;

public class Bread extends FoodItem {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public Bread setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "calorieContent=" + calorieContent +
                ", expirationDateInDays=" + expirationDateInDays +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}

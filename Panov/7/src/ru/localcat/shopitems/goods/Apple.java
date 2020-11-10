package ru.localcat.shopitems.goods;

import ru.localcat.shopitems.FoodItem;
import ru.localcat.shopitems.properties.Color;

public class Apple extends FoodItem {
    private Color color;

    public Color getColor() {
        return color;
    }

    public Apple setColor(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "calorieContent=" + calorieContent +
                ", expirationDateInDays=" + expirationDateInDays +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", color=" + color +
                '}';
    }
}

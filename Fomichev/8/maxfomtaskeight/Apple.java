package maxfomtaskeight;

public class Apple extends FoodItem {
    String color;

    public Apple(String name, int price, int calorific, int shelfLife, String color) {
        super(name, price, calorific, shelfLife);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

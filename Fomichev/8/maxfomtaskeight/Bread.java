package maxfomtaskeight;

public class Bread extends FoodItem {
    int weight;

    public Bread(String name, int price, int calorific, int shelfLife, int weight) {
        super(name, price, calorific, shelfLife);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

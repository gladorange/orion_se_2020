import java.util.concurrent.ThreadLocalRandom;

abstract class ShopItem {
    static final double MIN_PRICE = 99.9;
    static final double MAX_PRICE = 499.9;
    protected String name;
    protected double price = ThreadLocalRandom.current().nextDouble(MIN_PRICE, MAX_PRICE);

    ShopItem(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}
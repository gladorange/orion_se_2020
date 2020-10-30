import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FixPriceShop {
    static final int FIXED_PRICE = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
    static final int MAX_PRODUCT_COUNT = 100;
    static final int MAX_HAPPY_HOUR = 23;
    private HashMap<String, Integer> items = new HashMap<>();
    private int happyHour;
    private ArrayList<String> availableItems = new ArrayList<>();
    FixPriceShop(String[] items)
    {
        for (String item : items)
        {
            int count = ThreadLocalRandom.current().nextInt(0, MAX_PRODUCT_COUNT);
            this.items.put(item, count);
            if (count > 0)
                availableItems.add(item);
        }
        happyHour = ThreadLocalRandom.current().nextInt(0, MAX_HAPPY_HOUR);
    }

    int checkItemPrice(String item, int hour) {
        if (!availableItems.contains(item)) {
            return -1;
        }
        return hour == happyHour? (int)(FIXED_PRICE * 0.5) : FIXED_PRICE;
    }

    ArrayList<String> getItems() {
        return availableItems;
    }

    void buyItem(String item, int hour){
        int currentItemPrice = checkItemPrice(item, hour);
        if (currentItemPrice == -1) {
            System.out.println("Товар " + item + " не обнаружен");
        } else {
            System.out.println("Товар " + item + " продан по цене " + currentItemPrice);
            int newCount = items.get(item) - 1;
            items.put(item, newCount);
            System.out.println("Количества товара в магазие " + newCount);
            if (newCount == 0) {
                availableItems.remove(item);
                System.out.println("Товар " + item + " в магазине закончился");
            }
        }
    }

    public static void main(String[] args) {
        String[] fruitList = {"Apple", "Mango", "Pear", "Watermelon", "Melon"};
        FixPriceShop fruitShop = new FixPriceShop(fruitList);
        FindBestPrice(fruitShop);
        fruitShop.buyItem("Apple", ThreadLocalRandom.current().nextInt(0, MAX_HAPPY_HOUR));
        fruitShop.buyItem("Яблоко", ThreadLocalRandom.current().nextInt(0, MAX_HAPPY_HOUR));

        String[] vegetableList = {"Cucumber", "Tomato", "Eggplant"};
        FixPriceShop vegetableShop = new FixPriceShop(vegetableList);
        FindBestPrice(vegetableShop);

        String[] drinksList = {"Coca-Cola", "Wine", "Beer", "Water"};
        FixPriceShop drinkShop = new FixPriceShop(drinksList);
        FindBestPrice(drinkShop);
    }

    public static void FindBestPrice(FixPriceShop shop) {
        int randomItem = ThreadLocalRandom.current().nextInt(0, shop.getItems().size() - 1);
        String itemName = shop.getItems().get(randomItem);
        for (int hour = 0; hour <= MAX_HAPPY_HOUR; hour++) {
            int currentPrice = shop.checkItemPrice(itemName, hour);
            if (currentPrice < FIXED_PRICE) {
                System.out.println("Для товара " + itemName + " идеальня цена " + currentPrice + " в " + hour);
                break;
            }
        }
    }
}

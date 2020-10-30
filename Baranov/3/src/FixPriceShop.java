import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FixPriceShop {
    String[] items;
    static int price = 49;
    public int happyHour;

    FixPriceShop(String ...items) {
        this.happyHour = ThreadLocalRandom.current().nextInt(0, 23);
        this.items = items;
    }

    public static void main(String[] args) {

        FixPriceShop[]  shops = {
                new FixPriceShop("Apple", "Orange", "Milk", "Chocolate"),
                new FixPriceShop("Potato", "Bear", "Chips", "Bread"),
                new FixPriceShop("Eggs", "Carrot", "Mushrooms", "Soda"),
        };

        for (FixPriceShop shop: shops) {
            String[] arr = shop.getItems();
            String products = arr[ThreadLocalRandom.current().nextInt(0, arr.length)];
            for (int i = 0; i <= 23; i++) {
                if (shop.checkItemPrice(products, i) < FixPriceShop.price) {
                    shop.buyItem(products, i);
                    shop.buyItem(products, i);
                    logFoundHappyHour(i);
                    break;
                }
            }
        }
    }

    public int checkItemPrice(String item, int hour) {
        if (this.checkItem(item)) {
            return getPrice(hour);
        }
        return -1;
    }

    public int getPrice(int hour) {
        return this.happyHour == hour ? FixPriceShop.price / 2 : price;
    }

    public String[] getItems() {
        List<String> list = new ArrayList<String>();
        for(String s : items) {
            if(s != null) {
                list.add(s);
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] getItemsUseStream() {
        return Arrays.stream(this.items)
                .filter(item -> item != null)
                .toArray(String[]::new);
    }

    public void buyItem(String item, int hour) {
        if (checkItem(item)) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] == item) {
                    items[i] = null;
                    logSell(item, getPrice(hour));
                    return;
                }
            }
        }
        logNotFound(item);
    }

    static void logSell(String item, int price) {
        System.out.printf("товар %s продан по цене %s\n", item, price);
    }

    static void logNotFound(String item) {
        System.out.printf("товар %s не обнаружен\n", item);
    }

    public boolean checkItem(String item) {
        return Arrays.asList(this.items).contains(item);
    }

    static void logFoundHappyHour(int hour) {
        System.out.printf("Счастливый час %s\n", hour);
    }
}

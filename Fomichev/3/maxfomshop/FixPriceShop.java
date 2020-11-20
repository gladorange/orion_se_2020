package maxfomshop;

import java.util.Arrays;
import java.util.Random;

public class FixPriceShop {
    int productPrice = 49;
    public String[] items = {"Апельсин", "Банан", "Яблоко", "Груша",
            "Арбуз", "Дыня", "Ананас", "Смузи",
            "Блины", "Молоко", "Каша", "Чипсы"};
    int luckyHour;

    public FixPriceShop(String[] items, int luckyHour) {
        this.luckyHour = luckyHour;
    }

    public int checkItemPrice(String item, int hour) {
        if (item.equals("")) {
            return -1;
        }
        else if (luckyHour == hour) {
            return productPrice / 2;
        }
        else {
            return productPrice;
        }
    }

    public void getItems() {
        System.out.println("В магазине продается: " + Arrays.toString(items));
    }

    public String[] randItem() {
        int idx = new Random().nextInt(items.length);
        String a = items[idx];
        int idx2 = new Random().nextInt(items.length);
        while (idx2 == idx) {
            idx2 = new Random().nextInt(items.length);
        }
        String b = items[idx2];
        int idx3 = new Random().nextInt(items.length);
        while ((idx3 == idx2) || (idx3 == idx)) {
            idx3 = new Random().nextInt(items.length);
        }
        String c = items[idx3];
        int idx4 = new Random().nextInt(items.length);
        while ((idx4 == idx3) || (idx4 == idx2) || (idx4 == idx)) {
            idx4 = new Random().nextInt(items.length);
        }
        String d = items[idx4];
        return new String[] {a, b, c, d};
    }

    void buyItem (String item, int hour) {
        int priceItem = checkItemPrice(item, hour);
        if (priceItem == -1) {
            System.out.println("Товар не обнаружен");
        }
        else {
            for (int i = 0; i < items.length; i++) {
                if (items[i].equals(item)) {
                    items[i] = "";
                    break;
                }
            }
            System.out.println("Товар " + item + " продан по цене " + priceItem + " в " + hour + " часов");
        }
    }

    void createShop(FixPriceShop fixPriceShop) {
        fixPriceShop.items = fixPriceShop.randItem();
        fixPriceShop.getItems();
        int randomItems = new Random().nextInt(fixPriceShop.items.length);
        int randomHours = new Random().nextInt(24);
        System.out.println("Выбран случайный товар - " + fixPriceShop.items[randomItems]);
        fixPriceShop.checkItemPrice(fixPriceShop.items[randomItems], randomHours);
        fixPriceShop.buyItem(fixPriceShop.items[randomItems], randomHours);
        fixPriceShop.buyItem(fixPriceShop.items[randomItems], randomHours);

        System.out.println("\nИдем в другой магазин...\n");
    }


    public static void main(String[] args) {
        FixPriceShop shop1 = new FixPriceShop(new String[4], 15);
        FixPriceShop shop2 = new FixPriceShop(new String[4], 18);
        FixPriceShop shop3 = new FixPriceShop(new String[4], 22);
        shop1.createShop(shop1);
        shop2.createShop(shop2);
        shop3.createShop(shop3);
    }

}

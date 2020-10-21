import java.util.Arrays;
import java.util.Random;

public class FixPriceShop {
    int countItems;
    String[] items;
    static int price = 35;
    int happyHour;

    FixPriceShop (String ... items) {
        this.items = items;
        countItems = items.length;
        happyHour = new Random().nextInt(24);
    }

    public int checkItemPrice(String item, int hour) {
        if (!Arrays.asList(items).contains(item))
            return -1;
        else if (happyHour == hour) {
            return price / 2;
        }
        else {
            return price;
        }
    }

    public String[] getItems() {
        String[] currentItems = new String[countItems];
        int i = 0;
        for (String item : items) {
            if (item == null) {
                continue;
            }
            currentItems[i++] = item;
        }
        return currentItems;
    }

    public void buyItem(String item, int hour) {
        int priceItem = checkItemPrice(item, hour);
        if (priceItem == -1) {
            System.out.printf("Товар %s не обнаружен\n", item);
        }
        else {
            for (int i = 0; i < items.length; i++) {
                if (items[i].equals(item)) {
                    items[i] = null;
                    break;
                }
            }
            countItems--;
            System.out.printf("Товар %s продан по цене %s\n", item, priceItem);
        }
    }


}

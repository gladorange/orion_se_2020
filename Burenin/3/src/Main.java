import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        FixPriceShop[] list = {
                new FixPriceShop("Порошок", "Рис", "Гречка"),
                new FixPriceShop("Мороженое", "Хлеб", "Салфетки"),
                new FixPriceShop("Гречка", "Сыр", "Рис")
        };

        for (int i = 0; i < list.length; i++) {
            System.out.printf("Магазин %s\n", i + 1);
            String[] items = list[i].getItems();
            System.out.println(Arrays.toString(items));
            String item = items[new Random().nextInt(items.length)];
            for (int j = 0; j < 24; j++) {
                int price = list[i].checkItemPrice(item, j);
                if (price == FixPriceShop.price / 2) {
                    System.out.println("Счастливый час - " + j);
                    list[i].buyItem(item, j);
                    list[i].buyItem(item, j);
                }
            }
        }
    }
}

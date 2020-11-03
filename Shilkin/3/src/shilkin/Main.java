package shilkin;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        final int lastHour = 23;

        String[] fruits = {"apple", "apricot", "avocado", "pineapple", "banana", "bergamot"};
        String[] vegetables = {"beet", "broccoli", "cabbage", "carrot", "garlic", "onion"};
        String[] berries = {"barberry", "blueberry ", "cherry", "currant", "raspberry", "rowan"};

        FixPriceShop fruitShop = new FixPriceShop(fruits, 10);
        FixPriceShop vegetableShop = new FixPriceShop(vegetables, 20);
        FixPriceShop berryShop = new FixPriceShop(berries, 30);

        System.out.print("Товары из фруктового магазина: " );
        for (int i = 0;i < fruitShop.getItems().length;i++){
            System.out.print(fruitShop.getItems()[i]);
            if (i != fruitShop.getItems().length-1){
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        System.out.print("Товары из овощного магазина: " );
        for (int i = 0;i < vegetableShop.getItems().length;i++){
            System.out.print(vegetableShop.getItems()[i]);
            if (i != vegetableShop.getItems().length-1){
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        System.out.print("Товары из магазина ягод: " );
        for (int i = 0;i < berryShop.getItems().length;i++){
            System.out.print(berryShop.getItems()[i]);
            if (i != berryShop.getItems().length-1){
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        Random randomFruit = new Random();
        String fruit = fruitShop.getItems()[randomFruit.nextInt(fruitShop.getItems().length)];
        System.out.println("Выбран случайный фрукт из магазина фруктов: " + fruit);
        System.out.println();

        Random randomVegetable = new Random();
        String vegetable = vegetableShop.getItems()[randomVegetable.nextInt(vegetableShop.getItems().length)];
        System.out.println("Выбран случайный овощ из магазина овощей: " + vegetable);
        System.out.println();

        Random randomBerry = new Random();
        String berry = berryShop.getItems()[randomBerry.nextInt(berryShop.getItems().length)];
        System.out.println("Выбрана случайная ягода из магазина ягод: " + berry);
        System.out.println();

        for (int i = 0; i < lastHour; i++){
            if (fruitShop.checkItemPrice(fruit, i) < FixPriceShop.price){
                System.out.println("Счастливый час для покупки в фруктовом магазине: " + i);
                break;
            }
        }
        System.out.println();

        for (int i = 0; i < lastHour; i++){
            if (vegetableShop.checkItemPrice(vegetable, i) < FixPriceShop.price){
                System.out.println("Счастливый час для покупки в овощном магазине: " + i);
                break;
            }
        }
        System.out.println();

        for (int i = 0; i < lastHour; i++){
            if (berryShop.checkItemPrice(berry, i) < FixPriceShop.price){
                System.out.println("Счастливый час для покупки в магазине ягод: " + i);
                break;
            }
        }
        System.out.println();

        fruitShop.buyItem(fruit, 10);
        fruitShop.buyItem(fruit, 10);
        System.out.println();

        vegetableShop.buyItem(vegetable, 10);
        vegetableShop.buyItem(vegetable, 10);
        System.out.println();

        berryShop.buyItem(berry, 10);
        berryShop.buyItem(berry, 10);
        System.out.println();
    }
}

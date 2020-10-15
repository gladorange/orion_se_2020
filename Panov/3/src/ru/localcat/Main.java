package ru.localcat;

import java.util.Random;

public class Main {
    private static final Random randGen = new Random();

    public static void main(String[] args) throws Exception {

        FixPriceShop[] shops = new FixPriceShop[3];
        for (int i = 0; i < shops.length; i++) {
            shops[i] = new FixPriceShop(ItemsGenerator.getRandomItems());
            shops[i].setHappyHour(randGen.nextInt(23));

            //Так как магазины заполняютсья случайны образом опускаем момент с лучаным выборкой товара, в нашем кейсе,
            //даже нулевой товар будет случайным

            String itemForBuy = shops[i].getItems()[0];
            int idealTimeForBuy = 0;

            for (int i1 = 0; i1 < 24; i1++) {
                int itemPrice = shops[i].checkItemPrice(itemForBuy, i1);
                if (itemPrice < FixPriceShop.COST && itemPrice != -1) {
                    System.out.println("Счастливый час для " + itemForBuy + " = " + i1);
                    shops[i].buyItem(itemForBuy, i1);
                    shops[i].buyItem(itemForBuy, i1);
                }
            }
        }
    }
}

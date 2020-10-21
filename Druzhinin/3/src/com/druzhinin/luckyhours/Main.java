package com.druzhinin.luckyhours;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        FixPriceShop shop1 = new FixPriceShop(1);
        FixPriceShop shop2 = new FixPriceShop(2);
        FixPriceShop shop3 = new FixPriceShop(3);

        shop1.printItems();
        System.out.println();
        shop2.printItems();
        System.out.println();
        shop3.printItems();


        int checkedPrice = 49;
        while (checkedPrice != 24) {
            checkedPrice = shop1.checkItemPrice("Box", new Random().nextInt(23));
            if (checkedPrice == -1) {
                break;
            }
            else {
                shop1.buyItem("Box", checkedPrice);
            }
        }

        shop2.buyItem("Cup", 14);
        shop3.buyItem("Juice", 8);

        // Try again
        shop1.buyItem("Box", checkedPrice);
        shop2.buyItem("Cup", 14);
        shop3.buyItem("Juice", 8);
    }
}

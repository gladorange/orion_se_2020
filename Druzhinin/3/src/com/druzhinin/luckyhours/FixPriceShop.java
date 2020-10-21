package com.druzhinin.luckyhours;

import java.util.Random;

enum Goods {
    Ball,
    Book,
    Box,
    Chocolate,
    ComputerKeyboard,
    ComputerMouse,
    Cup,
    Glue,
    Juice,
    Lemonade,
    NewsPaper,
    Paper,
    Pen,
    Spoon,
    Stick,
    Plate,
    Tshort,
    Lemon,
    Banana,
    GasWater,
    Water,
    Shampoo,
    Soap
};

public class FixPriceShop {
    private static int price = 49;
    String[] items;
    private int luckyHour = 0;
    private int shopNumber = 0;

    public FixPriceShop() {
        fillShop();
    }

    public FixPriceShop(int number) {
        shopNumber = number;
        fillShop();
    }

    public int checkItemPrice(String item, int hour) {
        for (String position : items) {
            if (position == item) {
                return hour == luckyHour ? price / 2 : price;
            }
        }
        return -1;
    }

    public String[] getItems() {
        return items;
    }

    public void buyItem(String item, int hour) {

        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {

                String[] temporaryArray = new String[items.length - 1];

                // Copy the elements at the left of the index.
                System.arraycopy(items, 0, temporaryArray, 0, i);
                // Copy the elements at the right of the index.
                System.arraycopy(items, i + 1, temporaryArray, i, items.length - i - 1);

                items = new String[temporaryArray.length];
                System.arraycopy(temporaryArray, 0, items, 0, items.length);
                System.out.printf("Товар %s продан по цене %d\n", item, hour == luckyHour ? price / 2 : price);
                printItems();
                break;
            }
        }
    }

    public void printItems() {
        System.out.println("#Shop: " + shopNumber + " Count of items: " + items.length + " Lucky hour: " + luckyHour);
        for (String position : items) {
            System.out.println(position);
        }
    }

    private String getRandomItem() {
        Random randomForFilling = new Random();
        Goods[] values = Goods.values();
        Goods value = values[randomForFilling.nextInt(Goods.values().length)];

        return value.name();
    }

    private boolean isContain(String item) {
        for (String position : items) {
            if (position == item) {
                return true;
            }
        }
        return false;
    }

    private void fillShop() {
        Random random = new Random();

        luckyHour = random.nextInt(23);
        int size = random.nextInt(Goods.values().length);
        items = new String[size];

        for (int i = 0; i < items.length; i++) {
            while (true) {
                String item = getRandomItem();
                if (!isContain(item)) {
                    items[i] = item;
                    break;
                }
            }
        }
    }
}

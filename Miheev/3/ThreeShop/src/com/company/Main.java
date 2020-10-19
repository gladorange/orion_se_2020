package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int getMin(int[] values) {
        int min = values[0];
        int indexMin = 0;

        for (int index = 1; index < values.length; index++) {
            if (values[index] < min) {
                min = values[index];
                indexMin = index;
            }
        }

        return indexMin;
    }

    private static void findHappyHour(FixPriceShop shop) {
        if (shop == null)
            return;

        // random choice item
        String[] items = shop.getItems();
        int indexItems = (int)(Math.random() * (items.length));
        String item = items[indexItems];

        // search happy hour
        final int HOURS = 24;
        int[] prices = new int[HOURS];
        for (int hour = 0; hour < HOURS; ++hour) {
            prices[hour] = shop.checkItemPrice(item, hour);
        }

        // detected minimum
        System.out.format("happy hour %d for item %s\n", getMin(prices), item);
    }

    public static void main(String[] args) {
        FixPriceShop shop1
                = new FixPriceShop(2, 10, new String[] {"apple", "pear", "cucumber", "tomato"});
        FixPriceShop shop2
                = new FixPriceShop(10, 80, new String[] {"perfume", "soap", "shampoo", "deodorant"});
        FixPriceShop shop3
                = new FixPriceShop(23, 30, new String[] {"car", "tank", "boat", "ball"});

        findHappyHour(shop1);
        findHappyHour(shop2);
        findHappyHour(shop3);
    }
}

class FixPriceShop {
    // static fields
    static int price = 49;
    static int happyHour = 14;

    // private fields
    private String[] items;
    private int personalHappyHour;
    private int discount;

    public FixPriceShop(int personalHappyHour, int discount, String[] items) {
        this.discount = discount;
        this.personalHappyHour = personalHappyHour;

        if (items != null)
            this.items = items;
        else
            System.err.println("Bad third argument 'items!'");
    }

    private boolean searchItem(String item) {
        boolean isItem = false;

        for (String el : items) {
            if (el.equals(item)) {
                isItem = true;
                break;
            }
        }

        return isItem;
    }

    private int getPrice(int hour) {
        if (hour == happyHour)
            return (int)(price * 0.5);

        if (hour == personalHappyHour)
            return (int)(price - price * (discount / 100.0));

        return price;
    }

    private void deleteItem(String item) {
        if (!searchItem(item))
            return;

        List<String> list = new ArrayList<String>(Arrays.asList(items));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(item)) {
                list.remove(i);
            }
        }

        items = list.toArray(new String[0]);
    }

    public int checkItemPrice(String item, int hour) {
        if (searchItem(item))
            return getPrice(hour);
        else
            return -1;
    }

    public String[] getItems() {
        return items;
    }

    public void buyItem(String item, int hour) {
        if (searchItem(item)) {
            System.out.format("Товар %s продан по цене %d\n", item, getPrice(hour));
            deleteItem(item);
        }
        else
            System.out.format("Товар %s не обнаружен\n", item);
    }
}
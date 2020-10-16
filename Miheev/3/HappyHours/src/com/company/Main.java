package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FixPriceShop shop = new FixPriceShop(12, 30);
        System.out.println(Arrays.toString(shop.getItems()));

        // prices
        System.out.format("Цена в 8 часов: %d\n",  shop.checkItemPrice("shampoo", 8));
        System.out.format("Цена в 14 часов: %d\n", shop.checkItemPrice("shampoo", 14));
        System.out.format("Цена в 12 часов: %d\n", shop.checkItemPrice("shampoo", 12));
        System.out.format("Цена в 12 часов: %d\n", shop.checkItemPrice("shampo", 12));

        shop.buyItem("soap", 14);
        System.out.println(Arrays.toString(shop.getItems()));

        shop.buyItem("perfume", 14);
        System.out.println(Arrays.toString(shop.getItems()));

        shop.buyItem("shampoo", 14);
        System.out.println(Arrays.toString(shop.getItems()));

        shop.buyItem("deodorant", 12);
        System.out.println(Arrays.toString(shop.getItems()));
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
    private int count = 0;

    public FixPriceShop(int personalHappyHour, int discount) {
        this.discount = discount;
        this.personalHappyHour = personalHappyHour;

        items = new String[] {"perfume", "soap", "shampoo", "deodorant"};
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

        /** long way
        int indexDel = 0;

        for (int index = 0; index < items.length; ++index) {
            if (items[index].equals(item)) {
                indexDel = index;
                break;
            }
        }

        if (indexDel == items.length - 1) {
            items[indexDel] = "null";
            count++;
            return;
        }

        for (int index = indexDel; index < items.length - 1; ++index) {
            if (items[index + 1] != "null") {
                items[index] = items[index + 1];
            }
            else {
                items[index] = "null";
            }

            if (index == items.length - 2) {
                items[index + 1] = "null";
                count++;
            }
        }*/

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
        /** getItems for long way
        int size = items.length - count;
        String[] returnItems = new String[size];

        for (int index = 0; index < size; index++)
            returnItems[index] = items[index];

        return returnItems;
        **/
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
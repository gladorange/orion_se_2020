package com.happyclock;

import javafx.util.Pair;
import java.lang.String;

public class FixPriceShop {
    public static int discount_;
    public static int price_;

    private  Pair <Integer,Integer> discountHours;
    private String[] items;

    public  FixPriceShop(String[] products, Pair discount_hours) {
        items = products;
        discountHours = discount_hours;
        items = products;
    }

    public static void setPrise(int price) {
        price_= price;
    }

    public static void setDiscount(int discount) {
        discount_= discount;
    }

    public int checkItemPrice(String item, int hour) {
        int prise = -1;
        for (String product_name : items) {
            if (product_name == item) {
                prise = getPrise(hour);
                break;
            }
        }
        return prise;
    }

    public String[] getItems() {
        String[] items_ = {};
        if (items.length > 0) {
            items_ = items;
        }
        return items_;
    }

    public int getPrise(int hour){
        int prise = -1;
        if ( hour >= discountHours.getKey() && hour <= discountHours.getValue()) {
            prise = price_* discount_/ 100;
        }
        else {
            prise = price_;
        }
        return prise;
    }

    public void buyItem(String item, int hour) {
        int prise = 0;
        for (int i = 0; i < items.length; ++i) {
            if (items[i] == item) {
                prise = getPrise(hour);
                System.out.printf("товар %s продан по цене %d\n", item, prise);
                int new_items_size = items.length - 1;
                for (int k = i; k < items.length - 1; ++k){
                    items[k] = items[k + 1];
                }

                String[] temp_array;
                if (new_items_size > 0) {
                    temp_array = new String[new_items_size];
                    for (int k = 0; k < new_items_size; ++k) {
                        temp_array[k] = items[k];
                    }
                    items = temp_array;
                }
                break;
            }
        }
        if (prise == 0) {
            System.out.printf("товар %s не обнаружен\n", item);
        }
    }

    public  Pair <Integer,Integer> getDiscountHours() {
        return discountHours;
    }
}

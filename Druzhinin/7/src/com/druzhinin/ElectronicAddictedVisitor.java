package com.druzhinin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ElectronicAddictedVisitor implements ShopVisitor {
    @Override
    public void visitShop(ArrayList<? extends ShopItem> shop) {

        System.out.println("\nДо Електронико-зависимого клиента товаров: " + shop.size());
        ArrayList<ElectronicItem> electronicItems = new ArrayList<ElectronicItem>();
        for (ShopItem item : shop) {
            if (item instanceof ElectronicItem) {
                ElectronicItem electronicItem = (ElectronicItem) item;
                electronicItems.add(electronicItem);
                System.out.printf("%s - %s мощность: %s\n", electronicItem.getItemName(), electronicItem.getPrice(), electronicItem.getPowerConsumption());
            }
        }

        if (electronicItems.isEmpty()) {
            System.out.println("В этом магазине нет электроники, я расстроен");
            return;
        }

        Comparator<ElectronicItem> comparatorByPowerConsumption = new Comparator<ElectronicItem>() {
            @Override
            public int compare(ElectronicItem electronicItem, ElectronicItem t1) {
                return electronicItem.getPowerConsumption().compareTo(t1.getPowerConsumption());
            }
        };

        ElectronicItem maxPowerItem = Collections.max(electronicItems, comparatorByPowerConsumption);

        System.out.printf("имя_%S куплен по цене_%s\n", maxPowerItem.getItemName(), maxPowerItem.getPrice());

        shop.remove(maxPowerItem);

        for (ShopItem item : shop) {
            System.out.println(item.getItemName() + " - " + item.getPrice());
        }

        System.out.println("После Електронико-зависимого клиента товаров: " + shop.size());
    }
}

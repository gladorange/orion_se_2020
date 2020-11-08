package com.company.lesson8;

import com.company.lesson8.factories.AppleGarden;
import com.company.lesson8.factories.ElectronicFactory;
import com.company.lesson8.factories.FoodFactory;
import com.company.lesson8.products.ElectronicItem;
import com.company.lesson8.products.FoodItem;
import com.company.lesson8.products.ShopItem;
import com.company.lesson8.visitors.ElectronicAddictedVisitor;
import com.company.lesson8.visitors.ImJustLookingVisitor;
import com.company.lesson8.visitors.RichVisitor;
import com.company.lesson8.visitors.ShopVisitor;

import java.util.ArrayList;
import java.util.Collection;

public class Shops {

    public static void main(String[] args) {
        Collection<ShopItem> hypermarket = new ArrayList<>();
        Collection<ElectronicItem> electronicStore = new ArrayList<>();
        Collection<FoodItem> foodStore = new ArrayList<>();
        Collection<FoodItem.Apple> stall = new ArrayList<>();

        ElectronicFactory.fillShopWithElectronicGoods(hypermarket);
        ElectronicFactory.fillShopWithElectronicGoods(electronicStore);

        AppleGarden.fillShopWithApples(foodStore);
        AppleGarden.fillShopWithApples(stall);
        AppleGarden.fillShopWithApples(hypermarket);

        FoodFactory.fillShopWithFood(foodStore);
        FoodFactory.fillShopWithFood(hypermarket);

        Collection<ShopVisitor> visitors = new ArrayList<>();
        visitors.add(new ImJustLookingVisitor());
        visitors.add(new ElectronicAddictedVisitor());
        visitors.add(new RichVisitor());

        for (ShopVisitor visitor : visitors) {
            visitor.visitShop(hypermarket);
            visitor.visitShop(electronicStore);
            visitor.visitShop(foodStore);
            visitor.visitShop(stall);
        }
    }
}

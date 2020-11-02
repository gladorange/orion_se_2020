package ru.localcat;

import ru.localcat.fabric.AppleGarden;
import ru.localcat.fabric.ElectronicFabric;
import ru.localcat.fabric.FoodFactory;
import ru.localcat.shopitems.ElectronicItem;
import ru.localcat.shopitems.FoodItem;
import ru.localcat.shopitems.ShopItem;
import ru.localcat.shopitems.goods.Apple;
import ru.localcat.visitors.ElectronicAddictedVisitor;
import ru.localcat.visitors.ImJustLookingVisitor;
import ru.localcat.visitors.RichVisitor;
import ru.localcat.visitors.ShopVisitor;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Collection<ShopItem> gipermarket = new ArrayList<>();
        Collection<ElectronicItem> electroShop = new ArrayList<>();
        Collection<FoodItem> foodShop = new ArrayList<>();
        Collection<Apple> larek = new ArrayList<>();

        ElectronicFabric.fillShopWithElectronicGoods(gipermarket, 5);
        ElectronicFabric.fillShopWithElectronicGoods(electroShop,6);

        AppleGarden.fillShopWithApples(foodShop,3);
        AppleGarden.fillShopWithApples(larek, 2);
        AppleGarden.fillShopWithApples(gipermarket, 5);

        FoodFactory.fillShopWithFood(foodShop, 5);
        FoodFactory.fillShopWithFood(gipermarket, 10);

        Collection<ShopVisitor> visitors = new ArrayList<>();
        visitors.add(new ElectronicAddictedVisitor());
        visitors.add(new ImJustLookingVisitor());
        visitors.add(new RichVisitor());

        for (ShopVisitor visitor : visitors) {
            visitor.visitShop(gipermarket);
            visitor.visitShop(electroShop);
            visitor.visitShop(foodShop);
            visitor.visitShop(larek);
        }
    }
}

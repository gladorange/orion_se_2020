package ru.localcat.visitors;

import ru.localcat.shopitems.ElectronicItem;
import ru.localcat.shopitems.ShopItem;

import java.util.Collection;

public class ElectronicAddictedVisitor implements ShopVisitor{
    @Override
    public void visitShop(Collection<? extends ShopItem> collection) {
        int maxPower = 0;
        ElectronicItem goodWithMaxPower = null;
        for (ShopItem shopItem : collection) {
            if(shopItem instanceof ElectronicItem) {
                System.out.println("Техногик : " + shopItem.getName() + " - " + shopItem.getCost());

                if(((ElectronicItem) shopItem).getPower() > maxPower) {
                    maxPower = ((ElectronicItem) shopItem).getPower();
                    goodWithMaxPower = (ElectronicItem) shopItem;
                }
            }
        }

        if(goodWithMaxPower != null) {
            System.out.println("Техногик покупает  : " + goodWithMaxPower.getName() + " по цене " + goodWithMaxPower.getCost());
            collection.remove(goodWithMaxPower);
        }
    }
}

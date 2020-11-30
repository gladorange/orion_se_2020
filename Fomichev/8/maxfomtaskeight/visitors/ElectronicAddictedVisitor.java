package maxfomtaskeight.visitors;

import maxfomtaskeight.ElectronicItem;
import maxfomtaskeight.ShopItem;

import java.util.Collection;

public class ElectronicAddictedVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        checkShop(shop);
        buyItem(shop);
    }

    public void checkShop(Collection<? extends ShopItem> shop) {
        shop.forEach(shopItem -> {
            if (shopItem instanceof ElectronicItem) {
                System.out.println(shopItem.getName());
            }
        });
    }

    public void buyItem(Collection<? extends ShopItem> shop) {
        int maxPower = 0;
        ShopItem power = null;
        for (ShopItem item : shop) {
            if (item instanceof ElectronicItem && ((ElectronicItem) item).getPowerUse() > maxPower) {
                power = item;
                maxPower = ((ElectronicItem) item).getPowerUse();
            }
        }
        if (power != null) {
            System.out.printf("%s куплен по %d\n", power.getName(), power.getPrice());
        }
        shop.remove(power);
    }
}

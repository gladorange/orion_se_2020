package shilkin;

import shilkin.Exceptions.NoElementsInCollectionException;
import shilkin.Exceptions.NoExistsInCollectionException;
import shilkin.fabrics.AppleGarden;
import shilkin.fabrics.ElectronicFabric;
import shilkin.fabrics.FoodFactory;
import shilkin.items.ElectronicItem;
import shilkin.items.FoodItem;
import shilkin.items.ShopItem;
import shilkin.products.Apple;
import shilkin.visitors.ElectronicAddictedVisitor;
import shilkin.visitors.ImJustLookingVisitor;
import shilkin.visitors.RichVisitor;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Collection<ShopItem> hyperMarket = new ArrayList<>();
        Collection<ElectronicItem> mVideo = new ArrayList<>();
        Collection<FoodItem> spar = new ArrayList<>();
        Collection<Apple> appleMarket = new ArrayList<>();

        ElectronicFabric.fillShopWithElectronicGoods(hyperMarket);
        System.out.println();
        ElectronicFabric.fillShopWithElectronicGoods(mVideo);
        System.out.println();
        AppleGarden.fillShopWithApples(appleMarket);
        System.out.println();
        AppleGarden.fillShopWithApples(hyperMarket);
        System.out.println();
        AppleGarden.fillShopWithApples(spar);
        System.out.println();
        FoodFactory.fillShopWithFood(spar);
        System.out.println();
        FoodFactory.fillShopWithFood(hyperMarket);
        System.out.println();

        ImJustLookingVisitor imJustLookingVisitor = new ImJustLookingVisitor();
        RichVisitor richVisitor = new RichVisitor();
        ElectronicAddictedVisitor electronicAddictedVisitor = new ElectronicAddictedVisitor();
        try {
            imJustLookingVisitor.visitShop(hyperMarket);
            System.out.println();
            imJustLookingVisitor.visitShop(mVideo);
            System.out.println();
            imJustLookingVisitor.visitShop(spar);
            System.out.println();
            imJustLookingVisitor.visitShop(appleMarket);
            System.out.println();

            richVisitor.visitShop(hyperMarket);
            System.out.println();
            richVisitor.visitShop(mVideo);
            System.out.println();
            richVisitor.visitShop(spar);
            System.out.println();
            richVisitor.visitShop(appleMarket);
            System.out.println();

            electronicAddictedVisitor.visitShop(hyperMarket);
            System.out.println();
            electronicAddictedVisitor.visitShop(mVideo);
            System.out.println();
            electronicAddictedVisitor.visitShop(spar);
            System.out.println();
            electronicAddictedVisitor.visitShop(appleMarket);
            System.out.println();
        } catch (NoElementsInCollectionException | NoExistsInCollectionException e) {
            System.out.println(e.getMessage());
        }
    }
}

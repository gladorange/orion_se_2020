package maxfomtaskeight;

import maxfomtaskeight.fabric.AppleGarden;
import maxfomtaskeight.fabric.ElectronicFabric;
import maxfomtaskeight.fabric.FoodFactory;
import maxfomtaskeight.visitors.ElectronicAddictedVisitor;
import maxfomtaskeight.visitors.ImJustLookingVisitor;
import maxfomtaskeight.visitors.RichVisitor;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    static Collection<ShopItem> hyperStore = new ArrayList<>();
    static Collection<ElectronicItem> electronicStore = new ArrayList<>();
    static Collection<FoodItem> productStore = new ArrayList<>();
    static Collection<Apple> appleStore = new ArrayList<>();

    public static void initializeShops() {
        ElectronicFabric.fillShopWithElectronicGoods(electronicStore);
        ElectronicFabric.fillShopWithElectronicGoods(hyperStore);

        AppleGarden.fillShopWithApples(hyperStore);
        AppleGarden.fillShopWithApples(productStore);
        AppleGarden.fillShopWithApples(appleStore);

        FoodFactory.fillShopWithFood(hyperStore);
        FoodFactory.fillShopWithFood(productStore);
    }

    public static void main(String[] args) {
        initializeShops();
        System.out.println("\nImJustLookingVisitor:");

        ImJustLookingVisitor looker = new ImJustLookingVisitor();
        looker.visitShop(hyperStore);
        looker.visitShop(electronicStore);
        looker.visitShop(productStore);
        looker.visitShop(appleStore);

        System.out.println("\n\nElectronicAddictedVisitor:");

        ElectronicAddictedVisitor addictedVisitor = new ElectronicAddictedVisitor();
        addictedVisitor.visitShop(hyperStore);
        addictedVisitor.visitShop(electronicStore);
        addictedVisitor.visitShop(productStore);
        addictedVisitor.visitShop(appleStore);

        System.out.println("\nRichVisitor:");

        RichVisitor richVisitor = new RichVisitor();
        richVisitor.visitShop(hyperStore);
        richVisitor.visitShop(electronicStore);
        richVisitor.visitShop(productStore);
        richVisitor.visitShop(appleStore);
    }

}

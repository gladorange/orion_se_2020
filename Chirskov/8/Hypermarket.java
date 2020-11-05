import java.util.Collection;
import java.util.HashSet;

public class Hypermarket {
    public static void main(String[] args) {
        Collection<ShopItem> shopItems = new HashSet<>();
        Collection<ElectronicItem> electronicItems = new HashSet<>();
        Collection<FoodItem> foodItems = new HashSet<>();
        Collection<FoodItem.Apple> apples = new HashSet<>();

        ElectronicFabric.fillShopWithElectronicGoods(shopItems);
        ElectronicFabric.fillShopWithElectronicGoods(electronicItems);

        AppleGarden.fillShopWithApples(foodItems);
        AppleGarden.fillShopWithApples(apples);
        AppleGarden.fillShopWithApples(shopItems);

        FoodFactory.fillShopWithFood(foodItems);
        FoodFactory.fillShopWithFood(shopItems);

        ShopVisitor.ImJustLookingVisitor imJustLookingVisitor = new ShopVisitor.ImJustLookingVisitor();
        imJustLookingVisitor.visitShop(shopItems);
        imJustLookingVisitor.visitShop(electronicItems);
        imJustLookingVisitor.visitShop(foodItems);
        imJustLookingVisitor.visitShop(apples);

        ShopVisitor.ElectronicAddictedVisitor electronicAddictedVisitor = new ShopVisitor.ElectronicAddictedVisitor();
        electronicAddictedVisitor.visitShop(shopItems);
        electronicAddictedVisitor.visitShop(electronicItems);

        ShopVisitor.RichVisitor richVisitor = new ShopVisitor.RichVisitor();
        richVisitor.visitShop(shopItems);
    }
}
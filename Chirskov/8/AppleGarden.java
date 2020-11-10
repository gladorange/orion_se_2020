import java.util.ArrayList;
import java.util.Collection;

public class AppleGarden {
    static void fillShopWithApples(Collection<? super FoodItem.Apple> apples) {
        ArrayList<FoodItem.Color> colors = new ArrayList<>();
        FoodItem.Apple grannySmithApple = new FoodItem.Apple("GrannySmith");
        FoodItem.Apple redDeliciousApple = new FoodItem.Apple("RedDelicious");
        apples.add(grannySmithApple);
        colors.add(grannySmithApple.getColor());
        apples.add(redDeliciousApple);
        colors.add(redDeliciousApple.getColor());
        System.out.println("В магазин добавлены яблоки: " + colors);
    }
}

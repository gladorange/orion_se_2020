package ru.localcat.fabric;

import ru.localcat.shopitems.FoodItem;
import ru.localcat.shopitems.goods.Apple;
import ru.localcat.shopitems.goods.Bread;
import ru.localcat.shopitems.properties.Color;

import java.util.Collection;

public class FoodFactory {
    public static void fillShopWithFood(Collection<? super FoodItem> foodsList, int goodsCount) {
        int totalWeight = 0;
        for (int i = 0; i < goodsCount; i++) {

            if(i % 2 == 0) {
                //опустил реалиацию рандома, и заполнение всех полей, дольше и писать и проверять)
                foodsList.add(((Apple) new Apple().setColor(Color.GREEN).setName("Зеленое яблоко").setCost(60)));
            }
            else {
                foodsList.add((Bread) new Bread().setWeight(i*100).setName("Baton").setCost(20));
                totalWeight += i*100;
            }
        }

        //можно было сделать внутреннюю временую коллекцию ,чтобы показывать только добалвенные в цикле товары
        System.out.println("В магазин добавлены яблоки и хлеб" + foodsList + ", общий вес хлеба:" + totalWeight);
    }
}

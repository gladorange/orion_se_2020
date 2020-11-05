package ru.localcat.fabric;

import ru.localcat.shopitems.ShopItem;
import ru.localcat.shopitems.goods.Apple;
import ru.localcat.shopitems.properties.Color;

import java.util.Collection;

public class AppleGarden {
    public static void fillShopWithApples(Collection<? super Apple> applesList, int goodsCount) {
        for (int i = 0; i < goodsCount; i++) {
            //опустил реалиацию рандома, и заполнение всех полей, дольше и писать и проверять)
            applesList.add(((Apple) new Apple().setColor(Color.RED).setName("Красное яблоко").setCost(50)));
        }

        //можно было сделать внутреннюю временую коллекцию ,чтобы показывать только добалвенные в цикле товары
        System.out.println("В магазин добавлены яблоки" + applesList);
    }
}

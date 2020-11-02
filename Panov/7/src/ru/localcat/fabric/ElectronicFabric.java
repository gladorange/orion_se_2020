package ru.localcat.fabric;

import ru.localcat.shopitems.ElectronicItem;
import ru.localcat.shopitems.goods.Apple;
import ru.localcat.shopitems.goods.Bread;
import ru.localcat.shopitems.goods.Refrigerator;
import ru.localcat.shopitems.goods.TV;
import ru.localcat.shopitems.properties.Color;

import java.util.Collection;

public class ElectronicFabric {
    public static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> goodsList, int goodsCount) {
        for (int i = 0; i < goodsCount; i++) {

            if(i % 2 == 0) {
                //опустил реалиацию рандома, и заполнение всех полей, дольше и писать и проверять)
                goodsList.add((TV) new TV().setVolume(50).setPower(100*i).setName("Телек").setCost(1000));
            }
            else {
                goodsList.add((Refrigerator) new Refrigerator().setFreezerVolume(50).setPower(110*i).setName("Морозилка").setCost(1200));
            }
        }

        //можно было сделать внутреннюю временую коллекцию ,чтобы показывать только добалвенные в цикле товары
        System.out.println("В магазин добавлены " + goodsList );
    }
}

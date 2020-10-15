package ru.localcat;

import javax.xml.bind.annotation.XmlType;
import java.util.Random;

public class ItemsGenerator {
    private static final Random randGen = new Random();
    private static final int DEFAULT_COUNT_FOR_RAND_GEN_ITEMS = 10;
    private static String[] items = new String[]{
            "Товар 1",
            "Товар 2",
            "Товар 3",
            "Товар 4",
            "Товар 5",
            "Товар 6",
            "Товар 7",
            "Товар 8",
            "Товар 9"
    };

    public static String[] getItems() {
        return items;
    }

    public static String[] getRandomItems() throws Exception {
        return getRandomItems(randGen.nextInt(DEFAULT_COUNT_FOR_RAND_GEN_ITEMS) + 1);
    }

    public static String[] getRandomItems(int iCount) throws Exception {
        if(iCount > 0) {
            String[] resultItems = new String[iCount];
            for (int i = 0; i < iCount; i++) {
                resultItems[i] = items[randGen.nextInt(items.length-1)];
            }
            return resultItems;
        }
        else {
            throw new Exception("Количество товаров должно быть больше 0");
        }
    }
}

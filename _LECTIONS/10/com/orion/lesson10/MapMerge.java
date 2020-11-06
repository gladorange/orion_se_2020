package com.orion.lesson10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapMerge {


    public static void main(String[] args) {
        String text = "A B C D C B D C B D A C B C S";

        Map<Character, Integer> characterToCount = new HashMap<>();
        for (char character : text.toCharArray()) {
            characterToCount.merge(character, 1, (existingValue, newValue) -> existingValue + newValue);
            //characterToCount.merge(c, 1, Integer::sum);
        }


        System.out.println(characterToCount);


        final Entry<Character, Integer> max = Collections.min(characterToCount.entrySet(), Entry.comparingByValue());

        System.out.println("Реже всех встречается буква " + max.getKey() + ", " + max.getValue() + " раз");

    }
}

package com.orion.lesson6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionContains {


    public static void main(String[] args) {


        List<Integer> lists = new ArrayList<>();
        lists.add(2);
        System.out.println(lists);


        lists.remove((Integer)2);

        System.out.println(lists);

    }



    void removeAll(Collection<?> objects, Collection<?> objectToRemove) {
        for (Object toRemove : objectToRemove) {
            objects.remove(toRemove);
        }
    }
}

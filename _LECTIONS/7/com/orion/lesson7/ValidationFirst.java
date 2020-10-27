package com.orion.lesson7;

import java.util.ArrayList;
import java.util.List;

public class ValidationFirst {


    public static void main(String[] args) {
        List<String> gasolineList = new ArrayList<>();

        if (gasolineList.isEmpty()) {
            throw new RuntimeException("Список колонок не должен быть пуст!");
        }

        for (String str : gasolineList) {
            // какая то логика
        }
    }
}

package com.company.lesson5;

import com.company.lesson5.controls.Button;
import com.company.lesson5.controls.CheckBox;
import com.company.lesson5.controls.Rectangle;
import com.company.lesson5.controls.TextField;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public static String generateRandomStr() {
        Random random = new Random();
        char[] str = new char[random.nextInt(10) + 1];
        for (int i = 0; i < str.length; i++) {
            str[i] = (char)('a' + random.nextInt(26));
        }
        return new String(str);
    }

    public static Rectangle getRandomElement() {
        Main.TypeRect type = Main.TypeRect.values()[ThreadLocalRandom.current().nextInt(Main.TypeRect.values().length)];
        if (type == Main.TypeRect.Button) {
            return new Button("Кнопка");
        } else if (type == Main.TypeRect.CheckBox) {
            return new CheckBox("Галка");
        } else {
            return new TextField("Текстовое поле", RandomGenerator.generateRandomStr());
        }
    }
}

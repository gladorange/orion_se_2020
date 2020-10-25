package ru.localcat.controls;

import ru.localcat.controls.interfaces.InputControl;
import ru.localcat.interfaces.RandomlyFilled;

import java.util.Random;

public class TextInputControl extends Control implements InputControl, RandomlyFilled {
    private static final int MIN_LENGHT = 1;
    private static final int MAX_LENGHT = 10;
    private String text;
    private int textLength;

    public TextInputControl() {}

    public TextInputControl(int sX, int sY, int eX, int eY) {
        super(sX, sY, eX, eY);
    }

    @Override
    public void setText(String text) {
        textLength = text.length();
        if(textLength < MIN_LENGHT || textLength > MAX_LENGHT) {
            throw new RuntimeException("");
        }
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    public int getTextLength() {
        return textLength;
    }

    public static int getMinLenght() {
        return MIN_LENGHT;
    }

    public static int getMaxLenght() {
        return MAX_LENGHT;
    }

    @Override
    public void randomBuild(int x, int y) {
        this.startPositionX = x;
        this.startPositionY = y;
        this.endPositionX = new Random().nextInt(10) + x;
        this.endPositionY = new Random().nextInt(5) + y;

        this.caption = "text-input - "+startPositionX+
                "-"+startPositionY+
                "-"+endPositionX+
                "-"+endPositionY;
    }
}

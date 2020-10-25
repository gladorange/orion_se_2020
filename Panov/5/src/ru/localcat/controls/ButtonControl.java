package ru.localcat.controls;

import ru.localcat.controls.interfaces.Clickable;
import ru.localcat.controls.interfaces.ClickedControl;
import ru.localcat.exceptions.UnsettedCallbackException;
import ru.localcat.interfaces.RandomlyFilled;

import java.util.Random;

public class ButtonControl extends Control implements ClickedControl, RandomlyFilled {
    private Clickable clickableCallback;

    public ButtonControl() {}

    //Андрей, можно ли без переопределния как-то вызывать у экземпляра контсурктор родительского класса?
    public ButtonControl(int sX, int sY, int eX, int eY) {
        super(sX, sY, eX, eY);
    }

    @Override
    public void click() {
        if (clickableCallback != null) {
            clickableCallback.onClick(this);
        } else {
            throw new UnsettedCallbackException("Для элемента " + this.getCaption() + " не назначен обработчик");
        }
    }

    public void setClickableCallback(Clickable clickableCallback) {
        this.clickableCallback = clickableCallback;
    }

    @Override
    public void randomBuild(int x, int y) {
        this.startPositionX = x;
        this.startPositionY = y;
        this.endPositionX = new Random().nextInt(10) + x;
        this.endPositionY = new Random().nextInt(5) + y;

        this.caption = "button - "+startPositionX+
                "-"+startPositionY+
                "-"+endPositionX+
                "-"+endPositionY;
    }
}

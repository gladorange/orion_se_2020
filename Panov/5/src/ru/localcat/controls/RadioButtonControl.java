package ru.localcat.controls;

import ru.localcat.controls.interfaces.CheckedControl;
import ru.localcat.controls.interfaces.Clickable;
import ru.localcat.controls.interfaces.ClickedControl;
import ru.localcat.interfaces.RandomlyFilled;

import java.util.Random;

public class RadioButtonControl extends Control implements ClickedControl, CheckedControl, RandomlyFilled {
    private Clickable clickableCallback;
    private boolean checked = false;

    public RadioButtonControl() {}

    public RadioButtonControl(int sX, int sY, int eX, int eY) {
        super(sX, sY, eX, eY);
    }

    @Override
    public void changeCheck() {
        checked = !checked;
    }

    @Override
    public boolean getChecked() {
        return checked;
    }

    @Override
    public void click() {
        if (clickableCallback != null) {
            clickableCallback.onClick(this);
        }
        changeCheck();
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

        this.caption = "radio-button - "+startPositionX+
                "-"+startPositionY+
                "-"+endPositionX+
                "-"+endPositionY;
    }
}

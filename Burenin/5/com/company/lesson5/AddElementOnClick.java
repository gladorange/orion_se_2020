package com.company.lesson5;

import com.company.lesson5.controls.*;
import com.company.lesson5.controls.interfaces.ButtonClickCallback;
import com.company.lesson5.exceptions.ElementsOverlapException;
import com.company.lesson5.exceptions.ReadOnlyException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AddElementOnClick implements ButtonClickCallback {
    UI scene;

    public AddElementOnClick(UI sceneToAddElements) {
        this.scene = sceneToAddElements;
    }

    @Override
    public void onClicked() {
        List<Rectangle> allElements = scene.getAllElements();
        if (allElements.size() < 3)
            return;
        Rectangle r = RandomGenerator.getRandomElement();
        TextField textX = (TextField) allElements.get(1);
        TextField textY = (TextField) allElements.get(2);
        r.setProperties(Integer.parseInt(textX.getText()),
                Integer.parseInt(textY.getText()),
                ThreadLocalRandom.current().nextInt(1,10),
                ThreadLocalRandom.current().nextInt(1,10));
        try {
            scene.addElement(r);
        }
        catch (ReadOnlyException | ElementsOverlapException e) {
            System.out.println(e.getMessage());
        }
    }
}

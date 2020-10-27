package ru.localcat;

import ru.localcat.controls.ButtonControl;
import ru.localcat.controls.Control;
import ru.localcat.controls.RadioButtonControl;
import ru.localcat.controls.TextInputControl;
import ru.localcat.controls.interfaces.Clickable;
import ru.localcat.exceptions.ElementsOverlapException;
import ru.localcat.exceptions.OutOfCanvasException;
import ru.localcat.helpers.RandomElementGenerator;
import ru.localcat.interfaces.RandomlyFilled;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here
        final int SCENE_SIZE_X = 100;
        final int SCENE_SIZE_Y = 100;


        UI scene = new UI();
        scene.setSizeX(SCENE_SIZE_X);
        scene.setSizeY(SCENE_SIZE_Y);

        RandomElementGenerator rEG = new RandomElementGenerator();
        rEG.addClass(ButtonControl.class);
        rEG.addClass(RadioButtonControl.class);
        rEG.addClass(TextInputControl.class);

        ButtonControl addElementOnScene = new ButtonControl(1, 1, 10, 6);
        addElementOnScene.setCaption("Добавлятор элементов");
        scene.addElement(addElementOnScene);

        TextInputControl textCoordX = new TextInputControl(1, 6, 10, 10);
        textCoordX.setCaption("Координата x для нового элемента");
        scene.addElement(textCoordX);

        TextInputControl textCoordY = new TextInputControl(1, 11, 10, 20);
        textCoordY.setCaption("Координата Y для нового элемента");
        scene.addElement(textCoordY);

        addElementOnScene.setClickableCallback(new Clickable() {
            @Override
            public void onClick(Control control) {
                try {
                    Control newItem = rEG.getRandomElement();
                    if (newItem instanceof RandomlyFilled) {
                        textCoordX.setText(String.valueOf(new Random().nextInt(50) + 1));
                        textCoordY.setText(String.valueOf(new Random().nextInt(50) + 1));
                        RandomlyFilled tempNewItem = (RandomlyFilled) newItem;
                        tempNewItem.randomBuild(Integer.parseInt(textCoordX.getText()), Integer.parseInt(textCoordY.getText()));
                        scene.addElement((Control) tempNewItem);
                        System.out.println("Нажата кнопка в <" + textCoordX.getText() + "," + textCoordY.getText() + ">" +
                                " с названием Кнопка в <" + control.getStartPositionX() + "," + control.getStartPositionY() + ">");
                        System.out.println("Создан элемент " + ((Control) tempNewItem).getCaption());
                        System.out.println("____________________________________________________");
                    }
                } catch (ElementsOverlapException | OutOfCanvasException e) {
                    System.out.println(e.getMessage());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            addElementOnScene.click();
        }
    }
}

package com.druzhinin;

import java.util.Random;

public class AddElementOnClick implements ButtonClickCallback {
    UI scene;

    AddElementOnClick(UI sceneToAddElements) {
        scene = sceneToAddElements;
    }

    @Override
    public void onButtonClick() {
        Rectangle toAdd = generateRandomElement();
        try {
            scene.addElement(toAdd);
        }
        catch (ElementsOverlapException e) {
            System.out.println(e.getMessage());
        }
    }

    private Rectangle generateRandomElement() {
        Random random = new Random();

        int randomElement = random.nextInt(3);

        int randomX = random.nextInt(100);
        int randomY = random.nextInt(100);
        int randWidth = random.nextInt(10);
        int randHeight = random.nextInt(10);

        String randomCaption = generateString(random, "ABCDEFGHIJKLMNOPQRSTUVWXYZ" , random.nextInt(10));

        Point point = getCoordinate();

        switch (randomElement) {
            case 0:
                return new Button(randomX, randomY, randWidth, randHeight, randomCaption, random.nextBoolean(), this::onButtonClick);
            case 1:
                return new CheckBox(randomX, randomY, randWidth, randHeight, randomCaption, random.nextBoolean());
            case 2:
                return new TextField(randomX, randomY, randWidth, randHeight, randomCaption, random.nextBoolean(), generateString(random, "ABCDEFGHIJKLMNOPQRSTUVWXYZ" , random.nextInt(10)));
        }
        return null;
    }

    private Point getCoordinate () {
        Rectangle[] elements = scene.getAllElements();

        Point point = new Point();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] instanceof TextField) {
                TextField textField = (TextField) elements[i];
                if (textField.getCaption().contains("Координата x для нового элемента")) {
                    int coordinateX;
                    try {
                        coordinateX = Integer.parseInt(textField.getEnteredText());
                        point.x = coordinateX;
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }

                } else if (textField.getCaption().contains("Координата y для нового элемента")) {
                    int coordinateY;
                    try {
                        coordinateY = Integer.parseInt(textField.getEnteredText());
                        point.y = coordinateY;
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return point;
    }

    private static String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}

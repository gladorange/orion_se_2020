import java.util.concurrent.ThreadLocalRandom;

interface ButtonClickCallback {
    void onButtonClick();
}

class AddElementOnClick implements ButtonClickCallback {
    UI scene;

    AddElementOnClick(UI sceneToAddElements) {
        scene = sceneToAddElements;
    }

    @Override
    public void onButtonClick() {
        Rectangle toAdd = generateRandomElement(scene);
        try {
            scene.addElement(toAdd);
            System.out.println("Добавлен элемент " + toAdd);
        } catch (UI.ElementsOverlapException | UI.ElementsOutOfScene | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    Rectangle generateRandomElement(UI scene) {
        Rectangle randomElement = Element.createRandomElement();
        if (randomElement.getClass() == Button.class) {
            ButtonClickCallback callback = ThreadLocalRandom.current().nextBoolean()
                                         ? new DoNothingOnClick()
                                         : new AddElementOnClick(scene);
            ((Button) randomElement).setCallback(callback);
        }
        return randomElement;
    }
}

class DoNothingOnClick implements ButtonClickCallback {
    @Override
    public void onButtonClick() {
        System.out.println("Мы просто нажали на кнопку и ничего не произошло!");
    }
}
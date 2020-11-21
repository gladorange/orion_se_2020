package com.druzhinin.battleofwizards;

public class Referee {

    Scene scene;

    public Referee() {

    }

    void generateScene(int width, int height) {
        scene = new Scene(width, height);
    }
}

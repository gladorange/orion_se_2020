package com.orion.lesson4.inter;

import java.util.Random;

public class Button {



    final String title;
    final ButtonClickListener callback;

    public Button(String title, ButtonClickListener callback) {
        this.title = title;
        this.callback = callback;
    }

    interface ButtonClickListener {
        void onButtonClick(Button source);
    }


    void click() {
        callback.onButtonClick(this);
    }


    static class SummListener implements ButtonClickListener {

        @Override
        public void onButtonClick(Button source) {
            int one = new Random().nextInt(1000);
            int another = new Random().nextInt(1000);
            System.out.println(String.format("Сумма %s и %s = %s", another, one, one + another));
        }
    }

    public static void main(String[] args) {
        Button summButton = new Button("Складываем числа", new SummListener());


        summButton.click();
        summButton.click();
        summButton.click();
        summButton.click();
        summButton.click();


        Button powButton = new Button("Возводим в квадрат", new ButtonClickListener() {
            @Override
            public void onButtonClick(Button source) {
                int one = new Random().nextInt(1000);
                System.out.println(String.format("Квадрат %s  = %s", one, one * one));
            }
        });


        powButton.click();
        powButton.click();
        powButton.click();
        powButton.click();
        powButton.click();
        powButton.click();

    }


}

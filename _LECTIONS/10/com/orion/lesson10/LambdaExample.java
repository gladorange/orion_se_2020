package com.orion.lesson10;

import java.util.function.Consumer;

public class LambdaExample {


    static class Button {
        String name;
        Consumer<Button> onClick;

        public Button(String name, Consumer<Button>  onClick) {
            this.name = name;
            this.onClick = onClick;
        }

        void click() {
            onClick.accept(this);
        }
    }


    public static void main(String[] args) {
        Button b1 = new Button("Кнопка 1", new Consumer<Button>() {
            @Override
            public void accept(Button source) {
                System.out.println("Нажата кнопка с названием " + source.name);
            }
        });

        Button b2 = new Button("Кнопка 2", (Button source) -> System.out.println("Лямбда: Нажата кнопка с названием " + source.name));

        b1.click();
        b2.click();
    }
}

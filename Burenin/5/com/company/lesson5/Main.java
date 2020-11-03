package com.company.lesson5;

import com.company.lesson5.controls.Button;
import com.company.lesson5.controls.CheckBox;
import com.company.lesson5.controls.Rectangle;
import com.company.lesson5.controls.TextField;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    enum TypeRect {Button, CheckBox, TextField}
    public static void main(String[] args) {
        UI ui = new UI();

        Button button = new Button("Добавить элемент", new AddElementOnClick(ui));
        button.setProperties(1,1,10,10);
        ui.addElement(button);

        TextField textX = new TextField("Координата x для нового элемента", "0");
        textX.setProperties(1,11,10,5);
        ui.addElement(textX);

        TextField textY = new TextField("Координата y для нового элемента", "0");
        textX.setProperties(11,11,10,5);
        ui.addElement(textY);

        for (int i = 0; i < 10; i++) {
            textX.setText(String.valueOf(ThreadLocalRandom.current().nextInt(1, 100)));
            textY.setText(String.valueOf(ThreadLocalRandom.current().nextInt(1, 100)));
            button.click();
        }
        System.out.println();
        for (Rectangle r : ui.getAllElements()) {
            System.out.println(r);
            if (r == button)
                continue;

            if (r instanceof Button) {
                ((Button) r).click();
            }
            else if (r instanceof CheckBox) {
                ((CheckBox) r).click();
            }
            else if (r instanceof TextField) {
                System.out.println(((TextField) r).getText());
            }
        }
    }
}

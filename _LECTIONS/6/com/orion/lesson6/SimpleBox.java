package com.orion.lesson6;

import java.util.List;

public class SimpleBox<ARGUMENT_TYPE> {


    ARGUMENT_TYPE item;

    public SimpleBox(ARGUMENT_TYPE item) {
        this.item = item;
    }

    public ARGUMENT_TYPE getItem() {
        return item;
    }

    public void setItem(ARGUMENT_TYPE item) {
        this.item = item;
    }


    public static void main(String[] args) {
        SimpleBox<String> stringBox = new SimpleBox<>("");
        stringBox.setItem("42");
        final String item = stringBox.getItem();
        System.out.println(item.length());


        SimpleBox<Integer> intBox = new SimpleBox<>(42);
        intBox.setItem(42);
        final Integer itemInt = intBox.getItem();
        System.out.println(itemInt);

    }
}

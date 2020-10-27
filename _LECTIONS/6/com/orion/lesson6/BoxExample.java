package com.orion.lesson6;

public class BoxExample {


    public static void main(String[] args) {

        final int reslt = sumTwoBoxes(new SimpleBox<>(42), new SimpleBox<>(2));
        System.out.println(reslt);

    }




    static int sumTwoBoxes(SimpleBox<Integer> first,
                           SimpleBox<Integer> second) {
        return first.getItem() + second.getItem();
    }
}

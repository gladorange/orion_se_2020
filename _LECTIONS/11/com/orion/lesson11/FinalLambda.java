package com.orion.lesson11;

public class FinalLambda {





    public interface ClickListener {
        void onClick();
    }


    public static void main(String[] args) {
        String text = "some text";
        text = "another text";

        String finalText = text;
        /*ClickListener listener = new ClickListener() {


            String textInner;
            void contructor(String text) {
                textInner = text;
            }

            @Override
            public void onClick() {
                System.out.println(textInner);
            }
        };*/


        ClickListener listener = () -> System.out.println(finalText);
        listener.onClick();

    }
}

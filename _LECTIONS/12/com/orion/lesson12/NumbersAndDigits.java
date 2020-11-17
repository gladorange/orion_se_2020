package com.orion.lesson12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NumbersAndDigits {

    static FileOutputStream fos;

    static {
        try {
            fos = new FileOutputStream("number-digits.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {

        new Thread(() -> {
            byte[] toWrite = {66, 67, 68, 69, 70, 71, 72, 73, 74, 75};
            try {
                writeToFile(toWrite);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            final byte[] toWrite1 = {49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49};
            try {
                writeToFile(toWrite1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


        fos.flush();


    }

    private static final Object monitor = new Object();

    private synchronized static void writeToFile(byte[] toWrite) throws IOException {
        for (byte b : toWrite) {
            fos.write(b);
        }
    }


}

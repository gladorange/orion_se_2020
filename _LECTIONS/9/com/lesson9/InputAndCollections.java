package com.lesson9;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


public class InputAndCollections {


    public static void main(String[] args) throws IOException {


        long now = System.currentTimeMillis();
        readArray();
        System.out.println("Чтение из массива заняло " + (System.currentTimeMillis() - now));


        now = System.currentTimeMillis();
        readByte();
        System.out.println("Чтение по байтам заняло " + (System.currentTimeMillis() - now));


    }

    private static void readArray() throws IOException {
        byte[] reads = new byte[2];
        int counter = 0;


        int read;

        try (FileInputStream fs = new FileInputStream("C:\\programming\\lucene-demo\\src\\main\\resources\\War and Peace.txt")) {
            while ((read = fs.read(reads)) != -1) {
                counter++;
            }
        }

        System.out.println("Всего данные читались раз: " + counter);

        //  System.out.println(new String(reads));


    }


    private static void readByte() throws IOException {
        // FileInputStream fs = new FileInputStream("C:\\programming\\lucene-demo\\src\\main\\resources\\War and Peace.txt");
        InputStream fs = new BufferedInputStream(new FileInputStream("C:\\programming\\lucene-demo\\src\\main\\resources\\War and Peace.txt"));
        byte[] reads = new byte[2];
        int counter = 0;


        int readByte;
        while ((readByte = fs.read(reads)) != -1) {
            counter++;
        }
        System.out.println("Всего данные читались раз: " + counter);

        fs.close();
    }
}

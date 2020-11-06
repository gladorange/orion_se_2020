package com.orion.lesson10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class OutputAndWriter {


    public static void main(String[] args) throws Exception {
        try (FileOutputStream fos = new FileOutputStream("some-file.txt")) {

            fos.write(65);
            fos.write(66);
            fos.write(67);
            fos.write(68);
            fos.write(69);
        }

        try (FileWriter fos = new FileWriter("some-file-writer.txt")) {

            fos.append('a');
            fos.append('b');
            fos.append('c');
            fos.append('d');
            fos.append('e');
            fos.append("Some string");
        }
    }
}

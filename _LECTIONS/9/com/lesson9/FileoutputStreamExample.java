package com.lesson9;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileoutputStreamExample {


    public static void main(String[] args) throws IOException {

        byte[] array = new byte[]{65, 66, 67, 68, 69, 70};

        try (final OutputStream fos = new BufferedOutputStream(new FileOutputStream("file-to-write.txt", true))) {

            for (byte b : array) {
                fos.write(b);
            }
        }


    }
}

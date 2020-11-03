package com.lesson9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ArrayVsStream {


    public static void main(String[] args) {

        byte[] bytes = new byte[5];

        bytes[0] = 60;
        bytes[1] = 61;
        bytes[2] = 62;
        bytes[3] = 63;
        bytes[4] = 64;


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(60);
        baos.write(61);
        baos.write(62);
        baos.write(63);
        baos.write(64);

        final byte[] bytesFromStream = baos.toByteArray();


        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytesFromStream);


        int read = byteArrayInputStream.read();

        while (read != -1) {
            System.out.println(read);
            read = byteArrayInputStream.read();
        }



    }
}

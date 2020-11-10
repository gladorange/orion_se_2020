package com.orion.lesson10;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileExample {


    public static void main(String[] args) throws IOException {
        File file = new File("some file.txt");

        if (!file.exists()) {
            if (!file.createNewFile()) {
                System.out.println("Файл не создался");
            }
        }

        System.out.println(new Date(file.lastModified()));// Date лучше не использовать.


        File directory = new File("C:\\programming\\java\\orion_se_2020\\_LECTIONS");

        for (String fileName : directory.list()) {
            System.out.println(fileName);
            System.out.println(new File(directory, fileName).getAbsolutePath());
        }

    }
}

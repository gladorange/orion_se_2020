package com.druzhinin.FileManager;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainFileManager {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");

        while (true) {
            System.out.printf("> ");
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            command = command.trim().replaceAll(" +", " ");

            List<String> commandList = Arrays.asList(command.split(" "));

            String zeroArg = commandList.get(0);
            switch (zeroArg) {
                case "pwd":
                    System.out.println(path.toString());
                    break;
                case "ll":
                    File folder = path.toFile();
                    for (File file : folder.listFiles()) {
                        System.out.println(file.toString());
                    }
                    break;
                case "":
                case " ":
                    break;
                case "cat":
                    String nameOfFile = commandList.get(1);
                    List<String> lines = Files.readAllLines(Paths.get(nameOfFile));

                    for (String s: lines) {
                        System.out.println(s);
                    }
                    break;
                case "cd":
                    path = Paths.get(commandList.get(1));
                    System.out.printf("current path is: %s", path.toString());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + zeroArg);
            }
        }
    }
}

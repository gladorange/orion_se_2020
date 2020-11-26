package com.company.lesson9.part2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    String currentPath;

    public FileManager(String path) {
        this.currentPath = new File(path).getAbsolutePath();
    }

    public void pwd() {
        System.out.println("Current directory: " + currentPath);
    }

    public void ls() {
        File path = new File(currentPath);
        System.out.println(path.getPath());
        if (path.exists() && path.isDirectory()){
            String[] list = path.list();
            if (list == null) {
                System.out.println("Wrong path entered!");
            }
            else if (list.length == 0) {
                System.out.println("Folder is empty.");
            }
            else {
                for (String s : list) {
                    System.out.println(s);
                }
            }
        }
        else {
            System.out.println("Wrong path entered!");
        }
    }

    public void cd(String path) {
        final File file = new File(currentPath + "\\" + path);
        if (file.exists() && file.isDirectory()) {
            currentPath = file.getAbsolutePath();
            System.out.println("New Path: " + currentPath);
        }
        else {
            System.out.println("Wrong path entered!");
        }
    }

    public void cat(String fileName) {
        File file = new File(currentPath + "\\" + fileName);
        if (!file.exists() || !file.canRead()) {
            System.out.println("File not found");
            return;
        }
        try {
            FileReader fileReader = new FileReader(file.getAbsoluteFile());
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> commands= new ArrayList<>();
        commands.add("pwd");
        commands.add("ls");
        commands.add("cd");
        commands.add("cat");
        commands.add("quit");
        System.out.println("Available commands:" + commands);
        Scanner s = new Scanner(System.in);
        FileManager fileManager = new FileManager("");
        String message = "Enter a desired command: ";
        while (true) {
            System.out.print(message);
            List<String> list = Arrays.asList(s.nextLine().split(" "));
            String command = list.get(0);
            if (command.equals("quit")) {
                break;
            }

            switch (command) {
                case "pwd" -> {
                    fileManager.pwd();
                    break;
                }
                case "ls" -> {
                    fileManager.ls();
                    break;
                }
                case "cd" -> {
                    if (list.size() < 2) {
                        System.out.println("Enter path for command 'cd'");
                        break;
                    }
                    fileManager.cd(list.get(1));
                    break;
                }
                case "cat" -> {
                    if (list.size() < 2) {
                        System.out.println("Enter path for command 'cat'");
                        break;
                    }
                    fileManager.cat(list.get(1));
                    break;
                }
                default -> {
                    break;
                }
            }
        }
        System.out.println("You closed File Manager.");
    }
}

package ru.localcat.fm;

import ru.localcat.fm.commands.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CliFileManager {

    private static String currentDir;

    public static void start() throws IOException {
        System.out.println("FM mode = active");
        System.out.println("Please input command (exit for quit)");

        currentDir = new File(".").getAbsolutePath();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        while (!command.equals("exit")) {

            List<String> commandArgs = new ArrayList<>();
            //По идее под аргументы надо бы еще один массив
            commandArgs = Arrays.asList(command.split(" "));
            Command internalCommand = null;
            boolean executeCommand = true;

            switch (commandArgs.get(0)) {
                case "pwd": {
                        internalCommand = new PwdCommand();
                    break;
                }
                case "ll" : {
                        internalCommand = new LlCommand();
                    break;
                }
                case "cd": {
                        internalCommand = new CdCommand();
                    break;
                }
                case "cat": {
                        internalCommand = new CatCommand();
                    break;
                }
                default: {
                    System.out.println("Unknown command");
                    executeCommand = false;
                }
            }

            if(executeCommand) {
                internalCommand.setArgs(commandArgs);
                internalCommand.setTargetDir(currentDir);
                internalCommand.execute();
                currentDir = internalCommand.getCurrentDir();
                System.out.println(internalCommand.getResult());
            }

            command = reader.readLine();
        }

        System.out.println("FM mode = disable");
    }
}

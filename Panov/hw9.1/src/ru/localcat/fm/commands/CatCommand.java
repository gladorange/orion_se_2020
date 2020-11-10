package ru.localcat.fm.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CatCommand extends Command{

    @Override
    public void execute() {
        result = "Content = " + readFromFile(this.args.get(1));
    }

    private String readFromFile(String path)
    {

        Path filePath= Paths.get(path);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileContent = "";
        for (String line : lines) {
            fileContent += line + "\n";
        }

        return fileContent;
    }
}

package ru.localcat.fm.commands;

import java.io.File;

public class LlCommand extends Command {

    @Override
    public void execute() {
        readFiles(new File(this.currentDir));
    }

    public void readFiles(File baseDirectory){
        StringBuilder result = new StringBuilder();
        if (baseDirectory.isDirectory()){
            for (File file : baseDirectory.listFiles()) {
                String name = file.getName().toString();
                if(file.isFile()){
                    result.append(file.getName().toString() + " файл \n" ) ;
                }else {
                    result.append(file.getName().toString() + " каталог \n");
                }
            }
        }
        this.result = result.toString();
    }
}

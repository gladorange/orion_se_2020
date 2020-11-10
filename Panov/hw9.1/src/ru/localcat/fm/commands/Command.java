package ru.localcat.fm.commands;

import java.util.List;

public abstract class Command {
    protected List<String> args;
    protected String currentDir;
    protected String result;

    public abstract void execute();

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public void setTargetDir(String path) {
        this.currentDir = path;
    };

    public String getCurrentDir() {
        return this.currentDir;
    }
    public String getResult() {
        return result;
    };
}

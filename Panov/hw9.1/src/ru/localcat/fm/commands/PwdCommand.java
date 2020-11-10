package ru.localcat.fm.commands;

import java.io.File;

public class PwdCommand extends Command {

    @Override
    public void execute() {
        result = currentDir;
    }
}

package ru.localcat.fm.commands;

public class CdCommand extends Command {

    @Override
    public void execute() {
        //ll
        currentDir = this.args.get(1);
        result = "New Location = " + currentDir;
    }
}

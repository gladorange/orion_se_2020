package shilkin.characters;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected final String name;
    protected int health = 100;
    protected int position;
    protected List<Character> killedCharacters = new ArrayList<>();

    public Character(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public List<Character> getKilledCharacters() {
        return killedCharacters;
    }

    public void addKilledCharacters(Character killedCharacter) {
        this.killedCharacters.add(killedCharacter);
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public abstract void toAct(List<Character> characters, int position);

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Персонаж " + position;
    }
}

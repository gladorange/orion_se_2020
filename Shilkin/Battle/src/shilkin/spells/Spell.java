package shilkin.spells;

import shilkin.characters.Character;

import java.util.List;

public abstract class Spell {

    protected final String name;
    protected final int damage;

    public Spell(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public abstract void cast(List<Character> characters, int position);

    public String getName() {
        return name;
    }
}
package shilkin.spells;

import shilkin.characters.Character;
import shilkin.characters.Mage;

import java.util.List;

public abstract class Spell {

    protected final String name;

    public Spell(String name) {
        this.name = name;
    }

    public abstract void cast(Mage mage, List<? super Character> characters);

    public String getName() {
        return name;
    }
}

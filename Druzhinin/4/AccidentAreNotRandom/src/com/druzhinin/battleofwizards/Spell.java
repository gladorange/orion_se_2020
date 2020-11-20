package com.druzhinin.battleofwizards;

public class Spell {

    private String spell;

    public Spell(String spell) {
        this.spell = spell;
    }

    public String getSpell() {
        return spell;
    }

    public void cast() {
        System.out.printf("произносится заклинание: %s", spell);
    }

    @Override
    public String toString() {
        return spell;
    }
}

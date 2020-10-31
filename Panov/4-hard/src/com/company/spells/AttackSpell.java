package com.company.spells;

import com.company.Scene;

public abstract class AttackSpell implements Spell{
    protected int damage;
    protected String spellName;

    public abstract void apply(Scene scene, Integer position);

    public String getSpellName() {
        return spellName;
    }

    public int getDamage() {
        return damage;
    }
}

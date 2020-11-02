package com.company.spells;

import com.company.Scene;

public abstract class DefenceSpell implements Spell {
    protected String spellName;
    protected int defence;

    public abstract int returnDamageAfterDefence(AttackSpell attackSpell);
}

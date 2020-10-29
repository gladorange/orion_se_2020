package com.company.spells.defence;

import com.company.spells.AttackSpell;
import com.company.spells.DefenceSpell;

/**
 * Убирает 50% урона от нанесеного
 */
public class ShieldSpell extends DefenceSpell {

    public ShieldSpell() {
        spellName = "Shiled";
    }

    @Override
    public String getSpellName() {
        return null;
    }

    @Override
    public int returnDamageAfterDefence(AttackSpell attackSpell) {
        System.out.println(" укрывается щитом, принимая половину урона = " + (attackSpell.getDamage() / 2));
        return attackSpell.getDamage() / 2;
    }
}

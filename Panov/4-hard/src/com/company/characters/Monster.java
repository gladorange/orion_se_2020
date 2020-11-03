package com.company.characters;

import com.company.Scene;
import com.company.spells.AttackSpell;

public class Monster extends Character{

    public Monster(int health, String name) {
        this.health = health;
        this.name = name;
    }


    @Override
    public void castSpell(AttackSpell attackSpell, Scene scene, Integer characterPosition) {
        if(!spellsAllow.contains(attackSpell.getClass())) {
            throw new RuntimeException("Монстр не знает такое заклинание!");
        }
        System.out.println("Монстр "+name+" читает заклинание "+attackSpell.getSpellName());
        attackSpell.apply(scene, characterPosition);

        System.out.println("____________________________________");
    }
}

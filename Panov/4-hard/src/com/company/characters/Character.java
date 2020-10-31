package com.company.characters;

import com.company.Scene;
import com.company.spells.AttackSpell;
import com.company.spells.DefenceSpell;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected static final int MAX_SPELLS = 3;
    protected int health = 100;
    protected String name;
    protected List<AttackSpell> spells = new ArrayList<>(MAX_SPELLS);
    protected List<Class<? extends AttackSpell>> spellsAllow = new ArrayList<>(MAX_SPELLS);

    protected List<DefenceSpell> defenceSpells = new ArrayList<>(MAX_SPELLS);
    protected List<Class<? extends DefenceSpell>> defenceSpellsAllow = new ArrayList<>(MAX_SPELLS);

    public void cast(AttackSpell attackSpell, Scene scene, Integer characterPosition) {
        castSpell(attackSpell, scene, characterPosition);
        Character character = scene.getCharacterByPosition(characterPosition);

        scene.computeStep();
        if(scene.isFinalFight()) {
            //мог зашить тип персонажа в отделбную переменую, или брать класс нэйм, но не стал
            System.out.println(" ****** ПОБЕДА *************. Победил персонаж "+character.getName());
        }
    }
    protected abstract void castSpell(AttackSpell attackSpell, Scene scene, Integer characterPosition);

    public int getDamage(AttackSpell attackSpell) {

        int localDefence = attackSpell.getDamage();
        if(defenceSpells.isEmpty()) {
            return localDefence;
        }

        for (DefenceSpell defenceSpell : defenceSpells) {
            System.out.print(this.getName());
            localDefence = defenceSpell.returnDamageAfterDefence(attackSpell);
        }

        return localDefence;
    }

    public Character addSpell(AttackSpell spell) {
        if(spells.size() >= MAX_SPELLS) {
            throw new RuntimeException("Персонаж не может запомнить так много заклиний");
        }
        spellsAllow.add(spell.getClass());
        spells.add(spell);
        return this;
    }

    public Character addDefenceSpell(DefenceSpell defenceSpell) {
        if(defenceSpells.size() >= MAX_SPELLS) {
            throw new RuntimeException("Персонаж не может запомнить так много заклиний");
        }
        defenceSpellsAllow.add(defenceSpell.getClass());
        defenceSpells.add(defenceSpell);
        return this;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }
}

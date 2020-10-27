package com.druzhinin.battleofwizards;

import java.util.Arrays;
import java.util.Random;

public class Wizard extends Character {
    final private int MAX_SPELLS = 3;

    private Spell[] spellBook;
    private int countOfSpell;
    private int checkedSpell = -1;

    public Wizard(String name, int numberOfSpells) {
        super(name);

        if (numberOfSpells <= 3 & numberOfSpells > 0) {
            spellBook = new Spell[numberOfSpells];

            for (int i = 0; i < spellBook.length; i++) {
                spellBook[i] = generateRandomSpell();
            }
        } else {
            System.out.println("Некорректное значение количества заклинаний " + numberOfSpells);
        }
    }

    public void healing(int numberOfHealth) {
        int result = numberOfHealth + getHealth();
        if (result > MAX_HEALTH) {
            setHealth(MAX_HEALTH);
        } else {
            setHealth(result);
        }
    }

    public void setCheckedSpell(int spell) {
        if (spell == 1 | spell == 2 | spell == 3) {
            checkedSpell = spell - 1;
        }
        else {
            System.out.println("некорректный номер заклинания: " + spell);
        }
    }

    private Spell generateRandomSpell() {
        Random random = new Random();

        int kindOfSpell = random.nextInt(SPELLS.values().length);
        switch (SPELLS.values()[kindOfSpell]) {
            case MIGRAINE:
                return new SpellMigraine();
            case WALL_OF_FIRE:
                return new SpellWallOfFire();
            case BANISHING_MONSTERS:
                return new SpellBanishingMonsters();
            case CHAIN_LIGHTNING:
                return new SpellChainLightning();
            case FIRE_TOUCH:
                return new SpellFireTouch();
            case LIGHTNING:
                return new SpellLightning();
            case HEALING:
                return new SpellHealing();
        }
        System.out.println("Что то пошло не так с генерацией заклинаний");
        return null;
    }

    @Override
    public void attack() {
        System.out.printf("Магом %s ", super.getName());
        if (checkedSpell >= 0 & checkedSpell < spellBook.length) {
            spellBook[checkedSpell].cast();

            if (spellBook[checkedSpell] instanceof SpellHealing) {
                setHealth(10);
                System.out.printf("Маг %s себя исцелил\n", getName());
            }
            spellBook[checkedSpell] = null;
        } else {
            System.out.println("Некорректное значение выбранного заклинания" + checkedSpell);
        }
    }

    @Override
    public String toString() {
        return "Wizard{" + super.toString() +
                "spellBook=" + Arrays.toString(spellBook) +
                '}';
    }

    @Override
    public void decreaseHealth(int decr) {
        super.decreaseHealth(decr);
        if (getHealth() <= 0) {
            System.out.printf("Маг %s убит\n", getName());
            return;
        }
        System.out.printf("Маг %s атакован здоровье: %d\n", getName(), getHealth());
    }

    Spell getCurrentSpell() {

        Spell returnedSpell = null;

        if (checkedSpell < 0 | checkedSpell > 2) {
            System.out.println("Некорректное заклинание: " + checkedSpell);
        }
        else {
            if (spellBook[checkedSpell] != null) {
                returnedSpell = spellBook[checkedSpell];
            }
            else {
                System.out.println("Здесь нет заклинания");
            }
        }

        return returnedSpell;
    }
}

package shilkin.characters;

import shilkin.spells.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mage extends Character{

    private final List<? super Spell> spells;

    public Mage(String name, int health, List<? super Spell> spells) {
        super(name, health);
        this.spells = new ArrayList<>(spells);
    }

    public void setHealth(int health){
        super.health = health;
    }

    public int getHealth(){
        return super.health;
    }

    public String getName(){
        return super.name;
    }

    public void castSpell(List<? super Character> characters) {
        Random random = new Random();
        int randomSpell = random.nextInt(2);
        System.out.println("Маг " + super.name + " читает заклинание " + ((Spell)spells.get(randomSpell)).getName());
        ((Spell) spells.get(randomSpell)).cast(this, characters);
    }
}

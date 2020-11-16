package shilkin.characters;

import shilkin.spells.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mage extends Character{
    public Mage(String name, int position) {
        super(name, position);
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


    @Override
    public void toAct(List<Character> characters, int position) {
        Spell spell = getRandomSpell();
        System.out.println("Маг " + super.name + " читает заклинание " + spell.getName() + ".");
        spell.cast(characters, position);
    }

    private Spell getRandomSpell(){
        List<Spell> spells = new ArrayList<>();
        spells.add(new Heal());
        spells.add(new Lightning());
        spells.add(new ChainLightning());
        spells.add(new Banishing());
        spells.add(new FireTouch());
        spells.add(new Migraine());
        spells.add(new WallOfFire());
        Random random = new Random();
        return spells.get(random.nextInt(spells.size()));
    }

    @Override
    public String toString() {
        return "Маг " + super.getName() + " " + super.position;
    }
}
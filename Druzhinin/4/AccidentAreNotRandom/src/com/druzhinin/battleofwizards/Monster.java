package com.druzhinin.battleofwizards;

public class Monster extends Character {

    protected int demagePower;
    private int countOfDemage = 5;

    public Monster(String name, int power) {
        super(name);
        demagePower = power;
    }

    public int getDemage() {
        return countOfDemage;
    }

    @Override
    public void attack() {
        if (--countOfDemage < 0) {
            System.out.printf("У монстра %s не осталось урона\n", getName());
            return;
        }

        System.out.printf("Монстр %s атакует осталось осталось урона %d\n",
                getName(), getDemage());
    }

    public int getDemagePower() {
        return demagePower;
    }

    @Override
    public String toString() {
        return "Monster{" + super.toString() +
                "demagePower=" + demagePower +
                ", countOfDemage=" + countOfDemage +
                '}';
    }

    @Override
    public void decreaseHealth(int decr) {
        super.decreaseHealth(decr);
        if(getHealth() <= 0) {
            System.out.printf("Монстр %s убит\n", getName());
            return;
        }
        System.out.printf("Монстр %s атакован здоровье: %d\n", getName(), getHealth());
    }
}

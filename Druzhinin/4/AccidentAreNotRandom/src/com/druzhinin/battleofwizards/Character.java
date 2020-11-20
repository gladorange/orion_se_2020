package com.druzhinin.battleofwizards;

public abstract class Character {

    protected int MAX_HEALTH = 10;
    private int health = MAX_HEALTH;
    private String name;

    public Character(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void decreaseHealth(int decr) {
        health -= decr;
    }

    public String getName() {
        return name;
    }

    public void attack() {}

    @Override
    public String toString() {
        return "health=" + health +
                ", name='" + name + '\'';
    }
}

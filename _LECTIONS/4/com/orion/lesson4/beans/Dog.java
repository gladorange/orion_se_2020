package com.orion.lesson4.beans;

public class Dog {
    private String ownerName;
    private String name;
    boolean hungry;
    Boolean hungryObject;

    public Dog() {
    }

    public Dog(String ownerName, String name) {
        this.ownerName = ownerName;
        this.name = name;
    }


    public Boolean isHungryObject() {
        return hungryObject;
    }

    public void setHungryObject(Boolean hungryObject) {
        this.hungryObject = hungryObject;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }
}

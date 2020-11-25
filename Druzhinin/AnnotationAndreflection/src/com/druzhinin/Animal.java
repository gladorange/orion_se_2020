package com.druzhinin;

public class Animal {
    @XmlName("Ололо")
    private String ololo;

    @XmlName("Trololo")
    private  String trololo;

    public Animal(String ololo, String trololo) {
        this.ololo = ololo;
        this.trololo = trololo;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return "Animal{" +
                "ololo='" + ololo + '\'' +
                ", trololo='" + trololo + '\'' +
                '}';
    }
}

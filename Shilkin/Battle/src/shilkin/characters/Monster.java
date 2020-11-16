package shilkin.characters;

import shilkin.Utils;

import java.util.List;
import java.util.Random;

public class Monster extends Character {

    public Monster(String name, int position) {
        super(name, position);
    }

    @Override
    public void toAct(List<Character> characters, int position) {
        int damage = Utils.getRandomRange(5,10);
        Random random = new Random();
        int randomPosition = random.nextInt(characters.size());
        while (position == randomPosition){
            randomPosition = random.nextInt(characters.size());
        }
        String targetName = characters.get(randomPosition).getName();
        System.out.println("Монстр " + super.name + " атакует " + targetName + ".");
        int targetHealthBeforeAttack = characters.get(randomPosition).getHealth();
        int targetHealthAfterAttack = targetHealthBeforeAttack - damage;
        if (targetHealthAfterAttack <= 0){
            System.out.println("Монстр " + super.name + " наносит " + damage + " урона и убивает " + targetName + ".");
            super.killedCharacters.add(characters.get(randomPosition));
        }else {
            System.out.println("Монстр " + super.name + " наносит " + damage + " урона по " + targetName + ".");
            characters.get(randomPosition).setHealth(targetHealthAfterAttack);
        }
    }

    @Override
    public String toString() {
        return "Монстр " + super.getName() + " " + super.position;
    }
}
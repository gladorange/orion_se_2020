package shilkin.spells;

import shilkin.characters.Character;
import shilkin.characters.Mage;

import java.util.List;
import java.util.Random;

public class Lightning extends Spell {

    public Lightning() {
        super("Удар молнии", 10);
    }

    @Override
    public void cast(List<Character> characters, int position) {
        Random random = new Random();
        int randomPosition = random.nextInt(characters.size());
        String targetName = characters.get(randomPosition).getName();
        int targetHealthBeforeAttack = characters.get(randomPosition).getHealth();
        int targetHealthAfterAttack = targetHealthBeforeAttack - super.damage;
        if (targetHealthAfterAttack <= 0) {
            System.out.println("Заклинание " + super.name + " наносит " + super.damage + " урона и убивает " + targetName+ ".");
            characters.get(position).addKilledCharacters(characters.get(randomPosition));
        } else {
            System.out.println("Заклинание " + super.name + " наносит " + super.damage + " урона по " + targetName+ ".");
            characters.get(randomPosition).setHealth(targetHealthAfterAttack);
        }
    }
}
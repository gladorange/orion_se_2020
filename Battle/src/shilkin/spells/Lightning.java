package shilkin.spells;

import shilkin.characters.Character;
import shilkin.characters.Mage;

import java.util.List;
import java.util.Random;

public class Lightning extends Spell{

    public Lightning(String name) {
        super(name);
    }

    @Override
    public void cast(Mage mage, List<? super Character> characters) {
        int damage = 10;
        Random random = new Random();
        int randomCharacterPosition = random.nextInt(characters.size());
        String currentName = ((Character)characters.get(randomCharacterPosition)).getName();
        int currentHealth = ((Character)characters.get(randomCharacterPosition)).getHealth();
        ((Character)characters.get(randomCharacterPosition)).setHealth(currentHealth - damage);
        System.out.println("Маг " + mage.getName() + "призывает удар молнии. Молния попадает в "
                + currentName + " и наносит " + damage + " урона");
    }
}

package shilkin.spells;

import shilkin.characters.Character;

import java.util.List;
import java.util.Random;

public class ChainLightning extends Spell {
    public ChainLightning() {
        super("Цепная молния", 5);
    }

    @Override
    public void cast(List<Character> characters, int position) {
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(position) == characters.get(i)) {
                continue;
            }
            Random random = new Random();
            int randomPosition = random.nextInt(characters.size());
            String targetName = characters.get(randomPosition).getName();
            int targetHealthBeforeAttack = characters.get(randomPosition).getHealth();
            int targetHealthAfterAttack = targetHealthBeforeAttack - super.damage;
            if (targetHealthAfterAttack <= 0) {
                System.out.println("Заклинание " + super.name + " задевает " + targetName + " и наносит " + super.damage + " урона.");
                System.out.println(targetName + " погибает.");
                characters.get(position).addKilledCharacters(characters.get(randomPosition));
            } else {
                System.out.println("Заклинание " + super.name + " задевает " + targetName + " и наносит " + super.damage + " урона.");
                characters.get(randomPosition).setHealth(targetHealthAfterAttack);
            }
        }
    }
}
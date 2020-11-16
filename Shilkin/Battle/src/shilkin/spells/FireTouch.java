package shilkin.spells;

import shilkin.characters.Character;

import java.util.List;
import java.util.Random;

public class FireTouch extends Spell{
    public FireTouch() {
        super("Огненное касание", 6);
    }

    @Override
    public void cast(List<Character> characters, int position) {
        boolean flag = false;
        for (Character character : characters) {
            if ((character.getPosition() == characters.get(position).getPosition() + 1) || (character.getPosition() == characters.get(position).getPosition() - 1)) {
                flag = true;
                String targetName = character.getName();
                int targetHealthBeforeAttack = character.getHealth();
                int targetHealthAfterAttack = targetHealthBeforeAttack - super.damage;
                if (targetHealthAfterAttack <= 0) {
                    System.out.println("Заклинание " + super.name + " наносит " + super.damage + " урона и убивает " + targetName + ".");
                    characters.get(position).addKilledCharacters(character);
                } else {
                    System.out.println("Заклинание " + super.name + " наносит " + super.damage + " урона  по " + targetName + ".");
                    character.setHealth(targetHealthAfterAttack);
                }
            }
        }
        if (!flag){
            System.out.println("Чтение заклинания " + super.name + " было бесполезным, т.к. рядом с магом " + characters.get(position).getName() + " не стояло ни одного персонажа.");
        }
    }
}

package shilkin.spells;

import shilkin.characters.Character;

import java.util.List;

public class WallOfFire extends Spell{
    public WallOfFire() {
        super("Стена огня",4);
    }

    @Override
    public void cast(List<Character> characters, int position) {
        boolean flag = false;
        for (Character character : characters) {
            if (character.getPosition() % 2 == 0) {
                flag = true;
                String targetName = character.getName();
                int targetHealthBeforeAttack = character.getHealth();
                int targetHealthAfterAttack = targetHealthBeforeAttack - super.damage;
                if (targetHealthAfterAttack <= 0) {
                    System.out.println("Заклинание " + super.name + " наносит " + super.damage + " урона и убивает " + targetName+ ".");
                    characters.get(position).addKilledCharacters(character);
                } else {
                    System.out.println("Заклинание " + super.name + " наносит " + super.damage + " урона по " + targetName+ ".");
                    character.setHealth(targetHealthAfterAttack);
                }
            }
        }
        if (!flag){
            System.out.println("Чтение заклинания " + super.name + " было бесполезным, т.к. стене огня не удалось задеть ни одного персонажа.");
        }
    }
}

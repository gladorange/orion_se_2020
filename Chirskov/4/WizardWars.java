import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class WizardWars {
    public static HashSet<Character> characters = new HashSet<>();
    public static void main(String[] args) {
        WizardWars wars = new WizardWars();
        wars.initCharacters();
        wars.play();
    }

    void initCharacters() {
        Character.generateRandomNames();
        int maxCount = Character.randomNames.size();
        for (int i = 0; i < maxCount; ++i) {
            Character character = getRandomCharacter();
            character.setCurrentPosition(i);
            characters.add(character);
        }
    }
    public Character getRandomCharacter() {
        int characterNumber = ThreadLocalRandom.current().nextInt(0, Character.randomNames.size());
        final String characterName = Character.randomNames.remove(characterNumber);
        return ThreadLocalRandom.current().nextBoolean() ? Monster.getMonster(characterName) : new Mage(characterName);
    }

    void deleteDeadCharacters() {
        final Iterator iterator = characters.iterator();
        while (iterator.hasNext()) {
            final Character character = (Character)iterator.next();
            final boolean isDead = character.getCurrentHealth() <=0;
            if (isDead) {
                System.out.println(new StringBuilder().append(character.getName()).append(" убит").toString());
                iterator.remove();
            }
        }
    }

    public void play() {
        while (characters.size() > 1) {
            final Iterator iterator = characters.iterator();
            while (iterator.hasNext()) {
                final Character character = (Character) iterator.next();
                character.play(characters);
            }
            deleteDeadCharacters();
        }
        if (characters.size() == 1) {
            Character character = (Character)characters.toArray()[0];
            System.out.println("Персонаж " + character.getName() + " всех победил");
        }
        else {
            System.out.println("Победителей нет!");
        }
    }
}


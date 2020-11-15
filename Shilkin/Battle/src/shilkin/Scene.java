package shilkin;

import shilkin.characters.Character;
import shilkin.characters.Mage;
import shilkin.characters.Monster;

import java.util.*;

public class Scene {

    private final List<Character> characters = new ArrayList<>();

    public void setProperties(int numberOfCharacters) {
        List<Integer> randomInts = getNotRepeatingInts(numberOfCharacters);
        for (int i = 0; i < numberOfCharacters; i++) {
            String monsterName = getNamesList(0).get(randomInts.get(i));
            String mageName = getNamesList(1).get(randomInts.get(i));
            switch (getType()) {
                case 0 -> characters.add(new Monster(monsterName, randomInts.get(i)));
                case 1 -> characters.add(new Mage(mageName, randomInts.get(i)));
            }
        }
        System.out.println(characters.toString());
    }

    public void startGame() {
        System.out.println("Игра начинается");
        while (characters.size() != 1) {
            for (int i = 0; i < characters.size(); i++) {
                characters.get(i).toAct(characters, i);
                if (characters.get(i).getKilledCharacters().size() != 0) {
                    characters.removeAll(characters.get(i).getKilledCharacters());
                }
            }
        }
        System.out.println("Игра окончена. Победил " + characters.get(0).getName() + ".");
    }

    private int getType() {
        Random random = new Random();
        return random.nextInt(2);
    }

    private List<Integer> getNotRepeatingInts(int size) {
        Random random = new Random();
        List<Integer> randomPositions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int position = random.nextInt(10);
            while (randomPositions.contains(position)) {
                position = random.nextInt(10);
            }
            randomPositions.add(position);
        }
        return randomPositions;
    }

    private List<String> getNamesList(int type) {
        List<String> mageNames = new ArrayList<>();
        mageNames.add("Сакура");
        mageNames.add("Иллия");
        mageNames.add("Широ");
        mageNames.add("Кирей");
        mageNames.add("Эмия");
        mageNames.add("Токо");
        mageNames.add("Кайнет");
        mageNames.add("Лорелей");
        mageNames.add("Тосака");
        mageNames.add("Генрих");
        List<String> monsterNames = new ArrayList<>();
        monsterNames.add("Цербер");
        monsterNames.add("Гидра");
        monsterNames.add("Гарпия");
        monsterNames.add("Химера");
        monsterNames.add("Горгона");
        monsterNames.add("Василиск");
        monsterNames.add("Гоблин");
        monsterNames.add("Банши");
        monsterNames.add("Тролль");
        monsterNames.add("Грифон");
        if (type == 0) {
            return monsterNames;
        }
        return mageNames;
    }
}

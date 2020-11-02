package com.company;

import com.company.characters.Character;
import com.company.characters.Mage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scene {
    private final int size;
    private Map<Integer, Character> charactersList;
    // Незапомнил все задание, и сделал под случай, если нужно найти победившую сторону, если убиты все монстры/маги
    private Map<Class<? extends Character>,Integer> characterTypeCounter;

    public Scene(int size) {
        this.size = size;
        this.charactersList = new HashMap<>(size);
        this.characterTypeCounter = new HashMap<>();
    }

    public void computeStep() {
        if(charactersList.isEmpty()) {
            throw new RuntimeException("Сцена ил не заполена или все персонажи проиграли");
        }

        List<Integer> positionForRemoveStorage = new ArrayList<>();

        for(Map.Entry<Integer, Character> entry : charactersList.entrySet()) {
            if(entry.getValue().getHealth() <= 0) {
                positionForRemoveStorage.add(entry.getKey());
            }
        }
        for (Integer position : positionForRemoveStorage) {
            clearCharacterOnScene(position);
        }
    }

    public boolean isFinalFight() {
        if(charactersList.size() <= 1) {
            return true;
        }
        return false;
    }

    public void add(Integer position, Character character) {
        if(position >= size) {
            throw new RuntimeException("Нет такого места для персонажа");
        }

        if(charactersList.containsKey(position)) {
            throw new RuntimeException("Это место занято другим персонажем");
        }
        charactersList.put(position, character);
        Class<? extends Character> characterClass = character.getClass();
        Integer count = 0;
        if(characterTypeCounter.get(character.getClass()) != null) {
            count = characterTypeCounter.get(character.getClass());
        }
        count++;
        characterTypeCounter.put(characterClass, count);
    }

    public Character getCharacterByPosition(int position) {
        return charactersList.get((Integer) position);
    }

    public void clearCharacterOnScene(Integer position) {
        Character character = this.getCharacterByPosition(position);
        Class<? extends Character> characterClass = character.getClass();
        Integer count = 0;
        if(characterTypeCounter.get(character.getClass()) != null) {
            count = characterTypeCounter.get(character.getClass());
        }
        count--;
        if(count <= 0) {
            characterTypeCounter.remove(character.getClass());
        }
        else {
            characterTypeCounter.put(characterClass, count);
        }

        charactersList.remove(position);
    }

    public int getSize() {
        return size;
    }

    public int getCharactersTypes() {
        return characterTypeCounter.size();
    }

    public Map<Integer, Character> getCharactersList() {
        return charactersList;
    }
}

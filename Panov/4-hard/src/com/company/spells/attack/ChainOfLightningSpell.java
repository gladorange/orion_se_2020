package com.company.spells.attack;

import com.company.Scene;
import com.company.characters.Character;
import com.company.spells.AttackSpell;

import java.util.Map;

public class ChainOfLightningSpell extends AttackSpell {

    public ChainOfLightningSpell() {
        damage = 25;
        spellName = "Chain Of Lightning";
    }

    @Override
    public void apply(Scene scene, Integer position) {
        if (scene.getCharacterByPosition(position) == null) {
            throw new RuntimeException("Не по кому кастовать");
        }

        int spellDamage;

        //Кастуюем по всем персам кроме переданого, переданый, сам маг, на него не распростаняеться
        for (Map.Entry<Integer, Character> entry : scene.getCharactersList().entrySet()) {
            if (entry.getKey() != position) {
                Character character = scene.getCharacterByPosition(entry.getKey());

                spellDamage = character.getDamage(this);
                character.setHealth(character.getHealth() - spellDamage);

                System.out.println("Персонаж  " + character.getName() +
                        " ранен на " + spellDamage +
                        ". Теперь у него " +
                        character.getHealth() + " здоровья");
            }
        }

    }
}

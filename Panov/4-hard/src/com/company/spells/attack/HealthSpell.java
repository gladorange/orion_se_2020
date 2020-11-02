package com.company.spells.attack;

import com.company.Scene;
import com.company.characters.Character;
import com.company.spells.AttackSpell;

public class HealthSpell extends AttackSpell {
    public HealthSpell() {
        damage = - 100;
        spellName = "Health";
    }
    @Override
    public void apply(Scene scene, Integer position) {
        if(scene.getCharacterByPosition(position) == null) {
            throw new RuntimeException("Не по кому кастовать");
        }

        Character character = scene.getCharacterByPosition(position);
        character.setHealth(character.getHealth() - damage);
        System.out.println("Персонаж  "+character.getName()+
                " исцелен на "+(-damage)+
                ". Теперь у него "+
                character.getHealth()+" здоровья");
    }
}

package com.company.spells.attack;

import com.company.Scene;
import com.company.characters.Character;
import com.company.spells.AttackSpell;

public class MonsterSpell extends AttackSpell {

    public MonsterSpell(){
        damage = 20;
        spellName = "Monster Attack";
    }

    @Override
    public void apply(Scene scene, Integer position) {
        if(scene.getCharacterByPosition(position) == null) {
            throw new RuntimeException("Не по кому кастовать");
        }

        int spellDamage;
        Character character = scene.getCharacterByPosition(position);

        spellDamage = character.getDamage(this);
        character.setHealth(character.getHealth() - spellDamage);

        System.out.println("Персонаж  "+character.getName()+
                " ранен монстром на "+spellDamage+
                ". Теперь у него "+
                character.getHealth()+" здоровья");
    }
}

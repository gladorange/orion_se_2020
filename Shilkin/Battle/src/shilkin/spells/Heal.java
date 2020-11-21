package shilkin.spells;

import shilkin.characters.Character;

import java.util.List;

public class Heal extends Spell {

    public Heal() {
        super("Лечение",0);
    }

    @Override
    public void cast(List<Character> characters, int position) {
        if (characters.get(position).getHealth() == 100){
            System.out.println("Заклинание бесполезно, т.к. здоровье Мага " + characters.get(position).getName() + " полное.");
            return;
        }
        int effect = 10;
        if (characters.get(position).getHealth() + effect > 100){
            effect = 100 - characters.get(position).getHealth();
        }
        characters.get(position).setHealth(characters.get(position).getHealth() + effect);
        System.out.println("Маг " + characters.get(position).getName() + " Исцелен на 10." + " Теперь у него " + (characters.get(position).getHealth() + effect) + " еденицы здоровья.");
    }
}
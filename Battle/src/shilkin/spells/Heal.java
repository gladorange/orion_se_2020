package shilkin.spells;

import shilkin.characters.Character;
import shilkin.characters.Mage;

import java.util.List;

public class Heal extends Spell {

    public Heal(String name) {
        super(name);
    }

    @Override
    public void cast(Mage mage, List<? super Character> characters) {
        mage.setHealth(mage.getHealth() + 10);
        System.out.println("Маг " + mage.getName() + "Исцелен на 10." + " Теперь у него " + (mage.getHealth() + 10));
    }
}

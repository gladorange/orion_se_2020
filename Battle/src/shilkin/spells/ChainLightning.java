package shilkin.spells;

import shilkin.characters.Character;
import shilkin.characters.Mage;

import java.util.List;

public class ChainLightning extends Spell{


    public ChainLightning(String name) {
        super(name);
    }

    @Override
    public void cast(Mage mage, List<? super Character> characters) {
        int damage = 5;
        int magePosition = 0;
        for (int i = 0; i < characters.size(); i++) {
            if (mage.equals(characters.get(i))){
                magePosition = i;
                break;
            }
        }
        System.out.println("Маг " + mage.getName() + " произносит заклинание цепная молния");
        for (int i = 0; i < characters.size(); i++) {
            if (i == magePosition){
                continue;
            }
            int currentHealth = ((Character)characters.get(i)).getHealth();
            String currentName = ((Character)characters.get(i)).getName();
            ((Character)characters.get(i)).setHealth(currentHealth - damage);
            System.out.println("Цепная молния задевает " + currentName + " и наносит " + damage + " урона");
        }
    }
}

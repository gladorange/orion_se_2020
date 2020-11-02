package com.company;

import com.company.characters.Mage;
import com.company.characters.Monster;
import com.company.spells.attack.ChainOfLightningSpell;
import com.company.spells.attack.FireballSpell;
import com.company.spells.attack.HealthSpell;
import com.company.spells.attack.MonsterSpell;
import com.company.spells.defence.ShieldSpell;

public class Main {

    public static void main(String[] args) {

        Scene scene = new Scene(10);

        scene.add(1, new Mage(50, "Pendalf").addSpell(new HealthSpell()).addSpell(new ChainOfLightningSpell()));
        scene.add(3, new Monster(33, "Gnol").addSpell(new MonsterSpell()).addDefenceSpell(new ShieldSpell()));
        scene.add(4, new Monster(50, "Volodya Mort").addSpell(new MonsterSpell()));
        scene.add(9, new Mage(45, "Garryk").addSpell(new FireballSpell()).addSpell(new ChainOfLightningSpell()));
        //Only EX Test
        //scene.add(10, new Monster(1000, "FatMen"));

        //FIGHT
        scene.getCharacterByPosition(1).cast(new HealthSpell(), scene, 1);
        scene.getCharacterByPosition(9).cast(new FireballSpell(), scene, 3);

        scene.getCharacterByPosition(9).cast(new FireballSpell(), scene, 4);

        scene.getCharacterByPosition(4).cast(new MonsterSpell(), scene, 9);

        scene.getCharacterByPosition(1).cast(new ChainOfLightningSpell(), scene, 1);
        scene.getCharacterByPosition(1).cast(new ChainOfLightningSpell(), scene, 1);

        // Для проверки оконачнаия битвы можно вызвать scene.isFinalFight(), если бы мы захотели использовать рандомы с вайлом,

    }
}

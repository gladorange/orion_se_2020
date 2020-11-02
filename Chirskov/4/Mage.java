import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Mage extends Character {
    static final int MAX_SPELLS_COUNT = 3;
    Spell[] spells = new Spell[MAX_SPELLS_COUNT];
    Mage(String name) {
        super.name = name;
        initRandomSpells(spells);
    }
    @Override
    void play(HashSet<Character> characters) {
        int randomSpellNumber = ThreadLocalRandom.current().nextInt(0, MAX_SPELLS_COUNT);
        Spell spell = spells[randomSpellNumber];
        System.out.println(this + " " + spell);
        spell.castSpell(this, characters);
    }

    @Override
    public String toString() {
        return "Маг " + name + " читает заклинание";
    }

    static void initRandomSpells(Spell[] spells)
    {
        for (int i = 0; i < spells.length; ++i)
        {
            int spellNumber = ThreadLocalRandom.current().nextInt(0, Spell.SpellNames.values().length);
            Spell.SpellNames spell = Spell.SpellNames.values()[spellNumber];
            switch (spell) {
                case HealingSpell:
                    spells[i] = new HealingSpell();
                    break;
                case LightingSpell:
                    spells[i] = new LightingSpell();
                    break;
                case LightingToAllSpell:
                    spells[i] = new LightingToAllSpell();
                    break;
                case TouchOfFireSpell:
                    spells[i] = new TouchOfFireSpell();
                    break;
                case KillAllMonstersSpell:
                    spells[i] = new KillAllMonstersSpell();
                    break;
                case MigraineSpell:
                    spells[i] = new MigraineSpell();
                    break;
                case WallOfFire:
                    spells[i] = new WallOfFire();
                    break;
                default:
                    System.out.println("Нет такого заклинания!");
                    break;
            }
        }
    }
}

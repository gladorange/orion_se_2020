import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

interface Spell {
    int MAX_DAMAGE = 77;

    enum SpellNames {
        HealingSpell, LightingSpell, LightingToAllSpell, TouchOfFireSpell,
        KillAllMonstersSpell, MigraineSpell, WallOfFire
    }

    void castSpell(Character character, HashSet<Character> characters);
}

class HealingSpell implements Spell {
    public void castSpell(Character currentCharacter, HashSet<Character> characters) {
        if (!currentCharacter.checkIsAlive()) {
            return;
        }
        int heal = ThreadLocalRandom.current().nextInt(1, MAX_DAMAGE / 4);
        int healthAfterHeal = currentCharacter.getCurrentHealth() + heal;
        currentCharacter.setCurrentHealth(healthAfterHeal > 100 ? Character.MAX_HEALTH : healthAfterHeal);
        System.out.println(new StringBuilder().append("Маг ").append(currentCharacter.getName())
                .append(" исцелен на ").append(heal).append(". Теперь у него ")
                .append(currentCharacter.getCurrentHealth()).append(" здоровья").toString());
    }

    @Override
    public String toString() {
        return "Исцеление";
    }
}

class LightingSpell implements Spell {
    public void castSpell(Character currentCharacter, HashSet<Character> characters) {
        final Character targetCharacter = (Character) characters.toArray()[ThreadLocalRandom.current().nextInt(0, characters.size())];
        if (!targetCharacter.checkIsAlive()) {
            return;
        }
        int damage = ThreadLocalRandom.current().nextInt(1, MAX_DAMAGE);
        targetCharacter.setCurrentHealth(targetCharacter.getCurrentHealth() - damage);
        System.out.println(new StringBuilder().append("Маг ").append(currentCharacter.getName())
                .append(" наносит ").append(targetCharacter.getName()).append(" ").append(damage)
                .append(" урона молнией. ").append("Теперь у ").append(targetCharacter.getName())
                .append(" ").append(targetCharacter.getCurrentHealth()).append(" здоровья").toString());
    }

    @Override
    public String toString() {
        return "Молния";
    }
}

class LightingToAllSpell implements Spell {
    public void castSpell(Character character, HashSet<Character> characters) {
        int damage = ThreadLocalRandom.current().nextInt(1, MAX_DAMAGE / 2);
        StringBuilder builder = new StringBuilder("Цепная молния ударяет по ");
        boolean isSomebodyDamaged = false;
        final Iterator iterator = characters.iterator();
        while (iterator.hasNext()) {
            final Character targetCharacter = (Character) iterator.next();
            if (character.getName().equals(targetCharacter.getName())
                    || !targetCharacter.checkIsAlive()) {
                continue;
            }
            targetCharacter.setCurrentHealth(targetCharacter.getCurrentHealth() - damage);
            builder.append(targetCharacter.getName()).append(", ").toString();
            isSomebodyDamaged = true;
        }

        builder.delete(builder.length() - 2, builder.length() - 1);
        builder.append(System.getProperty("line.separator")).append("Каждый получает ").append(damage).append(" урона.");
        if (isSomebodyDamaged) {
            System.out.println(builder);
        }
    }

    @Override
    public String toString() {
        return "Цепная молния";
    }
}

class TouchOfFireSpell implements Spell {
    public void castSpell(Character character, HashSet<Character> characters) {
        int damage = ThreadLocalRandom.current().nextInt(1, MAX_DAMAGE / 3);
        StringBuilder builder = new StringBuilder("Огненное касание наносит урон по ");
        boolean isSomebodyDamaged = false;
        final Iterator iterator = characters.iterator();
        while (iterator.hasNext()) {
            final Character targetCharacter = (Character) iterator.next();
            if ((character.getCurrentPosition() != targetCharacter.getCurrentPosition() + 1
                    && character.getCurrentPosition() != targetCharacter.getCurrentPosition() - 1)
                    || !targetCharacter.checkIsAlive()) {
                continue;
            }
            targetCharacter.setCurrentHealth(targetCharacter.getCurrentHealth() - damage);
            builder.append(targetCharacter.getName()).append(", ").toString();
            isSomebodyDamaged = true;
        }
        builder.delete(builder.length() - 2, builder.length() - 1);
        builder.append(System.getProperty("line.separator")).append("Все рядом с ")
                .append(character.getName()).append(" получают по ").append(damage).append(" урона.");
        if (isSomebodyDamaged) {
            System.out.println(builder);
        };
    }

    @Override
    public String toString() {
        return "Огненное касание";
    }
}

class KillAllMonstersSpell implements Spell {
    public void castSpell(Character character, HashSet<Character> characters) {
        final Iterator iterator = characters.iterator();
        while (iterator.hasNext()) {
            final Character targetCharacter = (Character) iterator.next();
            if (!targetCharacter.checkIsAlive()) {
                continue;
            }
            if (targetCharacter.getClass() == Monster.class) {
                System.out.println(new StringBuilder().append(targetCharacter.getName()).append(" убит").toString());
            }
        }
        System.out.println("Все монстры изгнаны!");
    }

    @Override
    public String toString() {
        return "Изгнание монстров";
    }
}

class MigraineSpell implements Spell {
    public void castSpell(Character character, HashSet<Character> characters) {
        int damage = ThreadLocalRandom.current().nextInt(1, MAX_DAMAGE);
        final Iterator iterator = characters.iterator();
        while (iterator.hasNext()) {
            final Character targetCharacter = (Character) iterator.next();
            if (!targetCharacter.checkIsAlive()) {
                continue;
            }
            if (targetCharacter.getClass() == Mage.class) {
                targetCharacter.setCurrentHealth(targetCharacter.getCurrentHealth() - damage);
            }
        }
        System.out.println(new StringBuilder().append("У всех магов заболела голова и они получают по ")
                .append(damage).append(" урона").toString());
    }

    @Override
    public String toString() {
        return "Мигрень";
    }
}

class WallOfFire implements Spell {
    public void castSpell(Character character, HashSet<Character> characters) {
        int damage = ThreadLocalRandom.current().nextInt(1, MAX_DAMAGE);
        final Iterator iterator = characters.iterator();
        StringBuilder builder = new StringBuilder("Стена огня наносит урон ");
        boolean isSomebodyDamaged = false;
        while (iterator.hasNext()) {
            final Character targetCharacter = (Character) iterator.next();
            if (!targetCharacter.checkIsAlive()) {
                continue;
            }
            if (targetCharacter.getCurrentPosition() % 2 == 0) {
                targetCharacter.setCurrentHealth(targetCharacter.getCurrentHealth() - damage);
                builder.append(targetCharacter.getName()).append(", ").toString();
                isSomebodyDamaged = true;
            }
        }
        builder.delete(builder.length() - 2, builder.length() - 1);
        builder.append(System.getProperty("line.separator")).append("Все получают по ")
                .append(damage).append(" урона.");
        if (isSomebodyDamaged) {
            System.out.println(builder);
        }
    }

    @Override
    public String toString() {
        return "Стена огня";
    }
}


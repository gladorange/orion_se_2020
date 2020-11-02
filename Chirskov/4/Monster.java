import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Character {
    private int damage;
    public enum Names { Goblin, Ork, Ghoul}
    Monster(String name, int damage) {
        if (damage <= 0)
            damage = 1;
        this.damage = damage;
        super.name = name;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    void play(HashSet<Character> characters) {
        Character targetCharacter = (Character)characters.toArray()[ThreadLocalRandom.current().nextInt(0, characters.size())];
        if (!targetCharacter.checkIsAlive()) {
            return;
        }
        int currentHealth = targetCharacter.getCurrentHealth() - getDamage();
        targetCharacter.setCurrentHealth(currentHealth);
        System.out.println(this + " персонажу " + targetCharacter.getName());
    }

    @Override
    public String toString() {
        return "Монстр " + name + " наносит " + damage + " единиц урона";
    }

    public static class Goblin extends Monster {
        static final int GOBLIN_DAMAGE = 27;
        Goblin(String name) {
            super(name, GOBLIN_DAMAGE);
        }

        @Override
        public String toString() {
            return "Гоблин " + name + " наносит " + super.damage + " единиц урона";
        }
    }

    public static class Ork extends Monster {
        static final int ORK_DAMAGE = 30;
        Ork(String name) {
            super(name, ORK_DAMAGE);
        }

        @Override
        public String toString() {
            return "Орк " + name + " наносит " + super.damage + " единиц урона";
        }
    }

    public static class Ghoul extends Monster {
        static final int GHOUL_DAMAGE = 23;
        Ghoul(String name) {
            super(name, GHOUL_DAMAGE);
        }

        @Override
        public String toString() {
            return "Вурдалак " + name + " наносит " + super.damage + " единиц урона";
        }
    }

    public static Character getMonster(String name) {
        int monsterNumber = ThreadLocalRandom.current().nextInt(0, Monster.Names.values().length);
        Monster.Names monster = Monster.Names.values()[monsterNumber];
        switch (monster) {
            case Goblin:
                return new Goblin(name);
            case Ork:
                return new Ork(name);
            case Ghoul:
                return new Ghoul(name);
            default:
                System.out.println("Нет такого монстра, пусть будет Орк!");
                break;
        }
        return new Ork(name);
    }
}

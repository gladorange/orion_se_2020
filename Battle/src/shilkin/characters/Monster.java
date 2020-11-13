package shilkin.characters;

public class Monster extends Character{

    private final int damage;
    public Monster(String name, int health, int damage) {
        super(name, health);
        this.damage = damage;
    }

    @Override
    public void attack(Character character) {
        System.out.println("Монстр " + super.name + " атакует " + character.name + " и наносит " + damage + " урона");
    }
}

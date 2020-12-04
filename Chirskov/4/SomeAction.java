import java.util.ArrayList;


abstract class SomeAction {

    String actingCharacter;
    int damage;

    public void setActingCharacter(String actingCharacter) {
        this.actingCharacter = actingCharacter;
    }

    public String getActingCharacter() {
        return actingCharacter;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    String targetCharacter = "";
    public void setTargetCharacter(String targetCharacter) {
        this.targetCharacter += targetCharacter + " ";
    }

    public String getTargetCharacter() {
        return targetCharacter;
    }
}

class MonsterAction extends SomeAction {

}


class MageAction extends SomeAction {
    String spell;

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getSpell() {
        return spell;
    }
}
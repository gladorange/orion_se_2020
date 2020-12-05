import java.util.*;

public abstract class Character {
    @XmlIgnore
    static final int MAX_HEALTH = 100;
    @XmlIgnore
    private int currentHealth = MAX_HEALTH;

    public String name;
    @XmlIgnore
    private int currentPosition;
    @XmlIgnore
    private static ArrayList<String> randomNames = new ArrayList<>();
    public static ArrayList<String> getRandomNames() {
        if (randomNames.isEmpty()){
            generateRandomNames();
        }
        return randomNames;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    static void generateRandomNames() {
        randomNames.add("Clark Bell");
        randomNames.add("Orion Gill");
        randomNames.add("Gabriel White");
        randomNames.add("Jackson Kelly");
        randomNames.add("Regan Harper");
        randomNames.add("Wyatt Morris");
        randomNames.add("Jan Cox");
        randomNames.add("Orion Simpson");
        randomNames.add("Brayden Bell");
        randomNames.add("Troy Mitchell");
    }

    boolean checkIsAlive() {
        return getCurrentHealth() <= 0 ? false : true;
    }

    abstract void play(HashSet<Character> characters, SomeAction action);
}

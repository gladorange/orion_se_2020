package maxfomtaskeight;

public class Refrigerator extends ElectronicItem {
    int frostVolume;

    public Refrigerator(String name, int price, int powerUse, int frostVolume) {
        super(name, price, powerUse);
        this.frostVolume = frostVolume;
    }

    public int getFrostVolume() {
        return frostVolume;
    }
}

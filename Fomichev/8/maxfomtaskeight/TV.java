package maxfomtaskeight;

public class TV extends ElectronicItem {
    int volume;

    public TV(String name, int price, int powerUse, int volume) {
        super(name, price, powerUse);
        this.volume = volume;
    }
}

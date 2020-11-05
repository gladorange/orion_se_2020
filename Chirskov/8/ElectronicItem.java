import java.util.concurrent.ThreadLocalRandom;

abstract class ElectronicItem extends ShopItem {
    static final int MIN_POWER = 1;
    static final int MAX_POWER = 99;
    protected double power;
    ElectronicItem(String name) {
        super(name);
        power = ThreadLocalRandom.current().nextInt(MIN_POWER, MAX_POWER);
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public static class TV extends ElectronicItem {
        static final int MIN_VOLUME = 1;
        static final int MAX_VOLUME = 10;
        private int volume;
        TV(String name) {
            super(name);
            volume = ThreadLocalRandom.current().nextInt(MIN_VOLUME, MAX_VOLUME);
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        @Override
        public String toString() {
            return "Телевизор: " +
                    "мощность " + power +
                    ", громкость " + volume +
                    ", название " + name +
                    ", цена " + price;
        }
    }

    public static class Refrigerator extends ElectronicItem {
        static final int MIN_CAMERA_SIZE = 10;
        static final int MAX_CAMERA_SIZE = 100;
        private int cameraSize;
        Refrigerator(String name) {
            super(name);
            cameraSize = ThreadLocalRandom.current().nextInt(MIN_CAMERA_SIZE, MAX_CAMERA_SIZE);
        }

        public void setCameraSize(int cameraSize) {
            this.cameraSize = cameraSize;
        }

        @Override
        public String toString() {
            return "Холодильник: " +
                    "мощность " + power +
                    ", объем морозильной камеры " + cameraSize +
                    ", название " + name +
                    ", цена " + price;
        }
    }
}

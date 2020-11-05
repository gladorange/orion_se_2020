import java.util.concurrent.ThreadLocalRandom;

abstract class FoodItem extends ShopItem {
    protected int calorific;
    protected int days;
    FoodItem(String name, int calorific, int days) {
        super(name);
        this.calorific = calorific;
        this.days = days;
    }

    public void setCalorific(int calorific) {
        this.calorific = calorific;
    }

    public void setDays(int days) {
        this.days = days;
    }

    enum Color { RED, GREEN, YELLOW }
    public static class Apple extends FoodItem {
        static final int APPLE_CALORIFIC = 100;
        static final int APPLE_SHELF_LIFE = 45;
        private Color color;
        Apple(String name){
            super(name, APPLE_CALORIFIC, APPLE_SHELF_LIFE);
            color = Color.values()[ThreadLocalRandom.current().nextInt(0, Color.values().length)];
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Яблоко: " +
                    "калорийность " + calorific +
                    ", срок годности (в днях) " + days +
                    ", цвет " + color +
                    ", название " + name +
                    ", цена " + price;
        }
    }

    public static class Bread extends FoodItem {
        static final int BREAD_CALORIFIC = 3;
        static final int BREAD_SHELF_LIFE = 2;
        private int weight;
        Bread(String name, int weight) {
            super(name, weight * BREAD_CALORIFIC, BREAD_SHELF_LIFE);
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }


        @Override
        public String toString() {
            return "Хлеб " +
                    "калорийность " + calorific +
                    ", срок годности (в днях) " + days +
                    ", вес " + weight +
                    ", название " + name +
                    ", цена " + price;
        }
    }
}

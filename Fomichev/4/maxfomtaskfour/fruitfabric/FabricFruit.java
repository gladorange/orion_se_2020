package maxfomtaskfour.fruitfabric;

import java.util.Random;

public class FabricFruit {


    interface MakeFruit {
        Fruit create();
    }

    static class AppleFactory implements MakeFruit {
        @Override
        public Fruit create() {
            return new Apple();
        }
    }

    static class OrangeFactory implements MakeFruit {
        @Override
        public Fruit create() {
            return new Orange();
        }
    }

    static class PineappleFactory implements MakeFruit {
        @Override
        public Fruit create() {
            return new Pineapple();
        }
    }

    static class RandomFactory implements MakeFruit {
        MakeFruit[] factories;
        Random r = new Random();

        public RandomFactory(MakeFruit[] factories) {
            this.factories = factories;
        }

        @Override
        public Fruit create() {
            int ind = r.nextInt(factories.length);
            return factories[ind].create();
        }
    }


    public static void main(String[] args) {
        RandomFactory factory = new RandomFactory(new MakeFruit[]{
                new AppleFactory(),
                new OrangeFactory(),
                new PineappleFactory()
        });

        for (int i = 0; i < 10; i++) {
            Fruit fruit = factory.create();
            System.out.println(fruit);
        }
    }
}

package lesson4part3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[5];

        // создаю и заполняю фигуры
        for (int i = 0; i < figures.length; i++) {

            switch (new Random().nextInt(3)) {
                case 0:
                    figures[i] = new Circle(1+new Random().nextInt(100));
                    break;
                case 1:
                    figures[i] = new Square(1+new Random().nextInt(100));
                    break;
                case 2:
                    figures[i] = new IsoscelesTriangle(1+new Random().nextInt(50), 1+new Random().nextInt(50));
                    break;
            }

        }

        // вывожу фигуры

        for (int i = 0; i < figures.length; i++) {
            System.out.println(figures[i].getClass().getName()+" "+figures[i].square());
        }

    }
}

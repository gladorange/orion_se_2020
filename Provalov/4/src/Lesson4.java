import SequentialRandom.SequentialRandom;
import Fruit.*;
import Figure.*;

import java.io.IOException;

public class Lesson4 {
    public static Fruit getRandomFruit(){
        return switch (AvailableFruits.getRandomAvailableFruit()) {
            case APPLE -> new Apple();
            case ORANGE -> new Orange();
            case PINEAPPLE -> new Pineapple();
        };
    }

    public static void main(String[] args) throws IOException {
//    Задание 4-1. Случайности - не случайны
        SequentialRandom a = new SequentialRandom();
        System.out.println(""+a.getValue());
        SequentialRandom b = new SequentialRandom();
        System.out.println(""+b.getValue());
        SequentialRandom c = new SequentialRandom();
        System.out.println(""+c.getValue());
        SequentialRandom.resetRandom();
        SequentialRandom d = new SequentialRandom();
        System.out.println(""+d.getValue());
        SequentialRandom e = new SequentialRandom();
        System.out.println(""+e.getValue());
        System.out.println("");
//    Задание 4-2. Фруктовая неоднозначность
        Fruit[] fruits = new Fruit[4];
        for (int i = 0; i < fruits.length; i++){
            fruits[i] = getRandomFruit();
        }
        for (Fruit fruit :fruits) {
            System.out.println(fruit.toString());
        }
        System.out.println("");
//    Задание 4-3. Абстрактный супрематизм
        Figure[] figures = { new Circle(4.5f), new Square(2.3f), new IsoscelesTriangle(2,4), new Circle(5), new Square(7)};
        for (Figure figure : figures) {
            System.out.println(figure.toString());
        }

    }

//    Задание 4-3. Абстрактный супрематизм
//
//    Создать класс Figure, описывающий фигуру на двумерной плоскости с декартовыми координатами центра x,y.
//    В классе объявить метод square, который вычисляет площадь фигуры. В самом классе Figure метод ничего не делает, поведение определяется в классе-наследниках.
//    В классе объявить и реализовать метод getQuadrant(), который возвращает четверть на координатной плоскости, в которой лежит центр фигуры.
//    Для описания четверти используйте int с четырьями значениями: 1,2,3,4. Если четверть определить не удалось - верните -1.
//
//    Создать классы-наследники:
//    Circle - дополнительный параметр радиус, от 1 до 10
//    Square - дополнительный параметр - длина стороны,от 1 до 10.
//    IsoscelesTriangle - дополнительные параметры высота и основание, от 1 до 10.
//
//    В каждом классе определить метод square, чтобы он правильно считал площадь.
//
//    в main'e создать массив на 5 элементов типа Figure, заполните любыми фигурами (не обязательно случайными), выведите все фигуры в формате
//            "Название фигуры - площадь"
}

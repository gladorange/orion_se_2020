package ru.localcat;

import ru.localcat.i1.SequentialRandom;
import ru.localcat.i2.FruitImpl;
import ru.localcat.i2.RandomFruit;
import ru.localcat.i3.Circle;
import ru.localcat.i3.Figure;
import ru.localcat.i3.IsoscelesTriangle;
import ru.localcat.i3.Square;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        //issue 1

        System.out.println(" _______ issue 1 ____________");

        System.out.println(new SequentialRandom().getValue());
        System.out.println(new SequentialRandom().getValue());
        System.out.println(new SequentialRandom().getValue());
        SequentialRandom.resetRandom();
        System.out.println(new SequentialRandom().getValue());
        System.out.println(new SequentialRandom().getValue());


        //issue 2

        System.out.println(" _______ issue 2 ____________");

        FruitImpl[] fructs = new FruitImpl[4];

        for (int i = 0; i < fructs.length; i++) {
            fructs[i] = RandomFruit.getRandomFruit();
            System.out.println(fructs[i]);
        }

        //issue 3

        System.out.println(" _______ issue 3 ____________");

        ArrayList<Figure> figures = new ArrayList<>(5);

        figures.add(new Circle().setRadius(5));
        figures.add(new Square().setHeight(5).setWidth(3));
        figures.add(new IsoscelesTriangle().setBase(3).setHeight(2));
        figures.add(new Circle().setRadius(7));
        figures.add(new Square().setWidth(6).setHeight(8));

        for (Figure figure : figures) {
            System.out.println(figure.getFigureName() + " - " + figure.square());
        }


    }
}

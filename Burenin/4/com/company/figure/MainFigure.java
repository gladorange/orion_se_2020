package com.company.figure;

public class MainFigure {

    public static void main(String[] args) {
        Figure[] figures = {
                new Figure.Square(),
                new Figure.Circle(),
                new Figure.IsoscelesTriangle(),
                new Figure.Square(),
                new Figure.IsoscelesTriangle()
        };

        for (Figure figure : figures) {
            figure.square();
        }
    }
}

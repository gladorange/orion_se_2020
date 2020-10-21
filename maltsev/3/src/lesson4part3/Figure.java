package lesson4part3;

public class Figure {
    private double x;
    private double y;

    double square(){
        // площадь фигуры
        return 0;
    }

    int getQuadrant(){
        if ((x>0) && (y>0)) {return 1;}
        if ((x<0) && (y>0)) {return 2;}
        if ((x<0) && (y<0)) {return 3;}
        if ((x>0) && (y<0)) {return 4;}
        return -1;
    }

}

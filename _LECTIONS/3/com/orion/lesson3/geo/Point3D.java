package com.orion.lesson3.geo;


import static com.orion.lesson3.Point.*;

import com.orion.lesson3.Point;

public class Point3D extends com.orion.lesson3.point.Point {


    public Point3D() {
        Point anotherPoint = new Point();
        x = DEFAULT_X;
        printHello();
    }

    public static void main(String[] args) {
        var point3 = new Point3D();
    //    System.out.println(point3);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

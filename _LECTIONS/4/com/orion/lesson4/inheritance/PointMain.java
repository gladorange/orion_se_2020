package com.orion.lesson4.inheritance;

public class PointMain {

    public static void main(String[] args) {

        Point point = new Point3D(1,2,3);


        /*point.x = 42; не работает - поля приватные
        point.y = 12; не работает - поля приватные
        point.z = 42;  не работает - z не определен в Point

        */
        //System.out.println(point);
        point.printInfo();

        Point point2 = point.copy();

        if (point2 instanceof Point3D) {
            final int z = ((Point3D) point2).z;
        }


        if (point.getClass() == Point.class) {
            System.out.println("Точно двумерная точка");
        } else {
            System.out.println("Точно не двумерная точка");
        }


        Object someObject = new Point3D(1,2,3);


        if (someObject instanceof  Point) {
            ((Point3D) someObject).printInfo();
        }



    }
}

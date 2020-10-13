package com.orion.lesson3.point;

public class Point {
    protected int x;
    protected int y;
    protected int z;

    public Point() {
        this(42, 42);
    }

    {
        System.out.println("блок до конструктора");
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Конструктор,z=" + z);
    }

    {
        System.out.println("блок после конструктора");
        z = 42;
    }


    public static void main(String[] args) {
        Point p = new Point();
    }

    public Point(Point another) {
        this.x = another.x;
        this.y = another.y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

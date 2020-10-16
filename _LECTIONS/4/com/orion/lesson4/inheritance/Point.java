package com.orion.lesson4.inheritance;

public class Point {
   protected int x;
   private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    void printInfo() {
        System.out.println(String.format("Я точка с координатами %s, %s\n", x, y));
    }


    Point copy() {
        return new Point(x, y);
    }
}

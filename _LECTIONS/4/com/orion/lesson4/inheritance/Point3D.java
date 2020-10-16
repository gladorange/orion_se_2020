package com.orion.lesson4.inheritance;

public class Point3D extends Point {
    int z;



    public Point3D(int x, int y, int z) {
        //super();
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }


    @Override
    void printInfo() {
        //super.printInfo();

        System.out.printf("Я точка с координатами %s,%s,%s",getX(),getY(), z);
    }

    @Override
    Point3D copy() {
        return new Point3D(getX(),getY(),z);
    }
}

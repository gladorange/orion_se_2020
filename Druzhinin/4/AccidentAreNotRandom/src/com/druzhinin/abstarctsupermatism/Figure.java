package com.druzhinin.abstarctsupermatism;

class Center {
    public int x;
    public int y;

    public Center(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public abstract class Figure {

    private int H_RESOLUTION = 1920;
    private int V_RESOLUTION = 1080;

    public Figure(int x, int y) {
        center = new Center(x, y);
    }

    public int getQuadrant() {
        if (center.x > 0 & center.x < H_RESOLUTION / 2) {
            if (center.y > 0 & center.y <= V_RESOLUTION / 2) {
                return 1;
            }
            else if (center.y > V_RESOLUTION / 2 & center.y <= V_RESOLUTION) {
                return 2;
            }
        }
        else if (center.x >= H_RESOLUTION /2 & center.x <= H_RESOLUTION) {
            if (center.y > 0 & center.y <= V_RESOLUTION / 2) {
                return 3;
            }
            else if (center.y >= V_RESOLUTION / 2 & center.y <= V_RESOLUTION) {
                return 4;
            }
        }
        return -1;
    }

    public void setCenter(int x, int y) {
        center.x = x;
        center.y = y;
    }

    int getCenterX() {
        return center.x;
    }

    int getCenterY() {
        return center.y;
    }

    public void square() {
    }

    private Center center;
}

package shilkin;

public class Figure {
    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected final int x;
    protected final int y;

    protected int getSquare(){
        return 0;
    }

    public int getQuadrant(){
        if (x > 0 && y > 0){
            return 1;
        }else if(x < 0 && y > 0){
            return 2;
        }else if(x < 0 && y < 0){
            return 3;
        }else if(x > 0 && y < 0){
            return 4;
        }
        return -1;
    }
}

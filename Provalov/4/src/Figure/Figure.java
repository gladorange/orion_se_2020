package Figure;

public abstract class Figure {

    private int x,y;

    abstract float square();

    private int getQuadrant(){
        if (x > 0 && y > 0) {
            return 1;
        }else if (x > 0 && y < 0) {
            return 2;
        }else if (x < 0 && y < 0){
            return 3;
        }else if (x < 0 && y > 0) {
            return 4;
        } else
            return -1;
    }
}

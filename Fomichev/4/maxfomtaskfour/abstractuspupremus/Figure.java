package maxfomtaskfour.abstractuspupremus;

abstract class Figure {
    public int x;
    public int y;

    abstract int square();

    public int getQuadrant() {
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

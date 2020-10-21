package lesson4part3;

public class IsoscelesTriangle extends Figure{
    private int height;
    private int width;

    public IsoscelesTriangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    double square(){
        return height*width*1/2;
    }
}

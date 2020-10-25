package lesson4part3;

public class Circle extends Figure{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double square(){
        return Math.PI*radius*radius;
    }

}

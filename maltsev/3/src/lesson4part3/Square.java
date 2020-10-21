package lesson4part3;

public class Square extends Figure{
    private double len;

    public Square(double len) {
        this.len = len;
    }

    @Override
    double square(){
        return len*len;
    }

}

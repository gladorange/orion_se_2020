package Figure;

import java.io.IOException;

public class Square extends Figure {
    private float length;

    public void setLength(float length) throws IOException {
        if (length > 0 && length <= 10) {
            this.length = length;
        }else{
            throw new IOException("Длина стороны квадрата может быть только (0;10]");
        }

    }

    public Square(float length) throws IOException{
        this.setLength(length);
    }

    @Override
    float square() {
        return length * length;
    }

    @Override
    public String toString() {
        return "Квадрат - "+this.square();
    }
}

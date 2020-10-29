package Figure;

import java.io.IOException;

public class IsoscelesTriangle extends Figure {
    private float high;
    private float baseLength;

    public void setHigh(float high) throws IOException {
        if (high > 0 && high <= 10 ) {
            this.high = high;
        }else{
            throw new IOException("Высота треугольника может принимать значение (0;10]");
        }
    }

    public void setBaseLength(float baseLength) throws IOException {
        if (baseLength>0 && baseLength <= 10 ) {
            this.baseLength = baseLength;
        }else{
            throw new IOException("Основание равнобедренного треугольника может принимать значение (0;10]");
        }
    }

    public IsoscelesTriangle(float high, float baseLength) throws IOException{
        this.setHigh(high);
        this.setBaseLength(baseLength);
    }

    @Override
    float square() {
        return (float)(0.5 * high * baseLength);
    }

    @Override
    public String toString() {
        return "Равнобедренный треугольник - "+this.square();
    }
}

package Figure;

import java.io.IOException;

public class Circle extends Figure {
    private float radius;

    public Circle(float radius) throws IOException {
        this.setRadius(radius);
    }

    public void setRadius(float radius) throws IOException {
        if (radius > 0 && radius <= 10) {
            this.radius = radius;
        }else{
            throw new IOException("Радиус круга может быть только (0;10]");
        }
    }

    @Override
    float square() {
        return (float) (Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return "Круг - "+this.square();
    }
}

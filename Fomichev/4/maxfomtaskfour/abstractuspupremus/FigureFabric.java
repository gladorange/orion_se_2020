package maxfomtaskfour.abstractuspupremus;

public class FigureFabric {

    public static void main(String[] args) {
        Figure[] figures = {new Circle(), new Square(), new IsoscelesTriangle(), new Circle(), new Square(), new IsoscelesTriangle()};
        for (Figure figure : figures) {
            System.out.println(figure);
        }
    }
}

package Taask_4;

class IsoscelesTriangle extends Figure {
    int height;
    int base;

    public IsoscelesTriangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    @Override
    String square() {
        return  String.format("IsoscelesTriangle - %s", (height * base) / 2);
    }
}

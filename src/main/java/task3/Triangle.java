package task3;

class Triangle extends Figure {

    int sideA;
    int base;
    int height;

    public Triangle(int x, int y, int sideA, int base, int height) {
        super(x, y);
        this.sideA = sideA;
        this.base = base;
        this.height = height;
    }

    @Override
    public double getSquare() {
        return base * height / 2;
    }
}

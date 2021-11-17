package task3;

class Circle extends Figure {

    int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return radius * radius * 3.14;
    }
}

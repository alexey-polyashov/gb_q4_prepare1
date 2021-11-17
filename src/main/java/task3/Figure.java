package task3;

abstract public class Figure {

    private int x;
    private int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    abstract public double getSquare();

}

class Square extends Figure{

    int sideLong;

    public Square(int x, int y, int sideLong) {
        super(x, y);
        this.sideLong = sideLong;
    }

    @Override
    public double getSquare() {
        return sideLong*sideLong;
    }
}

class Triangle extends Figure{

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
        return base*height/2;
    }
}

class Circle extends Figure{

    int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return radius*radius*3.14;
    }
}

class Main{

    public static double calcSquare(Figure f){
        return f.getSquare();
    }

    public static void main(String[] args) {

        Figure s = new Square(1,1,3);
        Figure c = new Circle(1,1,3);
        Figure t = new Triangle(1,1,3, 2, 3);

        System.out.println("Square - " + calcSquare(s));
        System.out.println("Circle - " + calcSquare(c));
        System.out.println("Triangle - " + calcSquare(t));

    }
}


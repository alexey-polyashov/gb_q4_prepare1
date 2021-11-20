package task3;

class Main {

    public static double calcSquare(Figure f) {
        return f.getSquare();
    }

    public static void main(String[] args) {

        Figure s = new Square(1, 1, 3);
        Figure c = new Circle(1, 1, 3);
        Figure t = new Triangle(1, 1, 3, 2, 3);

        System.out.println("Square - " + calcSquare(s));
        System.out.println("Circle - " + calcSquare(c));
        System.out.println("Triangle - " + calcSquare(t));

    }
}

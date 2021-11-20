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


package task3;

class Square extends Figure {

    int sideLong;

    public Square(int x, int y, int sideLong) {
        super(x, y);
        this.sideLong = sideLong;
    }

    @Override
    public double getSquare() {
        return sideLong * sideLong;
    }
}



public sealed abstract class Figure permits Triangle, Rectangle, Circle {
    protected double x, y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();




    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

public sealed abstract class Figure permits Triangle, Rectangle, Circle {
    protected double x, y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    //TODO toString?

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //TODO avoid letting useless black spaces inside the classes. Use a single blank line between contexts and only that.
}

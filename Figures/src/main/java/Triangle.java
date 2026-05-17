public final class Triangle extends Figure {
    private double a, b, c;


    public Triangle(double x, double y, double a, double b, double c) {

        super(x, y);
        if (validTriangle(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;

        }
    }

    private boolean validTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;
        return (a + b > c && a + c > b && b + c > a);
    }

    @Override
    public double area() {
        double s = ((a + b + c) / 2);
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

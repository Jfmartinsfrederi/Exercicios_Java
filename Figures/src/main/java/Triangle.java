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

    //TODO IntelliJ tip: after finishing a class, use Code > Reformat Code (Ctrl + Alt + l) to make the code organized
}

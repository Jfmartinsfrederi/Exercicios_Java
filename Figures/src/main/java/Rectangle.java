public final class Rectangle extends Figure{
    private double a,b;

    public Rectangle(double x, double y, double a, double b) {
        super(x, y);
        if (a>0 && b>0){
            this.a = a;
            this.b = b;

        }
    }


    @Override
    public double area(){
        return a*b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

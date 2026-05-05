public final class Circle extends Figure {
    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        if (radius>0) {
            this.radius = radius;

        }
    }

    public double circumference(){
        return Math.PI*2*radius;
    }


    @Override
    public double area(){
        return Math.PI*Math.pow(radius,2);
    }

}

public class Main {
    public static void main(String[] args) {

        Figure[] figuras = new Figure[150];
        int index = 0;

        for (int i = 0; i < 50; i++) {
            figuras[index++] = new Triangle(i+1, i+1, i+3, i+4, i+5);
            figuras[index++] = new Circle(i+2, i+2, i+1);
            figuras[index++] = new Rectangle(i+3, i+3, i+5, i+1);
        }

        double sum = 0;

        for (Figure f : figuras) {
            sum += f.area();
            System.out.println(f);
        }

        System.out.println("Soma total: " + sum);
    }
}
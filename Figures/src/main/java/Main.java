public class Main {
    static void main(String[] args) {

        Figure[] figuras = new Figure[150];
        int index = 0;

        for (int i = 0; i < 50; i++) {
            figuras[index++] = new Triangle(i + 1, i + 1, i + 1, i + 1, i + 1);
            figuras[index++] = new Circle(i + 2, i + 2, i + 1);
            figuras[index] = new Rectangle(i + 2, i + 2, i + 1, i + 1); // TODO index++ here is a bug.
        }

        double sum = 0;
        for (Figure f : figuras) {
            sum += f.area();
            //TODO toString the figures here to check if everything is ok.
        }

        System.out.println("Soma total: " + sum);
    }
}
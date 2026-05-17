public class Main {
    static void main(String[] args) {
        Zoo zoo=new Zoo();

        Animal owl1=new Owl("Owl");
        Animal wolf=new Wolf("Wolf");
        Animal lion=new Lion("Lion");
        Animal bird=new Bird("Brid");

        zoo.addAnimal(owl1);
        zoo.addAnimal(lion);
        zoo.addAnimal(wolf);
        zoo.addAnimal(owl1);
        zoo.addAnimal(wolf);
        zoo.addAnimal(bird);
        zoo.addAnimal(lion);

        zoo.animalAction();

    }
}

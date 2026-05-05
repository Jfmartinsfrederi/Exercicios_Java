public class Main {
    static void main(String[] args) {
        //TODO Clean code tip: add a blank line everytime you change the context (it makes clear to read the code).
        Zoo zoo = new Zoo();

        Animal owl1 = new Owl("Owl"); // TODO clean code tip: add blank spaces around operators, to make it clear to see.
        Animal wolf = new Wolf("Wolf");
        Animal lion = new Lion("Lion");
        Animal bird = new Bird("Brid");

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

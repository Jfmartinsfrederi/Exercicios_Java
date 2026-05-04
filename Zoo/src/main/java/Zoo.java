public class Zoo {
    private Animal[] cages; // TODO it is safer to make it final, as IntelliJ suggests.
    private int numCages;

    public Zoo() {
        this.cages = new Animal[10];
        this.numCages = 0;
    }

    public void animalAction() {
        for (Animal animal : cages) {
            if (animal == null) return;

            animal.makeSound();
//            if (animal instanceof RunnableAnimal) {
//                ((RunnableAnimal) animal).run();
//            }

            //TODO it is simpler and modern to use Pattern Matching, as follows:
            if(animal instanceof RunnableAnimal runner)
                runner.run();

        }
    }

    public void addAnimal(Animal animal) {
        cages[numCages++] = animal;
    }

}

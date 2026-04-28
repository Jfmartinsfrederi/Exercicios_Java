public class Zoo {
    private Animal[] cages;
    private int numCages;

    public Zoo() {

        this.cages = new Animal[10];
        this.numCages=0;
    }

    public void animalAction() {
        for (Animal cage : cages) {
            if (cage==null) return;
            cage.makeSound();
            if (cage instanceof RunnableAnimal){
                ((RunnableAnimal)cage).run();
            }

        }
    }

    public void addAnimal(Animal animal){
        cages[numCages++]=animal;
    }

}

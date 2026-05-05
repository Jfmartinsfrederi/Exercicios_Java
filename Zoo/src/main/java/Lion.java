public class Lion extends Animal implements RunnableAnimal{

    public Lion(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Lion makes:Rwarraar!");

    }

    @Override
    public void run() {
        System.out.println("Lion is Running");
    }
}

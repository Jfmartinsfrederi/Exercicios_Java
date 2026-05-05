public class Wolf extends Animal implements RunnableAnimal{
    public Wolf(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Wolf makes: Auuuuu!");
    }

    public void run(){
        System.out.println("Wolf is running");
    }

}

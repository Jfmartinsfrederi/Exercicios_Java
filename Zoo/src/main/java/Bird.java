public class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Bird makes:Piu Piu!");
    }
}

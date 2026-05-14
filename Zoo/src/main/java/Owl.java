public class Owl extends Animal{
    public Owl(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
    System.out.println("Owl makes: Pruu Pruu!");
    }
    @Override
    public String toString() {
        return "A Owl named %s".formatted(getName());
    }
}

public class Bird extends Animal{

    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Bird makes: Piu Piu!");
    }

    //TODO add toString with something like "A bird named Reginaldo Rossi".
}

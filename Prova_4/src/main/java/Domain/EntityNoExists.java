package Domain;

public class EntityNoExists extends RuntimeException {
    public EntityNoExists(String message) {
        super(message);
    }
}

package game;

public enum GameEvent {

    TAKE_DAMAGE("Take damage"),
    TAKE_MUSHROOM("Take a mushroom"),
    TAKE_FLOWER("Take a flower"),
    TAKE_FEATHER("Take a feather");

    private final String description;

    GameEvent(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

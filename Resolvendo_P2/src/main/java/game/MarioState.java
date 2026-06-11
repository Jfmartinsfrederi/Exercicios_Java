package game;

public sealed interface MarioState permits Small,Dead,Big,Fire,Cape {
    void takeFlower();

    void takeFeather();

    void takeMushroom();

    void takeDamage();
}

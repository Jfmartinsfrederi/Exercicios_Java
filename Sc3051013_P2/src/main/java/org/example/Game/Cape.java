package org.example.Game;

public class Cape implements MarioState {
    private MarioGame mario;
    private MarioState big;
    private MarioState cape;
    private MarioState dead;
    private MarioState small;
    private MarioState fire;


    public Cape(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.nextState(fire, "Take Flower");

    }

    @Override
    public void takeFeather() {
        mario.incrementScore("Take Feather");

    }

    @Override
    public void takeMushroom() {
        mario.incrementScore("Take Mushroom");

    }

    @Override
    public void takeDamage() {
        mario.nextState(big, "Take Damage");

    }
}

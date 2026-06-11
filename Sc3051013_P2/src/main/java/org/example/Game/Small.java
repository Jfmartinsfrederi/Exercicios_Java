package org.example.Game;

public class Small implements MarioState {
    private MarioGame mario;
    private MarioState big;
    private MarioState cape;
    private MarioState dead;
    private MarioState fire;

    public Small(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.nextState(fire, "Take Flower");

    }

    @Override
    public void takeFeather() {
        mario.nextState(cape, "Take Feather");

    }

    @Override
    public void takeMushroom() {
        mario.nextState(big, "Take Mushroom");

    }

    @Override
    public void takeDamage() {
        mario.nextState(dead, "Take Damage");

    }
}

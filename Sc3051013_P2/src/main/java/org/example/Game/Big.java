package org.example.Game;

public class Big implements MarioState {
    private MarioGame mario;
    private MarioState big;
    private MarioState cape;
    private MarioState dead;
    private MarioState small;
    private MarioState fire;

    public Big(MarioGame mario) {
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
        mario.incrementScore("Take Mushroom");

    }

    @Override
    public void takeDamage() {
        mario.nextState(small, "Take Damage");

    }
}

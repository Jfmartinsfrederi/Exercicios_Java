package org.example.Game;

public class Fire implements MarioState {
    private MarioGame mario;
    private MarioState big;
    private MarioState cape;
    private MarioState dead;
    private MarioState small;
    private MarioState fire;

    public Fire(MarioGame mario) {
        this.mario = mario;
    }


    @Override
    public void takeFlower() {
        mario.incrementScore("Take Flower");

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
        mario.nextState(big, "Take Damage");

    }
}

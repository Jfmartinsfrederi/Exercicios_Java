package org.example.Game;

import java.time.LocalDateTime;
import java.util.Random;

public class MarioGame {
    private int score;
    private MarioState state;
    private MarioState nextState;
    private StringBuilder stringBuilder = new StringBuilder();

    public MarioGame() {

        this.score = 0;


    }

    public void takeMysteryBox() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0: {
                takeDamage();

            }
            case 1: {
                takeFeather();
            }
            case 2: {
                takeFlower();
            }
            case 3: {
                takeMushroom();
            }
        }

    }

    public void takeFlower() {
        state.takeFlower();


    }


    public void takeFeather() {
        state.takeFeather();


    }


    public void takeMushroom() {
        state.takeMushroom();


    }


    public void takeDamage() {
        state.takeDamage();

    }

    public void nextState(MarioState next, String event) {
        stringBuilder.append(LocalDateTime.now()).append("Take").append(event)
                .append(state).append(next).append(score);
        state = next;


    }

    public void incrementScore(String event) {
        score += 1000;
        stringBuilder.append(LocalDateTime.now()).append("Take").append(event)
                .append(state).append(state).append(score);

    }

    public void register() {

    }

    public boolean isDone() {
        return true;
    }

    public int getScore() {
        return score;
    }

    public MarioState getState() {
        return state;
    }


    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}

package org.example.Game;

public class Dead implements MarioState {
    @Override
    public void takeFlower() {
        throw new GameRuleViolationException("Voce morreu não pode mais jogar!");


    }

    @Override
    public void takeFeather() {

        throw new GameRuleViolationException("Voce morreu não pode mais jogar!");

    }

    @Override
    public void takeMushroom() {

        throw new GameRuleViolationException("Voce morreu não pode mais jogar!");

    }

    @Override
    public void takeDamage() {

        throw new GameRuleViolationException("Voce morreu não pode mais jogar!");

    }
}

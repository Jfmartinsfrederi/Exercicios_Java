package game;

public final class Dead implements MarioState {

    @Override
    public void takeFlower() {
        throw new GameRuleViolationException("Mario is dead!");
    }

    @Override
    public void takeFeather() {
        throw new GameRuleViolationException("Mario is dead!");

    }

    @Override
    public void takeMushroom() {
        throw new GameRuleViolationException("Mario is dead!");
    }

    @Override
    public void takeDamage() {
        throw new GameRuleViolationException("Mario is dead!");
    }
}

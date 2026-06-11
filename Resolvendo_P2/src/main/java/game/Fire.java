package game;

public  final class Fire implements MarioState{
    MarioGame mario;

    Fire(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.incrementScore(GameEvent.TAKE_FLOWER);


    }

    @Override
    public void takeFeather() {
        mario.nextState(new Cape(mario),GameEvent.TAKE_FEATHER);

    }

    @Override
    public void takeMushroom() {
        mario.incrementScore(GameEvent.TAKE_MUSHROOM);
    }

    @Override
    public void takeDamage() {
        mario.nextState(new Big(mario),GameEvent.TAKE_DAMAGE);

    }
}

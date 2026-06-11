package game;

public  final class Cape implements MarioState{
    MarioGame mario;

    Cape(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.nextState(new Fire(mario),GameEvent.TAKE_FLOWER);


    }

    @Override
    public void takeFeather() {
        mario.incrementScore(GameEvent.TAKE_FEATHER);

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

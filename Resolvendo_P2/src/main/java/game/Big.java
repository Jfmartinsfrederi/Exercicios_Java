package game;

public  final class Big implements MarioState{
    MarioGame mario;

    Big(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.nextState(new Fire(mario),GameEvent.TAKE_FLOWER);


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
        mario.nextState(new Small(mario),GameEvent.TAKE_DAMAGE);

    }
}

package game;

public  final class Small implements MarioState{
    MarioGame mario;

    Small(MarioGame mario) {
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
        mario.nextState(new Big(mario),GameEvent.TAKE_MUSHROOM);

    }

    @Override
    public void takeDamage() {
        mario.nextState(new Dead(),GameEvent.TAKE_DAMAGE);

    }
}

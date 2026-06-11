package game;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class MarioGame {
    private int score;
    private MarioState state;
    private List<String> logs;

    public MarioGame() {
        this.score = 0;
        this.state = new Small(this);
        this.logs = new ArrayList<>();
    }

    public void takeMysteryBox(){
        Random random= new Random();
        switch (random.nextInt(4)){
            case 0-> takeDamage();
            case 1-> takeFeather();
            case 2-> takeFlower();
            case 3-> takeMushroom();
        }


    }



    public void takeFlower(){
        state.takeFlower();
    }

    public void takeFeather(){
        state.takeFeather();
    }

    public void takeMushroom(){
        state.takeMushroom();
    }

    public void takeDamage(){
        state.takeDamage();
    }

    public void nextState(MarioState next,GameEvent gameEvent){
        register(next,gameEvent);

        state=next;
    }

    public void incrementScore(GameEvent gameEvent){
        score+=1000;
        register(state,gameEvent);
    }

    private void register(MarioState next,GameEvent gameEvent){
        String log= """ 
                [%s] %s | %s=>%s | Score=%d
                """.formatted(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy <hh>:<mm>:<ss>")),
                gameEvent.getDescription(),
                state.getClass().getSimpleName(),
                next.getClass().getSimpleName(),score);
        logs.add(log);

    }

    public boolean isDone(){
        return state instanceof Dead;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner=new StringJoiner(" ");
        for (String log : logs) {
            stringJoiner.add(log);
        }
        return stringJoiner.toString();
    }

    public int getScore() {
        return score;
    }
}

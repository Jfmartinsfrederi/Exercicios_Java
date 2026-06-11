package main;

import game.MarioGame;
import player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("p1"));
        players.add(new Player("p2"));
        players.add(new Player("p3"));
        players.add(new Player("p4"));
        players.add(new Player("p5"));

        for (Player player : players) {
            MarioGame marioGame = new MarioGame();

            for (int i = 0; i < 10 && !marioGame.isDone(); i++) {
                marioGame.takeMysteryBox();
                // para testar a variação de tempo coloque o codigo aqui
            }
            System.out.println(marioGame);
            player.addScore(marioGame.getScore());

        }
        players.sort(Collections.reverseOrder());
        System.out.println("Hall da Fama:");
        for (Player player : players) {
            System.out.println(player);
        }

    }
}

/*try {
     TimeUnit.MILLISECONDS.sleep(500);
      } catch (InterruptedException e) {
      throw new RuntimeException(e);
}*/

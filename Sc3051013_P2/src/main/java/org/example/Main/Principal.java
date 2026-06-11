package org.example.Main;

import org.example.Game.*;
import org.example.Player.Player;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args) {
        MarioGame gameMario = new MarioGame();
        MarioState big = new Big(gameMario);
        MarioState dead = new Dead();
        MarioState small = new Small(gameMario);
        MarioState cape = new Cape(gameMario);
        MarioState fire = new Fire(gameMario);


        Player player1 = new Player("p1");
        Player player2 = new Player("p2");
        Player player3 = new Player("p3");
        Player player4 = new Player("p4");
        Player player5 = new Player("p5");

        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        playerList.add(player5);
        for (Player player : playerList) {
            for (int i = 0; i < 10; i++) {
                gameMario.takeMysteryBox();

            }
            player.addScore(gameMario.getScore());

        }
        System.out.println("Hall da fama:");
        player1.compateTo(player2);
        player2.compateTo(player3);
        player3.compateTo(player4);
        player4.compateTo(player5);
        player5.compateTo(player1);


    }
}

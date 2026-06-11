package app;

import dao.PlayerDAO;
import model.Player;
import model.Team;
import perisistence.DataBaseInitializer;

public class Main {
    public static void main(String[] args) {
        DataBaseInitializer dataBaseInitializer=new DataBaseInitializer();
        dataBaseInitializer.initialize();

        PlayerDAO playerDAO=new PlayerDAO();

        Team team=new Team("America","Rússia","César",playerDAO);

        Player p1 = new Player("Kratos", 1, "GOL");
        Player p2 = new Player("Atreus", 2, "LAT");
        Player p3 = new Player("Thor", 3, "ZAG");
        Player p4 = new Player("Odin", 4, "ZAG");
        Player p5 = new Player("Freya", 5, "VOL");
        Player p6 = new Player("Brok", 6, "VOL");
        Player p7 = new Player("Sindri", 7, "MEI");
        Player p8 = new Player("Mimir", 8, "MEI");
        Player p9 = new Player("Baldur", 9, "ATA");
        Player p10 = new Player("Tyr", 10, "ATA");
        Player p11 = new Player("Heimdall", 11, "ATA");

        Player p12 = new Player("Zeus", 12, "GOL");
        Player p13 = new Player("Poseidon", 13, "LAT");
        Player p14 = new Player("Hades", 14, "ZAG");
        Player p15 = new Player("Hermes", 15, "VOL");
        Player p16 = new Player("Ares", 16, "MEI");
        Player p17 = new Player("Apollo", 17, "ATA");
        Player p18 = new Player("Cronos", 18, "ATA");


        team.addPlayer(p1);
        team.addPlayer(p2);
        team.addPlayer(p3);
        team.addPlayer(p4);
        team.addPlayer(p5);
        team.addPlayer(p6);
        team.addPlayer(p7);
        team.addPlayer(p8);
        team.addPlayer(p9);
        team.addPlayer(p10);
        team.addPlayer(p11);
        team.addPlayer(p12);
        team.addPlayer(p13);
        team.addPlayer(p14);
        team.addPlayer(p15);
        team.addPlayer(p16);
        team.addPlayer(p17);
        team.addPlayer(p18);

        team.updatePlayersMap();

        System.out.println("Titulares:");
        team.getFieldedPlayers().forEach(System.out::println);

        System.out.println("\nReservas:");
        team.getOutFieldedPlayers().forEach(System.out::println);

        // Teste de remoção
        team.removePlayer(p4);

        // Teste de substituição
        team.substitute(p1, p15);


        System.out.println("Titulares:");
        team.getFieldedPlayers().forEach(System.out::println);

        System.out.println("\nReservas:");
        team.getOutFieldedPlayers().forEach(System.out::println);

    }
}


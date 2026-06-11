package perisistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseInitializer {
    String players= """
            CREATE TABLE IF NOT EXISTS players (
                 name TEXT NOT NULL,
                 number INT NOT NULL,
                 position TEXT NOT NULL,
                 isFielded BOOLEAN,
                 team TEXT NOT NULL,
                 FOREIGN KEY (team) REFERENCES teams(name)
             )
            """;
    String teams= """ 
            CREATE TABLE IF NOT EXISTS teams (
            name TEXT NOT NULL,
            baseLocation TEXT NOT NULL,
            coachName TEXT NOT NULL,
            idCaptain int NOT NULL
            )
            """;
    String addConstraint= """
            ALTER TABLE players ADD CONSTRAINT
                FOREIGN KEY (team) REFERENCES TEAMS(name)
            """;
    public void initialize(){
        try (PreparedStatement statementPlayers=ConnectionFactory.getPreparedStatement(players);
        PreparedStatement statementTeams=ConnectionFactory.getPreparedStatement(teams)
        ){

            statementTeams.execute();
            statementPlayers.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

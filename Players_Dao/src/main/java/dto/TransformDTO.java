package dto;

import dao.InterfacePlayerDAO;
import model.Player;
import model.Team;

public class TransformDTO {
    public static PlayerDTO toDTO(Player player){
        return new PlayerDTO(player.getName(), player.getNumber(), player.getPosition(), player.isFielded());
    }

    public static Player fromDTO(PlayerDTO player){
        return new Player(player.name(), player.number(), player.postion(), player.isFIelded());
    }

    public static TeamDTO toDTO(Team team){
        return new TeamDTO(team.getName(), team.getBaseLocation(),
                team.getCoachName(),team.getCapitan().getNumber());
    }

    public static Team fromDTO(TeamDTO team,
                                  InterfacePlayerDAO<Integer,PlayerDTO> interfacePlayerDAO){
        return new Team(team.name(), team.baseLocation(), team.coachName(),interfacePlayerDAO);
    }
}

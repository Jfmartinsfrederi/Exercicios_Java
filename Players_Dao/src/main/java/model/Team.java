package model;

import dao.InterfacePlayerDAO;
import dto.PlayerDTO;
import dto.TransformDTO;
import exception.EntityAlreadyExistsException;
import exception.LimitPlayersTeamReached;

import java.util.*;

public class Team {
    private final String name;
    private String baseLocation;
    private String coachName;
    private Player capitan;

    private int fieldedPlayersCount;
    private int playersCount;
    private Map<Integer, Player> playersMap;

    private final InterfacePlayerDAO<Integer, PlayerDTO> interfacePlayerDAO;

    public Team(String name, String baseLocation, String coachName,
                InterfacePlayerDAO<Integer, PlayerDTO> interfacePlayerDAO) {
        isValidData(name, baseLocation, coachName);
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        this.playersMap = new TreeMap<>();
        this.interfacePlayerDAO = interfacePlayerDAO;
        this.fieldedPlayersCount = 0;
        this.playersCount = 0;
    }

    private void isValidData(String name, String baseLocation, String coachName) {
        if (name.isBlank()) throw new IllegalArgumentException("name must be not blank");
        if (baseLocation.isBlank()) throw new IllegalArgumentException("base location must be not blank");
        if (coachName.isBlank()) throw new IllegalArgumentException("coach name must be not blank");
        Objects.requireNonNull(name, "Name must be not null");
        Objects.requireNonNull(baseLocation, "Base location must be not null");
        Objects.requireNonNull(coachName, "Coach name must be not null");
    }

    public void addPlayer(Player player) {
        if (playersCount > 18) throw new LimitPlayersTeamReached("Teams only have 18 players or less");
        if (interfacePlayerDAO.findById(player.getNumber(),name).isPresent())
            throw new EntityAlreadyExistsException("Player já cadastrado");
        player.setFielded(notAllPlayersFielded());
        interfacePlayerDAO.save(TransformDTO.toDTO(player), name);
        updatePlayersMap();
        if (notAllPlayersFielded()) fieldedPlayersCount++;


    }


    public void removePlayer(Player player) {
        if (isInTeam(player)) throw new NoSuchElementException("Player not found");
        playersMap.remove(player.getNumber()); // 1*
        if (player.isFielded()) {
            fieldedPlayersCount--;
            if (notAllPlayersFielded()) {
                for (Player value : playersMap.values()) {
                    if (!value.isFielded()) {
                        value.setFielded();
                        interfacePlayerDAO.update(TransformDTO.toDTO(value), name);
                        break;
                    }

                }


            }
        }
        interfacePlayerDAO.remove(player.getNumber(), name);
        updatePlayersMap();


    }



    public void substitute(Player substitute, Player starter) {
        isInTeam(substitute);
        isInTeam(starter);
        if (!substitute.isFielded()) {
            throw new IllegalArgumentException("Player deve estar em campo " + substitute.getName());
        }
        if (starter.isFielded()) {
            throw new IllegalArgumentException("Player deve estar no banco " + starter.getName());
        }
        substitute.setFielded();
        starter.setFielded();
        playersMap.replace(substitute.getNumber(), substitute);
        playersMap.replace(starter.getNumber(), starter);
        interfacePlayerDAO.update(TransformDTO.toDTO(substitute), name);
        interfacePlayerDAO.update(TransformDTO.toDTO(starter), name);
    }


    public void setCapitan(Player capitan) {
        isInTeam(capitan);
        this.capitan=capitan;
    }
    private boolean isInTeam(Player player) {
        return !playersMap.containsKey(player.getNumber());
    }

    public List<Player> getFieldedPlayers() {
        return playersMap.values().stream()
                .filter(Player::isFielded).toList();
    }


    public List<Player> getOutFieldedPlayers() {
        return playersMap.values().stream()
                .filter(p -> !p.isFielded()).toList();
    }

    public void updatePlayersMap() {
        playersMap.clear();

        interfacePlayerDAO.getPlayers(name)
                .values()
                .forEach(p ->
                        playersMap.put(
                                p.number(),
                                TransformDTO.fromDTO(p)
                        ));
    }

    private boolean notAllPlayersFielded() {
        return fieldedPlayersCount < 11;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return """
                Name:%s | Location:%s | Coach:%s | Captain:%s
                """.formatted(name, baseLocation, coachName, capitan.getName());
    }

    public String getName() {
        return name;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public String getCoachName() {
        return coachName;
    }

    public Player getCapitan() {
        return capitan;
    }


}

/*
1* Aqui também poderiamos colocar uma verificação
que não deixaria remover um player em campo
if (player.isFielded())
throw new PlayerFieldedException("Player não pode ser removido em campo")
mas optamos por colocar um código que substitui um player automaticamente
*/
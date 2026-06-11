package dao;

import dto.TeamDTO;
import perisistence.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TeamDAO implements InterfaceTeamDAO<String, TeamDTO>{


    @Override
    public void save(TeamDTO teamDTO) {
        String sql="INSERT INTO teams (name,baseLocation,coachName,idCaptain)" +
                "WHERE (?,?,?,?)";
        try (PreparedStatement ps= ConnectionFactory.getPreparedStatement(sql)){
            ps.setString(1, teamDTO.name());
            ps.setString(2, teamDTO.baseLocation());
            ps.setString(3, teamDTO.coachName());
            ps.setInt(4, teamDTO.idCaptain());

            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void remove(String name) {
        String sql="DELETE FROM teams" +
                "WHERE name=?";
        try (PreparedStatement ps= ConnectionFactory.getPreparedStatement(sql)){
            ps.setString(1, name);


            ps.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(TeamDTO teamDTO) {
        String sql="UPDATE teams SET baseLocation=?,coachName=?,idCaptain=?" +
                "WHERE name=?";
        try (PreparedStatement ps= ConnectionFactory.getPreparedStatement(sql)){
            ps.setString(1, teamDTO.baseLocation());
            ps.setString(2, teamDTO.coachName());
            ps.setInt(3,teamDTO.idCaptain());
            ps.setString(4, teamDTO.name());

            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public Optional<TeamDTO> findByName(String name) {
        String sql="SELECT * FROM teams" +
                "WHERE name=?";
        try (PreparedStatement ps=ConnectionFactory.getPreparedStatement(sql)){
            ps.setString(1,name);

            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                return Optional.of(new TeamDTO(rs.getString("name"),
                        rs.getString("baseLocation"),
                        rs.getString("coachName"),
                        rs.getInt("idCaptain")));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Map<String, TeamDTO> getTeams() {
        String sql="SELECT * FROM teams";
        Map<String,TeamDTO> teamMap =new TreeMap<>();
        try (PreparedStatement ps=ConnectionFactory.getPreparedStatement(sql)){
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                teamMap.put(rs.getString("name"),new TeamDTO(rs.getString("name"),
                        rs.getString("baseLocation"),
                        rs.getString("coachName"),
                        rs.getInt("idCaptain")));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return teamMap;
    }
}

package dao;

import dto.PlayerDTO;
import perisistence.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PlayerDAO implements InterfacePlayerDAO<Integer, PlayerDTO> {


    @Override
    public void save(PlayerDTO playerDTO,String team) {
        String sql ="INSERT INTO players (name,number,position,isFielded,team) " +
                "VALUES (?,?,?,?,?)";
        try (PreparedStatement ps= ConnectionFactory.getPreparedStatement(sql)){
            ps.setString(1, playerDTO.name());
            ps.setInt(2, playerDTO.number());
            ps.setString(3, playerDTO.postion());
            ps.setBoolean(4, playerDTO.isFIelded());
            ps.setString(5,team);
            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Integer id,String team) {
        String sql="DELETE FROM players " +
                "WHERE number=? and team=?";
        try (PreparedStatement ps=ConnectionFactory.getPreparedStatement(sql)){
            ps.setInt(1,id);
            ps.setString(2,team);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(PlayerDTO playerDTO,String team) {
        String sql="UPDATE players SET name=?,position=?,isFielded=? " +
                "WHERE number=? and team=?";
        try (PreparedStatement ps= ConnectionFactory.getPreparedStatement(sql)){
            ps.setString(1, playerDTO.name());
            ps.setString(2, playerDTO.postion());
            ps.setBoolean(3, playerDTO.isFIelded());
            ps.setInt(4,playerDTO.number());
            ps.setString(5,team);
            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Optional<PlayerDTO> findById(Integer id,String team) {
        String sql="SELECT * FROM players " +
                "WHERE number=? and team=?";
        try (PreparedStatement ps=ConnectionFactory.getPreparedStatement(sql)){
            ps.setInt(1,id);
            ps.setString(2,team);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                return Optional.of(new PlayerDTO(rs.getString("name"),
                        rs.getInt("number"),
                        rs.getString("position"),
                        rs.getBoolean("isFIelded")));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Map<Integer,PlayerDTO> getPlayers(String team) {
        String sql="SELECT * FROM players " +
                "WHERE team=?";
        Map<Integer,PlayerDTO> playerMap=new TreeMap<>();
        try (PreparedStatement ps=ConnectionFactory.getPreparedStatement(sql)){
            ps.setString(1,team);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                playerMap.put(rs.getInt("number"),new PlayerDTO(rs.getString("name"),
                        rs.getInt("number"),
                        rs.getString("position"),
                        rs.getBoolean("isFIelded")));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return playerMap;
    }
}

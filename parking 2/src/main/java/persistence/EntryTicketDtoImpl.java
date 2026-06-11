package persistence;

import customer.CustomerDao;
import dto.CustomerDto;
import dto.EntryTicketDto;
import dto.ExitTicketDto;
import ticket.TicketDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class EntryTicketDtoImpl implements TicketDao {


    @Override
    public void save(EntryTicketDto entryTicketDto) {
        String sql="INSERT INTO ticket (id,plate,entry,exit,fee) " +
                "VALUES (?,?,?,?,?)";
        try (PreparedStatement ps=ConnectionFactory.getPreparedStateman(sql)){
            ps.setString(1, entryTicketDto.id());
            ps.setString(2, entryTicketDto.plate());
            ps.setString(3, entryTicketDto.entry());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<EntryTicketDto> findOpenTicket(String plate) {
        String sql="SELECT * FROM ticket " +
                "WHERE plate=? and exit is null";
        try (PreparedStatement ps=ConnectionFactory.getPreparedStateman(sql)){
            ps.setString(1,plate);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                return Optional.of(new EntryTicketDto(rs.getString("id"),
                        rs.getString("plate"),
                        rs.getString("entry")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateExit(ExitTicketDto exitTicketDto) {
        String sql="UPDATE ticket SET exit=?,fee=? " +
                "WHERE plate=?";
        try (PreparedStatement ps=ConnectionFactory.getPreparedStateman(sql)){
            ps.setString(1, exitTicketDto.exit());
            ps.setDouble(2,exitTicketDto.fee());
            ps.setString(3, exitTicketDto.plate());
            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}

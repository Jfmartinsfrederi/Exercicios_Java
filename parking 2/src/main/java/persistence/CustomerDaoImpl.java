package persistence;

import costs.PeriodCostDao;
import customer.CustomerDao;
import dto.CustomerDto;
import dto.PeriodCostDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public void save(CustomerDto customerDto) {
        String sql="INSERT INTO customer (plate,phone,type) " +
                "VALUES (?,?,?)";
        try (PreparedStatement ps=ConnectionFactory.getPreparedStateman(sql)){
            ps.setString(1, customerDto.plate());
            ps.setString(2, customerDto.phone());
            ps.setString(3, customerDto.type());
            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Optional<CustomerDto> findOne(String plate) {
        String sql="SELECT * FROM customer " +
                "WHERE plate=?";
        try (PreparedStatement ps=ConnectionFactory.getPreparedStateman(sql)){
            ps.setString(1,plate);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                return Optional.of(new CustomerDto(rs.getString("plate"),
                        rs.getString("phone"),
                        rs.getString("type")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

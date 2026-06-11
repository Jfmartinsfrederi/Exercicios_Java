package persistence;

import costs.PeriodCostDao;
import dto.PeriodCostDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodCostDaoImpl implements PeriodCostDao {

    @Override
    public List<PeriodCostDto> findAll() {
        String sql= "SELECT *FROM period_cost";
        List<PeriodCostDto> list=new ArrayList<>();
        try (PreparedStatement ps=ConnectionFactory.getPreparedStateman(sql)){
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                list.add(new PeriodCostDto(rs.getInt("hours"),
                        rs.getDouble("cost")));
            }


        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;

    }
}

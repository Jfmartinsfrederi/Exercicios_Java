package persistence;

import model.Paycheck;
import repository.RepositoryPaychecks;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BancoPaychecks implements RepositoryPaychecks<String,Paycheck> {


    @Override
    public void add(String id, Paycheck paycheck) {
        String sql="INSERT INTO paychecks (payday,salary,id_employee) " +
                "VALUES (?,?,?)";

        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setString(1,paycheck.getPayday().toString());
            ps.setDouble(2,paycheck.getSalary());
            ps.setString(3,id);
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, Paycheck paycheck) {
        String sql= "UPDATE paychecks SET payday=?, salary=? " +
                "WHERE id_employee=? and payday=? and salary=?";

        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1,paycheck.getPayday().toString());
            ps.setDouble(2,paycheck.getSalary());
            ps.setString(3, id);
            ps.setString(4,paycheck.getPayday().toString());
            ps.setDouble(5,paycheck.getSalary());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(String id, Paycheck paycheck) {
        String sql = "DELETE FROM paychecks " +
                "WHERE id_employee=? and payday=? and salary=?";
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.setString(2,paycheck.getPayday().toString());
            ps.setDouble(3,paycheck.getSalary());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Paycheck> findByDate(String id, LocalDate localDate) {
        String sql = "SELECT * FROM paychecks " +
                "WHERE id_employee = ? and payday=?";
        List<Paycheck> paychecks= new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1,id);
            ps.setString(2,localDate.toString());
            final ResultSet rs=ps.executeQuery();
            while (rs.next()){
                paychecks.add(new Paycheck(LocalDate.parse(rs.getString("payday")),
                        rs.getDouble("salary")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(paychecks);

    }

    @Override
    public List<Paycheck> getPaychecksByEmployee(String id) {
        String sql = "SELECT * FROM paychecks " +
                "WHERE id_employee = ?";
        List<Paycheck> paychecks= new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1,id);
            final ResultSet rs=ps.executeQuery();
            while (rs.next()){
                paychecks.add(new Paycheck(LocalDate.parse(rs.getString("payday")),
                        rs.getDouble("salary")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(paychecks);
    }

    @Override
    public List<Paycheck> getPaychecks() {
        String sql = "SELECT * FROM paychecks";
        List<Paycheck> paychecks= new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement ps = connection.prepareStatement(sql)) {

            final ResultSet rs=ps.executeQuery();
            while (rs.next()){
                paychecks.add(new Paycheck(LocalDate.parse(rs.getString("payday")),
                        rs.getDouble("salary")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(paychecks);
    }
}



















package persistence;

import model.Employee;
import repository.RepositoryEmployees;

import java.sql.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BancoEmployees implements RepositoryEmployees<String, Employee> {

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employees (id,name,jobTitle,dateOfEmployment,salary) " +
                "VALUES (?,?,?,?,?) ";
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getJobTitle());
            preparedStatement.setString(4, employee.getDateOfEmployment().toString());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employees SET name = ?, jobTitle = ?, dateOfEmployment = ?, salary= ? " +
                "WHERE id = ?";
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getJobTitle());
            preparedStatement.setString(4, employee.getDateOfEmployment().toString());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(String id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<Employee> findById(String id) {
        String sql = "SELECT *FROM employees WHERE id = ?";

        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new Employee(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("jobTitle"),
                        LocalDate.parse(rs.getString("dateOfEmployment")),
                        rs.getDouble("salary")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return Optional.empty();
    }

    @Override
    public Map<String, Employee> getEmployees() {
        String sql="SELECT *FROM employees";
        Map<String,Employee> employeeMap=new TreeMap<>();
        try (final Connection connection=DriverManager.getConnection("jdbc:sqlite:database.db");
        final PreparedStatement ps= connection.prepareStatement(sql)){
            final ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Employee employee=new Employee(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("jobTitle"),
                        LocalDate.parse(rs.getString("dateOfEmployment")),
                        rs.getDouble("salary"));
                employeeMap.put(employee.getId(), employee);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


        return Collections.unmodifiableMap(employeeMap);
    }


}



















package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitializer {

    public static void initialize() {
        createTable();
    }

    public static void createTable() {

        String employeeSql = """
                
                        CREATE TABLE IF NOT EXISTS employees (
                            id TEXT PRIMARY KEY,
                            name TEXT NOT NULL,
                            jobTitle TEXT,
                            salary REAL,
                            dateOfEmployment TEXT
                        );
                """;

        String paycheckSql = """
                CREATE TABLE IF NOT EXISTS paychecks(
                    payday TEXT NOT NULL,
                    salary REAL NOT NULL,
                    id_employee TEXT,
                FOREIGN KEY (id_employee) REFERENCES employees(id)
                        );
                
                """;

        try (
                Connection connection =
                        DriverManager.getConnection("jdbc:sqlite:database.db");

                PreparedStatement employeeStatement =
                        connection.prepareStatement(employeeSql);

                PreparedStatement paycheckStatement =
                        connection.prepareStatement(paycheckSql);
        ) {

            employeeStatement.executeUpdate();
            paycheckStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

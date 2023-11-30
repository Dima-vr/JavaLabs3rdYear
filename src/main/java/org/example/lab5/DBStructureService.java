package org.example.lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBStructureService {
    final String url;
    final String username;
    final String password;
    final Connection connection;

    DBStructureService(String url, String username, String password) throws SQLException {
        this.url = url;
        this.username = username;
        this.password = password;
        connection = getConnection();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    void dropAllTables() throws SQLException {
        String sqlStatement[] =
                {
                        "DROP TABLE IF EXISTS car",
                        "DROP TABLE IF EXISTS train"
                };
        Statement statement = connection.createStatement();
        for (String sqlSt : sqlStatement) {
            statement.execute(sqlSt);
        }
        System.out.println("All tables removed");
    }

    void createAllTables() throws SQLException {
        String sqlStatement[] =
                {
                        """
                        CREATE TABLE vehicle.car (
                            id INT NOT NULL AUTO_INCREMENT,
                            wheels INT NOT NULL,
                            engineSize DOUBLE NOT NULL,
                            mark varchar(50),
                            model varchar(50),
                            dateOfRelease date,
                            PRIMARY KEY (id)
                        );
                    """,
                        """
                        CREATE TABLE vehicle.train (
                            id INT NOT NULL AUTO_INCREMENT,
                            engineSize DOUBLE NOT NULL,
                            countWagons INT NOT NULL,
                            mark varchar(50),
                            model varchar(50),
                            dateOfRelease date,
                            PRIMARY KEY (id)
                        );
                    """
                };

        Statement statement = connection.createStatement();
        for (String sqlSt : sqlStatement) {
            statement.execute(sqlSt);
        }
        System.out.println("All tables created");
    }
}

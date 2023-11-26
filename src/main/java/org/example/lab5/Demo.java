package org.example.lab5;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/vehicle";
        String username = "root";
        String password = "admin";
        DBStructureService service = new DBStructureService(url, username, password);
        service.createAllTables();
//        service.dropAllTables();
    }
}
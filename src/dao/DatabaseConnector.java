package dao;

import java.sql.*;

public class DatabaseConnector {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/madrasah_management", "root", "123");
            return con;
        } catch (Exception e) {
            System.err.println("Connection Error"+ e);
            return null;
        }
    }
}

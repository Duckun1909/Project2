package io.aptech.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String host ="jdbc:mysql://localhost:3306/librarymanagement";
    private static final String username ="root";
    private static final String password ="Dangtay192003";
    private static Connection connection;
    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(host,username,password);

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(){
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

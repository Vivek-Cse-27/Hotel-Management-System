package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
    public Connection connection;
    public Statement statement;

    public Connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Code/HotelMS/Hotel Management System/hotel.db");

            statement = connection.createStatement();
            statement.execute("PRAGMA journal_mode=WAL;");
            statement.execute("PRAGMA synchronous=NORMAL;");
            statement.execute("PRAGMA busy_timeout=5000;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

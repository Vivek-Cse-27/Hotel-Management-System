package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.File;

public class Connect {
    public Connection connection;
    public Statement statement;

    public Connect(){
        try {
            Class.forName("org.sqlite.JDBC");

            File dbFile = new File("hotel.db");
            String dbPath = dbFile.getAbsolutePath();

            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

            statement = connection.createStatement();

            statement.execute("PRAGMA journal_mode=WAL;");
            statement.execute("PRAGMA synchronous=NORMAL;");
            statement.execute("PRAGMA busy_timeout=5000;");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

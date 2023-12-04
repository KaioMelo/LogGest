package br.mil.fab.pagl.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConfigConnectionDB {
    private static final Properties properties = new Properties();

    static{
        try(InputStream input = ConfigConnectionDB.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(input);
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (IOException |  ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(
            properties.getProperty("url"),
            properties.getProperty("user"),
            properties.getProperty("password"));
    }
}

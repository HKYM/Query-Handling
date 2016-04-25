package com.sdzee.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
public class DBUtil {
 
    private static Connection conn;
 
    public static Connection getConnection() {
        if( conn != null )
            return conn;
 
        InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream( "/db.properties" );
        Properties properties = new Properties();
        try {
            properties.load( inputStream );
            String driver = "com.mysql.jdbc.Driver" ; 
            String url = "jdbc:mysql://localhost:3306/membres";
            String user = "root";
            String password = "";
            Class.forName( driver );
            conn = DriverManager.getConnection( url, user, password );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return conn;
    }
 
    public static void closeConnection( Connection toBeClosed ) {
        if( toBeClosed == null )
            return;
        try {
            toBeClosed.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
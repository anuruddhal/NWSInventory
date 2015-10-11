/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wb.control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Anuruddha
 */
public class DBFactory {

    static Connection connection = null; 
    static String userName = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/nwsdb";
    static String driver = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws Exception {
        if (connection == null) {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
        }
        return connection;
    }
    
    
}

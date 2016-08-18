/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Henrique
 */
public class Conexao {
    private static HashMap<String, String> properties = Util.ReadPropFile.readFile();
    private static  String dbURL = properties.get("dbURL");
    private static String dbUser = properties.get("user");
    private static String dbPass = properties.get("password");;
    
    public static Connection getConnection()throws ClassNotFoundException, SQLException{
       Connection conn = null;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        return conn;
    }
    
}

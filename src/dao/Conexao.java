/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Henrique
 */
public class Conexao {
    
    private static  String dbURL = "jdbc:mysql://localhost:3307/originalita";
    private static String dbUser = "root";
    private static String dbPass = "kiron";
    
    public static Connection getConnection()throws ClassNotFoundException, SQLException{
       Connection conn = null;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        return conn;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.ReadPropFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Henrique
 */
public class Conexao {

    private ReadPropFile readPropFile = new ReadPropFile();
    private HashMap<String, String> properties = readPropFile.readFile();
    private String dbURL = properties.get("dbURL");
    private String dbUser = properties.get("user");;
    private String dbPass = properties.get("password");;
    
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        return conn;
    }

}

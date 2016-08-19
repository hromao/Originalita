/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henrique
 */
public class ReadPropFile {

    private static Properties prop = new Properties();
    private static InputStream input;
    private static HashMap<String, String> properties = new HashMap<>();
    private Awesome minharola;

    public HashMap<String, String> readFile() {
        try {
            String arquivo = "config.properties";
            input = getClass().getClassLoader().getResourceAsStream(arquivo);
            if (input == null) {
                return null;
            }

            prop.load(input);

            properties.put("dbURL", prop.getProperty("dbURL"));
            properties.put("user", prop.getProperty("user"));
            properties.put("password", prop.getProperty("password"));

        } catch (IOException ex) {
            Logger.getLogger(ReadPropFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                    return properties;
                } catch (IOException ex) {
                    Logger.getLogger(ReadPropFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return properties;
    }

}

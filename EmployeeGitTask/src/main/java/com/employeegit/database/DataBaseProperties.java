/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeegit.database;

/**
 *
 * @author Ibrahim
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Ibrahim
 */
public class DataBaseProperties {
    public static void main(String[] args) {
        Properties rootProperties = new Properties();
            FileOutputStream propertiesFile = null;
            Map<Object,Object> propertiesMap = new TreeMap<>();
            propertiesMap.put("MYSQL_DB_URL","jdbc:mysql://localhost:3306/msql");
            propertiesMap.put("MYSQL_DB_USERNAME", "root");
            propertiesMap.put("MYSQL_DB_PASSWORD", "root");
            
        try {
            propertiesFile = new FileOutputStream("fileProp.properties");
            rootProperties.putAll(propertiesMap);
            rootProperties.store(propertiesFile,null);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
             try {
                 if(rootProperties == null) rootProperties.clear();
                 if(propertiesFile == null) propertiesFile.close();
             } catch (IOException ex) {
                 Logger.getLogger(DataBaseProperties.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
}

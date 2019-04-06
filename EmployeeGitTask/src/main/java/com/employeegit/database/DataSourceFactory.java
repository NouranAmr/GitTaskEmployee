/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeegit.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.util.Properties;
import javax.sql.DataSource;
/**
 *
 * @author Ibrahim
 */
public class DataSourceFactory {
    public static DataSource getNewDataSource(){
        MysqlDataSource datasourceRoot = null;
        Properties rootProperties = new Properties();
        FileInputStream input = null;
        //Map<Object,Object> propertiesMap = new TreeMap<>();  
        try{
            input = new FileInputStream("fileprop.properties");
            datasourceRoot = new MysqlDataSource();
            rootProperties.load(input);
            datasourceRoot.setURL(rootProperties.getProperty("MYSQL_DB_URL"));
            datasourceRoot.setUser(rootProperties.getProperty("MYSQL_DB_USERNAME"));
            datasourceRoot.setPassword(rootProperties.getProperty("MYSQL_DB_PASSWORD"));
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return datasourceRoot;
    }
}

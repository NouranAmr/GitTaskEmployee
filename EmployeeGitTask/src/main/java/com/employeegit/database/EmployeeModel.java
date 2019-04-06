/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeegit.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Ibrahim
 */
public class EmployeeModel {
    static MysqlDataSource datasoucePrint = null;
     static  Connection datasourceConnection = null;
     static Statement selectStatement =null,createStatment= null;
     static PreparedStatement insertStatement=null,deleteStatment=null,updateStatement=null;
     static   ResultSet selectSet = null,createSet=null,insertSet=null;
          
    public static void createConnection(){
       datasoucePrint = (MysqlDataSource)DataSourceFactory.getNewDataSource();
        
         try {
                         
             datasourceConnection = datasoucePrint.getConnection();
             datasourceConnection.setAutoCommit(true);
//               createTable();
//             insertRow(1111,"ahmed","mohame","salah","hhs@gmail","01012566678");
//             insertRow(2222,"ahmed2","mohame2","salah2","ejjrkk@gmail","51111212");
//             insertRow(3333,"ahmed3","mohame3","salah3","nnfkjffk@gmail","015422233");
//             insertRow(4444,"ahmed4","mohame4","salah4","ppooll@gmail","25151223");
//             insertRow(5555,"ahmed5","mohame5","salah5","qwrr@gmail","11200288");
//             insertRow(6666,"ahmed6","mohame6","salah6","zxxxxxxxlfjk@gmail","18489922");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
        
    }
    public static void createTable(){
    
        
         try {
             createStatment = datasourceConnection.createStatement();
            createStatment.executeUpdate("create table person(id INT,first_name VARCHAR(100),middle_name VARCHAR(40),last_name VARCHAR(40),email VARCHAR(40),phone VARCHAR(40))"
                     );
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
    
    }
    public static void insertRow(int id,String firstName,String middleName,String lastName,String email,String phone){
        
        try {
            insertStatement = datasourceConnection.prepareStatement("insert into person values (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE first_name=? ,middle_name = ?,last_name = ?,email= ?,phone = ?");
            insertStatement.setInt(1, id);
            insertStatement.setString(2, firstName);
            insertStatement.setString(3, middleName);
            insertStatement.setString(4, lastName);
            insertStatement.setString(5, email);
            insertStatement.setString(6, phone);
            insertStatement.setString(7, firstName);
            insertStatement.setString(8, middleName);
            insertStatement.setString(9, lastName);
            insertStatement.setString(10, email);
            insertStatement.setString(11, phone);
            insertStatement.executeUpdate();
           // datasourceConnection.commit();
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
    }
    public static ResultSet selectTable(){
        try {
             selectStatement = datasourceConnection.createStatement();
            selectSet = selectStatement.executeQuery("select id,first_name,middle_name,last_name,email,phone from person");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return selectSet;
    }
    public static void deleteRow(int deletedId){
         try {
             deleteStatment = datasourceConnection.prepareStatement("delete from person where id = ?");
             deleteStatment.setInt(1, deletedId);
             deleteStatment.executeUpdate();
             //datasourceConnection.commit();
           
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
    }
    public static void updateRow(int updaedId,String firstName,String middleName,String lastName,String email,String phone){
         try {
             updateStatement = datasourceConnection.prepareStatement("update person set first_name=? ,middle_name = ?,last_name = ?,email= ?,phone = ? where id = ?");
             insertStatement.setString(1, firstName);
             insertStatement.setString(2, middleName);
             insertStatement.setString(3, lastName);
             insertStatement.setString(4, email);
             insertStatement.setString(5, phone);
             insertStatement.setInt(6, updaedId);
             updateStatement.executeUpdate();
         } catch (SQLException ex) {
             ex.printStackTrace();
         }

    }
}

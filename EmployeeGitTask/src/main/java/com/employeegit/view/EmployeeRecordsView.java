/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeegit.view;

import com.employeegit.database.EmployeeModel;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nouran
 */
public class EmployeeRecordsView extends Application {
    
     @Override
    public void start(Stage primaryStage) {
      
        Scene scene = new Scene(new EmployeeRecordsViewBase());
        primaryStage.setTitle("Employees");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeeModel.createConnection();
        launch(); 
    } 
    
}

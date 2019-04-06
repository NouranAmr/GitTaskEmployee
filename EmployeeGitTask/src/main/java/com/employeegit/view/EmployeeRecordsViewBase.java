/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeegit.view;


import com.employeegit.database.EmployeeModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Nouran
 */
public class EmployeeRecordsViewBase extends AnchorPane {
    
      protected final Pane pane;
    protected final TextField id;
    protected final TextField firstName;
    protected final TextField middleName;
    protected final TextField lastName;
    protected final TextField email;
    protected final TextField phone;
    protected final Label id_lbl;
    protected final Label firstName_lbl;
    protected final Label middleName_lbl;
    protected final Label lastName_lbl;
    protected final Label email_lbl;
    protected final Label phone_lbl;
    protected final Button new_btn;
    protected final Button update_btn;
    protected final Button delete_btn;
    protected final Button first_btn;
    protected final Button previous_btn;
    protected final Button next_btn;
    protected final Button last_btn;

    static ResultSet employeeSet;
    static int i = 1, p = 1;

    public EmployeeRecordsViewBase() {

        pane = new Pane();
        lastName = new TextField();
        id = new TextField();
        middleName = new TextField();
        firstName = new TextField();
        email = new TextField();
        phone = new TextField();
        id_lbl = new Label();
        firstName_lbl = new Label();
        middleName_lbl = new Label();
        lastName_lbl = new Label();
        email_lbl = new Label();
        phone_lbl = new Label();
        new_btn = new Button();
        update_btn = new Button();
        delete_btn = new Button();
        first_btn = new Button();
        previous_btn = new Button();
        next_btn = new Button();
        last_btn = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        pane.setLayoutX(-1.0);
        pane.setPrefHeight(400.0);
        pane.setPrefWidth(600.0);

        firstName.setLayoutX(226.0);
        firstName.setLayoutY(76.0);

        middleName.setLayoutX(226.0);
        middleName.setLayoutY(126.0);
        middleName.setPrefHeight(25.0);
        middleName.setPrefWidth(149.0);

        lastName.setLayoutX(226.0);
        lastName.setLayoutY(181.0);
        lastName.setPrefHeight(25.0);
        lastName.setPrefWidth(149.0);

        id.setLayoutX(226.0);
        id.setLayoutY(36.0);

        email.setLayoutX(226.0);
        email.setLayoutY(240.0);
        email.setPrefHeight(25.0);
        email.setPrefWidth(284.0);

        phone.setLayoutX(226.0);
        phone.setLayoutY(291.0);
        phone.setPrefHeight(25.0);
        phone.setPrefWidth(203.0);

        id_lbl.setLayoutX(78.0);
        id_lbl.setLayoutY(40.0);
        id_lbl.setText("ID");

        firstName_lbl.setLayoutX(78.0);
        firstName_lbl.setLayoutY(80.0);
        firstName_lbl.setText("First Name");

        middleName_lbl.setLayoutX(78.0);
        middleName_lbl.setLayoutY(130.0);
        middleName_lbl.setText("Middle Name");

        lastName_lbl.setLayoutX(78.0);
        lastName_lbl.setLayoutY(185.0);
        lastName_lbl.setText("Last Name");

        email_lbl.setLayoutX(78.0);
        email_lbl.setLayoutY(244.0);
        email_lbl.setText("Email");

        phone_lbl.setLayoutX(78.0);
        phone_lbl.setLayoutY(295.0);
        phone_lbl.setText("Phone");

        new_btn.setLayoutX(95.0);
        new_btn.setLayoutY(361.0);
        new_btn.setMnemonicParsing(false);
        new_btn.setText("New");

        update_btn.setLayoutX(163.0);
        update_btn.setLayoutY(361.0);
        update_btn.setMnemonicParsing(false);
        update_btn.setText("Update");

        delete_btn.setLayoutX(226.0);
        delete_btn.setLayoutY(361.0);
        delete_btn.setMnemonicParsing(false);
        delete_btn.setText("Delete");

        first_btn.setLayoutX(289.0);
        first_btn.setLayoutY(361.0);
        first_btn.setMnemonicParsing(false);
        first_btn.setText("First");

        previous_btn.setLayoutX(343.0);
        previous_btn.setLayoutY(361.0);
        previous_btn.setMnemonicParsing(false);
        previous_btn.setText("Previous");

        next_btn.setLayoutX(422.0);
        next_btn.setLayoutY(361.0);
        next_btn.setMnemonicParsing(false);
        next_btn.setText("Next");

        last_btn.setLayoutX(482.0);
        last_btn.setLayoutY(361.0);
        last_btn.setMnemonicParsing(false);
        last_btn.setText("Last");

        pane.getChildren().add(id);
        pane.getChildren().add(firstName);
        pane.getChildren().add(middleName);
        pane.getChildren().add(lastName);
        pane.getChildren().add(email);
        pane.getChildren().add(phone);
        pane.getChildren().add(id_lbl);
        pane.getChildren().add(firstName_lbl);
        pane.getChildren().add(middleName_lbl);
        pane.getChildren().add(lastName_lbl);
        pane.getChildren().add(email_lbl);
        pane.getChildren().add(phone_lbl);
        pane.getChildren().add(new_btn);
        pane.getChildren().add(update_btn);
        pane.getChildren().add(delete_btn);
        pane.getChildren().add(first_btn);
        pane.getChildren().add(previous_btn);
        pane.getChildren().add(next_btn);
        pane.getChildren().add(last_btn);
        getChildren().add(pane);

        employeeSet = EmployeeModel.selectTable();
        settextFieldonnext();
        next_btn.setOnAction((e) -> settextFieldonnext());
        previous_btn.setOnAction((e) -> settextFieldonprevious());
        last_btn.setOnAction(e -> settextFieldonLast());
        first_btn.setOnAction(e -> settextFieldonFirst());
        new_btn.setOnAction(e -> settextFieldonNew());
        update_btn.setOnAction(e -> settextFieldonUpdate());
        delete_btn.setOnAction(e -> settextFieldonDelete());
    }

    public void settextFieldonnext() {
        try {
            if (employeeSet.next()) {
                id.setText("" + employeeSet.getInt(1));
                firstName.setText(employeeSet.getString(2));
                middleName.setText(employeeSet.getString(3));
                lastName.setText(employeeSet.getString(4));
                email.setText(employeeSet.getString(5));
                phone.setText(employeeSet.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void settextFieldonprevious() {
        try {
            if (employeeSet.previous()) {
                id.setText("" + employeeSet.getInt(1));
                firstName.setText(employeeSet.getString(2));
                middleName.setText(employeeSet.getString(3));
                lastName.setText(employeeSet.getString(4));
                email.setText(employeeSet.getString(5));
                phone.setText(employeeSet.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void settextFieldonLast() {
        try {
            employeeSet.last();
            id.setText("" + employeeSet.getInt(1));
            firstName.setText(employeeSet.getString(2));
            middleName.setText(employeeSet.getString(3));
            lastName.setText(employeeSet.getString(4));
            email.setText(employeeSet.getString(5));
            phone.setText(employeeSet.getString(6));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void settextFieldonFirst() {
        try {
            employeeSet.first();
            id.setText("" + employeeSet.getInt(1));
            firstName.setText(employeeSet.getString(2));
            middleName.setText(employeeSet.getString(3));
            lastName.setText(employeeSet.getString(4));
            email.setText(employeeSet.getString(5));
            phone.setText(employeeSet.getString(6));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void settextFieldonNew() {
        id.setText("");
        firstName.setText("");
        middleName.setText("");
        lastName.setText("");
        email.setText("");
        phone.setText("");

    }

    private void settextFieldonUpdate() {
        if ((id.getText().equals("")) || (firstName.getText().equals("")) || (middleName.getText().equals("")) || (email.getText().equals("")) || (phone.getText().equals(""))) {
            new Alert(Alert.AlertType.INFORMATION, "insert all information").show();
        } else {
            EmployeeModel.insertRow(Integer.valueOf(id.getText()), firstName.getText(), middleName.getText(), lastName.getText(), email.getText(), phone.getText());
            employeeSet = EmployeeModel.selectTable();
        }
    }

    private void settextFieldonDelete() {
        if (id.getText().equals("")) {
            new Alert(Alert.AlertType.INFORMATION, "insert id information").show();
        } else {
            EmployeeModel.deleteRow(Integer.valueOf(id.getText()));
            employeeSet = EmployeeModel.selectTable();
            id.setText("");
            firstName.setText("");
            middleName.setText("");
            lastName.setText("");
            email.setText("");
            phone.setText("");
        }
    }
    
}

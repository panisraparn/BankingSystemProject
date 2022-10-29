package ku.cs.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.models.Employee;
import ku.cs.services.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;


    //เป็น account ที่ไว้ใช้ login
    public Employee empLoginAccount;


    @FXML
    void handleLoginButton(ActionEvent event) {

//        String emp_IdLoginStr = usernameTextField.getText();
//        String emp_passwordStr = passwordField.getText();
//
//        DatabaseConnection connectNow = new DatabaseConnection();
//        Connection connectDB = connectNow.getConnection();
//
//        String connectQuery = "SELECT Emp_id, Emp_name, Emp_password FROM employee WHERE Emp_id = '"+emp_IdLoginStr+"'";
////        empLoginAccount = new (Emp_id);
//
//        try {
//            Statement statement = connectDB.createStatement();
//            ResultSet queryOutput = statement.executeQuery(connectQuery);
//
//            empLoginAccount = new(queryOutput.getString("Emp_id"), );
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }


    }
}



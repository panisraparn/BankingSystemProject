package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.models.Employee;

import java.io.IOException;
import java.sql.*;

public class LoginController {


    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;


    //เป็น account ที่ไว้ใช้ login
    public Employee empLoginAccount;
    String loginEmpId;
    String loginName;
    String loginJtitle;
    String loginPassword;

    //database connect
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    @FXML
    void handleLoginButton(ActionEvent event) {

        String emp_IdLoginStr = usernameTextField.getText();
        String emp_passwordStr = passwordField.getText();

        //DB connect
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test_loansystem", "root", "");
            System.out.println("Connection is created successfully:");

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT Emp_id,Emp_name, Emp_jTitle ,Emp_password FROM employee  WHERE Emp_id = '"+emp_IdLoginStr+"'  AND  Emp_password = '"+emp_passwordStr+"'  ");

            while (rs.next()){
                loginEmpId = rs.getString(1);
                loginName = rs.getNString(2);
                loginJtitle = rs.getString(3);
                loginPassword = rs.getString(4);
                this.empLoginAccount = new Employee (loginEmpId,loginName,loginJtitle,loginPassword);
                System.out.println(empLoginAccount.toCsv());
            }
            System.out.println("loginAccount can use from jdbc");
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Please check it in the MySQL Table......... ……..");

        if(empLoginAccount == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("ข้อมูลไม่ถูกต้องโปรดตรวจสอบความถูกต้องในการเข้าสู่ระบบอีกครั้ง");
            alert.showAndWait();
        }else{
            if(empLoginAccount.getEmp_jTitle().equals("1")){
                try {
                    FXRouter.goTo("emp_home", empLoginAccount);
                } catch (IOException e) {
                    System.err.println("ไปที่หน้า emp_home ไม่ได้");
                    System.err.println("ให้ตรวจสอบการกำหนด route");
                }
            }else {
                if (empLoginAccount.getEmp_jTitle().equals("2")){
                    try {
                        FXRouter.goTo("manager_home", empLoginAccount);
                    } catch (IOException e) {
                        System.err.println("ไปที่หน้า manager_home ไม่ได้");
                        System.err.println("ให้ตรวจสอบการกำหนด route");
                    }
                }else {
                    try {
                        FXRouter.goTo("creditboard_home", empLoginAccount);
                    } catch (IOException e) {
                        System.err.println("ไปที่หน้า creditboard_home ไม่ได้");
                        System.err.println("ให้ตรวจสอบการกำหนด route");
                    }
                }
            }
        }
    }
}



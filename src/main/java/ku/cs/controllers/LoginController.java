package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.models.Customer;
import ku.cs.models.Employee;
import ku.cs.services.Database.CustomerDatabase;
import ku.cs.services.Database.Database;
import ku.cs.services.Database.EmployeeDatabase;

import java.io.IOException;
import java.sql.*;

public class LoginController {


    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;


    //เป็น account ที่ไว้ใช้ login
    public Employee empLoginAccount;
    //emp database
    public Employee employeeDB = new Employee("0","0","0","0");

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

        employeeDB.setEmp_id(emp_IdLoginStr);
        employeeDB.setEmp_password(emp_passwordStr);

        // ใช้ Db
        Database<Employee> database = new EmployeeDatabase();
        empLoginAccount = database.readDatabase(employeeDB);


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



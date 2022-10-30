package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import ku.cs.FXRouter;
import ku.cs.models.Employee;

import java.awt.*;
import java.io.IOException;

public class EmpHomeController {

    @FXML
    public Label empNameLabel;

    //---------------------------------------------------------------------------
    public Employee empLoginAccount;

    //----------------------------------------------------------------------------
    @FXML
    public void initialize(){
        empLoginAccount = (Employee) FXRouter.getData();
        showEmpLoginData(empLoginAccount);
    }

    @FXML
    private void showEmpLoginData(Employee loginAccount){
        empNameLabel.setText(loginAccount.getEmp_name());
    }

    @FXML
    public void clickBackToLogin(Event event) {
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    void clickToRegister(ActionEvent event) {
        try {
            FXRouter.goTo("emp_registration");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_registration ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }


    @FXML
    void clickToEmp_Document(ActionEvent event) {
        try {
            FXRouter.goTo("emp_document");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_document ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    void clickToEmp_Document_Loan(ActionEvent event) {
        try {
            FXRouter.goTo("emp_document_loan");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_document_loan ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }





}

package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import ku.cs.FXRouter;

import java.io.IOException;

public class EmpInvoice2Controller {

    @FXML private TextField ctmDebtTextField;
    @FXML private Label dateLabel;
    @FXML private Label customerIdLabel;
    @FXML private Label fnameLabel;
    @FXML private Label lnameLabel;
    @FXML private Label bankAccLabel;

    @FXML void clickBackToLogin(MouseEvent event) {
        try {
            FXRouter.goTo("emp_home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}

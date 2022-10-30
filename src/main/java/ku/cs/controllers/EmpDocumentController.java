package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import ku.cs.FXRouter;

import java.io.IOException;


public class EmpDocumentController {

    @FXML
    void clickBackToEmp_home(MouseEvent event) {
        try {
            FXRouter.goTo("emp_home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

}

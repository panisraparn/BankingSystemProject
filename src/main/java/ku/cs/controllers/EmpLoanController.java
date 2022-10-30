package ku.cs.controllers;

import javafx.scene.input.MouseEvent;
import ku.cs.FXRouter;

import java.io.IOException;

public class EmpLoanController {
    
    public void clickBackToLogin(MouseEvent event) {
        
    }

    public void clickBackToEmp_home(MouseEvent event) {
        try {
            FXRouter.goTo("emp_home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}

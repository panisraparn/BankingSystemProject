package ku.cs.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import ku.cs.FXRouter;

import java.io.IOException;

public class CreditBoardHomeController {

    @FXML
    public void clickBackToLogin(Event event) {
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}

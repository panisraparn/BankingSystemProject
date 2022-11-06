package ku.cs.controllers;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ku.cs.FXRouter;
import ku.cs.servicesDB.Customer_DBConnect;
import ku.cs.servicesDB.DatabaseConnection;
import ku.cs.servicesDB.MySQLConnection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class EmpCheckListController {

    @FXML
    void clickBackToEmp_home(MouseEvent event) {
        try {
            FXRouter.goTo("emp_home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    void handlePrintButton(ActionEvent event) {
//        Task<Void> task = new Task<Void>() {
//            @Override
//            protected Void call() throws Exception {
//                HashMap parameter = new HashMap();
//                JasperPrint jasperPrint = JasperFillManager.fillReport("report/report01.jasper",parameter, MySQLConnection.createConnection());
//                JasperViewer viewer = new JasperViewer(jasperPrint,false);
//                viewer.setVisible(true);
//                return null;
//            }
//        };
//        ExecutorService service = Executors.newCachedThreadPool();
//        service.execute(task);
//        service.shutdown();





    }

}

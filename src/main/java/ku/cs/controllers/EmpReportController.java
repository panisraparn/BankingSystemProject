package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import ku.cs.FXRouter;
import ku.cs.models.Invoice;
import ku.cs.models.InvoiceList;
import ku.cs.servicesDB.Database;
import ku.cs.servicesDB.Invoice_DBConnect;

import java.io.IOException;

public class EmpReportController {


    @FXML private Label firstnameLabel;
    @FXML private Label lastnameLabel;
    @FXML private Label ctmIdLabel;
    @FXML private Label Invoice_statusLabel;
    @FXML private Label dateLabel;
    @FXML private ListView<String> reportOfDebtorListView;

    //ListView
    private InvoiceList reportOfDebtorList = new InvoiceList();
    private javafx.collections.ObservableList<String> ObservableList;
    private String id = "0";

    @FXML
    public void initialize(){
        clearLabel();
        //อ่าน database ของ invoice
        Database<Invoice, InvoiceList> database = new Invoice_DBConnect();
        String allInvoiceQuery = " Select * FROM invoice WHERE Invoice_status = '1' || Invoice_status = '2' || Invoice_status = '0' || Invoice_status = '3'  ";
        reportOfDebtorList = database.readDatabase(allInvoiceQuery);

        showListView();
        handleInvoiceSelected();
    }

    private void handleInvoiceSelected() {
    }

    private void showListView() {
    }

    private void clearLabel() {
        firstnameLabel.setText("");
        lastnameLabel.setText("");
        ctmIdLabel.setText("");
        Invoice_statusLabel.setText("");
        dateLabel.setText("");
    }

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

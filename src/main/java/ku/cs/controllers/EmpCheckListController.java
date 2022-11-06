package ku.cs.controllers;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ku.cs.FXRouter;
import ku.cs.models.Invoice;
import ku.cs.models.InvoiceList;
import ku.cs.servicesDB.Database;
import ku.cs.servicesDB.Invoice_DBConnect;

public class EmpCheckListController {

    @FXML private Label invoiceIdLabel;
    @FXML private Label firstnameLabel;
    @FXML private Label LastnameLabel;
    @FXML private Label Ctm_cidLabel;
    @FXML private Label invoiceCtmDebt;
    @FXML private Label invoiceStatusLabel;
    @FXML private Label dateLabel;

    @FXML private Label emp_nameLabel;
    @FXML private Label emp_idLabel;

    @FXML private TextField findCtmCidTextField;

    //ListView
    private InvoiceList waitToTrackDownDebtsList = new InvoiceList();
    private javafx.collections.ObservableList<String> ObservableList;
    private String id = "0";



    @FXML
    void initialize(){
        clearLabel();
        //อ่าน database ของ invoice
        Database<Invoice, InvoiceList> database = new Invoice_DBConnect();
        String allInvoiceQuery = " Select * FROM invoice WHERE Invoice_status = '1' || Invoice_status = '2' || Invoice_status = '0' || Invoice_status = '3'  ";
        waitToTrackDownDebtsList = database.readDatabase(allInvoiceQuery);

        showListView();
        handleInvoiceSelected();
    }



    private void clearLabel() {

    }

    private void handleInvoiceSelected() {
    }

    private void showListView() {
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

    @FXML
    void clickShowAllInvoice(MouseEvent event) {

    }

    @FXML
    void findCustomerButton(ActionEvent event) {

    }

    @FXML
    void handleBackToEmpHomeButton(ActionEvent event) {
        try {
            FXRouter.goTo("emp_home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

}

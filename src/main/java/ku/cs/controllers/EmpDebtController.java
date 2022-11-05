package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import ku.cs.FXRouter;
import ku.cs.models.*;
import ku.cs.servicesDB.*;

import java.io.IOException;

public class EmpDebtController {

    @FXML
    private ListView<String> waitToTrackDownDebtsListView;
    @FXML private Label invoiceIdLabel;
    @FXML private Label firstnameLabel;
    @FXML private Label invoiceCtmDebt;
    @FXML private Label LastnameLabel;
    @FXML private Label invoiceStatusLabel;
    @FXML private TextField findCtmCidTextField;

    //ListView
    private InvoiceList waitToTrackDownDebtsList = new InvoiceList();
    private javafx.collections.ObservableList<String> ObservableList;
    private String selectedInvoice_Id = "0";


    @FXML
    public void initialize(){
        //อ่าน database ของ invoice
    }

    @FXML void findCustomerButton(ActionEvent event) {
        Customer customer = new Customer("0", "0");
        Database<Customer, CustomerList> database = new Customer_DBConnect();
        String q =" Select * FROM customer WHERE Ctm_cid = '"+findCtmCidTextField.getText()+"'  ";
        customer = database.readRecord(q); //เจอ return record ไม่เจอ return null

        if(findCtmCidTextField.getText().equals("")){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("กรุณาใส่เลขบัตรประจำตัวประชาชนของลูกค้าที่ต้องการค้นหา");
            alert.showAndWait();


        }else{

            if (customer == null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!!");
                alert.setHeaderText(null);
                alert.setContentText("ไม่พบข้อมูลลูกค้าในระบบโปรดตรวจสอบข้อมูลลูกค้า");
                alert.showAndWait();

//                clearShowLabel();


            }else{
                Database<Invoice,InvoiceList>  database1 = new Invoice_DBConnect();
                String q1 = " Select * FROM invoice WHERE Invoice_customerId = '"+findCtmCidTextField.getText()+" ";
                waitToTrackDownDebtsList = database1.readDatabase(q1);
                showListView();
                handleInvoiceSelected();
            }
        }
    }

    private void showListView() {
        ObservableList = FXCollections.observableArrayList();
        for(int i = waitToTrackDownDebtsList.countInvoiceElement()-1; i>=0; i--)
        {
            Invoice invoice = waitToTrackDownDebtsList.getInvoiceRecord(i);
//          ObservableList.add("No."+doc.getDtb_id()+" CustomerId : "+doc.getDtb_customerId()+"  Date : "+doc.getDtb_date());

            ObservableList.add(invoice.getInvoice_id());
        }
        waitToTrackDownDebtsListView.setItems(ObservableList);
    }

    private void handleInvoiceSelected(){

    }

    @FXML
    void handleCheckInfoButton(ActionEvent event) {
        waitToTrackDownDebtsListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
//                        System.out.println(newValue + " is selected");
                        selectedInvoice_Id = newValue;
//                        showSelectedCustomer(selectedLoan_id);
                    }
                });
    }

    @FXML
    void clickShowAllInvoice(MouseEvent event) {

        Customer customer = new Customer("0", "0");
        Database<Customer, CustomerList> database = new Customer_DBConnect();
        String q =" Select * FROM customer WHERE Ctm_cid = '"+findCtmCidTextField.getText()+"'  ";
        customer = database.readRecord(q); //เจอ return record ไม่เจอ return null

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

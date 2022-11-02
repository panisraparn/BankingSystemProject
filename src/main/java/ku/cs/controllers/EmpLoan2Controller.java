package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import ku.cs.FXRouter;
import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.models.LoanAgreement;
import ku.cs.servicesDB.Customer_DBConnect;
import ku.cs.servicesDB.Database;

import java.io.IOException;

public class EmpLoan2Controller {

    @FXML private TextField termTextField;
    @FXML private TextField amountTextField;
    @FXML private TextField witness1TextField;
    @FXML private TextField witness2TextField;
    @FXML private TextField emp2TextField;
    @FXML private ChoiceBox<String> typeChoiceBox;
    @FXML private Label firstnameLabel;
    @FXML private Label lastnameLabel;
    @FXML private Label ctmIdLabel;
    @FXML private Label ctm_cidLabel;
    @FXML private Label emp1Label;


//    prepare data for emp who login and record loan Agreement with customer Id who is borrower
    public LoanAgreement empLoginWithCtm_idForLoan;

    @FXML
    public  void initialize(){
        //รับ รหัสพนักงานที่ login กับ customer id ที่จะบันทีกสัญญา จาก emp_loan1
        empLoginWithCtm_idForLoan = (LoanAgreement) FXRouter.getData();
        showEmpLoginWithCtm_idForLoan(empLoginWithCtm_idForLoan);

        //set ChoiceBox
        typeChoiceBox.getItems().add("0: ไม่มีคนค้ำ");
        typeChoiceBox.getItems().add("1: มีคนค้ำ");


    }

    private void showEmpLoginWithCtm_idForLoan(LoanAgreement empLoginWithCtm_idForLoan) {

        emp1Label.setText(empLoginWithCtm_idForLoan.getLoan_Emp1());
        ctmIdLabel.setText(empLoginWithCtm_idForLoan.getLoan_customerId());

        //อ่าน database จาก customer
        Customer customer = new Customer("0", "0");
        Database<Customer, CustomerList> database = new Customer_DBConnect();
        String q =" Select * FROM customer WHERE Ctm_id = '"+empLoginWithCtm_idForLoan.getLoan_customerId()+"'  ";
        customer = database.readDatabase(customer,q); //เจอ return record ไม่เจอ return null
        System.out.println(customer.toCsv());

        firstnameLabel.setText(customer.getCtm_firstname());
        lastnameLabel.setText(customer.getCtm_lastname());
        ctm_cidLabel.setText(customer.getCtm_cid());

    }


    @FXML
    void recordButton(ActionEvent event) {

        String termStr = termTextField.getText();
        String amountStr = amountTextField.getText();
        String em2IdStr = emp2TextField.getText();
        String witness1 = witness1TextField.getText();
        String witness2 = witness2TextField.getText();

        //typeChoiceBox ??
        String type = String.valueOf(typeChoiceBox.getItems());
        System.out.println(type);






//        if(){
//
//        }else{
//
//        }
    }

    @FXML
    void cancelButton(ActionEvent event) {

    }



    @FXML
    void clickBackToLogin(MouseEvent event) {
        try {
            FXRouter.goTo("emp_home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

}

package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import ku.cs.FXRouter;
import ku.cs.models.Employee;
import ku.cs.models.LoanAgreement;
import ku.cs.models.LoanAgreementList;
import ku.cs.servicesDB.Database;
import ku.cs.servicesDB.LoanAgreement_DBConnect;

import java.io.IOException;

public class EmpInvoiceController {

    @FXML private ListView <String> waitToCreateInvoice;
    @FXML private Label empNameLabel;

    public Employee empLoginAccount;

    //listview
    private LoanAgreementList loanAgreementList = new LoanAgreementList();
    private javafx.collections.ObservableList<String> ObservableList;

    //----------------------------------------------------------------------------
    @FXML
    public void initialize(){
        empLoginAccount = (Employee) FXRouter.getData();
        showEmpLoginData(empLoginAccount);

        //อ่าน database ของ loan Agreement
        Database<LoanAgreement, LoanAgreementList> database = new LoanAgreement_DBConnect();
        String query = " Select * From LoanAgreement Where Loan_balance != 0";
        loanAgreementList = database.readDatabase(query);
        showListView();
    }

    private void showEmpLoginData(Employee empLoginAccount) {
        empNameLabel.setText(empLoginAccount.getEmp_name());
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

    @FXML
    void handleInvoiceButton(ActionEvent event) {
        try {
            FXRouter.goTo("emp_invoice2");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_invoice2 ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}

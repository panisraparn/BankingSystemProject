package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import ku.cs.FXRouter;
import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.models.DocumentTOB;
import ku.cs.models.DocumentTOBList;
import ku.cs.servicesDB.CustomerDBConnect;
import ku.cs.servicesDB.Database;
import ku.cs.servicesDB.DocumentTOBDBConnect;

import java.io.IOException;


public class EmpDocumentController {
    @FXML
    private TextField findCtmCidTextField;

    @FXML
    private Label showFirstnameLabel;

    @FXML
    private Label showLastnameLabel;

    @FXML
    private Label showCtmIdLabel;

    //customer ที่ต้องการ บันทึกเอกสาร
    private Customer dtbForInsertRecord;
    private String ctm_cid; //เลขประจำตัวประชาชนของผู้ที่ต้องการบันทึกเอกสารรายได้



    @FXML
    void findCustomerButton(ActionEvent event) {
        Customer customer = new Customer("0", "0", "0", "0", "0", "0", "0","0","0","0");
        Database<Customer, CustomerList> database = new CustomerDBConnect();
        String q =" Select * FROM customer WHERE Ctm_cid = '"+findCtmCidTextField.getText()+"'  ";
        customer = database.readDatabase(customer,q); //เจอ return record ไม่เจอ return null

        if(findCtmCidTextField.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("กรุณาใส่เลขบัตรประจำตัวประชาชนของลูกค้าที่ต้องการค้นหา");
            alert.showAndWait();
        }else{
            if (customer.getCtm_cid().equals("0")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!!");
                alert.setHeaderText(null);
                alert.setContentText("ไม่พบข้อมูลลูกค้าในระบบโปรดตรวจสอบความถูกต้อง");
                alert.showAndWait();

            }else{
                //for test output return from customer Table
                //        System.out.println(customer.toCsv());

                //setLabel
                showCtmIdLabel.setText(customer.getCtm_Id());
                showFirstnameLabel.setText(customer.getCtm_firstname());
                showLastnameLabel.setText(customer.getCtm_lastname());

                this.dtbForInsertRecord = customer;
                ctm_cid = findCtmCidTextField.getText();
            }


        }




    }

    @FXML
    void recordToDocumentTableButton(ActionEvent event) {
        //* dtb_id ต้องไม่ซ้ำ // dtb_customerId ไม่ซ้ำ

        if(ctm_cid.equals("")){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("กรุณาใส่เลขบัตรประจำตัวประชาชนของลูกค้าที่ต้องการบันทึกเอกสารในช่องค้นหา");
            alert.showAndWait();


        }else{
//            if(){
//
//            }else{
//
//            }if(){
//
//            }else{
//
//            }
//
//            //prepare For generate ctm_id
//
//            DocumentTOB tempDtbChekDtb_id = new DocumentTOB("0",showCtmIdLabel.getText() );
//            DocumentTOB tempDtbCheckDtb_customerID = new DocumentTOB("0",showCtmIdLabel.getText());
//
//            String dtb_idStr = null;
//            String checkDtb_id = "0";
//
//
//            while (checkDtb_id.equals("0")){
//                //random ctm_id 7 digit
//                dtb_idStr = tempDtbChekDtb_id.generateDtb_id();
//
//                // ใช้ Db
//                Database<DocumentTOB, DocumentTOBList> database = new DocumentTOBDBConnect();
//
//
//                //หา dtb_id ในตาราง dtb ที่ตรงกับ dtb_idStr(เลขที่สุ่ม) ถ้า เจอ--> return account ไม่เจอ return null
//                String queryCheckCtm_id = " SELECT * FROM documenttransactionofborrow  WHERE Dtb_id = '"+dtb_idStr+"' ";
//                tempDtbChekDtb_id = database.readDatabase(tempDtbChekDtb_id,queryCheckCtm_id);
//
//                if (tempDtbChekDtb_id == null){ //หาไม่เจอ
//                    checkDtb_id = "1";
//                }else { //หาเจอ
//                    checkDtb_id = "0";
//                }
//            }//while true ให้ generate ctm_id จนกว่าจะไม่ซ้ำ
//
//
//            //check ctm_cid ว่าซ้ำกับที่มีอยู่ไหม ถ้าซ้าเข้า if / ไม่ซ้ำ เข้า else
//            Database<Customer, CustomerList> database1 = new CustomerDBConnect();
//            String queryCheckCtm_cid = " SELECT * FROM customer  WHERE Ctm_cid = '"+findCtmCidTextField.getText()+"' ";
//            tempDtbChekDtb_customerId = database1.readDatabase(tempDtbChekDtb_customerId, queryCheckCtm_cid);
//
//            //มีซ้ำเข้า if (เจอ)
//            // ไม่ซ้ำ else (ไม่เจอ)
//
//            if (tempDtbChekDtb_customerId == null){
//
//                // ใช้ Db
//                Database<DocumentTOB, DocumentTOBList> database2 = new DocumentTOBDBConnect();
//                ctmInsertToDB = new Customer(dtb_idStr,idNumberStr,firstnameStr,lastnameStr,ctmForSetImageView.getCtm_img(),sexCheckBoxStr,phoneNumStr,addressStr,workplaceStr,bankAccNumStr);
//                database2.insertDatabase(ctmInsertToDB);
//
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Error!!");
//                alert.setHeaderText(null);
//                alert.setContentText("ระบบบันทึกข้อมูลลูกค้าสำเร็จ");
//                alert.showAndWait();
//
//                try {
//                    FXRouter.goTo("emp_home");
//                } catch (IOException e) {
//                    System.err.println("ไปที่หน้า menu ไม่ได้");
//                    System.err.println("ให้ตรวจสอบการกำหนด route");
//                }
//
//            }else{
//                clearTextField();
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Error!!");
//                alert.setHeaderText(null);
//                alert.setContentText("ระบบมีฐานข้อมูลของลูกค้ารายนี้แล้ว");
//                alert.showAndWait();
//            }

        }


    }



    @FXML
    void cancelButton(ActionEvent event) {

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

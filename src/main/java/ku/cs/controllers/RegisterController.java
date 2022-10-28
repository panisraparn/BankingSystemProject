package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import ku.cs.FXRouter;
import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.services.CustomerFileDataSource;
import ku.cs.services.DataSource;
import ku.cs.services.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterController {
    @FXML private TextField IdNumberTextField;
    @FXML private TextField firstnameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private ImageView ctmImageView;
    @FXML private CheckBox femaleCheckBox;
    @FXML private CheckBox maleCheckBox;
    @FXML private TextField phoneNumberTextField;
    @FXML private TextField bankAccountNumberTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField workplaceTextField;

    private String sexCheckBoxStr;
    private String ctm_idStr;
    private Customer randomCtm_id;

    //database connect
    Connection con;
    PreparedStatement pst;

    private void clearTextField() {
        randomCtm_id = null;
        IdNumberTextField.setText("");
        firstnameTextField.setText("");
        lastNameTextField.setText("");
        ctmImageView.setImage(null);
        femaleCheckBox.setSelected(false);
        maleCheckBox.setSelected(false);
        phoneNumberTextField.setText("");
        addressTextField.setText("");
        workplaceTextField.setText("");
        bankAccountNumberTextField.setText("");

    }

    @FXML
    void handleBackButton (ActionEvent event){
        JOptionPane.showMessage
    }

    @FXML
    void handleUploadImageButton(ActionEvent event) {

    }

    @FXML
    void handleFemaleCheckBox(ActionEvent event){
        if(femaleCheckBox.isSelected()){
            sexCheckBoxStr = "1"; //female = 1, male = 2
        }
    }

    @FXML
    void handleMaleCheckBox(ActionEvent event){
        if(maleCheckBox.isSelected()){
            sexCheckBoxStr = "2"; //female = 1, male = 2
        }
    }

    @FXML
    void handleRecordButton(ActionEvent event) {


        //เขียนอ่านไฟล์
        DataSource<CustomerList> dataSource = new CustomerFileDataSource();
        CustomerList customers = dataSource.readData();

        //--------------------------------------------------------------------------------------------------------------
        ctm_idStr = randomCtm_id.randCtm_id(); //random ctm_id
        String idNumberStr = IdNumberTextField.getText();
        String firstnameStr = firstnameTextField.getText();
        String lastnameStr = lastNameTextField.getText();


        String phoneNumStr = phoneNumberTextField.getText();
        String bankAccNumStr = bankAccountNumberTextField.getText();
        String addressStr = addressTextField.getText();
        String workplaceStr = workplaceTextField.getText();



        //if text field มีช่องว่าง ให้ alert ถ้าไม่มีช่องว่าง (else) ให้ บันทึก
        if(firstnameStr.equals("") || lastnameStr.equals("") || idNumberStr.equals("") || sexCheckBoxStr.equals("")
                || phoneNumStr.equals("") || bankAccNumStr.equals("") || addressStr.equals("") || workplaceStr.equals("") )
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("Please check your information and try again.");

            alert.showAndWait();
        }

        //มี ctm_id ซ้ำ
        else if (customers.checkCtm_idIsExits(ctm_idStr)){

            while (customers.checkCtm_idIsExits(ctm_idStr)){
                ctm_idStr = randomCtm_id.randCtm_id();
            }//while true ให้ generate ctm_id จนกว่าจะไม่ซ้ำ

        }

        //มีชื่อซ้ำ
        else if (customers.checkFirstAndLastNameIsExits(firstnameStr,lastnameStr)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("ลูกค้าได้ลงทะเบียนลูกค้าไว้แล้ว");

            alert.showAndWait();

        }

        else{

            //insert ข้อมูล ในตาราง customer
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_loansystem","root","");

                pst = con.prepareStatement("insert into customer(Ctm_id, Ctm_cid, Ctm_firstname, Ctm_lastname, Ctm_img, " +
                        "Ctm_sex, Ctm_tel, Ctm_address, Ctm_workplace, Ctm_bankaccount VALUE (?,?,?,?,?,?,?,?,?,?))");

                pst.setString(1, ctm_idStr);
                pst.setString(2, idNumberStr);
                pst.setString(3,firstnameStr);
                pst.setString(4,lastnameStr);
                pst.setString(5,Ctm_img);
                pst.setString(6, sexCheckBoxStr);
                pst.setString(7,phoneNumStr);
                pst.setString(8,addressStr);
                pst.setString(9,workplaceStr);
                pst.setString(10,bankAccNumStr);

                int status = pst.executeUpdate();


                //popup
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!!");
                alert.setHeaderText(null);

                if (status==1)
                {
                    // popup เเจ้งว่า บันทึกข้อมุูลสำเร็จ
                    alert.setContentText("บันทึกข้อมูลลูกค้าสำเร็จ");


                }else {
                    // popup เเจ้งว่า บันทึกข้อมุูลไม่สำเร็จ
                    alert.setContentText("บันทึกข้อมูลลูกค้าไม่สำเร็จ โปรดทำรายการใหม่");

                }
                alert.showAndWait();

            } catch (ClassNotFoundException ex){
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null,ex);
            } catch (SQLException ex){
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null,ex);
            }




            // code เปลี่ยนหน้า --> ไปหน้า Menu
            try {
                System.out.println("menu");
                FXRouter.goTo("menu");
            } catch (IOException e) {
                System.err.println("ไปที่หน้า signup ไม่ได้");
                System.err.println("ให้ตรวจสอบการกำหนด route");
            }
        }

    }

}

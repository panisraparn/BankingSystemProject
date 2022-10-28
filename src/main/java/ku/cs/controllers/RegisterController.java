package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import ku.cs.FXRouter;
import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.services.CustomerFileDataSource;
import ku.cs.services.DataSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
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

    //-------------------------------------------------
    private Customer randomCtm_id; //for set ctm_id
    private Customer customerForSetImagePath;

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
        //ต้องการกลับไป Menu ใช่ไหม
//        JOptionPane.showMessage

        //if ไม่ใช่
        // else ใช่ --> clear text field
        clearTextField();
        //กลับสู่หน้า home view
        // code เปลี่ยนหน้า --> ไปหน้า Menu

//        try {
//            System.out.println("menu");
//            FXRouter.goTo("menu");
//        } catch (IOException e) {
//            System.err.println("ไปที่หน้า signup ไม่ได้");
//            System.err.println("ให้ตรวจสอบการกำหนด route");
//        }
    }


    @FXML
    void handleUploadImageButton(ActionEvent event) {

        FileChooser chooser = new FileChooser();

        // SET FILECHOOSER INITIAL DIRECTORY
        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));

        // DEFINE ACCEPTABLE FILE EXTENSION
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("images PNG JPG", "*.png", "*.jpg", "*.jpeg"));

        // GET FILE FROM FILECHOOSER WITH JAVAFX COMPONENT WINDOW
        Node source = (Node) event.getSource();
        File file = chooser.showOpenDialog(source.getScene().getWindow());

        if (file != null) {
            try {
                // CREATE FOLDER IF NOT EXIST
                File destDir = new File("images");
                if (!destDir.exists()) destDir.mkdirs();

                // RENAME FILE
                String[] fileSplit = file.getName().split("\\.");
                String filename = LocalDate.now() + "_" + System.currentTimeMillis() + "."
                        + fileSplit[fileSplit.length - 1];
                Path target = FileSystems.getDefault().getPath(
                        destDir.getAbsolutePath() + System.getProperty("file.separator") + filename
                );

                // COPY WITH FLAG REPLACE FILE IF FILE IS EXIST
                Files.copy(file.toPath(), target, StandardCopyOption.REPLACE_EXISTING);

                // SET NEW FILE PATH TO IMAGE
                this.ctmImageView.setImage(new Image(target.toUri().toString()));

                //setImagePath
                Customer customerForSetImagePath = new Customer("0", "0", "0", "0","0","0","0","0","0");
                customerForSetImagePath.setCtmImagePath(destDir + "/" + filename);
                this.customerForSetImagePath = customerForSetImagePath;

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void handleFemaleCheckBox(ActionEvent event){
        maleCheckBox.setSelected(false);
        if(femaleCheckBox.isSelected()){
            sexCheckBoxStr = "1"; //female = 1, male = 2
        }
    }

    @FXML
    void handleMaleCheckBox(ActionEvent event){
        femaleCheckBox.setSelected(false); //เมื่อกด check ที่ maleCheckbox ต้อง setSelected(false) เพื่อให้ check ได้แค่กล่องเดียว
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
        randomCtm_id.setCtm_id(); //random ctm_id
        ctm_idStr=randomCtm_id.getCtm_Id();


        String idNumberStr = IdNumberTextField.getText();
        String firstnameStr = firstnameTextField.getText();
        String lastnameStr = lastNameTextField.getText();


        String phoneNumStr = phoneNumberTextField.getText();
        String bankAccNumStr = bankAccountNumberTextField.getText();
        String addressStr = addressTextField.getText();
        String workplaceStr = workplaceTextField.getText();

        //--------------------------------------------------------------------------------------------------------------
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
                randomCtm_id.setCtm_id();
                ctm_idStr=randomCtm_id.getCtm_Id();

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
            //insert ข้อมูล ในตาราง customer Database
            try{

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_loansystem","root","");


                pst = con.prepareStatement("insert into customer(Ctm_id, Ctm_cid, Ctm_firstname, Ctm_lastname, Ctm_img, " +
                        "Ctm_sex, Ctm_tel, Ctm_address, Ctm_workplace, Ctm_bankaccount VALUE (?,?,?,?,?,?,?,?,?,?))");


                pst.setString(1, ctm_idStr);
                pst.setString(2, idNumberStr);
                pst.setString(3,firstnameStr);
                pst.setString(4,lastnameStr);
                pst.setString(5, customerForSetImagePath.getCtm_img());
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
                    //เมื่อบันทึกลงใน database สำเร็จ ให้ record ใน file csv
                    customers.addCustomer(new Customer(ctm_idStr,idNumberStr,firstnameStr,lastnameStr, customerForSetImagePath.getCtm_img(), sexCheckBoxStr, phoneNumStr, addressStr, workplaceStr, bankAccNumStr));









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

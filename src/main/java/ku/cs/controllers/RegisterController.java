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
import java.sql.*;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegisterController {

    @FXML
    private ImageView ctmImageView;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField IdNumberTextField;

    @FXML
    private CheckBox femaleCheckBox;

    @FXML
    private CheckBox maleCheckBox;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField bankAccountNumberTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField workplaceTextField;

    //-------------------------------------------------------------------------------------------------------------------------------------
    private String sexCheckBoxStr; //female = 1, male = 2
    private Customer ctmForSetImageView = new Customer("0");

    //database connect
    Connection conn = null;
    Statement stmt = null;

    //ต่อ database
//    public void Connect(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con  = DriverManager.getConnection("jdbc:mysql://localhost/test_loansystem","root","");
//
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }



    @FXML
    void handleFemaleCheckBox(ActionEvent event) {
        maleCheckBox.setSelected(false);
        if (femaleCheckBox.isSelected()) {
            this.sexCheckBoxStr = "1"; //female = 1, male = 2
        }
    }

    @FXML
    void handleMaleCheckBox(ActionEvent event) {
        femaleCheckBox.setSelected(false); //เมื่อกด check ที่ maleCheckbox ต้อง setSelected(false) เพื่อให้ check ได้แค่กล่องเดียว
        if (maleCheckBox.isSelected()) {
            this.sexCheckBoxStr = "2"; //female = 1, male = 2
        }
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
                ctmForSetImageView.setCtmImagePath(destDir + "/" + filename);
                //System.out.println("Upload: "+accountForSetImagePath.getImagePath());

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void handleRecordButton(ActionEvent event) throws SQLException {

//        Connect();


        //generate ctm_id
        Customer randomCtm_id = new Customer("0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
        String ctm_idStr = randomCtm_id.generateCtm_id();
        System.out.println("ctm_idStr1" + ctm_idStr);

        //เขียนอ่านไฟล์ csv
        DataSource<CustomerList> dataSource = new CustomerFileDataSource();
        CustomerList customers = dataSource.readData();

        //--------------------------------------------------------------------------------------------------------------
        String idNumberStr = IdNumberTextField.getText();
        String firstnameStr = firstnameTextField.getText();
        String lastnameStr = lastNameTextField.getText();
        String phoneNumStr = phoneNumberTextField.getText();
        String bankAccNumStr = bankAccountNumberTextField.getText();
        String addressStr = addressTextField.getText();
        String workplaceStr = workplaceTextField.getText();


        if (firstnameStr.equals("") || lastnameStr.equals("") || idNumberStr.equals("") || sexCheckBoxStr.equals("")
                || phoneNumStr.equals("") || bankAccNumStr.equals("") || addressStr.equals("") || workplaceStr.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("Please check your information and try again.");

            alert.showAndWait();

        } else {
            //ถ้าไม่ได้ upload รูป ให้ alert ว่า ใส่รูปด้วย
            if (ctmForSetImageView.getCtm_img().equals("0")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!!");
                alert.setHeaderText(null);
                alert.setContentText("ใส่รูปของลูกค้าก่อนกดบันทึก");
                alert.showAndWait();

            } else {
                //check ctm_id ว่าซ้ำกับที่มีอยู่ไหม ถ้าซ้าเข้า if ไม่ซ้ำ เข้า else
                if (customers.checkCtm_idIsExits(ctm_idStr)) {
                    System.out.println("เข้าแสดงว่า ctm _ id ซ้ำ");
                    while (customers.checkCtm_idIsExits(ctm_idStr)) {
                        ctm_idStr = randomCtm_id.generateCtm_id();
                    }//while true ให้ generate ctm_id จนกว่าจะไม่ซ้ำ

                } else {
                    //check ctm_cid ว่าซ้ำกับที่มีอยู่ไหม ถ้าซ้าเข้า if ไม่ซ้ำ เข้า else
                    if (customers.checkCtm_CidIsExits(idNumberStr)) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error!!");
                        alert.setHeaderText(null);
                        alert.setContentText("ระบบมีฐานข้อมูลของลูกค้ารายนี้แล้ว");
                        alert.showAndWait();

                    } else {
                        try {

                            
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test_loansystem", "root", "");
                            System.out.println("Connection is created successfully:");
                            stmt = (Statement) conn.createStatement();
                            String query1 = "INSERT INTO customer " + "VALUES ('"+ctm_idStr+"','"+idNumberStr+"','"+firstnameStr+"','"+lastnameStr+"','"+ctmForSetImageView.getCtm_img()+"','"+sexCheckBoxStr+"','"+phoneNumStr+"' ,'"+addressStr+"','"+workplaceStr+"','"+bankAccNumStr+"')";
                            stmt.executeUpdate(query1);
                            System.out.println("Record is inserted in the table successfully..................");
                        } catch (Exception excep) {
                            excep.printStackTrace();
                        } finally {
                            try {
                                if (stmt != null)
                                    conn.close();
                            } catch (SQLException se) {}
                            try {
                                if (conn != null)
                                    conn.close();
                            } catch (SQLException se) {
                                se.printStackTrace();
                            }
                        }
                        System.out.println("Please check it in the MySQL Table......... ……..");
                    }

                        //บันทึกข้อมูลลูกค้า ใน file csv
                        //new customer
                        customers.addCustomer(new Customer(ctm_idStr, idNumberStr, firstnameStr, lastnameStr, ctmForSetImageView.getCtm_img(), sexCheckBoxStr, phoneNumStr, addressStr, workplaceStr, bankAccNumStr));
                        //เขียนไฟล์
                        dataSource.writeData(customers);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error!!");
                        alert.setHeaderText(null);
                        alert.setContentText("ระบบบันทึกข้อมูลลูกค้าสำเร็จ");
                        alert.showAndWait();

                        try {
                            FXRouter.goTo("menu");
                        } catch (IOException e) {
                            System.err.println("ไปที่หน้า menu ไม่ได้");
                            System.err.println("ให้ตรวจสอบการกำหนด route");
                        }
                    }
                }
            }
        }


    @FXML
    void handleBackButton(ActionEvent event) {

        //ต้องการกลับไป Menu ใช่ไหม
        //        JOptionPane.showMessage

        //if ไม่ใช่
        // else ใช่ --> clear text field
        clearTextField();
        //กลับสู่หน้า home view
        // code เปลี่ยนหน้า --> ไปหน้า Menu

        try {
            System.out.println("menu");
            FXRouter.goTo("menu");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า signup ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }

    }

    private void clearTextField() {
        ctmForSetImageView = null;
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
}

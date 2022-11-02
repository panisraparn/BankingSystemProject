package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import ku.cs.FXRouter;

import java.io.IOException;

public class EmpLoanController {
    @FXML
    private ListView<?> borrowerListView;

    @FXML
    private Label FirstnameLabel;

    @FXML
    private Label LastnameLabel;


//    private ProductFileDataSource dataSource;
//    private ProductList products;
//
//    //---------------------------------------------------------------------------------------------------------
//    public Product selectedProduct;   private ProductFileDataSource dataSource;
//    private ProductList products;
//
//    //---------------------------------------------------------------------------------------------------------
//    public Customer selectedCustomer;
//
//    @FXML
//    public void initialize(){
//        //รับ login account
//        loginAccount=(SellerAccount)FXRouter.getData();
//
////        System.out.println((SellerAccount)FXRouter.getData());
////        System.out.println(FXRouter.getData());
////        System.out.println(loginAccount.getStoreName());
//
//        dataSource = new ProductFileDataSource("Data","StockOfProduct.csv");
//        dataSource.readData();
//        dataSource.writeData(products);
//
//        //------------------------------------
//        products = dataSource.getAllProductList();
//
//////        Product product = new Product("username6","store6","room spray",150,20,"300ml");
//        Product productTemp = products.searchStoreName(loginAccount.getStoreName());
//        products.removeProduct(productTemp);
//        dataSource.writeData(products); //เขียนไฟล์ใหม่
//
//        showListview();
//        clearSelectedAccount();
//        handleSelectedListview();
//    }
//
//
//
//    private void showListview() {
//        //ให้ ListView เรียงตามเวลา login ล่าสุด
//        productListView.getItems().addAll(products.getAllProducts());
//        productListView.refresh();
//
//    }
//
//    private void handleSelectedListview() {
//        productListView.getSelectionModel().selectedItemProperty().addListener(
//                new ChangeListener<Product>() {
//                    @Override
//                    public void changed(ObservableValue<? extends Product> observable,
//                                        Product oldValue, Product newValue) {
//                        //System.out.println(newValue + " is selected");
//                        selectedProduct = newValue;
//                        showSelectedAccount(newValue);
//                    }
//                });
//    }


    @FXML
    void handleRecordLoanButton(ActionEvent event) {

    }

    public void clickBackToEmp_home(MouseEvent event) {
        try {
            FXRouter.goTo("emp_home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า emp_home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }




}

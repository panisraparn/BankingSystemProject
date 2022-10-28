package ku.cs.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomerList {

    private  ArrayList<Customer> customers;

    public CustomerList(){
        customers = new ArrayList<>();
    }

    //เพิ่ม customer
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    // เรียกดู all customer
    public ArrayList<Customer> getAllCustomers(){return  customers;}


    // check ctm_id isExits
    public  boolean checkCtm_idIsExits(String ctm_Id){
        for(Customer customer: this.customers){
            if (customer.isDuplicateCtm_Id(ctm_Id)){
                return true;
            }
        }return false; // วน customers แล้วไม่เจอ ctm_id ที่ตรงกัน
    }


    // check firstname and lastname
    public boolean checkFirstAndLastNameIsExits(String firstname, String lastname){
        for(Customer customer: this.customers){
            if(customer.isDuplicateFirstname(firstname) && customer.isDuplicateLastname(lastname)){
                return true;
            }
        }return false; // วน customers แล้วไม่เจอ firstname and lastname ที่ตรงกัน





    }


}

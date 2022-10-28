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
    public ArrayList<Customer> getAllCustomersList(){return  customers;}


    // check ctm_id isExits
    public  boolean checkCtm_idIsExits(String ctm_Id){
        for(Customer customer: this.customers){
            if (customer.isDuplicateCtm_Id(ctm_Id)){
                return true;
            }
        }return false; // วน customers แล้วไม่เจอ ctm_id ที่ตรงกัน
    }

    //checkCtm_cid is exits
    public boolean checkCtm_CidIsExits(String ctm_cid) {
        for(Customer customer: this.customers){
            if (customer.isDuplicateCtm_cid(ctm_cid)){
                return true;
            }
        }return false; // วน customers แล้วไม่เจอ ctm_id ที่ตรงกั
    }


//    public  boolean checkFirstnameIsExits(String firstname){
//        for(Customer customer: this.customers){
//            if(customer.isDuplicateFirstname(firstname)){
//                return true;
//            }
//        }return false; // วน customers แล้วไม่เจอ firstname and lastname ที่ตรงกัน
//    }
//
//    public  boolean checkLastnameIsExits(String lastname){
//        for(Customer customer: this.customers){
//            if(customer.isDuplicateFirstname(lastname)){
//                return true;
//            }
//        }return false; // วน customers แล้วไม่เจอ firstname and lastname ที่ตรงกัน
//    }


    // search ctm_id และให้ return customer ออกมา ถ้าไม่เจอ ctm_id ให้ return null
    public Customer searchCtm_id(String ctm_id){
        for(Customer customer:this.customers){
            if(customer.isCtm_id(ctm_id)){
                return customer;
            }
        }return null;
    }


    public String toCsv() {
        String result = "";
        for (Customer customer : this.customers){
            result += customer.toCsv() + "\n";
        }
        return result;
    }


}

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

    public String toCsv() {
        String result = "";
        for (Customer customer : this.customers){
            result += customer.toCsv() + "\n";
        }
        return result;
    }


}

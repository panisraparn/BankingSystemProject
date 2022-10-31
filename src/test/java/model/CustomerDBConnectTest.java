package model;

import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.servicesDB.CustomerDBConnect;
import ku.cs.servicesDB.Database;
import org.junit.jupiter.api.Test;

public class CustomerDBConnectTest {

    @Test
    void readDatabaseList(){
        CustomerList customerList = new CustomerList();
        Database<Customer, CustomerList> database = new CustomerDBConnect();
        String q =" Select * FROM customer WHERE Ctm_sex = '2' ";
        customerList = database.readDatabase(q);
        System.out.println(customerList.toCsv());
    }



}

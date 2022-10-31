package model;

import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.servicesDB.CustomerDatabaseConnection;
import ku.cs.servicesDB.Database;
import org.junit.jupiter.api.Test;

public class CustomerDatabaseConnectionTest {

    @Test
    void readDatabaseList(){
        CustomerList customerList = new CustomerList();
        Database<Customer, CustomerList> database = new CustomerDatabaseConnection();
        String q =" Select * FROM customer WHERE Ctm_sex = '2' ";
        customerList = database.readDatabase(q);
        System.out.println(customerList.toCsv());
    }
}

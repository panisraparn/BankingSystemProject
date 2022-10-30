package ku.cs.services.Database;

import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.models.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDatabase implements Database<Customer> {


    @Override
    public void insertDatabase(Customer customer) {
        //database connect
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test_loansystem", "root", "");
            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO customer " + "VALUES ('"+customer.getCtm_Id()+"','"+customer.getCtm_cid()+"','"+customer.getCtm_firstname()+"','"+customer.getCtm_lastname()+"','"+customer.getCtm_img()+"','"+customer.getCtm_sex()+"','"+customer.getCtm_tel()+"' ,'"+customer.getCtm_address()+"','"+customer.getCtm_workplace()+"','"+customer.getCtm_bankAccount()+"')";
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

    @Override
    public void readDatabase(Customer customer) {



    }




}

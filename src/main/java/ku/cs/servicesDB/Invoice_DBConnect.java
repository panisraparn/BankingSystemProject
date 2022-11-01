package ku.cs.servicesDB;

import ku.cs.models.*;

import java.sql.*;

public class Invoice_DBConnect implements Database<Invoice, InvoiceList>{

    //database connect
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;

    //prepare for return Receipt  from method readData
    private Invoice invoiceRecord;

    //ใส่ object --> insert ข้อมูลใน table
    @Override
    public void insertDatabase(Invoice invoice) {

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

            String query1 = "INSERT INTO invoice " + "VALUES ('" +invoice.getInvoice_id()+ "','" + invoice.getInvoice_customerId() + "'" +
                    ",'" + invoice.getInvoice_ctmfirstname() + "','" + invoice.getInvoice_ctmlastname() + "','" + invoice.getInvoice_ctmbankAccount() + "'" +
                    ",'" + invoice.getInvoice_ctmDebt() + "','" + invoice.getInvoice_date() + " ', '" +invoice.getInvoice_status()+ "')";

            stmt.executeUpdate(query1);

            System.out.println("Record is inserted in the table successfully..................");

        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Please check it in the MySQL Table......... ……..");

    }

    //ใส่ Object ใส่ query return เป็น class object
    @Override
    public Invoice readDatabase(Invoice invoice, String query) {
        //prepare data
        String id = invoice.getInvoice_id();
        String customerId = invoice.getInvoice_customerId();
        String fname= invoice.getInvoice_ctmfirstname();
        String lname = invoice.getInvoice_ctmlastname();
        String bankAcc = invoice.getInvoice_ctmbankAccount();
        int debt = invoice.getInvoice_ctmDebt();
        String date = invoice.getInvoice_date();
        String status = invoice.getInvoice_status();

        //DB connect
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test_loansystem", "root", "");
            System.out.println("Connection is created successfully:");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                id = rs.getString(1);
                customerId = rs.getNString(2);
                fname = rs.getString(3);
                lname = rs.getString(4);
                bankAcc = rs.getString(5);
                debt = Integer.parseInt(rs.getString(6));
                date = rs.getNString(7);
                status = rs.getString(8);

                this.invoiceRecord = new Invoice(id, customerId, fname, lname, bankAcc, debt, date, status);

//                System.out.println(empLoginAccount.toCsv());
            }
            System.out.println("Account can use from jdbc");
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Please check it in the MySQL Table......... ……..");


        return invoiceRecord;
    }

    //ใส่ query return เป็น list
    @Override
    public InvoiceList readDatabase(String q) {

        InvoiceList list = new InvoiceList();

        //DB connect
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test_loansystem", "root", "");
            System.out.println("Connection is created successfully:");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(q);

            while (rs.next()) {
                String id = rs.getString(1);
                String customerId = rs.getNString(2);
                String fname = rs.getString(3);
                String lname = rs.getString(4);
                String bankAcc = rs.getString(5);
                int debt = Integer.parseInt(rs.getString(6));
                String date = rs.getNString(7);
                String status = rs.getString(8);

                this.invoiceRecord = new Invoice(id, customerId, fname, lname, bankAcc, debt, date, status);
                list.addInvoice(invoiceRecord);
//                System.out.println(empLoginAccount.toCsv());
            }
            System.out.println("list can use from jdbc");
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Please check it in the MySQL Table......... ……..");

        return list;
    }

    //ใส่ query --> update table
    @Override
    public void updateDatabase(String q) { }
}
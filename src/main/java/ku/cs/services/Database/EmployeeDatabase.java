//package ku.cs.services.Database;
//
//import ku.cs.models.Customer;
//import ku.cs.models.Employee;
//
//import java.sql.*;
//
//public class EmployeeDatabase implements Database<Employee> {
//
//    //database connect
//    public Connection conn = null;
//    public Statement stmt = null;
//    public ResultSet rs = null;
//
//    @Override
//    public void insertDatabase(Employee employee) {
//
//    }
//
//    @Override
//    public void readDatabase(Employee employee) {
//        //DB connect
//        try {
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test_loansystem", "root", "");
//            System.out.println("Connection is created successfully:");
//
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery("SELECT Emp_id,Emp_name, Emp_jTitle ,Emp_password FROM employee  WHERE Emp_id = '"+employee.getEmp_id()+"'  AND  Emp_password = '"+employee.getEmp_password()+"'  ");
//
//            while (rs.next()){
//                loginEmpId = rs.getString(1);
//                loginName = rs.getNString(2);
//                loginJtitle = rs.getString(3);
//                loginPassword = rs.getString(4);
//                this.empLoginAccount = new Employee (loginEmpId,loginName,loginJtitle,loginPassword);
//                System.out.println(empLoginAccount.toCsv());
//            }
//            System.out.println("loginAccount can use from jdbc");
//        } catch (Exception excep) {
//            excep.printStackTrace();
//        } finally {
//            try {
//                if (stmt != null)
//                    conn.close();
//            } catch (SQLException se) {}
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//        System.out.println("Please check it in the MySQL Table......... ……..");
//    }
//}

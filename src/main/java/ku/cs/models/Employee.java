package ku.cs.models;

public class Employee {

    private String emp_id;
    private String emp_name;
    private String emp_jTitle;
    private String emp_password;

    //add employee
    public Employee(String emp_id, String emp_name, String emp_jTitle, String emp_password) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_jTitle = emp_jTitle;
        this.emp_password = emp_password;
    }


    public String toCsv() {
        return emp_id + "," + emp_name + "," + emp_jTitle + ","  + emp_password;
    }
}

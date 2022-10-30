package ku.cs.models;

import java.util.Date;

public class LoanAgreement {
    private String loan_id;
    private String loan_customerId;
    private String loan_firstname;
    private String loan_lastname;
    private String loan_type; //รูปแบบเงินกู้
    private int loan_term; //อายุสัญญา
    private Date loan_date; //วันที่ออกสัญญา
    private int loan_balance;//ยอดคงเหลือที่ต้องชำระ
    private int loan_amount;// จำนวนเงินกู้
    private String loan_witness1;
    private String loan_witness2;
    private String loan_Emp1;
    private String loan_Emp2;


    //constructor


    public LoanAgreement(String loan_id, String loan_customerId, String loan_firstname, String loan_lastname, String loan_type, int loan_term, Date loan_date, int loan_balance, int loan_amount, String loan_witness1, String loan_witness2, String loan_Emp1, String loan_Emp2) {
        this.loan_id = loan_id;
        this.loan_customerId = loan_customerId;
        this.loan_firstname = loan_firstname;
        this.loan_lastname = loan_lastname;
        this.loan_type = loan_type;
        this.loan_term = loan_term;
        this.loan_date = loan_date;
        this.loan_balance = loan_balance;
        this.loan_amount = loan_amount;
        this.loan_witness1 = loan_witness1;
        this.loan_witness2 = loan_witness2;
        this.loan_Emp1 = loan_Emp1;
        this.loan_Emp2 = loan_Emp2;
    }


    //setter

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public void setLoan_customerId(String loan_customerId) {
        this.loan_customerId = loan_customerId;
    }

    public void setLoan_firstname(String loan_firstname) {
        this.loan_firstname = loan_firstname;
    }

    public void setLoan_lastname(String loan_lastname) {
        this.loan_lastname = loan_lastname;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public void setLoan_term(int loan_term) {
        this.loan_term = loan_term;
    }

    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }

    public void setLoan_balance(int loan_balance) {
        this.loan_balance = loan_balance;
    }

    public void setLoan_amount(int loan_amount) {
        this.loan_amount = loan_amount;
    }

    public void setLoan_witness1(String loan_witness1) {
        this.loan_witness1 = loan_witness1;
    }

    public void setLoan_witness2(String loan_witness2) {
        this.loan_witness2 = loan_witness2;
    }

    public void setLoan_Emp1(String loan_Emp1) {
        this.loan_Emp1 = loan_Emp1;
    }

    public void setLoan_Emp2(String loan_Emp2) {
        this.loan_Emp2 = loan_Emp2;
    }

    //Getter

    public String getLoan_id() {
        return loan_id;
    }

    public String getLoan_customerId() {
        return loan_customerId;
    }

    public String getLoan_firstname() {
        return loan_firstname;
    }

    public String getLoan_lastname() {
        return loan_lastname;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public int getLoan_term() {
        return loan_term;
    }

    public Date getLoan_date() {
        return loan_date;
    }

    public int getLoan_balance() {
        return loan_balance;
    }

    public int getLoan_amount() {
        return loan_amount;
    }

    public String getLoan_witness1() {
        return loan_witness1;
    }

    public String getLoan_witness2() {
        return loan_witness2;
    }

    public String getLoan_Emp1() {
        return loan_Emp1;
    }

    public String getLoan_Emp2() {
        return loan_Emp2;
    }
}

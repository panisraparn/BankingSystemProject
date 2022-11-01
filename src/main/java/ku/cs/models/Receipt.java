package ku.cs.models;

public class Receipt {
    private String rec_id;
    private String rec_customerId;
    private String rec_date;
    private int rec_payAmt;
    private int rec_balanceLoan;
    private String rec_invoiceId;

   //add Receipt
    public Receipt(String rec_id, String rec_customerId, String rec_date, int rec_payment, int rec_balanceLoan, String rec_invoiceId) {
        this.rec_id = rec_id;
        this.rec_customerId = rec_customerId;
        this.rec_date = rec_date;
        this.rec_payAmt = rec_payment;
        this.rec_balanceLoan = rec_balanceLoan;
        this.rec_invoiceId = rec_invoiceId;
    }

    //setter

    public void setRec_id(String rec_id) {
        this.rec_id = rec_id;
    }

    public void setRec_customerId(String rec_customerId) {
        this.rec_customerId = rec_customerId;
    }

    public void setRec_date(String rec_date) {
        this.rec_date = rec_date;
    }

    public void setRec_payAmt(int rec_payAmt) {
        this.rec_payAmt = rec_payAmt;
    }

    public void setRec_balanceLoan(int rec_balanceLoan) {
        this.rec_balanceLoan = rec_balanceLoan;
    }

    public void setRec_invoiceId(String rec_invoiceId) {
        this.rec_invoiceId = rec_invoiceId;
    }

    //getter

    public String getRec_id() {
        return rec_id;
    }

    public String getRec_customerId() {
        return rec_customerId;
    }

    public String getRec_date() {
        return rec_date;
    }

    public int getRec_payAmt() {
        return rec_payAmt;
    }

    public int getRec_balanceLoan() {
        return rec_balanceLoan;
    }

    public String getRec_invoiceId() {
        return rec_invoiceId;
    }

    public String toCsv(){
        return rec_id +","+ rec_customerId +","+ rec_date +","+ rec_payAmt +","
                + rec_balanceLoan +","+ rec_invoiceId;
    }
}

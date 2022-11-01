package ku.cs.models;

public class Invoice {
    private String invoice_id;
    private String invoice_customerId;
    private String invoice_ctmfirstname;
    private String invoice_ctmlastname;
    private String invoice_ctmbankAccount;
    private int invoice_ctmDebt;
    private String invoice_date;
    private String invoice_status;

    //add invoice
    public Invoice(String invoice_id, String invoice_customerId, String invoice_ctmfirstname, String invoice_ctmlastname,
                   String invoice_ctmbankAccount, int invoice_ctmDebt, String invoice_date, String invoice_status) {

        this.invoice_id = invoice_id;
        this.invoice_customerId = invoice_customerId;
        this.invoice_ctmfirstname = invoice_ctmfirstname;
        this.invoice_ctmlastname = invoice_ctmlastname;
        this.invoice_ctmbankAccount = invoice_ctmbankAccount;
        this.invoice_ctmDebt = invoice_ctmDebt;
        this.invoice_date = invoice_date;
        this.invoice_status = invoice_status;
    }

    //setter
    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public void setInvoice_customerId(String invoice_customerId) {
        this.invoice_customerId = invoice_customerId;
    }

    public void setInvoice_ctmfirstname(String invoice_ctmfirstname) {
        this.invoice_ctmfirstname = invoice_ctmfirstname;
    }

    public void setInvoice_ctmlastname(String invoice_ctmlastname) {
        this.invoice_ctmlastname = invoice_ctmlastname;
    }

    public void setInvoice_ctmbankAccount(String invoice_ctmbankAccount) {
        this.invoice_ctmbankAccount = invoice_ctmbankAccount;
    }

    public void setInvoice_ctmDebt(int invoice_ctmDebt) {
        this.invoice_ctmDebt = invoice_ctmDebt;
    }

    public void setInvoice_date(String invoice_date) {
        this.invoice_date = invoice_date;
    }

    public void setInvoice_status(String invoice_status) {
        this.invoice_status = invoice_status;
    }

    //getter
    public String getInvoice_id() {
        return invoice_id;
    }

    public String getInvoice_customerId() {
        return invoice_customerId;
    }

    public String getInvoice_ctmfirstname() {
        return invoice_ctmfirstname;
    }

    public String getInvoice_ctmlastname() {
        return invoice_ctmlastname;
    }

    public String getInvoice_ctmbankAccount() {
        return invoice_ctmbankAccount;
    }

    public int getInvoice_ctmDebt() {
        return invoice_ctmDebt;
    }

    public String getInvoice_date() {
        return invoice_date;
    }

    public String getInvoice_status() {
        return invoice_status;
    }

    public String toCsv() {
        return invoice_id +","+ invoice_customerId +","+ invoice_ctmfirstname +","+ invoice_ctmlastname +","+
                invoice_ctmbankAccount +","+ invoice_ctmDebt +","+invoice_status;
    }


}

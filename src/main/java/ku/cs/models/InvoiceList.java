package ku.cs.models;

import java.util.ArrayList;

public class InvoiceList {

    public ArrayList<Invoice> invoices;

    //constructor
    public InvoiceList() { this.invoices = new ArrayList<>(); }


    //เพิ่ม invoice
    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }

    public String toCsv(){
        String result = "";
        for(Invoice invoice : this.invoices){
            result += invoice.toCsv() + "\n";
        }
        return result;
    }




}

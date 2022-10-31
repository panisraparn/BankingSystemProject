package ku.cs.models;

import java.util.Date;

public class DocumentTransactionOfBorrow {

    private String Dtb_id;
    private String Dtb_customerId;
    private String Dtb_document1;
    private String Dtb_document2;
    private String Dtb_document3;
    private String Dtb_document4;
    private Date Dtb_date;
    private  String Dtb_status;

    //add DocumentTrans
    public DocumentTransactionOfBorrow(String dtb_id, String dtb_customerId, String dtb_document1, String dtb_document2, String dtb_document3, String dtb_document4, Date dtb_date, String dtb_status) {
        Dtb_id = dtb_id;
        Dtb_customerId = dtb_customerId;
        Dtb_document1 = dtb_document1;
        Dtb_document2 = dtb_document2;
        Dtb_document3 = dtb_document3;
        Dtb_document4 = dtb_document4;
        Dtb_date = dtb_date;
        Dtb_status = dtb_status;
    }












}

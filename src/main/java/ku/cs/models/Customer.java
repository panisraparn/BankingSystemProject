package ku.cs.models;

import java.util.Random;

public class Customer {
    private String ctm_Id;
    private String ctm_cid;
    private String ctm_firstname;
    private String ctm_lastname;
    private String ctm_img;
    private String ctm_sex;
    private String ctm_tel;
    private String ctm_address;
    private String ctm_workplace;
    private String ctm_bankAccount;

    //new user
    public Customer(String ctm_cid, String ctm_firstname, String ctm_lastname, String ctm_img, String ctm_sex,
                    String ctm_tel, String ctm_address, String ctm_workplace, String ctm_bankAccount)
    {
        this.ctm_Id = randCtm_id();
        this.ctm_cid = ctm_cid;
        this.ctm_firstname = ctm_firstname;
        this.ctm_lastname = ctm_lastname;
        this.ctm_img = ctm_img;
        this.ctm_sex = ctm_sex;
        this.ctm_tel = ctm_tel;
        this.ctm_address = ctm_address;
        this.ctm_workplace = ctm_workplace;
        this.ctm_bankAccount = ctm_bankAccount;


    }

    //random Ctm_id 7 digits
    public String randCtm_id(){
        Random rand = new Random();
        int digit7 = rand.nextInt(9999999);
        String randCtm_idStr = String.format("%7d",digit7);
        return randCtm_idStr;
    }

    //check firstname ซ้ำ
    public boolean isDuplicateFirstname(String ctm_firstname){
        return this.ctm_firstname.equals(ctm_firstname);
    }

    //check lastname ซ้ำ
    public boolean isDuplicateLastname(String ctm_lastname){
        return this.ctm_lastname.equals(ctm_lastname);
    }
    public boolean isDuplicateCtm_Id(String ctm_Id) {
        return this.ctm_Id.equals(ctm_Id);
    }

    @Override
    public String toString(){
        return ctm_Id + "," + ctm_cid + "," + ctm_firstname + "," + ctm_lastname + ","+ ctm_img + ","
                + ctm_sex + "," + ctm_tel + "," + ctm_address + "," + ctm_workplace + "," + ctm_bankAccount;
    }



}

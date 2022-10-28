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

    //ใช้ตอน test กับ setCtmImagePath ใน
    public Customer(String ctm_cid, String ctm_firstname, String ctm_lastname, String ctm_img, String ctm_sex,
                    String ctm_tel, String ctm_address, String ctm_workplace, String ctm_bankAccount)
    {
        this.ctm_cid = ctm_cid;
        this.ctm_firstname = ctm_firstname;
        this.ctm_lastname = ctm_lastname;
        this.ctm_img = "images/Profile_icon.jpg" ;
        this.ctm_sex = ctm_sex;
        this.ctm_tel = ctm_tel;
        this.ctm_address = ctm_address;
        this.ctm_workplace = ctm_workplace;
        this.ctm_bankAccount = ctm_bankAccount;
    }
    //new user
    public Customer(String ctm_idStr, String idNumberStr, String firstnameStr, String lastnameStr, String ctm_img, String sexCheckBoxStr, String phoneNumStr, String addressStr, String workplaceStr, String bankAccNumStr) {
    }


    //random Ctm_id 7 digits
    public void setCtm_id(){
        Random rand = new Random();
        int digit7 = rand.nextInt(9999999);
        String randCtm_idStr = String.format("%7d",digit7);
        this.ctm_Id =randCtm_idStr;
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

    //set รูป(imagePath) UserDefault กรณีที่ register แล้ว user ไม่ upload รูป
    public void setCtmImagePath () {
        this.ctm_img = "images/Profile_icon.jpg";
    }


    //set รูป(imagePath) กรณีที่ user กดปุ่ม อัพโหลดรูป
    public  void setCtmImagePath(String imagePath){
        this.ctm_img = imagePath;
    }


    public String getCtm_Id() {
        return ctm_Id;
    }

    public String getCtm_cid() {
        return ctm_cid;
    }

    public String getCtm_firstname() {
        return ctm_firstname;
    }

    public String getCtm_lastname() {
        return ctm_lastname;
    }

    public String getCtm_img() {
        return ctm_img;
    }

    public String getCtm_sex() {
        return ctm_sex;
    }

    public String getCtm_tel() {
        return ctm_tel;
    }

    public String getCtm_address() {
        return ctm_address;
    }

    public String getCtm_workplace() {
        return ctm_workplace;
    }

    public String getCtm_bankAccount() {
        return ctm_bankAccount;
    }

    @Override
    public String toString(){
        return ctm_Id + "," + ctm_cid + "," + ctm_firstname + "," + ctm_lastname + ","+ ctm_img + ","
                + ctm_sex + "," + ctm_tel + "," + ctm_address + "," + ctm_workplace + "," + ctm_bankAccount;
    }



}

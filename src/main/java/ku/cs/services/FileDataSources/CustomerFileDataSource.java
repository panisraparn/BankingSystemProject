package ku.cs.services.FileDataSources;

import ku.cs.models.Customer;
import ku.cs.models.CustomerList;

import java.io.*;

public class CustomerFileDataSource implements DataSource<CustomerList> {

    private String directoryName;
    private String filename;

    private CustomerList customers = new CustomerList();

    public CustomerFileDataSource(){

        //directoryName = "csv-data"; //directory จริง ชื่อว่า csv-data
        //fileName = "weapon.csv"; //fileName ที่ทำงานกับ WeaponList
        //มีoverload constructor --> ใช้ chain
        //production file
        this("Data","Customer.csv");
    }

    //for test
    public CustomerFileDataSource(String directoryName, String filename){
        this.directoryName =directoryName;
        this.filename = filename;
        initialFileNotExist();

    }

    private void initialFileNotExist() {
        File file = new File(directoryName);

        if(!file.exists()){ //ถ้า directory ไม่มีอยู่ให้สร้าง
            file.mkdir();
        }
        //check file --> ต้องการ path
        String path = directoryName+File.separator+filename;

        file = new File(path); //ชื่อ file.csv

        //ถ้าไม่มี file ให้สร้าง file
        if(!file.exists()){
            try {
                file.createNewFile();

            } catch (IOException e) { e.printStackTrace(); }
        }
    }

    @Override
    public void writeData(CustomerList customerList) {
        //วีธีการเขียน สมมติว่า รับ AccountList มา --> เราจะเขียนข้อมูลทั้งหมด ใน AccountList เลย

        String path = directoryName + File.separator + filename;
        File file = new File(path);

        FileWriter writer = null;
        BufferedWriter buffer = null;
        // ป้องกันการเกิด Exception
        try {
            writer = new FileWriter(file);
            buffer = new BufferedWriter(writer);

            buffer.write(customerList.toCsv());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public CustomerList readData() {
        String path = "Data"+File.separator+"Customer.csv";
        File file = new File(path);

        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);

            String line = "";
            while( (line = buffer.readLine()) != null){

                String[] data = line.split(",");
                if(data.length == 10){
                    customers.addCustomer(new Customer(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[4],
                            data[5],
                            data[6],
                            data[7],
                            data[8],
                            data[9]
                    ));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public CustomerList getAllCustomerList(){
        return customers;
    }


}

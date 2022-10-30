package ku.cs.services.FileDataSources;

import ku.cs.models.Employee;
import ku.cs.models.EmployeeList;

import java.io.*;

public class EmployeeFileDataSource implements DataSource<EmployeeList> {

    private String directoryName;
    private String filename;

    private EmployeeList employees = new EmployeeList();

    public EmployeeFileDataSource(String directoryName, String filename) {
        this.directoryName = directoryName;
        this.filename = filename;
        initialFileNotExist();
    }

    public EmployeeFileDataSource() {
        this("Data","Employee.csv");
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
    public void writeData(EmployeeList employeeList) {
        //วีธีการเขียน สมมติว่า รับ AccountList มา --> เราจะเขียนข้อมูลทั้งหมด ใน AccountList เลย

        String path = directoryName + File.separator + filename;
        File file = new File(path);

        FileWriter writer = null;
        BufferedWriter buffer = null;
        // ป้องกันการเกิด Exception
        try {
            writer = new FileWriter(file);
            buffer = new BufferedWriter(writer);

            buffer.write(employeeList.toCsv());

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
    public EmployeeList readData() {
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
                if(data.length == 4){
                    employees.addEmployee(new Employee(
                            data[0],
                            data[1],
                            data[2],
                            data[3]
                    ));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}

package ku.cs.servicesDB;

import ku.cs.models.Customer;
import ku.cs.models.Employee;

public interface Database<T> {

    void insertDatabase(T t);

    //ใส่ Object ใส่ query return เป็น class object
    T readDatabase(T t,String query);


}

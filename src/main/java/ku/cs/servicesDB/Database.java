package ku.cs.servicesDB;

import ku.cs.models.Customer;
import ku.cs.models.Employee;

import java.util.ArrayList;

public interface Database<T, C> {

    void insertDatabase(T t);

    //ใส่ Object ใส่ query return เป็น class object
    T readDatabase(T t,String query);

    C readDatabase(String q);
}

package ku.cs.services.Database;

import ku.cs.models.Customer;
import ku.cs.models.Employee;

public interface Database<T> {
    void insertDatabase(T t);

    void readDatabase(T t);


}

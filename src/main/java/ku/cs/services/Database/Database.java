package ku.cs.services.Database;

import ku.cs.models.Employee;

public interface Database<T> {
    void insertDatabase(T t);

    T readDatabase(T t);

}

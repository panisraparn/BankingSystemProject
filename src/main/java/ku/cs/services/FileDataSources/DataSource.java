package ku.cs.services.FileDataSources;

public interface DataSource<T> {

    void writeData(T t);
    T readData();

}

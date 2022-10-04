package repository;

import entity.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public abstract class Repository<T> {
    protected Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/freedom", "root", "Berkelium*97");
    }
    public abstract List<T> getList();
    public abstract T getById(Integer id);
    public abstract T insert(Teacher teacher);
    public abstract boolean update(Teacher teacher);
    public  abstract boolean delete(Integer id);
}

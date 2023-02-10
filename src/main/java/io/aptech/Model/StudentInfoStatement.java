package io.aptech.Model;

import io.aptech.Entity.Student;
import io.aptech.Generic.DAORepository;
import javafx.collections.ObservableList;

import java.sql.Connection;

public class StudentInfoStatement implements DAORepository<Student> {
    private static final Connection connect = MySqlConnection.getConnection();

    @Override
    public void insert(Student studentInfo) {
        try {

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student studentInfo) {

    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public void remove(Student studentInfo) {

    }

    @Override
    public ObservableList<Student> getAll() {
        return null;
    }
}

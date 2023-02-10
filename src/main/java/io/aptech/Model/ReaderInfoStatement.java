package io.aptech.Model;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import io.aptech.Entity.Reader;
import io.aptech.Entity.Student;
import io.aptech.Generic.DAORepository;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReaderInfoStatement implements DAORepository<Reader> {
    private static final Connection connect = MySqlConnection.getConnection();

    public static ReaderInfoStatement getSatement(){
        return new ReaderInfoStatement();
    }

    @Override
    public void insert(Reader rd) {
        try {
            String sql = "INSERT INTO `reader`(reader_name, reader_phone, reader_address, reader_cid)" +
                    "VALUES(?,?,?,?)";
            PreparedStatement st = connect.prepareStatement(sql);
            st.setString(1, rd.getReader_name());
            st.setString(2, rd.getReader_phone());
            st.setString(3, rd.getReader_address());
            st.setString(4, rd.getReader_cid());
            st.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Reader rd) {

    }

    @Override
    public Reader getById(int id) {
        return null;
    }

    @Override
    public void remove(Reader rd) {

    }

    @Override
    public ObservableList<Reader> getAll() {
        return null;
    }
}

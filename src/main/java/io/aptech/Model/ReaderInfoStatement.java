package io.aptech.Model;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import io.aptech.Entity.Book;
import io.aptech.Entity.Reader;
import io.aptech.Generic.DAORepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReaderInfoStatement implements DAORepository<Reader> {
    private static final Connection connect = MySqlConnection.getConnection();

    @Override
    public void insert(Reader rd) {
        System.out.println(rd.toString());
        try {
            String sql = "INSERT INTO `reader`(reader_name, reader_phone, reader_address, reader_cid, reader_code)" +
                    "VALUES(?,?,?,?,?)";
            PreparedStatement st = connect.prepareStatement(sql);
            st.setString(1, rd.getReader_name());
            st.setString(2, rd.getReader_phone());
            st.setString(3, rd.getReader_address());
            st.setString(4, rd.getReader_cid());
            st.setString(5, rd.getReader_code());
            st.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Reader rd) {
        try {
            String sql = "UPDATE `reader` set `reader_name`=?, `reader_phone`=?, `reader_address`=?, `reader_cid`=?, `reader_code`=? WHERE `id` = ?";
            PreparedStatement st = connect.prepareStatement(sql);
            st.setString(1, rd.getReader_name());
            st.setString(2, rd.getReader_phone());
            st.setString(3, rd.getReader_address());
            st.setString(4, rd.getReader_cid());
            st.setString(5, rd.getReader_code());
            st.setInt(6, rd.getReader_id());
            st.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Reader getById(int id) {
        return null;
    }

    @Override
    public void remove(Reader rd) {
        try {
            String sql = "DELETE FROM `reader` WHERE `id` = ?";
            PreparedStatement st = connect.prepareStatement(sql);
            st.setInt(1, rd.getReader_id());
            st.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Reader> getAll() {
        ObservableList<Reader> readers = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * from `reader`";
            PreparedStatement st = connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("id"));
                reader.setReader_name(rs.getString("reader_name"));
                reader.setReader_phone(rs.getString("reader_phone"));
                reader.setReader_address(rs.getString("reader_address"));
                reader.setReader_cid(rs.getString("reader_cid"));
                reader.setReader_code(rs.getString("reader_code"));
                readers.add(reader);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return readers;
    }

//    public Book[] getBookBorrowingByID(int id){
//        List<Book> books = new ArrayList<>();
//        try {
//            String sql = "SELECT * from `reader` join `borrow` on reader.id = borrow.reader_id";
//            PreparedStatement st = connect.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while(rs.next()){
//                Reader reader = new Reader();
//                reader.setReader_id(rs.getInt("id"));
//                reader.setReader_name(rs.getString("reader_name"));
//                reader.setReader_phone(rs.getString("reader_phone"));
//                reader.setReader_address(rs.getString("reader_address"));
//                reader.setReader_cid(rs.getString("reader_cid"));
//                readers.add(reader);
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return readers;
//    }
}

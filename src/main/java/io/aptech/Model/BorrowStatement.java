package io.aptech.Model;

import io.aptech.Entity.Author;
import io.aptech.Entity.Borrow;
import io.aptech.Entity.Reader;
import io.aptech.Generic.DAORepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowStatement implements DAORepository<Borrow> {
    private static final Connection connection = MySqlConnection.getConnection();

    @Override
    public void insert(Borrow borrow) {
        try {
            String sql= "INSERT INTO borrow(reader_id, payment) VALUES (?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, borrow.getReader().getReader_id());
            pst.setFloat(2, borrow.getPayment());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Borrow borrow) {
        try {
            String sql = "UPDATE borrow SET payment = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setFloat(1, Float.parseFloat(String.valueOf(borrow.getPayment())));
            pst.setInt(2, borrow.getBorrow_id());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Borrow getById(int id) {
        return null;
    }

    @Override
    public void remove(Borrow borrow) {

    }

    @Override
    public ObservableList<Borrow> getAll() {
        ObservableList<Borrow> borrows = FXCollections.observableArrayList();
        try {
            String sql = "select * from borrow join reader on borrow.reader_id = reader.id";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Borrow borrow = new Borrow();
                borrow.setBorrow_id(rs.getInt("id"));
                borrow.setPayment(rs.getFloat("payment"));

                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("reader_id"));
                reader.setReader_code(rs.getString("reader_code"));
                reader.setReader_name(rs.getString("reader_name"));
                reader.setReader_phone(rs.getString("reader_phone"));
                reader.setReader_address(rs.getString("reader_address"));
                reader.setReader_cid(rs.getString("reader_cid"));

                borrow.setReader(reader);
                borrows.add(borrow);
            }
            rs.close();
            pst.close();
        } catch (Exception e) { e.printStackTrace();
        }
        return borrows;
    }

    public int getLastInsertID(){
        int id = 0;
        try {
            String sql = "select LAST_INSERT_ID()";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            id = rs.getInt(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
}

package io.aptech.Model;

import io.aptech.Entity.Book;
import io.aptech.Entity.Borrow;
import io.aptech.Entity.BorrowDetail;
import io.aptech.Entity.Reader;
import io.aptech.Generic.DAORepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class BorrowDetailStatement implements DAORepository<BorrowDetail> {
    private static final Connection connection = MySqlConnection.getConnection();

    @Override
    public void insert(BorrowDetail borrowDetail) {
        System.out.println(borrowDetail.toString());
        try {
            String sql= "INSERT INTO borrowdetail(book_id, borrow_id, note, borrow_date, return_date, status) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, borrowDetail.getBook().getBook_id());
            pst.setInt(2, borrowDetail.getBorrow().getBorrow_id());
            pst.setString(3, borrowDetail.getNote());
            pst.setDate(4, borrowDetail.getBorowDate());
            pst.setDate(5,  borrowDetail.getReturnDate());
            pst.setString(6, String.valueOf(borrowDetail.getStatus()));
            System.out.println(pst.toString());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(BorrowDetail borrowDetail) {
        try {
            String sql = "UPDATE borrowdetail set return_date = ?, status = ?, note=? where id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setDate(1, borrowDetail.getReturnDate());
            pst.setString(2, borrowDetail.getStatus());
            pst.setString(3, borrowDetail.getNote());
            pst.setInt(4, borrowDetail.getId());
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public BorrowDetail getById(int id) {
        return null;
    }

    @Override
    public void remove(BorrowDetail borrowDetail) {

    }

    @Override
    public ObservableList<BorrowDetail> getAll() {
        ObservableList<BorrowDetail> borrowDetails = FXCollections.observableArrayList();
        try {
            String sql = "select * from borrowdetail brd inner join borrow br on brd.borrow_id = br.id\n" +
                    "inner join book b on brd.book_id = b.id\n" +
                    "inner join reader r on r.id = br.reader_id;";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Reader r = new Reader();
                r.setReader_id(rs.getInt("r.id"));
                r.setReader_name(rs.getString("reader_name"));
                r.setReader_code(rs.getString("reader_code"));
                r.setReader_phone(rs.getString("reader_phone"));
                r.setReader_address(rs.getString("reader_address"));
                r.setReader_cid(rs.getString("reader_cid"));

                Book b = new Book();
                b.setBook_id(rs.getInt("b.id"));
                b.setBook_name(rs.getString("book_name"));
                b.setBook_price(rs.getFloat("book_price"));
                b.setBook_code(rs.getString("book_code"));
                b.setBook_status(rs.getString("book_status"));
                b.setBook_description(rs.getString("book_description"));

                Borrow br = new Borrow();
                br.setBorrow_id(rs.getInt("br.id"));
                br.setReader(r);
                br.setPayment(rs.getFloat("payment"));

                BorrowDetail brd = new BorrowDetail();
                brd.setId(rs.getInt("brd.id"));
                brd.setNote(rs.getString("note"));
                brd.setBorowDate(rs.getDate("borrow_date"));
                brd.setReturnDate(rs.getDate("return_date"));
                brd.setStatus(rs.getString("status"));
                brd.setBorrow(br);
                brd.setBook(b);

                borrowDetails.add(brd);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return borrowDetails;
    }
}

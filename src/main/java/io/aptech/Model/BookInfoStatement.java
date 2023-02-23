package io.aptech.Model;

import io.aptech.Entity.Book;
import io.aptech.Generic.DAORepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInfoStatement implements DAORepository<Book> {
    private static final Connection connection = MySqlConnection.getConnection();


    @Override
    public void insert(Book book) {
        try {
            String sql= "INSERT INTO book(`book_name`,`book_price`,`book_description`,`book_img`,`book_status`,`cat_id`,`author_id`,`publisher_id`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, book.getBook_name());
            pst.setFloat(2, book.getBook_price());
            pst.setString(3, book.getBook_description());
            pst.setString(4,book.getBook_image());
            pst.setString(5, book.getBook_status());
            pst.setInt(6, book.getCategory().getCat_id());
            pst.setInt(7,book.getAuthor().getAu_id());
            pst.setInt(8,book.getPublisher().getPus_id());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public void remove(Book book) {

    }

    @Override
    public ObservableList<Book> getAll() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        try {
            String sql = "select * from book where 1";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt( "id"));
                book.setBook_name(rs.getString(  "book_name"));
                book.setBook_price (rs.getFloat(  "book_price") );
                book.setBook_description (rs.getString( "book_description"));
                book.setBook_image (rs.getString( "book_image"));
                book.setBook_status (rs.getString( "book_status"));
                book.getCategory().setCat_id(rs.getInt( "cat_id"));
                book.getAuthor().setAu_id(rs.getInt( "author_id"));
                book.getPublisher().setPus_id(rs.getInt( "publisher_id"));
                books.add( book);
            }
            rs.close();
            pst.close();
        } catch (Exception e) { e.printStackTrace();
        }
        return books;

    }
}

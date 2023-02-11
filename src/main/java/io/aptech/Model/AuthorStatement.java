package io.aptech.Model;

import io.aptech.Entity.Author;
import io.aptech.Generic.DAORepository;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorStatement implements DAORepository<Author> {
    private static final Connection connection = MySqlConnection.getConnection();

    @Override
    public void insert(Author author) {
        try {
            String sql= "INSERT INTO author(au_name) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, book.getBook_name());
            pst.setFloat(2, book.getBook_price());
            pst.setString(3, book.getBook_description());
            pst.setString(4,book.getBook_image());
            pst.setString(5, book.getBook_quantity());
            pst.setInt(6, book.getCategory().getCat_id());
            pst.setInt(7,book.getAuthor().getAu_id());
            pst.setInt(8,book.getPublisher().getPus_id());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public Author getById(int id) {
        return null;
    }

    @Override
    public void remove(Author author) {

    }

    @Override
    public ObservableList<Author> getAll() {
        return null;
    }
}

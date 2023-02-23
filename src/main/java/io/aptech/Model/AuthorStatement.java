package io.aptech.Model;

import io.aptech.Entity.Author;
import io.aptech.Entity.Book;
import io.aptech.Entity.Category;
import io.aptech.Generic.DAORepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorStatement implements DAORepository<Author> {
    private static final Connection connection = MySqlConnection.getConnection();

    @Override
    public void insert(Author author) {
        try {
            String sql= "INSERT INTO author(au_name,au_description) VALUES (?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, author.getAu_name());
            pst.setString(2, author.getAu_description());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Author author) {
        try {
            String sql = "UPDATE author SET au_name =?,au_description =? WHERE id =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, author.getAu_name());
            pst.setString(2, author.getAu_description());
            pst.setInt(3, author.getAu_id());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Author getById(int id) {
        return null;
    }

    @Override
    public void remove(Author author) {
        try {
            String sql = "DELETE FROM author WHERE id =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, author.getAu_id());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Author> getAll() {
        ObservableList<Author> authors = FXCollections.observableArrayList();
        try {
            String sql = "select * from author where 1";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Author author = new Author();
                author.setAu_id(rs.getInt( "id"));
                author.setAu_name(rs.getString(  "au_name"));
                author.setAu_description (rs.getString(  "au_description") );
                authors.add( author);
            }
            rs.close();
            pst.close();
        } catch (Exception e) { e.printStackTrace();
        }
        return authors;
    }
    public static ObservableList<Author> searchByKeyword(String key){
        ObservableList<Author> authors = FXCollections.observableArrayList();

        try {
            String keyword = key.replace(" ","%");
            String sql = "SELECT id,au_name"+
                    ",au_description"+
                    " FROM author"+
                    " WHERE au_name LIKE '%" + keyword + "%' ";
            System.out.println(sql);
            PreparedStatement pts = connection.prepareStatement(sql);
            ResultSet rs = pts.executeQuery();
            while (rs.next()) {
                Author author = new Author();
                author.setAu_id(rs.getInt("id"));

                author.setAu_name(rs.getString("au_name"));
                author.setAu_description(rs.getString("au_description"));
                authors.add(author);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return authors;
    }
}

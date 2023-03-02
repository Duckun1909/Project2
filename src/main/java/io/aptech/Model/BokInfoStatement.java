package io.aptech.Model;

import io.aptech.Entity.Author;
import io.aptech.Entity.Book;
import io.aptech.Entity.Category;
import io.aptech.Entity.Publisher;
import io.aptech.Generic.DAORepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BokInfoStatement implements DAORepository<Book> {
    private static final Connection connection = MySqlConnection.getConnection();

    @Override
    public void insert(Book book) {
        try {

            String sql= "INSERT INTO book(book_name,book_price,book_description,book_status,cat_id,author_id,pushlisher_id,book_code) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, book.getBook_name());
            pst.setFloat(2, book.getBook_price());
            pst.setString(3, book.getBook_description());
            pst.setString(4, String.valueOf(book.getBook_status()));
            pst.setInt(5, book.getCategory().getCat_id());
            pst.setInt(6, book.getAuthor().getAu_id());
            System.out.println();
            pst.setInt(7, book.getPublisher().getPus_id());
            pst.setString(8, book.getBook_code());
            pst.executeUpdate();
            System.out.println(pst.toString());
            System.out.println(sql);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {
        System.out.println(book.getAuthor().getAu_id());
        try {
            String sql = "UPDATE book SET book_name =?,book_price =?,book_description=?,book_status=?,book_code=?,cat_id=?,pushlisher_id=?,author_id=? WHERE id =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, book.getBook_name());
            pst.setFloat(2, book.getBook_price());
            pst.setString(3, book.getBook_description());
            pst.setString(4, String.valueOf(book.getBook_status()));
            pst.setString(5, book.getBook_code());
            pst.setInt(6, book.getCategory().getCat_id());
            pst.setInt(7, book.getPublisher().getPus_id());
            pst.setInt(8, book.getAuthor().getAu_id());
            pst.setInt(9, book.getBook_id());

            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public void remove(Book book) {
        try {
            String sql = "DELETE FROM book WHERE id =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, book.getBook_id());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Book> getAll() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        try {
            String sql = "select * from book inner join category on book.cat_id = category.id inner join publisher on book.pushlisher_id = publisher.id inner join author on book.author_id = author.id";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Category category = new Category();
                category.setCat_id(rs.getInt( "cat_id"));
                category.setCat_name(rs.getString( "cat_name"));
                category.setCat_description(rs.getString( "cat_description"));
                category.setCat_code(rs.getString( "cat_code"));

                Publisher publisher = new Publisher();
                publisher.setPus_id(rs.getInt( "pushlisher_id"));
                publisher.setPus_name(rs.getString( "pus_name"));
                publisher.setPus_email(rs.getString( "pus_email"));
                publisher.setPus_web(rs.getString( "pus_web"));
                publisher.setPus_address(rs.getString( "pus_address"));

                Author author = new Author();
                author.setAu_id(rs.getInt( "author_id" ));
                author.setAu_name(rs.getString( "au_name"));
                author.setAu_description(rs.getString( "au_description"));

                Book book = new Book();
                book.setBook_id(rs.getInt( "id"));
                book.setBook_name(rs.getString( "book_name"));
                book.setBook_price (rs.getFloat(  "book_price") );
                book.setBook_description(rs.getString(  "book_description"));
                book.setBook_status(rs.getString(  "book_status"));
                book.setCategory(category);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setBook_code(rs.getString(  "book_code"));
                books.add(book);
            }
            rs.close();
            pst.close();
        } catch (Exception e) { e.printStackTrace();
        }
        return books;
    }
    public static ObservableList<Book> searchByKeyword(String key){
        ObservableList<Book> books = FXCollections.observableArrayList();
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
                Book book = new Book();
                book.setBook_id(rs.getInt( "id"));
                book.setBook_name(rs.getString(  "book_name"));
                book.setBook_price (rs.getFloat(  "book_price") );
                book.setBook_description(rs.getString(  "book_description"));
                book.setBook_status(rs.getString(  "book_status"));
                book.getCategory().setCat_id(rs.getInt(  "cat_id"));
                book.getAuthor().setAu_id((rs.getInt(  "author_id")));
                book.getPublisher().setPus_id(rs.getInt(  "publisher_id"));
                book.setBook_code(rs.getString(  "book_code"));
                books.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }
    public static ObservableList<String> getAuthorNames(){
        ObservableList<String> authorNames = FXCollections.observableArrayList();
        try {
            String sql = "SELECT id, au_name FROM author where 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Author author = new Author();
                author.setAu_id(rs.getInt("id"));
                author.setAu_name(rs.getString("au_name"));
                authorNames.add(author.getAu_name());
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return authorNames;
    }
    public static ObservableList<String> getPublisherNames(){
        ObservableList<String> publisherNames = FXCollections.observableArrayList();
        try {
            String sql = "SELECT id,pus_name FROM pushlisher where 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Publisher publisher = new Publisher();
                publisher.setPus_id(rs.getInt("id"));
                publisher.setPus_name(rs.getString("pus_name"));
                publisherNames.add(publisher.getPus_name());
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return publisherNames;
    }
    public static ObservableList<String> getCategoryNames(){
        ObservableList<String> categoryNames = FXCollections.observableArrayList();
        try {
            String sql = "SELECT id, cat_name FROM category where 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setCat_id(rs.getInt("id"));
                category.setCat_name(rs.getString("cat_name"));
                categoryNames.add(category.getCat_name());
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categoryNames;
    }
}


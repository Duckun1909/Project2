package io.aptech.Model;

import io.aptech.Entity.Author;
import io.aptech.Entity.Publisher;
import io.aptech.Generic.DAORepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherStatement implements DAORepository<Publisher> {
    private static final Connection connection = MySqlConnection.getConnection();

    @Override
    public void insert(Publisher publisher) {
        try {
            String sql= "INSERT INTO publisher(pus_name,pus_email,pus_web,pus_address) VALUES (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, publisher.getPus_name());
            pst.setString(2, publisher.getPus_email());
            pst.setString(3, publisher.getPus_web());
            pst.setString(4, publisher.getPus_address());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Publisher publisher) {
        try {
            String sql = "UPDATE publisher SET pus_name =?,pus_email =?,pus_web = ? ,pus_address=? WHERE id =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, publisher.getPus_name());
            pst.setString(2, publisher.getPus_email());
            pst.setString(3, publisher.getPus_web());
            pst.setString(4, publisher.getPus_address());
            pst.setInt(5, publisher.getPus_id());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Publisher getById(int id) {
        return null;
    }

    @Override
    public void remove(Publisher publisher) {
        try {
            String sql = "DELETE FROM publisher WHERE id =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, publisher.getPus_id());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Publisher> getAll() {
        ObservableList<Publisher> publishers = FXCollections.observableArrayList();
        try {
            String sql = "select * from publisher where 1";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Publisher publisher = new Publisher();
                publisher.setPus_id(rs.getInt( "id"));
                publisher.setPus_name(rs.getString(  "pus_name"));
                publisher.setPus_email (rs.getString(  "pus_email"));
                publisher.setPus_web (rs.getString(  "pus_web"));
                publisher.setPus_address (rs.getString(  "pus_address"));
                publishers.add( publisher);
            }
            rs.close();
            pst.close();
        } catch (Exception e) { e.printStackTrace();
        }
        return publishers;
    }
    public static ObservableList<Publisher> searchByKeyword(String key){
        ObservableList<Publisher> publishers = FXCollections.observableArrayList();

        try {
            String keyword = key.replace(" ","%");
            String sql = "SELECT id,pus_name"+
                    ",pus_email"+
                    ",pus_web"+
                    ",pus_address"+
                    " FROM publisher"+
                    " WHERE pus_name LIKE '%" + keyword + "%' ";
            System.out.println(sql);
            PreparedStatement pts = connection.prepareStatement(sql);
            ResultSet rs = pts.executeQuery();
            while (rs.next()) {
                Publisher publisher = new Publisher();
                publisher.setPus_id(rs.getInt("id"));

                publisher.setPus_name(rs.getString("pus_name"));
                publisher.setPus_email(rs.getString("pus_email"));
                publisher.setPus_web(rs.getString("pus_web"));
                publisher.setPus_address(rs.getString("pus_address"));
                publishers.add(publisher);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return publishers;
    }
}

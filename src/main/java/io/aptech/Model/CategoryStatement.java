//package io.aptech.Model;
//
//import io.aptech.Generic.DAORepository;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class CategoryStatement implements DAORepository<Category> {
//
//    private static final Connection  connection = MySqlConnection.getConnection();
//
//
//
//    @Override
//    public void insert(Category category) {
//        try {
//            String sql = "INSERT INTO tblcategory(`cat_code`, `cat_name`, `cat_description`) VALUES(?,?,?)";
//            PreparedStatement pst = connection.prepareStatement(sql);
//            pst.setString(1, category.getCode());
//            pst.setString(2,category.getName());
//            pst.setString(3,category.getDescription());
//            pst.executeUpdate();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void update( Category category) {
//
//    }
//
//    @Override
//    public Category getById(int id) {
//        return null;
//    }
//
//
//    @Override
//    public void remove(Category category) {
//
//    }
//
//    @Override
//    public ObservableList<Category> getAll() {
//        ObservableList<Category> categories = FXCollections.observableArrayList();
//        try {
//            String sql = "select * from tblcategory where 1";
//            PreparedStatement pst = connection.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()){
//                Category category = new Category();
//                category.setId(rs.getInt( "id"));
//                category.setCode(rs.getString(  "cat_code"));
//                category.setName (rs.getString(  "cat_name"));
//                category.setDescription (rs.getString( "cat_description"));
//                categories.add( category);
//            }
//            rs.close();
//            pst.close();
//        } catch (Exception e) { e.printStackTrace();
//        }
//        return categories;
//    }
//    public static ObservableList<Category> searchByKeyword(String xxx) {
//    ObservableList<Category> categories = FXCollections.observableArrayList();
//    try{
//        String keyword = xxx.replace("" ,"%");
//        String sql= "SELECT id ,cat_code"+
//                ",cat_name"+
//                ",cat_description " +
//                "FROM tblcategory " +
//                " WHERE cat_code LIKE '%" + keyword +"%' OR cat_name LIKE '%" + keyword +"%'  ";
//        System.out.println(sql);
//
//        PreparedStatement pts =connection.prepareStatement(sql);
//        ResultSet rs = pts.executeQuery();
//        while(rs.next()){
//            Category category = new Category();
//            category.setId(rs.getInt("id"));
//            category.setCode(rs.getString("cat_code"));
//            category.setName(rs.getString("cat_name"));
//            category.setDescription(rs.getString("cat_description"));
//            categories.add(category);
//        }
//    }catch(SQLException e){
//        e.printStackTrace();
//    }
//    return categories;
//    }
//
//}

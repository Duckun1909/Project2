package io.aptech.Controller;

import io.aptech.Entity.Category;
import io.aptech.Model.CategoryStatement;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable{
    @FXML
    private TableColumn<Category, String> cid;
//    @FXML
//    private TableColumn<Category, String> ccode;
    @FXML
    private TableColumn<Category, String> cname;
    @FXML
    private TableColumn<Category, String> cdes;
    @FXML
    private TableView<Category> tableCategory = new TableView<Category>();




    private ObservableList<Category> categories ;
    private CategoryStatement categoryStatement = new CategoryStatement();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categories = categoryStatement.getAll();
        System.out.println(categories);
        tableCategory.getColumns().get(0).setVisible(false);
        cid.setCellValueFactory(new PropertyValueFactory<Category, String>("id"));
        cname.setCellValueFactory(new PropertyValueFactory<Category, String>("cat_name"));
        cdes.setCellValueFactory(new PropertyValueFactory<Category,String>("cat_description"));
        tableCategory.setItems(categories);

    }
}
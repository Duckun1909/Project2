package io.aptech.Controller;

import io.aptech.Entity.Author;
import io.aptech.Entity.Category;
import io.aptech.Model.AuthorStatement;
import io.aptech.Model.CategoryStatement;
import io.aptech.Model.Random;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable{
//    @FXML
//    private TextField txtBookId;

    @FXML
    private TextField txtBookCode;
    @FXML
    private TextField txtBookName;
    @FXML
    private TextArea txtDescription;
    @FXML
    private TableColumn<Category, String> cid;
    @FXML
    private TableColumn<Category, String> ccode;
    @FXML
    private TableColumn<Category, String> cname;
    @FXML
    private TableColumn<Category, String> cdes;


    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;
    @FXML
    private TableView<Category> tableCategory = new TableView<Category>();


    public void setValueCategoryForm(Category category){
        String readerCode = category.getCat_code()==null?"":String.valueOf(category.getCat_code());
        txtBookCode.setText(readerCode);
        txtBookName.setText(category.getCat_name());
        txtDescription.setText(category.getCat_description());

    }

    private ObservableList<Category> categories ;
    private static CategoryStatement categoryStatement = new CategoryStatement();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categories = categoryStatement.getAll();
        System.out.println(categories);
        tableCategory.getColumns().get(0).setVisible(false);
        cid.setCellValueFactory(new PropertyValueFactory<Category, String>("id"));
        ccode.setCellValueFactory(new PropertyValueFactory<Category, String>("cat_code"));
        cname.setCellValueFactory(new PropertyValueFactory<Category, String>("cat_name"));
        cdes.setCellValueFactory(new PropertyValueFactory<Category,String>("cat_description"));
        tableCategory.setItems(categories);

        txtBookName.setOnKeyReleased(e->{
           txtBookCode.setText(Random.randomCode(txtBookName.getText()));
        });

        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Category c = new Category();
                c.setCat_code(txtBookCode.getText());
//                System.out.println(txtBookCode.getText());
                c.setCat_name(txtBookName.getText());
                c.setCat_description(txtDescription.getText());
                categoryStatement.insert(c);
                categories  =  categoryStatement.getAll();
                tableCategory.setItems(categories);
                tableCategory.refresh();
                setValueCategoryForm(new Category());
            }
        });
        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Category category = tableCategory.getSelectionModel().getSelectedItem();
                category.setCat_code(txtBookCode.getText());
                category.setCat_name(txtBookName.getText());
                category.setCat_description(txtDescription.getText());
                categoryStatement.update(category);
                categories = categoryStatement.getAll();
                tableCategory.setItems(categories);
                tableCategory.refresh();
                setValueCategoryForm(new Category());
                btnAdd.setDisable(false);
            }
        });

        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert aler = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete", ButtonType.YES, ButtonType.NO);
                aler.setTitle("Author confirmation");
                aler.showAndWait();
                if (aler.getResult().equals(ButtonType.YES)) {
                    Category c = tableCategory.getSelectionModel().getSelectedItem();
                    categories.remove(c);
                    categoryStatement.remove(c);
                    tableCategory.refresh();
                    setValueCategoryForm(new Category());
                    btnAdd.setDisable(false);
                }
            }
        });

        tableCategory.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Category c = tableCategory.getSelectionModel().getSelectedItem();

                txtBookCode.setDisable(true);
                setValueCategoryForm(c);
                tableCategory.setItems(categories);

                tableCategory.refresh();
                btnAdd.setDisable(true);
            }
        });

    }
}
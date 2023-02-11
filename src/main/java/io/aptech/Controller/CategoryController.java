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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable{
    @FXML
    private TextField txtBookId;
    @FXML
    private TextField txtBookName;
    @FXML
    private TextArea txtDescription;
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
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;




    private ObservableList<Category> categories ;
    private CategoryStatement categoryStatement = new CategoryStatement();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categories = categoryStatement.getAll();
        System.out.println(categories);
        tableCategory.getColumns().get(0).setVisible(false);
        cid.setCellValueFactory(new PropertyValueFactory<Category, String>("cat_id"));
        cname.setCellValueFactory(new PropertyValueFactory<Category, String>("cat_name"));
        cdes.setCellValueFactory(new PropertyValueFactory<Category,String>("cat_description"));
        tableCategory.setItems(categories);



        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert aler = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete", ButtonType.YES, ButtonType.NO);
                aler.setTitle("Person confirmation");
                aler.showAndWait();
                if (aler.getResult().equals(ButtonType.YES)) {
                    Category c = tableCategory.getSelectionModel().getSelectedItem();
                    categories.remove(c);
                }
            }
        });

        tableCategory.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Category c = tableCategory.getSelectionModel().getSelectedItem();
                txtBookId.setText(String.valueOf(c.getCat_id()));
                System.out.println(c.getCat_id());
                txtBookId.setDisable(true);

                txtBookName.setText(c.getCat_name());
                txtDescription.setText(c.getCat_description());
            }
        });

    }
}
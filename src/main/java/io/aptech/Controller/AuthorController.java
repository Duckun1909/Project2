package io.aptech.Controller;

import io.aptech.Entity.Author;
import io.aptech.Entity.Category;
import io.aptech.Model.AuthorStatement;
import io.aptech.Model.CategoryStatement;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthorController implements Initializable {
    @FXML
    private TextField txtAuthorID;
    @FXML
    private TextField txtAuthorName;
    @FXML
    private TextArea txtAuthorDescription;
    @FXML
    private TableView<Author> authorTableView;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn authorNameCol;
    @FXML
    private TableColumn authorDescriptionCol;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnRefresh;
    private static AuthorStatement authorStatement =new AuthorStatement();
    ObservableList<Author> authors = authorStatement.getAll();
    public void setValueCategoryForm(Author author){
        String readerCode = author.getAu_id()==0?"":String.valueOf(author.getAu_id());
        txtAuthorID.setText(readerCode);
        txtAuthorName.setText(author.getAu_name());
        txtAuthorDescription.setText(author.getAu_description());

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        authorTableView.getColumns().get(0).setVisible(false);
        idCol.setCellValueFactory(new PropertyValueFactory<Author, String>("id"));
        authorNameCol.setCellValueFactory(new PropertyValueFactory<Author, String>("au_name"));
        authorDescriptionCol.setCellValueFactory(new PropertyValueFactory<Author, String>("au_description"));
        authorTableView.setItems(authors);


        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                String newCategoryCode = txtAuthorID.getText();
                Author newAuthor = new Author();
                newAuthor.setAu_name(txtAuthorName.getText());
                newAuthor.setAu_description(txtAuthorDescription.getText());
//                newAuthor.setAu_id(Integer.parseInt(txtAuthorID.getText()));
                authorStatement.insert(newAuthor);
                authors = authorStatement.getAll();
                authorTableView.setItems(authors);
                authorTableView.refresh();
                setValueCategoryForm(new Author());
            }
        });
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert aler = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete", ButtonType.YES, ButtonType.NO);
                aler.setTitle("Author confirmation");
                aler.showAndWait();
                if (aler.getResult().equals(ButtonType.YES)) {
                    Author author = authorTableView.getSelectionModel().getSelectedItem();
                    authors.remove(author);
                    authorStatement.remove(author);
                    authorTableView.refresh();
                    setValueCategoryForm(new Author());
                    btnAdd.setDisable(false);
                }
            }
        });

        authorTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Author author = authorTableView.getSelectionModel().getSelectedItem();
                txtAuthorID.setText(String.valueOf(author.getAu_id()));
                txtAuthorID.setDisable(true);
                setValueCategoryForm(author);
                btnAdd.setDisable(true);

            }
        });
        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Author newAuthor = authorTableView.getSelectionModel().getSelectedItem();

                newAuthor.setAu_name(txtAuthorName.getText());
                newAuthor.setAu_description(txtAuthorDescription.getText());
                authorStatement.update(newAuthor);
                authors = authorStatement.getAll();
                authorTableView.setItems(authors);
                authorTableView.refresh();
                setValueCategoryForm(new Author());
                btnAdd.setDisable(false);
            }
        });
        txtSearch.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyword = txtSearch.getText();
                authors = AuthorStatement.searchByKeyword(keyword);
                authorTableView.setItems(authors);
                authorTableView.refresh();
            }
        });
//        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                String keyword = txtSearch.getText();
//                authors = AuthorStatement.searchByKeyword(keyword);
//                System.out.println(authors);
//                authorTableView.setItems(authors);
//                authorTableView.refresh();
//            }
//        });

        btnRefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                authors = authorStatement.getAll();
                authorTableView.setItems(authors);
                authorTableView.refresh();
            }
        });
    }
}
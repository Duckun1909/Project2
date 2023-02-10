package io.aptech.Controller;

import io.aptech.Entity.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BookInfoController implements Initializable {
    @FXML
    private TextField bkId;
    @FXML
    private TextField bkName;
    @FXML
    private TextField bkAuthor;
    @FXML
    private TextField bkPublisher;
    @FXML
    private TextField bkPrice;
    @FXML
    private TextField bkStatus;
    @FXML
    private TextField bkCategory;
    @FXML
    private TextField bkDescription;
    @FXML
    private TableView<Book> tableView = new TableView<>();
    @FXML
    private TableColumn<Book, String> colId;
    @FXML
    private TableColumn<Book, String> colName;
    @FXML
    private TableColumn<Book, String> colAuthor;
    @FXML
    private TableColumn<Book, String> colPublisher;
    @FXML
    private TableColumn<Book, String> colPrice;
    @FXML
    private TableColumn<Book, String> colStatus;
    @FXML
    private TableColumn<Book, String> colCategory;
    @FXML
    private TableColumn<Book, String> colDescription;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

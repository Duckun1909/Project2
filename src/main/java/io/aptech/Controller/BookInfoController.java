package io.aptech.Controller;

import io.aptech.Entity.Author;
import io.aptech.Entity.Book;
import io.aptech.Entity.Publisher;
import io.aptech.Model.BookInfoStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class BookInfoController implements Initializable {
    @FXML
    private TextField txtBookId;
    @FXML
    private TextField txtBookName;
    @FXML
    private ComboBox<Author> txtBookAuthor;
    @FXML
    private ComboBox<Publisher> txtBookPublisher;
    @FXML
    private TextField txtBookPrice;
    @FXML
    private TextField txtBookStatus;
    @FXML
    private ComboBox txtBookCategory;
    @FXML
    private TextArea txtDescription;
    @FXML
    private TableView<Book> tableView = new TableView<>();
    @FXML
    private TableColumn<Book, String> idCol;
    @FXML
    private TableColumn<Book, String> bookNameCol;
    @FXML
    private TableColumn<Book, String> authorCol;
    @FXML
    private TableColumn<Book, String> publisherCol;
    @FXML
    private TableColumn<Book, String> priceCol;
    @FXML
    private TableColumn<Book, String> statusCol;
    @FXML
    private TableColumn<Book, String> categoryCol;
    @FXML
    private TableColumn<Book, String> descriptionCol;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;


    private static BookInfoStatement bookInfoStatement =new BookInfoStatement();
    public  void setValueToTable(){
        ObservableList<Book> books = bookInfoStatement.getAll();
        idCol.setCellValueFactory(new PropertyValueFactory<Book, String>("id"));
        bookNameCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_name"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author_id"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher_id"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_price"));
        statusCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_status"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<Book, String>("cat_id"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_description"));
        tableView.setItems(books);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setValueToTable();
        btnAdd.setOnAction(event -> {
           Book book = new Book(0,txtBookName.getText(),Float.parseFloat(txtBookPrice.getText()),null,txtBookStatus.getText(),txtDescription.getText());
           bookInfoStatement.insert(book);
           tableView.refresh();
           ListCell<Author> authorCell = new ListCell<Author>() ;
           txtBookAuthor.setButtonCell(authorCell);
        });

    }
}

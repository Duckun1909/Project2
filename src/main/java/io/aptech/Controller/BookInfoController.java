package io.aptech.Controller;

import io.aptech.Entity.Author;
import io.aptech.Entity.Book;
import io.aptech.Entity.Category;
import io.aptech.Entity.Publisher;
import io.aptech.Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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

public class BookInfoController implements Initializable {
    @FXML
    private TextField txtBookId;
    @FXML
    private TextField txtBookName;
    @FXML
    private TextField txtBookPrice;
    @FXML
    private TextField txtStatus;
    @FXML
    private ComboBox<Category> txtCategory;
    @FXML
    private ComboBox<Publisher> txtPublisher;
    @FXML
    private ComboBox<Author> txtAuthor;
    @FXML
    private TextArea txtDescription = new TextArea();
    @FXML
    private TableView<Book> bookTableView;
    @FXML
    private TableColumn<Book,String> idCol;
    @FXML
    private TableColumn<Book,String>bookNameCol;
    @FXML
    private TableColumn <Book,String>priceCol;
    @FXML
    private TableColumn <Book,String>statusCol;
    @FXML
    private TableColumn<Book,String> categoryCol;
    @FXML
    private TableColumn<Book,String> publisherCol;
    @FXML
    private TableColumn<Book,String> authorCol;
    @FXML
    private TableColumn<Book,String> bookDescriptionCol;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSearch;
    private static BokInfoStatement bokInfoStatement =new BokInfoStatement();
    private static AuthorStatement authorStatement =new AuthorStatement();
    private static PublisherStatement publisherStatement =new PublisherStatement();
    private static CategoryStatement categoryStatement =new CategoryStatement();
    ObservableList<Book> books = bokInfoStatement.getAll();
    ObservableList<Author> listAuthorNames = authorStatement.getAll();
    ObservableList<Publisher> listPublisherNames = publisherStatement.getAll();
    ObservableList<Category> listCategoryNames = categoryStatement.getAll();
    public void setValueCategoryForm(Book book){

        String readerCode = book.getBook_id()==0?"":String.valueOf(book.getBook_id());

        txtBookId.setText(readerCode);
        txtBookName.setText(book.getBook_name());
        txtBookPrice.setText(String.valueOf(book.getBook_price()));
        txtDescription.setText(book.getBook_description());
        txtStatus.setText(book.getBook_status());

        txtCategory.setValue(book.getCategory());
        txtPublisher.setValue(book.getPublisher());
        txtAuthor.setValue(book.getAuthor());


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtAuthor.setItems(listAuthorNames);
        txtCategory.setItems(listCategoryNames);
        txtPublisher.setItems(listPublisherNames);
        books.forEach(book -> {

            System.out.println(book.toString());
        });
//        bookTableView.getColumns().get(0).setVisible(false);
        idCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_code"));
        bookNameCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_price"));
        statusCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_status"));
        categoryCol.setCellValueFactory(b->new SimpleStringProperty(b.getValue().getCategory().getCat_name()));
        publisherCol.setCellValueFactory(b->new SimpleStringProperty(b.getValue().getPublisher().getPus_name()));
        authorCol.setCellValueFactory(
                b->new SimpleStringProperty(b.getValue().getAuthor().getAu_name()
                )
        );

        bookDescriptionCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_description"));
        bookTableView.setItems(books);


        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                String newCategoryCode = txtAuthorID.getText();
                Book book = new Book();
                book.setBook_name(txtBookName.getText());
                book.setBook_price(Float.parseFloat(txtBookPrice.getText()));
                book.setBook_status(txtStatus.getText());
                book.setCategory(txtCategory.getValue());

                book.setPublisher(txtPublisher.getValue());
                book.setAuthor(txtAuthor.getValue());

                book.setBook_description(txtDescription.getText());

                book.setBook_code(txtBookId.getText());
//                newAuthor.setAu_id(Integer.parseInt(txtAuthorID.getText()));
                bokInfoStatement.insert(book);
                books = bokInfoStatement.getAll();
                bookTableView.setItems(books);
                bookTableView.refresh();
                setValueCategoryForm(new Book());
            }
        });
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert aler = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete", ButtonType.YES, ButtonType.NO);
                aler.setTitle("Author confirmation");
                aler.showAndWait();
                if (aler.getResult().equals(ButtonType.YES)) {
                    Book book = bookTableView.getSelectionModel().getSelectedItem();
                    books.remove(book);
                    bokInfoStatement.remove(book);
                    bookTableView.refresh();
                    btnAdd.setDisable(false);
                    setValueCategoryForm(new Book());
                }
            }
        });

        bookTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Book book = bookTableView.getSelectionModel().getSelectedItem();
                txtBookId.setText(String.valueOf(book.getBook_code()));
                txtBookId.setDisable(true);
                txtBookName.setText(book.getBook_name());
                txtBookPrice.setText(String.valueOf(book.getBook_price()));
                txtStatus.setText(book.getBook_status());
                txtCategory.setValue(book.getCategory());
                txtAuthor.setValue(book.getAuthor());
                txtPublisher.setValue(book.getPublisher());
                txtDescription.setText(book.getBook_description());
                btnAdd.setDisable(true);
                setValueCategoryForm(book);
            }
        });
        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Book book = bookTableView.getSelectionModel().getSelectedItem();

                Category c = txtCategory.getSelectionModel().getSelectedItem();
                Publisher p =txtPublisher.getSelectionModel().getSelectedItem();
                Author a = txtAuthor.getSelectionModel().getSelectedItem();
                System.out.println(a.getAu_id());



                book.setBook_name(txtBookName.getText());
                book.setBook_price(Float.parseFloat(txtBookPrice.getText()));
                book.setBook_status(txtStatus.getText());


                book.setBook_description(txtDescription.getText());
                book.setCategory(c);
                book.setAuthor(a);
                book.setPublisher(p);

                bokInfoStatement.update(book);
                books = bokInfoStatement.getAll();
                bookTableView.setItems(books);
                bookTableView.refresh();
                btnAdd.setDisable(false);
                setValueCategoryForm(new Book());

            }
        });
        txtBookName.setOnKeyReleased(e->{
                    txtBookId.setText(Random.randomCode(txtBookName.getText()));
                }
        );
        txtSearch.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyword = txtSearch.getText();
                books = BokInfoStatement.searchByKeyword(keyword);
                bookTableView.setItems(books);
                bookTableView.refresh();
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



    }
}

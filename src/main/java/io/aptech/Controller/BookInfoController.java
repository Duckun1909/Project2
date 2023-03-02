package io.aptech.Controller;

import io.aptech.Entity.Author;
import io.aptech.Entity.Book;
import io.aptech.Entity.Category;
import io.aptech.Entity.Publisher;
import io.aptech.Model.*;
import javafx.beans.property.SimpleStringProperty;
import io.aptech.Validation.BookValidation;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
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
import java.io.ObjectInputFilter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class BookInfoController implements Initializable {
    @FXML
    private TextField txtBookId;
    @FXML
    private TextField txtBookName;
    @FXML
    private TextField txtBookPrice;
    @FXML
    private ComboBox<String> txtStatus;
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
    private Label CodeLabel;
    @FXML
    private Label NameLabel;
    @FXML
    private Label PriceLabel;
    @FXML
    private Label DesLabel;
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
    ObservableList<String> listStatusNames = FXCollections.observableArrayList("Old","New");
    public void setValueCategoryForm(Book book){
        String readerCode = book.getBook_code()==null?"":String.valueOf(book.getBook_code());
        txtBookId.setText(readerCode);
        txtBookName.setText(book.getBook_name());
        txtBookPrice.setText(String.valueOf(book.getBook_price()));
        txtDescription.setText(book.getBook_description());
        txtCategory.setValue(book.getCategory());
        txtPublisher.setValue(book.getPublisher());
        txtAuthor.setValue(book.getAuthor());
        txtStatus.setValue(book.getBook_status());
    }
    String flag = "true";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtAuthor.setItems(listAuthorNames);
        txtCategory.setItems(listCategoryNames);
        txtPublisher.setItems(listPublisherNames);
        txtStatus.setItems(listStatusNames);

//        bookTableView.getColumns().get(0).setVisible(false);
        idCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_code"));
        bookNameCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_price"));
        statusCol.setCellValueFactory(b->new SimpleStringProperty(b.getValue().getBook_status().toString()));
        categoryCol.setCellValueFactory(b->new SimpleStringProperty(b.getValue().getCategory().getCat_name()));
        publisherCol.setCellValueFactory(b->new SimpleStringProperty(b.getValue().getPublisher().getPus_name()));
        authorCol.setCellValueFactory(
                b->new SimpleStringProperty(b.getValue().getAuthor().getAu_name()
                )
        );

        bookDescriptionCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_description"));
        bookTableView.setItems(books);

        txtBookName.setOnKeyReleased(e-> {

            txtBookId.setText(Random.randomCode(txtBookName.getText()));
            if ((!BookValidation.isBookName(txtBookName.getText())) && !txtBookName.getText().equals("")) {
                NameLabel.setText("Book Name is not valid");
                txtBookName.setStyle("-fx-border-color: red");
                flag = "false";
            }else if (txtBookName.getText()== "") {
                flag = "false";
                txtBookName.setStyle("-fx-border-color: White");
                NameLabel.setText("");
            }
            else {
                flag = "true";
                txtBookName.setStyle("-fx-border-color: green");
                NameLabel.setText("");
            }
        });
        txtBookPrice.setOnKeyReleased(e-> {

            if ((!BookValidation.isBookPrice(txtBookPrice.getText())) && !txtBookPrice.getText().equals("")) {
                flag = "false";
                PriceLabel.setText("Book Price is not valid");
                txtBookPrice.setStyle("-fx-border-color: red");
            } else if (txtBookPrice.getText()== "") {
                flag = "false";
                txtBookPrice.setStyle("-fx-border-color: White");
                PriceLabel.setText("");
            } else {
                flag = "true";
                txtBookPrice.setStyle("-fx-border-color: green");
                PriceLabel.setText("");
            }

        });
//        txtDescription.setOnKeyReleased(e-> {
//
//            if ((!BookValidation.isBookDes(txtDescription.getText())) && !txtDescription.getText().equals("")) {
//                DesLabel.setText("Book Description is not valid");
//                txtDescription.setStyle("-fx-border-color: red");
//            }else if (txtDescription.getText()== "") {
//                txtDescription.setStyle("-fx-border-color: White");
//                DesLabel.setText("");
//            }
//            else {
//                txtDescription.setStyle("-fx-border-color: green");
//                DesLabel.setText("");
//            }
//        });

        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(flag);
                Book book = new Book();
                if (txtBookName.getText().isEmpty()){
                    NameLabel.setText("you must enter this field");
                    txtBookName.setStyle("-fx-border-color: red");
                }
                else if(txtBookPrice.getText().isEmpty()){
                    PriceLabel.setText("you must enter this field");
                    txtBookPrice.setStyle("-fx-border-color: red");
                }
                else if (txtDescription.getText().isEmpty()) {
                    DesLabel.setText("you must enter this field");
                    txtDescription.setStyle("-fx-border-color: red");
                } else if (flag.equals("false")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please check your form again!!!!", ButtonType.OK);
                    alert.setTitle("Check your information");
                    alert.showAndWait();
                } else {
                    txtBookName.setStyle("-fx-border-color: green");
                    NameLabel.setText("");
                    txtBookPrice.setStyle("-fx-border-color: green");
                    PriceLabel.setText("");
                    txtDescription.setStyle("-fx-border-color: green");
                    DesLabel.setText("");
                    book.setBook_name(txtBookName.getText());
                    book.setBook_price(Float.parseFloat(txtBookPrice.getText()));
                    book.setBook_status(String.valueOf(txtStatus.getValue()));
                    book.setCategory(txtCategory.getValue());

                    book.setPublisher(txtPublisher.getValue());
                    book.setAuthor(txtAuthor.getValue());

                    book.setBook_description(txtDescription.getText());

                    book.setBook_code(txtBookId.getText());

                    bokInfoStatement.insert(book);
                    books = bokInfoStatement.getAll();
                    bookTableView.setItems(books);
                    bookTableView.refresh();
                    setValueCategoryForm(new Book());}
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
                txtStatus.setValue(String.valueOf(book.getBook_status()));
                txtCategory.setValue(book.getCategory());
                txtAuthor.setValue(book.getAuthor());
                System.out.println(book.getAuthor());
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


                book.setBook_name(txtBookName.getText());
                book.setBook_price(Float.parseFloat(txtBookPrice.getText()));
                book.setBook_status(String.valueOf(txtStatus.getValue()));

                book.setBook_description(txtDescription.getText());
                book.setCategory(c);
                book.setAuthor(a);
                book.setPublisher(p);
                if (txtBookName.getText().isEmpty()){
                    NameLabel.setText("you must enter this field");
                    txtBookName.setStyle("-fx-border-color: red");
                }
                else if(txtBookPrice.getText().isEmpty()){
                    PriceLabel.setText("you must enter this field");
                    txtBookPrice.setStyle("-fx-border-color: red");
                }
                else if (txtDescription.getText().isEmpty()) {
                    DesLabel.setText("you must enter this field");
                    txtDescription.setStyle("-fx-border-color: red");
                }else {
                    txtBookName.setStyle("-fx-border-color: green");
                    NameLabel.setText("");
                    txtBookPrice.setStyle("-fx-border-color: green");
                    PriceLabel.setText("");
                    txtDescription.setStyle("-fx-border-color: green");
                    DesLabel.setText("");
                    bokInfoStatement.update(book);
                    books = bokInfoStatement.getAll();
                    bookTableView.setItems(books);
                    bookTableView.refresh();
                    btnAdd.setDisable(false);
                    setValueCategoryForm(new Book());
                }
            }
        });




        txtSearch.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyword = txtSearch.getText();
                String regex = ".*" + keyword.replaceAll("\\s+", ".*") + ".*";
                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                ObservableList<Book> filteredPeople = books.stream()
                        .filter(p -> {
                            Pattern pName = Pattern.compile(pattern.pattern(), Pattern.CASE_INSENSITIVE);
                            return pName.matcher(p.getBook_name()).matches() || pName.matcher(p.getBook_code()).matches();
                        })
                        .collect(FXCollections::observableArrayList, ObservableList::add, ObservableList::addAll);

                bookTableView.setItems(filteredPeople);
                bookTableView.refresh();
            }
        });





    }
}

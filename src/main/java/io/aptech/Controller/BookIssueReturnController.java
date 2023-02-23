package io.aptech.Controller;

import io.aptech.Entity.*;
import io.aptech.Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.sql.Date;

public class BookIssueReturnController implements Initializable {
    @FXML private TableView<Book> bookTable;
    @FXML private TextField txtBookSearch;
    @FXML private Button btnBookSearch;
    @FXML private TableColumn<Book, String> bookIDCol;
    @FXML private TableColumn<Book, String> bookCodeCol;
    @FXML private TableColumn<Book, String> bookNameCol;
    @FXML private TableColumn<Book, String> bookPriceCol;
    @FXML private TableColumn<Book, String> bookDescriptionCol;
    @FXML private TableColumn<Book, String> bookCategoryCol;
    @FXML private TableColumn<Book, String> bookAuthorCol;
    @FXML private TableColumn<Book, String> bookStatusCol;

    @FXML private TableView<Reader> readerTable;
    @FXML private TextField txtReaderSearch;
    @FXML private Button btnReaderSearch;
    @FXML private TableColumn<Reader, String> readerIDCol;
    @FXML private TableColumn<Reader, String> readerCodeCol;
    @FXML private TableColumn<Reader, String> readerNameCol;
    @FXML private TableColumn<Reader, String> readerPhoneCol;
    @FXML private TableColumn<Reader, String> readerAddressCol;
    @FXML private TableColumn<Reader, String> readerCidCol;
    @FXML private DatePicker returnDate;

    @FXML private Button btnConfirm;


    private BokInfoStatement bookInfoStatement = new BokInfoStatement();
    private ReaderInfoStatement readerInfoStatement = new ReaderInfoStatement();
    private BorrowStatement borrowStatement = new BorrowStatement();
    private BorrowDetailStatement borrowDetailStatement = new BorrowDetailStatement();

    private ObservableList<Book> books;
    private ObservableList<Reader> readers;

    private Reader reader;


    public void setValueToTableReader(){
        readers = readerInfoStatement.getAll();
        readerTable.refresh();
        if(!readers.isEmpty()){
            readerIDCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_id"));
            readerCodeCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_code"));
            readerNameCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_name"));
            readerPhoneCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_phone"));
            readerAddressCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_address"));
            readerCidCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_cid"));
            readerTable.setItems(readers);
        }
    }

    public void setValueToTableBook(){
        books = bookInfoStatement.getAll();
        bookTable.refresh();
        if(!books.isEmpty()){
            bookIDCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_id"));
            bookCodeCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_code"));
            bookNameCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_name"));
            bookPriceCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_price"));
            bookDescriptionCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_description"));
            bookCategoryCol.setCellValueFactory(b->new SimpleStringProperty(b.getValue().getCategory().getCat_name()));
            bookAuthorCol.setCellValueFactory(b->new SimpleStringProperty(b.getValue().getAuthor().getAu_name()));
            bookStatusCol.setCellValueFactory(new PropertyValueFactory<Book, String>("book_status"));
            bookTable.setItems(books);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        LocalDate minDate = LocalDate.now();
        returnDate.setValue(minDate);
        setValueToTableReader();
        setValueToTableBook();
        List<Book> bookList = new ArrayList<>();


        readerTable.setOnMouseClicked(e->{
            reader = readerTable.getSelectionModel().getSelectedItem();
            System.out.println(reader.toString());
        });

        bookTable.setOnMouseClicked(e->{
            ObservableList<Integer> selectedIndices = bookTable.getSelectionModel().getSelectedIndices();
            bookList.clear();
            for(Integer i : selectedIndices){
                Book book = bookTable.getItems().get(i);
                bookList.add(book);
            }
            System.out.println(bookList.toString());
        });

        btnConfirm.setOnMouseClicked(e->{
            Date brdate = Date.valueOf(LocalDate.now());
            Date redate = Date.valueOf(returnDate.getValue());
            float payment= 0.0F;
            System.out.println(books.size());
            for(Book b:books){
                payment+=b.getBook_price();
            }
            Borrow br = new Borrow(0, reader, payment);
            borrowStatement.insert(br);
            System.out.println(payment);

            Borrow borrow = new Borrow();
            borrow.setBorrow_id(borrowStatement.getLastInsertID());
            System.out.println(borrowStatement.getLastInsertID());
            System.out.println(borrow.toString());
            for(Book b:bookList){
                BorrowDetail brtail = new BorrowDetail();
                brtail.setId(0);
                brtail.setBook(b);
                brtail.setBorrow(borrow);
                brtail.setBorowDate(brdate);
                brtail.setReturnDate(redate);
                brtail.setStatus(String.valueOf(BorrowDetailStatus.BORROWING));
                borrowDetailStatement.insert(brtail);
                System.out.println(1);
            }
        });
    }
}

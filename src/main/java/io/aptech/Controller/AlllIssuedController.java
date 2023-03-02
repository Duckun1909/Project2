package io.aptech.Controller;

import io.aptech.Entity.*;
import io.aptech.Model.BorrowDetailStatement;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AlllIssuedController implements Initializable {
    @FXML
    TableView<BorrowDetail> issuedBookTable;

    @FXML TableColumn<BorrowDetail, String> readerCode;
    @FXML TableColumn<BorrowDetail, String> readerName;
    @FXML TableColumn<BorrowDetail, String> bookCode;
    @FXML TableColumn<BorrowDetail, String> bookName;
    @FXML TableColumn<BorrowDetail, String> borrowDate;
    @FXML TableColumn<BorrowDetail, String> returnDate;
    @FXML TableColumn<BorrowDetail, String> borrowStatus;
    @FXML TableColumn<BorrowDetail, String> fee;
    @FXML TableColumn<BorrowDetail, String> note;
    @FXML TableColumn<BorrowDetail, String> borrowDetailID;
    @FXML Button btnReturn;
    @FXML TextArea txtReturnStatus;

    BorrowDetailStatement borrowDetailStatement = new BorrowDetailStatement();

    ObservableList<BorrowDetail> borrowDetails;

    BorrowDetail brd = new BorrowDetail();

    public void setValueToTableBook(){
        borrowDetails = borrowDetailStatement.getAll();
        issuedBookTable.refresh();
        if(!borrowDetails.isEmpty()){
            readerCode.setCellValueFactory(r->new SimpleStringProperty(r.getValue().getBorrow().getReader().getReader_code()));
            readerName.setCellValueFactory(r->new SimpleStringProperty(r.getValue().getBorrow().getReader().getReader_name()));
            bookCode.setCellValueFactory(b->new SimpleStringProperty(b.getValue().getBook().getBook_code()));
            bookName.setCellValueFactory(b->new SimpleStringProperty(b.getValue().getBook().getBook_name()));
//            borrowDate.setCellValueFactory(new PropertyValueFactory<BorrowDetail, String>("borrowDate"));
            returnDate.setCellValueFactory(new PropertyValueFactory<BorrowDetail, String>("returnDate"));
            borrowStatus.setCellValueFactory(new PropertyValueFactory<BorrowDetail, String>("status"));
            fee.setCellValueFactory(b->new SimpleStringProperty(String.valueOf(b.getValue().getBook().getBook_price())));
            note.setCellValueFactory(new PropertyValueFactory<BorrowDetail, String>("note"));
            borrowDetailID.setCellValueFactory(new PropertyValueFactory<BorrowDetail, String>("id"));
            issuedBookTable.setItems(borrowDetails);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setValueToTableBook();
        issuedBookTable.setOnMouseClicked(e->{
            brd = issuedBookTable.getSelectionModel().getSelectedItem();
        });
        btnReturn.setOnMouseClicked(e->{
            Date reDate = Date.valueOf(LocalDate.now());
            brd.setStatus(String.valueOf(BorrowDetailStatus.RETURNED));
            brd.setReturnDate(reDate);
            brd.setNote(txtReturnStatus.getText());
            borrowDetailStatement.update(brd);
            issuedBookTable.refresh();
            setValueToTableBook();
        });
    }
}

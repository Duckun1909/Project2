package io.aptech.Controller;

import io.aptech.Entity.Reader;
import io.aptech.Model.ReaderInfoStatement;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ReaderInforController implements Initializable {
    @FXML private TextField txtSearch;
    
    @FXML private Button btnSearch; 
    @FXML private Button btnRefresh; 

    @FXML private TextField txtReaderID;
    @FXML private TextField txtReaderName;
    @FXML private TextField txtReaderPhone;
    @FXML private TextField txtReaderAddress;
    @FXML private TextField txtReaderCID;
    @FXML private Button btnAdd;
    @FXML private Button btnUpdate;
    @FXML private Button btnDelete;
    @FXML
    static TableView<Reader> readerTable;
    @FXML
    static
    TableColumn<Reader, String> idCol;
    @FXML
    static
    TableColumn<Reader, String> readerNameCol;
    @FXML
    static
    TableColumn<Reader, String> readerPhoneCol;
    @FXML
    static
    TableColumn<Reader, String> readerAddressCol;
    @FXML
    static
    TableColumn<Reader, String> readerCidCol;
    @FXML
    TableColumn<Reader, String> issueBookCol;

    public static void setValueToTable(){
        ObservableList<Reader> readers = ReaderInfoStatement.getSatement().getAll();
        idCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_id"));
        readerNameCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_name"));
        readerPhoneCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_phone"));
        readerAddressCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_address"));
        readerCidCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_cid"));
        readerTable.setItems(readers);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setValueToTable();
        btnAdd.setOnMouseClicked(e->{
            Reader reader = new Reader(0, txtReaderName.getText(), txtReaderPhone.getText(), txtReaderAddress.getText(), txtReaderCID.getText());
            ReaderInfoStatement.getSatement().insert(reader);
            setValueToTable();
        });
    }
}

package io.aptech.Controller;

import io.aptech.Entity.Reader;
import io.aptech.Model.Random;
import io.aptech.Model.ReaderInfoStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ReaderInforController implements Initializable {
    @FXML private TextField txtSearch;

    @FXML private Button btnSearch;
    @FXML private Button btnRefresh;

    @FXML private TextField txtReaderID;
    @FXML private TextField txtReaderCode;
    @FXML private TextField txtReaderName;
    @FXML private TextField txtReaderPhone;
    @FXML private TextField txtReaderAddress;
    @FXML private TextField txtReaderCID;
    @FXML private VBox readerForm;
    @FXML private Button btnAdd;
    @FXML private Button btnUpdate;
    @FXML private Button btnDelete;
    @FXML
    TableView<Reader> readerTable;
    @FXML
    TableColumn<Reader, String> readerID;
    @FXML
    TableColumn<Reader, String> readerCodeCol;
    @FXML
    TableColumn<Reader, String> readerNameCol;
    @FXML
    TableColumn<Reader, String> readerPhoneCol;
    @FXML
    TableColumn<Reader, String> readerAddressCol;
    @FXML
    TableColumn<Reader, String> readerCidCol;
    @FXML
    TableColumn<Reader, String> issueBookCol;

    private ObservableList<Reader> readers;

    public ReaderInfoStatement readerInfoStatement = new ReaderInfoStatement();



    public void setValueToTable(){
        readers = readerInfoStatement.getAll();
        readerTable.refresh();
        if(!readers.isEmpty()){
            System.out.println(1);
            readerID.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_id"));
            readerCodeCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_code"));
            readerNameCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_name"));
            readerPhoneCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_phone"));
            readerAddressCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_address"));
            readerCidCol.setCellValueFactory(new PropertyValueFactory<Reader, String>("reader_cid"));
            readerTable.setItems(readers);
        }
    }

    public void setValueReaderForm(Reader reader){
        String readerCode = reader.getReader_code()==null?"":String.valueOf(reader.getReader_code());
        txtReaderID.setText(String.valueOf(reader.getReader_id()));
        txtReaderCode.setText(readerCode);
        txtReaderName.setText(reader.getReader_name());
        txtReaderPhone.setText(reader.getReader_phone());
        txtReaderAddress.setText(reader.getReader_address());
        txtReaderCID.setText(reader.getReader_cid());
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setValueToTable();
        txtReaderName.setOnKeyReleased(e->{
            txtReaderCode.setText(Random.randomCode(txtReaderName.getText()));
        });
        btnAdd.setOnMouseClicked(e->{
            Reader reader = new Reader(0, txtReaderName.getText(), txtReaderPhone.getText(), txtReaderAddress.getText(), txtReaderCID.getText(), txtReaderCode.getText());
            readerInfoStatement.insert(reader);
            setValueReaderForm(new Reader());
            setValueToTable();
        });

        readerTable.setOnMouseClicked(e->{
            Reader reader = readerTable.getSelectionModel().getSelectedItem();
            if(!(reader==null)){
                setValueReaderForm(reader);
                btnAdd.setDisable(true);
            }
        });
        btnDelete.setOnMouseClicked(e->{
            Reader reader = readerTable.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Are you sure you want to delete this reader?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Reader confirmation");
            alert.setHeaderText("This reader will be permanently deleted!");
            alert.showAndWait();
            if (alert.getResult().equals(ButtonType.YES)){
                readerInfoStatement.remove(reader);
                readers.remove(reader);
                setValueToTable();
                setValueReaderForm(new Reader());
                btnAdd.setDisable(false);
            }
        });
        btnUpdate.setOnMouseClicked((e->{
            Reader reader = new Reader(Integer.parseInt(txtReaderID.getText()), txtReaderName.getText(), txtReaderPhone.getText(), txtReaderAddress.getText(), txtReaderCID.getText(), txtReaderCode.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Are you sure you want to update this reader?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Reader confirmation");// line 2
            alert.setHeaderText("This reader will be permanently updated!");
            alert.showAndWait();
            System.out.println(reader.toString());
            if (alert.getResult().equals(ButtonType.YES)){
                System.out.println(reader);
                readerInfoStatement.update(reader);
                readers.remove(readerTable.getSelectionModel().getSelectedCells());
                setValueToTable();
                setValueReaderForm(new Reader());
                btnAdd.setDisable(false);
            }
        }));
    }
}

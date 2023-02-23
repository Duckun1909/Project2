package io.aptech.Controller;

import io.aptech.Entity.Author;
import io.aptech.Entity.Publisher;
import io.aptech.Model.AuthorStatement;
import io.aptech.Model.PublisherStatement;
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

public class PublisherController implements Initializable {
    @FXML
    private TextField txtPublisherID;
    @FXML
    private TextField txtPublisherName;
    @FXML
    private TextField txtPublisherEmail;
    @FXML
    private TextField txtPublisherWeb;
    @FXML
    private TextArea txtAddress;
    @FXML
    private TableView<Publisher> publisherTableView;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn publisherNameCol;
    @FXML
    private TableColumn publisherEmailCol;
    @FXML
    private TableColumn publisherWebCol;
    @FXML
    private TableColumn addressCol;
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
    private static PublisherStatement publisherStatement =new PublisherStatement();
    ObservableList<Publisher> publishers = publisherStatement.getAll();
    public void setValueCategoryForm(Publisher publisher){
        String readerCode = publisher.getPus_id()==0 ? "" :String.valueOf(publisher.getPus_id());
        txtPublisherID.setText(readerCode);
        txtPublisherName.setText(publisher.getPus_name());
        txtPublisherEmail.setText(publisher.getPus_email());
        txtAddress.setText(publisher.getPus_address());
        txtPublisherWeb.setText(publisher.getPus_web());

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        publisherTableView.getColumns().get(0).setVisible(false);
        idCol.setCellValueFactory(new PropertyValueFactory<Publisher, String>("id"));
        publisherNameCol.setCellValueFactory(new PropertyValueFactory<Publisher, String>("pus_name"));
        publisherEmailCol.setCellValueFactory(new PropertyValueFactory<Publisher, String>("pus_email"));
        publisherWebCol.setCellValueFactory(new PropertyValueFactory<Publisher, String>("pus_web"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Publisher, String>("pus_address"));
        publisherTableView.setItems(publishers);


        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

//                String newCategoryCode = txtAuthorID.getText();
                Publisher publisher = new Publisher();
                publisher.setPus_name(txtPublisherName.getText());
                publisher.setPus_email(txtPublisherEmail.getText());
                publisher.setPus_web(txtPublisherWeb.getText());
                publisher.setPus_address(txtAddress.getText());
//                newAuthor.setAu_id(Integer.parseInt(txtAuthorID.getText()));
                publisherStatement.insert(publisher);
                publishers = publisherStatement.getAll();
                publisherTableView.setItems(publishers);
                publisherTableView.refresh();
                setValueCategoryForm(new Publisher());

            }
        });
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert aler = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete", ButtonType.YES, ButtonType.NO);
                aler.setTitle("Author confirmation");
                aler.showAndWait();
                if (aler.getResult().equals(ButtonType.YES)) {
                    Publisher publisher = publisherTableView.getSelectionModel().getSelectedItem();
                    publishers.remove(publisher);
                    publisherStatement.remove(publisher);
                    publisherTableView.refresh();
                    setValueCategoryForm(new Publisher());
                    btnAdd.setDisable(false);
                }
            }
        });

        publisherTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Publisher publisher = publisherTableView.getSelectionModel().getSelectedItem();
                txtPublisherID.setText(String.valueOf(publisher.getPus_id()));
                txtPublisherID.setDisable(true);
                setValueCategoryForm(publisher);

                btnAdd.setDisable(true);

            }
        });
        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Publisher publisher = publisherTableView.getSelectionModel().getSelectedItem();
                publisher.setPus_name(txtPublisherName.getText());
                publisher.setPus_email(txtPublisherEmail.getText());
                publisher.setPus_web(txtPublisherWeb.getText());
                publisher.setPus_address(txtAddress.getText());
                publisherStatement.update(publisher);
//                publishers = publisherStatement.getAll();
                publisherTableView.setItems(publishers);
                publisherTableView.refresh();
                setValueCategoryForm(new Publisher());
                btnAdd.setDisable(false);
            }
        });
        txtSearch.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyword = txtSearch.getText();
                publishers = publisherStatement.searchByKeyword(keyword);
                publisherTableView.setItems(publishers);
                publisherTableView.refresh();
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
                publishers = publisherStatement.getAll();
                publisherTableView.setItems(publishers);
                publisherTableView.refresh();
            }
        });
    }
}


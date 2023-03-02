package io.aptech.Controller;


import io.aptech.Entity.Publisher;

import io.aptech.Model.PublisherStatement;

import io.aptech.Validation.PublisherValidation;
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
    @FXML
    private Label NameLabel;
    @FXML
    private Label EmailLabel;
    @FXML
    private Label WebLabel;
    @FXML
    private Label AddressLabel;
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
    private String flag = "true";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        publisherTableView.getColumns().get(0).setVisible(false);
        idCol.setCellValueFactory(new PropertyValueFactory<Publisher, String>("id"));
        publisherNameCol.setCellValueFactory(new PropertyValueFactory<Publisher, String>("pus_name"));
        publisherEmailCol.setCellValueFactory(new PropertyValueFactory<Publisher, String>("pus_email"));
        publisherWebCol.setCellValueFactory(new PropertyValueFactory<Publisher, String>("pus_web"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Publisher, String>("pus_address"));
        publisherTableView.setItems(publishers);

        txtPublisherName.setOnKeyReleased(e-> {

            if ((!PublisherValidation.isPublisherName(txtPublisherName.getText())) && !txtPublisherName.getText().equals("")) {
                NameLabel.setText("Name is not valid");
                txtPublisherName.setStyle("-fx-border-color: red");
                flag = "false";
            }else if (txtPublisherName.getText()== "") {
                txtPublisherName.setStyle("-fx-border-color: White");
                NameLabel.setText("");
                flag = "false";
            }
            else {
                txtPublisherName.setStyle("-fx-border-color: green");
                NameLabel.setText("");
                flag = "true";
            }
        });
        txtPublisherEmail.setOnKeyReleased(e-> {

            if ((!PublisherValidation.isPublisherEmail(txtPublisherEmail.getText()))&& !txtPublisherEmail.getText().equals("")) {
                EmailLabel.setText("Email is not valid");
                txtPublisherEmail.setStyle("-fx-border-color: red");
                flag = "false";
            }else if (txtPublisherEmail.getText()== "") {
                txtPublisherEmail.setStyle("-fx-border-color: White");
                EmailLabel.setText("");
                flag = "false";
            }
            else {
                txtPublisherEmail.setStyle("-fx-border-color: green");
                EmailLabel.setText("");
                flag = "true";
            }
        });
        txtPublisherWeb.setOnKeyReleased(e-> {

            if ((!PublisherValidation.isPublisherWeb(txtPublisherWeb.getText()))&& !txtPublisherWeb.getText().equals("")) {
                WebLabel.setText("This web is not valid");
                txtPublisherWeb.setStyle("-fx-border-color: red");
                flag = "false";
            }else if (txtPublisherWeb.getText()== "") {
                txtPublisherWeb.setStyle("-fx-border-color: White");
                WebLabel.setText("");
                flag = "false";
            }
            else {
                txtPublisherWeb.setStyle("-fx-border-color: green");
                WebLabel.setText("");
                flag = "true";
            }
        });
//        txtAddress.setOnKeyReleased(e-> {
//
//            if ((!PublisherValidation.isPublisherAddress(txtAddress.getText()))&& !txtAddress.getText().equals("")) {
//                AddressLabel.setText("Address is not valid");
//                txtAddress.setStyle("-fx-border-color: red");
//                flag = "false";
//            }else if (txtAddress.getText()== "") {
//                txtAddress.setStyle("-fx-border-color: White");
//                AddressLabel.setText("");
//                flag = "false";
//            }
//            else {
//                txtAddress.setStyle("-fx-border-color: green");
//                WebLabel.setText("");
//                flag = "true";
//            }
//        });


        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

//                String newCategoryCode = txtAuthorID.getText();
                Publisher publisher = new Publisher();
                if (txtPublisherName.getText().isEmpty()){
                    NameLabel.setText("you must enter this field");
                    txtPublisherName.setStyle("-fx-border-color: red");
                }
                else if (txtPublisherEmail.getText().isEmpty()) {
                    EmailLabel.setText("you must enter this field");
                    txtPublisherEmail.setStyle("-fx-border-color: red");
                }else if (txtPublisherWeb.getText().isEmpty()) {
                    WebLabel.setText("you must enter this field");
                    txtPublisherWeb.setStyle("-fx-border-color: red");
                }
                else if (txtAddress.getText().isEmpty()) {
                    AddressLabel.setText("you must enter this field");
                    txtAddress.setStyle("-fx-border-color: red");
                }
                else if (!flag.equals("true")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please check your form again!!!!", ButtonType.OK);
                    alert.setTitle("Check your information");
                    alert.showAndWait();
                }
                else {
                    txtPublisherName.setStyle("-fx-border-color: green");
                    NameLabel.setText("");
                    txtPublisherEmail.setStyle("-fx-border-color: green");
                    EmailLabel.setText("");
                    txtPublisherWeb.setStyle("-fx-border-color: green");
                    WebLabel.setText("");
                    txtAddress.setStyle("-fx-border-color: green");
                    AddressLabel.setText("");
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
                if (txtPublisherName.getText().isEmpty()){
                    NameLabel.setText("you must enter this field");
                    txtPublisherName.setStyle("-fx-border-color: red");
                }
                else if (txtPublisherEmail.getText().isEmpty()) {
                    EmailLabel.setText("you must enter this field");
                    txtPublisherEmail.setStyle("-fx-border-color: red");
                }else if (txtPublisherWeb.getText().isEmpty()) {
                    WebLabel.setText("you must enter this field");
                    txtPublisherWeb.setStyle("-fx-border-color: red");
                }
                else if (txtAddress.getText().isEmpty()) {
                    AddressLabel.setText("you must enter this field");
                    txtAddress.setStyle("-fx-border-color: red");
                }
                else if (!flag.equals("true")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please check your form again!!!!", ButtonType.OK);
                    alert.setTitle("Check your information");
                    alert.showAndWait();
                }
                else {
                    txtPublisherName.setStyle("-fx-border-color: green");
                    NameLabel.setText("");
                    txtPublisherEmail.setStyle("-fx-border-color: green");
                    EmailLabel.setText("");
                    txtPublisherWeb.setStyle("-fx-border-color: green");
                    WebLabel.setText("");
                    txtAddress.setStyle("-fx-border-color: green");
                    AddressLabel.setText("");
                    publisherStatement.update(publisher);
//                publishers = publisherStatement.getAll();
                    publisherTableView.setItems(publishers);
                    publisherTableView.refresh();
                    setValueCategoryForm(new Publisher());
                    btnAdd.setDisable(false);
                }
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


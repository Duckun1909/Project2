package io.aptech.Controller;

import io.aptech.Execute.FxmlLoader;
import javafx.animation.FillTransition;
import javafx.collections.ObservableList;
import javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private StackPane stackRootPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnDashboard;

    @FXML
    private ImageView imgDashboard;

    @FXML
    private Button btnIsuueReturnBook;

    @FXML
    private ImageView imgIsuueReturnBook;

    @FXML
    private Button btnStudentInfo;

    @FXML
    private ImageView imgStudentInfo;

    @FXML
    private Button btnBookInfo;
    @FXML
    private Pane viewPane;
    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ImageView imgBookInfo;

    @FXML
    private Button btnSetting;

    @FXML
    private ImageView imgSetting;

    @FXML
    private Button btnAbout;

    @FXML
    private ImageView imgAbout;

    @FXML
    private AnchorPane centerPane;

    @FXML
    private Button btnIssuedBook;


    private Button activeMenuButton;
    private FillTransition ft;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ft = new FillTransition();
        activeMenuButton = btnDashboard;
        btnDashboard.fire();
        btnBookInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewPane = FxmlLoader.getViewPane("/Views/BookInfo.fxml");
                mainBorderPane.setCenter(viewPane);
                btnBookInfo.setStyle("-fx-background-color: #fb8c00");
                btnStudentInfo.setStyle("-fx-background-color: #fff");
                btnIsuueReturnBook.setStyle("-fx-background-color: #fff");
                btnIssuedBook.setStyle("-fx-background-color: #fff");
            }
        });

        btnStudentInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewPane = FxmlLoader.getViewPane("/Views/StudentInfo.fxml");
                mainBorderPane.setCenter(viewPane);
                btnStudentInfo.setStyle("-fx-background-color: #fb8c00");
                btnBookInfo.setStyle("-fx-background-color: #fff");
                btnIsuueReturnBook.setStyle("-fx-background-color: #fff");
                btnIssuedBook.setStyle("-fx-background-color: #fff");
            }
        });
        btnIsuueReturnBook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewPane = FxmlLoader.getViewPane("/Views/BookIsuaReturn.fxml");
                mainBorderPane.setCenter(viewPane);
                btnIsuueReturnBook.setStyle("-fx-background-color: #fb8c00");
                btnBookInfo.setStyle("-fx-background-color: #fff");
                btnStudentInfo.setStyle("-fx-background-color: #fff");
                btnIssuedBook.setStyle("-fx-background-color: #fff");
            }
        });

        btnIssuedBook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewPane = FxmlLoader.getViewPane("/Views/AllissuedlBook.fxml");
                mainBorderPane.setCenter(viewPane);
                btnIssuedBook.setStyle("-fx-background-color: #fb8c00");
                btnBookInfo.setStyle("-fx-background-color: #fff");
                btnStudentInfo.setStyle("-fx-background-color: #fff");
                btnIsuueReturnBook.setStyle("-fx-background-color: #fff");
            }
        });
    }
}

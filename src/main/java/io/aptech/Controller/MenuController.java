package io.aptech.Controller;

import io.aptech.Execute.FxmlLoader;
import javafx.animation.FillTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private StackPane stackRootPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnAuthor;
    @FXML
    private Button btnPulisher;
    @FXML
    private Button btnCategory;


    @FXML
    private Button btnIsuueReturnBook;



    @FXML
    private Button btnStudentInfo;



    @FXML
    private Button btnBookInfo;
    @FXML
    private Pane viewPane;
    @FXML
    private BorderPane mainBorderPane;

    @FXML AnchorPane dasbord;







    @FXML
    private Button btnIssuedBook;


    private Button activeMenuButton;
    private FillTransition ft;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewPane = FxmlLoader.getViewPane("/Views/Dashbord.fxml");
        mainBorderPane.setCenter(viewPane);
        btnDashboard.setStyle("-fx-background-color: #fb8c00");


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
                btnAuthor.setStyle("-fx-background-color: #fff");
                btnPulisher.setStyle("-fx-background-color: #fff");
                btnCategory.setStyle("-fx-background-color: #fff");
                btnDashboard.setStyle("-fx-background-color: #fff");

            }
        });

        btnDashboard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewPane = FxmlLoader.getViewPane("/Views/Dashbord.fxml");
                mainBorderPane.setCenter(viewPane);
                btnDashboard.setStyle("-fx-background-color: #fb8c00");

                btnBookInfo.setStyle("-fx-background-color: #fff");
                btnStudentInfo.setStyle("-fx-background-color: #fff");
                btnIsuueReturnBook.setStyle("-fx-background-color: #fff");
                btnIssuedBook.setStyle("-fx-background-color: #fff");
                btnAuthor.setStyle("-fx-background-color: #fff");
                btnPulisher.setStyle("-fx-background-color: #fff");
                btnCategory.setStyle("-fx-background-color: #fff");

            }
        });



        btnStudentInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewPane = FxmlLoader.getViewPane("/Views/ReaderInfo.fxml");
                mainBorderPane.setCenter(viewPane);
                btnStudentInfo.setStyle("-fx-background-color: #fb8c00");
                btnBookInfo.setStyle("-fx-background-color: #fff");
                btnIsuueReturnBook.setStyle("-fx-background-color: #fff");
                btnIssuedBook.setStyle("-fx-background-color: #fff");
                btnAuthor.setStyle("-fx-background-color: #fff");
                btnPulisher.setStyle("-fx-background-color: #fff");
                btnCategory.setStyle("-fx-background-color: #fff");
                btnDashboard.setStyle("-fx-background-color: #fff");
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
                btnAuthor.setStyle("-fx-background-color: #fff");
                btnPulisher.setStyle("-fx-background-color: #fff");
                btnCategory.setStyle("-fx-background-color: #fff");
                btnDashboard.setStyle("-fx-background-color: #fff");
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
                btnAuthor.setStyle("-fx-background-color: #fff");
                btnPulisher.setStyle("-fx-background-color: #fff");
                btnCategory.setStyle("-fx-background-color: #fff");
                btnDashboard.setStyle("-fx-background-color: #fff");
            }
        });
        btnAuthor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewPane = FxmlLoader.getViewPane("/Views/Author.fxml");
                mainBorderPane.setCenter(viewPane);
                btnIssuedBook.setStyle("-fx-background-color: #fff");
                btnBookInfo.setStyle("-fx-background-color: #fff");
                btnStudentInfo.setStyle("-fx-background-color: #fff");
                btnIsuueReturnBook.setStyle("-fx-background-color: #fff");
                btnAuthor.setStyle("-fx-background-color: #fb8c00");
                btnPulisher.setStyle("-fx-background-color: #fff");
                btnCategory.setStyle("-fx-background-color: #fff");
                btnDashboard.setStyle("-fx-background-color: #fff");
            }
        });
        btnPulisher.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewPane = FxmlLoader.getViewPane("/Views/Pulisher.fxml");
                mainBorderPane.setCenter(viewPane);
                btnIssuedBook.setStyle("-fx-background-color: #fff");
                btnBookInfo.setStyle("-fx-background-color: #fff");
                btnStudentInfo.setStyle("-fx-background-color: #fff");
                btnIsuueReturnBook.setStyle("-fx-background-color: #fff");
                btnAuthor.setStyle("-fx-background-color: #fff");
                btnPulisher.setStyle("-fx-background-color: #fb8c00");
                btnCategory.setStyle("-fx-background-color: #fff");
                btnDashboard.setStyle("-fx-background-color: #fff");
            }
        });
        btnCategory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewPane = FxmlLoader.getViewPane("/Views/Category.fxml");
                mainBorderPane.setCenter(viewPane);
                btnIssuedBook.setStyle("-fx-background-color: #fff");
                btnBookInfo.setStyle("-fx-background-color: #fff");
                btnStudentInfo.setStyle("-fx-background-color: #fff");
                btnIsuueReturnBook.setStyle("-fx-background-color: #fff");
                btnAuthor.setStyle("-fx-background-color: #fff");
                btnPulisher.setStyle("-fx-background-color: #fff");
                btnCategory.setStyle("-fx-background-color: #fb8c00");
                btnDashboard.setStyle("-fx-background-color: #fff");
            }
        });
    }
}

package io.aptech.Controller;
import io.aptech.Model.MySqlConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DashbordController implements Initializable {
    @FXML
    private Label all_Books;

    @FXML
    private BarChart<?, ?> barchart;

    @FXML
    private AnchorPane dataReportViewer;

    @FXML
    private ImageView imgIssueBook;

    @FXML
    private ImageView imgRetrunBook;

    @FXML
    private ImageView imgRetrunBook1;

    @FXML
    private ImageView imgTotalBook;

    @FXML
    private Label iss_Books;

    @FXML
    private AnchorPane issue3dAnchor;

    @FXML
    private AnchorPane issueRoundAnchor;

    @FXML
    private Label lblBook;

    @FXML
    private Label lblIssue;

    @FXML
    private Label lblReturn;

    @FXML
    private Label lblReturn1;

    @FXML
    private Label reader_Books;

    @FXML
    private AnchorPane returnBook3dAnchor;

    @FXML
    private AnchorPane returnBook3dAnchor1;

    @FXML
    private AnchorPane returnBookRoundAnchor;

    @FXML
    private AnchorPane returnBookRoundAnchor1;

    @FXML
    private AnchorPane totalBook3dAnchor;

    @FXML
    private AnchorPane totalBookRoundAnchor;

    @FXML
    private Label total_Books;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    //    DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    public void allbook(){

        String sql = "SELECT COUNT(id) FROM book ";

        connect = MySqlConnection.getConnection();
        int countAC = 0;
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while(result.next()){
                countAC = result.getInt("COUNT(id)");
            }

            all_Books.setText(String.valueOf(countAC));

        }catch(Exception e){e.printStackTrace();}

    }
    public void readers(){
        String sql = "SELECT COUNT(id) FROM reader ";

        connect = MySqlConnection.getConnection();
        int countAC = 0;
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while(result.next()){
                countAC = result.getInt("COUNT(id)");
            }

            reader_Books.setText(String.valueOf(countAC));

        }catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allbook();
        readers();
    }
}

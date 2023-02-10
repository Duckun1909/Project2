module io.aptech.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires validatorfx;
//    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;

    requires java.sql;
    requires mysql.connector.j;

    opens io.aptech.Execute to javafx.fxml;
    exports io.aptech.Execute;
    exports io.aptech.Controller;
    opens io.aptech.Controller to javafx.fxml;


    exports io.aptech.Entity;
    opens io.aptech.Entity to javafx.fxml;

}
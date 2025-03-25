module com.example.chess2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.testng;
    requires org.junit.jupiter.api;

    opens com.example.chess2 to javafx.fxml;
    exports com.example.chess2;
}
module com.example.random3dart {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.random3dart to javafx.fxml;
    exports com.example.random3dart;
}
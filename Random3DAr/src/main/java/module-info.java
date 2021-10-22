module com.example.random3dar {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.random3dar to javafx.fxml;
    exports com.example.random3dar;
}
module com.example.dynamicartshape {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.dynamicartshape to javafx.fxml;
    exports com.example.dynamicartshape;
}
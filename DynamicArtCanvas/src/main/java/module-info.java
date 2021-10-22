module com.example.dynamicartcanvas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.dynamicartcanvas to javafx.fxml;
    exports com.example.dynamicartcanvas;
}
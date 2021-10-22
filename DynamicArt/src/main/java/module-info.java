module com.example.dynamicart {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dynamicart to javafx.fxml;
    exports com.example.dynamicart;
}
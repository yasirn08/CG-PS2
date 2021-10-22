package com.example.dynamicartshape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DynamicArtShape extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("DynamicArtShape.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("DynamicArtShape");
        stage.setScene(scene);
        stage.show();
    }
}
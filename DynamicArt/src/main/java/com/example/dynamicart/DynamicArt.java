package com.example.dynamicart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DynamicArt extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("DynamicArt.fxml"));
        primaryStage.setTitle("Dynamic Art Canvas");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
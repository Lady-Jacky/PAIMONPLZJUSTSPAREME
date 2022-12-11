package com.example.paimonplzjustspareme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    boolean fight;

    @Override
    @FXML
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Fightwho.fxml"));
        Scene scene = new Scene(root);
        Image icon = new Image("diona.jpg");
        stage.getIcons().add(icon);
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.setX(100);
        stage.setY(200);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
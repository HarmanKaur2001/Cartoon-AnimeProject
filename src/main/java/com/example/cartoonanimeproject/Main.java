package com.example.cartoonanimeproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CartoonSearchView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Image icon = new Image(CartoonSearch.class.getResourceAsStream("default.jpg"));
        stage.getIcons().add(icon);
        stage.setTitle(" Cartoon-Anime Search");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
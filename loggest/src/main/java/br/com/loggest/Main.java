package br.com.loggest;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.application.Application;

import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlURL = getClass().getResource("/view/FXMLMain.fxml");
        if (fxmlURL != null) {
            FXMLLoader loader = new FXMLLoader(fxmlURL);
            ScrollPane root = loader.load();
            Scene mainScene = new Scene(root);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("LoggGest - Seu sistema de gerenciamento");
            primaryStage.centerOnScreen();
            primaryStage.show();
        } else {
            System.out.println("Arquivo FXML não encontrado!");
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

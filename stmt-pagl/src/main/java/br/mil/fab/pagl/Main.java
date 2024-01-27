package br.mil.fab.pagl;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlURL = getClass().getResource("/view/FXMLMain.fxml");
        if (fxmlURL != null) {
            FXMLLoader loader = new FXMLLoader(fxmlURL);
            Parent root = loader.load();
            primaryStage.setTitle("Prefeitura da Aéronautica do Galeão (PAGL)");
            primaryStage.setMaximized(false);
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        } else {
            System.out.println("Arquivo FXML não encontrado!");
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

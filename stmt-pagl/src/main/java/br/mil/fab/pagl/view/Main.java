package br.mil.fab.pagl.view;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Criar componentes da interface do usuário
        Button btn = new Button("Clique em mim!");

        // Configurar a lógica de evento
        btn.setOnAction(e -> System.out.println("Olá, JavaFX!"));

        // Configurar o layout da interface do usuário
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Configurar a cena
        Scene scene = new Scene(root, 300, 250);

        // Configurar o palco
        primaryStage.setTitle("JavaFX sem FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

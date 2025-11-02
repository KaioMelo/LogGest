package br.com.loggest.model.util;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class SceneNavigator {

    private static final Stack<Scene> SCENE_HISTORY = new Stack<>();
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void navigateTo(Scene newScene) {
        if (primaryStage == null) {
            System.err.println("Primary Stage não foi definido no SceneNavigator!");
            return;
        }

        Scene currentScene = primaryStage.getScene();
        if (currentScene != null && !SCENE_HISTORY.contains(currentScene)) {
            SCENE_HISTORY.push(currentScene);
        }
        primaryStage.setScene(newScene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    public static void goBack() {
        if (!SCENE_HISTORY.isEmpty()) {
            Scene previousScene = SCENE_HISTORY.pop();
            if (primaryStage != null) {
                primaryStage.setScene(previousScene);
                primaryStage.setResizable(false);
                primaryStage.show();
                primaryStage.centerOnScreen();
            }
        } else {
            System.out.println("❌ Sem histórico de cenas para voltar.");
        }
    }
}


package br.com.loggest.controller.home;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLMainController implements Initializable {

    @FXML
    private ProgressBar progressBar = new ProgressBar();
    @FXML
    private Label labelProgress = new Label();
    @Override
    public void initialize(URL url, ResourceBundle rB) {
        progressBar.progressProperty().bind(task.progressProperty());
        task.messageProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                labelProgress.setText("Carregando Sistema..."+ t1 +"%");
            }
        });
        new Thread(task).start();
        task.setOnSucceeded(ev -> {
            labelProgress.setText("Tudo pronto!");
//            progressBar.getScene().getWindow().hide();
//            Stage stage = new Stage();
            try {
                Stage stage = (Stage) progressBar.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/home/FXMLLogin.fxml"));
                Parent root = loader.load();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
                stage.centerOnScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Task<ObservableList> task = new Task<ObservableList>() {
        @Override
        protected ObservableList call() throws Exception {
            for(int i = 0; i < 101; i++){
                updateProgress(i, 99);
                updateMessage(String.valueOf(i));
                Thread.sleep(100);
            }
            return null;
        }
    };
}

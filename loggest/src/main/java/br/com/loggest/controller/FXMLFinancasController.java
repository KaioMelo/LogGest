package br.com.loggest.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLFinancasController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private void loadScene(String fxmlPath, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        ScrollPane root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    public void handleHome(ActionEvent event) throws IOException {
        loadScene("/view/home/FXMLInicio.fxml", event);
    }

    @FXML
    public void handleClientes(ActionEvent event) throws IOException {
        loadScene("/view/cliente/FXMLClientes.fxml", event);
    }

    @FXML
    public void handleEstoque(ActionEvent event) throws IOException {
        loadScene("/view/FXMLEstoque.fxml", event);
    }

    @FXML
    public void handleVeiculos(ActionEvent event) throws IOException {
        loadScene("/view/FXMLVeiculos.fxml", event);
    }

    @FXML
    public void handleSinistro(ActionEvent event) throws IOException {
        loadScene("/view/FXMLSinistro.fxml", event);
    }

    @FXML
    public void handleRecursosHumanos(ActionEvent event) throws IOException {
        loadScene("/view/FXMLRecursosHumanos.fxml", event);
    }

    @FXML
    public void handleFinanceiro(ActionEvent event) throws IOException {
        loadScene("/view/FXMLFinancas.fxml", event);
    }

    @FXML
    public void handleRelatorios(ActionEvent event) throws IOException {
        loadScene("/view/FXMLRelatorios.fxml", event);
    }
}

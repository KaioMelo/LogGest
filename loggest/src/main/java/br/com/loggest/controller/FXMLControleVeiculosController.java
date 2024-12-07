package br.com.loggest.controller;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLControleVeiculosController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private void loadScene(String fxmlPath, Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Node root = loader.load();
        Scene scene = new Scene((Parent) root);
        Stage stage = null;

        if (event.getSource() instanceof Node) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        }

        if (stage != null) {
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        } else {
            throw new IllegalStateException("O Stage não pôde ser obtido.");
        }
    }

    @FXML
    public void handleHome(ActionEvent event) throws IOException {
        loadScene("/view/FXMLInicio.fxml", event);
    }

    @FXML
    public void handleClientes(ActionEvent event) throws IOException {
        loadScene("/view/FXMLRegistroClientes.fxml", event);
    }

    @FXML
    public void handleFornecedores(ActionEvent event) throws IOException {
        loadScene("/view/FXMLRegistroFornecedores.fxml", event);
    }

    @FXML
    public void handleEstoque(ActionEvent event) throws IOException {
        loadScene("/view/FXMLControleEstoque.fxml", event);
    }

    @FXML
    public void handleVeiculos(ActionEvent event) throws IOException {
        loadScene("/view/FXMLControleVeiculos.fxml", event);
    }

    @FXML
    public void handleRecursosHumanos(ActionEvent event) throws IOException {
        loadScene("/view/FXMLControleRecursosHumanos.fxml", event);
    }

    @FXML
    public void handleFinanceiro(ActionEvent event) throws IOException {
        loadScene("/view/FXMLControleFinanceiro.fxml", event);
    }

    @FXML
    public void handleRelatorios(ActionEvent event) throws IOException {
        loadScene("/view/FXMLControleRelatorios.fxml", event);
    }

    @FXML
    public void handleEstatisticas(ActionEvent event) throws IOException {
        loadScene("/view/FXMLEstatisticas.fxml", event);
    }

    //Controle Ações no painel
    @FXML
    public void handleRegistroVeiculos(Event event) throws IOException{
        loadScene("/view/FXMLRegistroVeiculos.fxml", event);
    }
}

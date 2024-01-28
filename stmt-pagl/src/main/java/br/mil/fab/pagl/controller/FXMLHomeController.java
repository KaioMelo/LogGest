package br.mil.fab.pagl.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLHomeController{
    @FXML
    private MenuItem menuItemVeiculo;
    @FXML
    private MenuItem menuItemMotorista;

    private void loadScene(String fxmlPath, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleHome(ActionEvent event) throws IOException {
        loadScene("/view/FXMLHome.fxml", event);
    }

    @FXML
    public void handleVeiculo(ActionEvent event) throws IOException {
        loadScene("/view/FXMLVeiculo.fxml", event);
    }

    @FXML
    public void handleMotorista(ActionEvent event) throws IOException {
        loadScene("/view/FXMLMotorista.fxml", event);
    }
}

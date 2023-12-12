package br.mil.fab.pagl.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLHomeController implements Initializable {
    @FXML
    private MenuItem menuItemVeiculo;
    @FXML
    private MenuItem menuItemMotorista;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rB) {

    }

    @FXML
    public void handleMenuItemVeiculo () throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FXMLVeiculo.fxml"));
        anchorPane.getChildren().setAll(a);
    }
}

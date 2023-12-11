package br.mil.fab.pagl.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLHomeController implements Initializable {

    @FXML
    private MenuItem menuItemVeiculo;

    @Override
    public void initialize(URL url, ResourceBundle rB) {

    }

    @FXML
    public void entrarEmInterfaceVeiculo () throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLVeiculo.fxml"));
    }
}

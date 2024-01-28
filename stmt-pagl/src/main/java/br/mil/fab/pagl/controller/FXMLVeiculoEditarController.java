package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.VeiculoDAO;
import br.mil.fab.pagl.dao.impl.VeiculoDAOImpl;
import br.mil.fab.pagl.model.Veiculo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class FXMLVeiculoEditarController {
    @FXML
    private TextField textFieldRegFab;
    @FXML
    private TextField textFieldPlaca;
    @FXML
    private TextField textFieldMarca;
    @FXML
    private TextField textFieldModelo;
    @FXML
    private Button buttonEditar;
    @FXML
    private Button buttonCancelar;

    private List<Veiculo> listVeiculos;
    private ObservableList<Veiculo> observableListVeiculo;
    private VeiculoDAO veiculoDAO = new VeiculoDAOImpl();

    @FXML
    public void handleCancelarAtualizacao(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLVeiculo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleAtualizarVeiculo(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Veiculo obj = new Veiculo();
        try {
            if (validarEntradasDeDados()) {
                obj.setRg_fab(textFieldRegFab.getText());
                obj.setPlaca(textFieldPlaca.getText());
                obj.setMarca(textFieldMarca.getText());
                obj.setModelo(textFieldModelo.getText());
                clearFileds();
                alert.setTitle("SUCESSO!");
                alert.setHeaderText("Veículo Atualizado!");
                alert.show();
                veiculoDAO.update(obj);
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLVeiculo.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void HandleCarregarCampos(String rgFab, String placa, String marca, String modelo) {
        textFieldRegFab.setText(rgFab);
        textFieldPlaca.setText(placa);
        textFieldMarca.setText(marca);
        textFieldModelo.setText(modelo);
    }

    private boolean validarEntradasDeDados() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String errorMessage = "";
        Veiculo obj = new Veiculo();

        if (textFieldRegFab.getText() == null || textFieldRegFab.getText().trim().equals("")) {
            errorMessage += "RegFab Inválido: \n";
        }
        if (textFieldPlaca.getText() == null || textFieldPlaca.getText().trim().equals("")) {
            errorMessage += "Placa Inválida: \n";
        }
        if (textFieldMarca.getText() == null || textFieldMarca.getText().trim().equals("")) {
            errorMessage += "Marca Inválida: \n";
        }
        if (textFieldModelo.getText() == null || textFieldModelo.getText().trim().equals("")) {
            errorMessage += "Modelo Inválido: \n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            clearFileds();
            alert.setTitle("ERROR ao Atualizar Veículo!");
            alert.setHeaderText("Campos inválidos, por favor, corrija!");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

    public void clearFileds() {
        textFieldRegFab.setText("");
        textFieldPlaca.setText("");
        textFieldMarca.setText("");
        textFieldModelo.setText("");
    }
}

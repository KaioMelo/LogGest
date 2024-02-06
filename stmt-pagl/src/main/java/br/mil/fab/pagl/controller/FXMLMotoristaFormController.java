package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.MotoristaDAO;
import br.mil.fab.pagl.dao.VeiculoDAO;
import br.mil.fab.pagl.dao.impl.MotoristaDAOImpl;
import br.mil.fab.pagl.dao.impl.VeiculoDAOImpl;
import br.mil.fab.pagl.model.Motorista;
import br.mil.fab.pagl.model.Veiculo;
import br.mil.fab.pagl.service.MotoristaService;
import br.mil.fab.pagl.util.Utils;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLMotoristaFormController implements Initializable {
    @FXML
    private TextField textFieldIDMotorista;
    @FXML
    private TextField textFieldNomeMotorista;
    @FXML
    private TextField textFieldCNH;
    @FXML
    private TextField textFieldOM;
    @FXML
    private TextField textFieldSessao;
    @FXML
    private Button buttonEditar;
    @FXML
    private Button buttonCancelar;

    private List<Veiculo> listVeiculos;
    private ObservableList<Veiculo> observableListVeiculo;
    private MotoristaService service = new MotoristaService();
    private Motorista motorista;
    private void setMotoristaService(MotoristaService service){
        this.service = service;
    }

    public void setMotorista(Motorista motorista){
        this.motorista = motorista;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void handleCancelarAtualizacao(ActionEvent event) throws IOException {
        Utils.currentStage(event).close();
    }

    @FXML
    public void handleAtualizarVeiculo(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Motorista obj = new Motorista();
        try {
            if (validarEntradasDeDados()) {
                obj.setId_motorista(Integer.parseInt(textFieldIDMotorista.getText()));
                obj.setNome_motorista(textFieldNomeMotorista.getText());
                obj.setCnh(Integer.parseInt(textFieldCNH.getText()));
                obj.setOm(textFieldOM.getText());
                obj.setSessao(textFieldSessao.getText());
                clearFileds();
                alert.setTitle("SUCESSO!");
                alert.setHeaderText("Motorista Atualizado!");
                alert.show();
                service.saveOrUpdate(obj);
                Utils.currentStage(event).close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validarEntradasDeDados(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Veiculo obj = new Veiculo();
        String errorMessage = "";
        if (textFieldNomeMotorista.getText() == null || textFieldNomeMotorista.getText().trim().equals("")) {
            errorMessage += "RegFab Inválido: \n";
        } if (textFieldCNH.getText() == null || textFieldCNH.getText().trim().equals("")) {
            errorMessage += "Placa Inválida: \n";
        } if (textFieldOM.getText() == null || textFieldOM.getText().trim().equals("")) {
            errorMessage += "Marca Inválida: \n";
        } if (textFieldSessao.getText() == null || textFieldSessao.getText().trim().equals("")) {
            errorMessage += "Modelo Inválido: \n";
        } if (errorMessage.length() == 0) {
            return true;
        } else {
            clearFileds();
            alert.setTitle("ERROR ao Cadastrar Motorista!");
            alert.setHeaderText("Campos inválidos, por favor, corrija!");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

    public void clearFileds() {
        textFieldNomeMotorista.setText("");
        textFieldCNH.setText("");
        textFieldOM.setText("");
        textFieldSessao.setText("");
    }

    public void updateFormData(){
        if(motorista == null){
            throw  new IllegalArgumentException("Motorista está nulo");
        }
        textFieldIDMotorista.setText(String.valueOf(motorista.getId_motorista()));
        textFieldNomeMotorista.setText(String.valueOf(motorista.getNome_motorista()));
        textFieldCNH.setText(String.valueOf(motorista.getCnh()));
        textFieldOM.setText(String.valueOf(motorista.getOm()));
        textFieldSessao.setText(String.valueOf(motorista.getSessao()));
    }
}

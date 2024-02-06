package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.OrdemMissaoDAO;

import br.mil.fab.pagl.dao.impl.OrdemMissaoDAOImpl;
import br.mil.fab.pagl.model.OrdemMissao;
import br.mil.fab.pagl.model.Veiculo;
import br.mil.fab.pagl.service.OrdemMissaoService;
import br.mil.fab.pagl.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ResourceBundle;

public class FXMLOrdemMissaoFormController implements Initializable {
    @FXML
    private TextField textFieldIdMissao;
    @FXML
    private TextField textFieldSolicitante;
    @FXML
    private TextField textFieldContato;
    @FXML
    private TextField textFieldDestino;
    @FXML
    private TextField textFieldServico;
    @FXML
    private DatePicker datePickerData;
    @FXML
    private Button buttonRegistrar;
    @FXML
    private Button buttonCancelar;

    private OrdemMissao missao;
    private OrdemMissaoService service = new OrdemMissaoService();

    private void setOrdemMissaoService(OrdemMissaoService service){
        this.service = service;
    }
    public void setOrdemMissao(OrdemMissao missao){
        this.missao = missao;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
    }

    private void initializeNodes(){
        Utils.formatDatePicker(datePickerData, "dd/MM/yyyy");
    }

    @FXML
    public void handleCancelarRegistro(ActionEvent event) throws IOException {
        Utils.currentStage(event).close();
    }

    @FXML
    public void handleRegistrarMissao(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        OrdemMissao obj = new OrdemMissao();
        try {
            if (validarEntradasDeDados()) {
                obj.setSolicitante(textFieldSolicitante.getText().trim().toUpperCase());
                obj.setContato(textFieldContato.getText().trim());
                obj.setServico(textFieldServico.getText().trim());
                obj.setDestino(textFieldDestino.getText().trim());
                obj.setData(Date.valueOf(datePickerData.getValue()));
                clearFileds();
                alert.setTitle("SUCESSO!");
                alert.setHeaderText("Veículo Atualizado!");
                alert.show();
                service.saveOrUpdate(obj);
                Utils.currentStage(event).close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validarEntradasDeDados() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String errorMessage = "";
        Veiculo obj = new Veiculo();

        if (textFieldSolicitante.getText() == null || textFieldSolicitante.getText().trim().equals("")) {
            errorMessage += "Solicitante Inválido: \n";
        }
        if (textFieldContato.getText() == null || textFieldContato.getText().trim().equals("")) {
            errorMessage += "Contato Inválido: \n";
        }
        if (textFieldServico.getText() == null || textFieldServico.getText().trim().equals("")) {
            errorMessage += "Serviço Inválido: \n";
        }
        if (textFieldDestino.getText() == null || textFieldDestino.getText().trim().equals("")) {
            errorMessage += "Destino Inválido: \n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            clearFileds();
            alert.setTitle("ERROR ao Registrar Missão!");
            alert.setHeaderText("Campos inválidos, por favor, corrija!");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

    public void clearFileds() {
        textFieldSolicitante.setText("");
        textFieldContato.setText("");
        textFieldServico.setText("");
        textFieldDestino.setText("");
    }

    public void updateFormData(){
        if(missao == null){
            throw  new IllegalArgumentException("Missão está nulo");
        }
        textFieldIdMissao.setText(String.valueOf(missao.getId_ordem()));
        textFieldSolicitante.setText(missao.getSolicitante());
        textFieldContato.setText(missao.getContato());
        textFieldServico.setText(missao.getServico());
        textFieldDestino.setText(missao.getDestino());
        if(missao.getData() != null){
            datePickerData.setValue(LocalDate.ofInstant(missao.getData().toInstant(), ZoneId.systemDefault()));
        }
    }
}

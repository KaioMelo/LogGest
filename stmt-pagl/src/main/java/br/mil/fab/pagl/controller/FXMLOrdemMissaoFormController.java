//package br.mil.fab.pagl.controller;
//
//
//import br.mil.fab.pagl.model.exceptions.ValidationException;
//import br.mil.fab.pagl.model.entities.Viagens;
//import br.mil.fab.pagl.model.service.OrdemMissaoService;
//import br.mil.fab.pagl.model.util.Alerts;
//import br.mil.fab.pagl.model.util.Utils;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TextField;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Date;
//import java.time.Instant;
//import java.time.ZoneId;
//import java.util.ResourceBundle;
//
//public class FXMLOrdemMissaoFormController implements Initializable {
//    @FXML
//    private TextField textFieldIdMissao;
//    @FXML
//    private TextField textFieldSolicitante;
//    @FXML
//    private TextField textFieldContato;
//    @FXML
//    private TextField textFieldServico;
//    @FXML
//    private TextField textFieldDestino;
//    @FXML
//    private DatePicker datePickerData;
//    @FXML
//    private Button buttonRegistrar;
//    @FXML
//    private Button buttonCancelar;
//
//    private Viagens missao;
//    private OrdemMissaoService service = new OrdemMissaoService();
//    private Viagens obj;
//
//    private void setOrdemMissaoService(OrdemMissaoService service) {
//        this.service = service;
//    }
//
//    public void setOrdemMissao(Viagens missao) {
//        this.missao = missao;
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        initializeNodes();
//    }
//
//    private void initializeNodes() {
//        Utils.formatDatePicker(datePickerData, "dd/MM/yyyy");
//    }
//
//    @FXML
//    public void handleCancelarRegistro(ActionEvent event) throws IOException {
//        Utils.currentStage(event).close();
//    }
//
//    @FXML
//    public void handleRegistrarMissao(ActionEvent event) {
//        if (missao == null) {
//            throw new IllegalStateException("Entity was null");
//        }
//        if (service == null) {
//            throw new IllegalStateException("Service was null");
//        }
//        try {
//            missao = validarEntradasDeDados();
//            service.saveOrUpdate(missao);
//            clearFields();
//            Alerts.showAlert("SUCESSO", "Missão Atualizado!", null, Alert.AlertType.ERROR);
//            Utils.currentStage(event).close();
//
//        }catch (RuntimeException e) {
//            Alerts.showAlert("Error saving object", null, e.getMessage(), Alert.AlertType.ERROR);
//        }
//    }
//
//    private Viagens validarEntradasDeDados() {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        ValidationException exception = new ValidationException("Validation error");
//        Viagens obj = new Viagens();
//
//        obj.setId_ordem(Utils.tryParseToInt(textFieldIdMissao.getText()));
//
//        if (textFieldSolicitante.getText() == null || textFieldSolicitante.getText().trim().equals("")) {
//            exception.addError("Solicitante", "Inválido");
//        }
//        obj.setSolicitante(textFieldSolicitante.getText());
//        if (textFieldContato.getText() == null || textFieldContato.getText().trim().equals("")) {
//            exception.addError("Contato", "Inválido");
//        }
//        obj.setContato(textFieldContato.getText());
//        if (textFieldServico.getText() == null || textFieldServico.getText().trim().equals("")) {
//            exception.addError("Serviço", "Inválido");
//        }
//        obj.setServico(textFieldServico.getText());
//        if (textFieldDestino.getText() == null || textFieldDestino.getText().trim().equals("")) {
//            exception.addError("Destino", "Inválido");
//        }
//        obj.setDestino(textFieldDestino.getText());
//        if (datePickerData.getValue() == null){
//            exception.addError("Data", "Inválido");
//        }else{
//            Instant instant = Instant.from(datePickerData.getValue().atStartOfDay(ZoneId.systemDefault()));
//            obj.setData(Date.from(instant));
//        }
//        if (exception.getErrors().size() > 0) {
//            clearFields();
//            alert.setTitle("ERROR ao Registrar Missão!");
//            alert.setHeaderText("Campos inválidos, por favor, corrija!");
//            alert.show();
//            throw exception;
//        }
//        return obj;
//    }
//
//    public void clearFields() {
//        textFieldSolicitante.setText("");
//        textFieldContato.setText("");
//        textFieldServico.setText("");
//        textFieldDestino.setText("");
//        datePickerData.setValue(null);
//    }
//
//    public void updateFormData() {
//        if (missao == null) {
//            throw new IllegalArgumentException("Missão está nulo");
//        }
//        textFieldIdMissao.setText(String.valueOf(missao.getId_ordem()));
//        textFieldSolicitante.setText(missao.getSolicitante());
//        textFieldContato.setText(missao.getContato());
//        textFieldServico.setText(missao.getServico());
//        textFieldDestino.setText(missao.getDestino());
//        if (missao.getData() != null) {
//            Date dataSql = (Date) missao.getData();
//            java.util.Date utilDate = new java.util.Date(dataSql.getTime());
//            datePickerData.setValue(utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//        }
//    }
//}

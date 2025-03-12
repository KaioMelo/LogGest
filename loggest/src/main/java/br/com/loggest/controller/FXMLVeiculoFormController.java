//package br.com.loggest.controller;
//
//import br.com.loggest.model.entities.Veiculo;
//import br.com.loggest.model.service.VeiculoService;
//import br.com.loggest.model.util.Utils;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class FXMLVeiculoFormController implements Initializable {
//    private Veiculo veiculo;
//    @FXML
//    private TextField textFieldIdVeiculo;
//    @FXML
//    private TextField textFieldRegFab;
//    @FXML
//    private TextField textFieldPlaca;
//    @FXML
//    private TextField textFieldMarca;
//    @FXML
//    private TextField textFieldModelo;
//    @FXML
//    private Button buttonEditar;
//    @FXML
//    private Button buttonCancelar;
//
//    private List<Veiculo> listVeiculos;
//    private ObservableList<Veiculo> observableListVeiculo;
//
//    private VeiculoService service = new VeiculoService();
//    public void setVeiculo(Veiculo veiculo){
//        this.veiculo = veiculo;
//    }
//
//    private void setVeiculoService(VeiculoService service){
//        this.service = service;
//    }
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }
//
//    @FXML
//    public void handleCancelarAtualizacao(ActionEvent event) throws IOException {
//        Utils.currentStage(event).close();
//    }
//
//    @FXML
//    public void handleAtualizarVeiculo(ActionEvent event){
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        Veiculo obj = new Veiculo();
//        try {
//            if (validarEntradasDeDados()) {
//                /*obj.setId_veiculo(Integer.parseInt(textFieldIdVeiculo.getText()));
//                obj.setRg_fab(textFieldRegFab.getText());*/
//                obj.setPlaca(textFieldPlaca.getText());
//                obj.setMarca(textFieldMarca.getText());
//                obj.setModelo(textFieldModelo.getText());
//                clearFileds();
//                alert.setTitle("SUCESSO!");
//                alert.setHeaderText("Veículo Atualizado!");
//                alert.show();
//                service.saveOrUpdate(obj);
//                Utils.currentStage(event).close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private boolean validarEntradasDeDados() {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        String errorMessage = "";
//        Veiculo obj = new Veiculo();
//
//        if (textFieldRegFab.getText() == null || textFieldRegFab.getText().trim().equals("")) {
//            errorMessage += "RegFab Inválido: \n";
//        }
//        if (textFieldPlaca.getText() == null || textFieldPlaca.getText().trim().equals("")) {
//            errorMessage += "Placa Inválida: \n";
//        }
//        if (textFieldMarca.getText() == null || textFieldMarca.getText().trim().equals("")) {
//            errorMessage += "Marca Inválida: \n";
//        }
//        if (textFieldModelo.getText() == null || textFieldModelo.getText().trim().equals("")) {
//            errorMessage += "Modelo Inválido: \n";
//        }
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            clearFileds();
//            alert.setTitle("ERROR ao Atualizar Veículo!");
//            alert.setHeaderText("Campos inválidos, por favor, corrija!");
//            alert.setContentText(errorMessage);
//            alert.show();
//            return false;
//        }
//    }
//
//    public void clearFileds() {
//        textFieldRegFab.setText("");
//        textFieldPlaca.setText("");
//        textFieldMarca.setText("");
//        textFieldModelo.setText("");
//    }
//
//    public void updateFormData(){
//        if(veiculo == null){
//            throw  new IllegalArgumentException("Veículo está nulo");
//        }
//        /*textFieldIdVeiculo.setText(String.valueOf(veiculo.getId_veiculo()));
//        textFieldRegFab.setText(String.valueOf(veiculo.getRg_fab()));*/
//        textFieldPlaca.setText(String.valueOf(veiculo.getPlaca()));
//        textFieldMarca.setText(String.valueOf(veiculo.getMarca()));
//        textFieldModelo.setText(String.valueOf(veiculo.getModelo()));
//    }
//}

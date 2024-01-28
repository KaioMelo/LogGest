package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.MotoristaDAO;
import br.mil.fab.pagl.dao.VeiculoDAO;
import br.mil.fab.pagl.dao.impl.MotoristaDAOImpl;
import br.mil.fab.pagl.dao.impl.VeiculoDAOImpl;
import br.mil.fab.pagl.model.Motorista;
import br.mil.fab.pagl.model.Veiculo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLMotoristaEditarController implements Initializable {
    @FXML
    private TextField textFieldNomeMotorista;
    @FXML
    private TextField textFieldCNH;
    @FXML
    private  TextField textFieldOM;
    @FXML
    private  TextField textFieldSessao;
    @FXML
    private Button buttonEditar;
    @FXML
    private Button buttonCancelar;

    private List<Motorista> listaMotoristas;
    private ObservableList<Motorista> observableListMotorista;
    private MotoristaDAO motoristaDAO = new MotoristaDAOImpl();
    private Stage dialoStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void handleCancelarAtualizacao(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLMotorista.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private Motorista AtualizarMotorista() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Motorista obj = new Motorista();
        try {
            if(validarEntradasDeDados()){
                obj.setNome_motorista(textFieldNomeMotorista.getText().toUpperCase());
                obj.setCnh(Integer.parseInt(textFieldCNH.getText()));
                obj.setOm(textFieldOM.getText());
                obj.setSessao(textFieldSessao.getText());
                clearFileds();
                alert.setTitle("SUCESSO!");
                alert.setHeaderText("Motorista Atualizado!");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
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
}

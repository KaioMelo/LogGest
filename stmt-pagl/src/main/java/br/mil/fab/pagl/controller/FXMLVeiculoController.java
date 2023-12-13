package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.VeiculoDAO;
import br.mil.fab.pagl.dao.impl.VeiculoDAOImpl;
import br.mil.fab.pagl.model.Veiculo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLVeiculoController implements Initializable {

    @FXML
    private TableView<Veiculo> tableViewVeiculo;
    @FXML
    private TableColumn<Veiculo, String> tableColumnRegFab;
    @FXML
    private TableColumn<Veiculo, String> tableColumnPlaca;
    @FXML
    private TableColumn<Veiculo, String> tableColumnMarca;
    @FXML
    private TableColumn<Veiculo, String> tableColumnModelo;
    @FXML
    private TextField textFieldRegFab;
    @FXML
    private TextField textFieldPlaca;
    @FXML
    private TextField textFieldMarca;
    @FXML
    private TextField textFieldModelo;
    @FXML
    private TextField textFieldList;
    @FXML
    private Button buttonAdicionar;
    @FXML
    private Button buttonEditar;
    @FXML
    private Button buttonDeletar;

    private List<Veiculo> listVeiculos;
    private ObservableList<Veiculo> observableListVeiculo;
    private VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
    private Stage dialoStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarTableViewVeiculos();
    }

    @FXML
    public void handleHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLHome.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleVeiculo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLVeiculo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleMotorista(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLMotorista.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleAdicionarVeiculo(ActionEvent event) {
        Veiculo obj = new Veiculo();
        obj = registarVeiculo();
        veiculoDAO.create(obj);
        tableViewVeiculo.getItems().clear();
        carregarTableViewVeiculos();
    }

    @FXML
    public void carregarTableViewVeiculos() {
        tableColumnRegFab.setCellValueFactory(new PropertyValueFactory<>("rg_fab"));
        tableColumnPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        tableColumnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tableColumnModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tableViewVeiculo.getItems().addAll(veiculoDAO.findAll());
    }

    @FXML
    public void handleEditarVeiculo() {
        handleTextFieldList();
    }

    @FXML
    public void handleDeletarVeiculo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String rgFab = "";
        Veiculo selectedVeiculo = tableViewVeiculo.getSelectionModel().getSelectedItem();
        if (selectedVeiculo != null) {
            rgFab = selectedVeiculo.getRg_fab();
        }
        clearFileds();
        alert.setTitle("SUCESSO!");
        alert.setHeaderText("Veículo Deletado!");
        alert.show();
        veiculoDAO.deleteByRgFab(rgFab);
        tableViewVeiculo.getItems().clear();
        carregarTableViewVeiculos();
    }

    @FXML
    private void handleTextFieldList(){

    }

    private Veiculo registarVeiculo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Veiculo obj = new Veiculo();
        try {
            if(validarEntradasDeDados()){
                obj.setRg_fab(textFieldRegFab.getText().toUpperCase());
                obj.setPlaca(textFieldPlaca.getText().toUpperCase());
                obj.setMarca(textFieldMarca.getText());
                obj.setModelo(textFieldModelo.getText());
                clearFileds();
                alert.setTitle("SUCESSO!");
                alert.setHeaderText("Veículo Cadastrado!");
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
        if (textFieldRegFab.getText() == null || textFieldRegFab.getText().trim().equals("")) {
            errorMessage += "RegFab Inválido: \n";
        } if (textFieldPlaca.getText() == null || textFieldPlaca.getText().trim().equals("")) {
            errorMessage += "Placa Inválida: \n";
        } if (textFieldMarca.getText() == null || textFieldMarca.getText().trim().equals("")) {
            errorMessage += "Marca Inválida: \n";
        } if (textFieldModelo.getText() == null || textFieldModelo.getText().trim().equals("")) {
            errorMessage += "Modelo Inválido: \n";
        } if (errorMessage.length() == 0) {
            return true;
        } else {
            clearFileds();
            alert.setTitle("ERROR ao Cadastrar Veículo!");
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

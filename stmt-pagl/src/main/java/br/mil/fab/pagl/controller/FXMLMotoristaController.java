package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.MotoristaDAO;
import br.mil.fab.pagl.dao.impl.MotoristaDAOImpl;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class FXMLMotoristaController implements Initializable {

    @FXML
    private TableView<Motorista> tableViewMotorista;
    @FXML
    private TableColumn<Motorista, String> tableColumnNome;
    @FXML
    private TableColumn<Motorista, Integer> tableColumnCNH;
    @FXML
    private TableColumn<Motorista, String> tableColumnOM;
    @FXML
    private TableColumn<Motorista, String> tableColumnSessao;
    @FXML
    private TextField textFieldNomeMotorista;
    @FXML
    private TextField textFieldCNH;
    @FXML
    private  TextField textFieldOM;
    @FXML
    private  TextField textFieldSessao;
    private List<Motorista> listaMotoristas;
    private ObservableList<Motorista> observableListMotorista;
    private MotoristaDAO motoristaDAO = new MotoristaDAOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarTableViewMotorista();
    }
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

    public void handleAdicionarMotorista (ActionEvent event){
        Motorista obj = new Motorista();
        obj = registrarMotorista();
        motoristaDAO.create(obj);
        tableViewMotorista.getItems().clear();
        carregarTableViewMotorista();
    }

    @FXML
    public void carregarTableViewMotorista() {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome_motorista"));
        tableColumnCNH.setCellValueFactory(new PropertyValueFactory<>("cnh"));
        tableColumnOM.setCellValueFactory(new PropertyValueFactory<>("om"));
        tableColumnSessao.setCellValueFactory(new PropertyValueFactory<>("sessao"));
        tableViewMotorista.getItems().addAll(motoristaDAO.findAll());
    }

    private Motorista registrarMotorista(){
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
                alert.setHeaderText("Motorista Cadastrado!");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    @FXML
    public void handleEditarMotorista(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLMotoristaEditar.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleDeletarMotorista(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Integer cnh = null;
        Motorista selectedMotorista = tableViewMotorista.getSelectionModel().getSelectedItem();
        if (selectedMotorista != null) {
            cnh = selectedMotorista.getCnh();
        }
        clearFileds();
        alert.setTitle("SUCESSO!");
        alert.setHeaderText("Motorista Deletado!");
        alert.show();
        motoristaDAO.deleteByCNH(cnh);
        tableViewMotorista.getItems().clear();
        carregarTableViewMotorista();
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

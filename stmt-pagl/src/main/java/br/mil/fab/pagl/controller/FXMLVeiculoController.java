package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.VeiculoDAO;
import br.mil.fab.pagl.dao.impl.VeiculoDAOImpl;
import br.mil.fab.pagl.model.Veiculo;
import com.google.protobuf.Descriptors;
import javafx.collections.FXCollections;
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
    public void handleHome (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLHome.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleVeiculo (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLVeiculo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleMotorista (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLMotorista.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleAdicionarVeiculo(ActionEvent event){
        Veiculo obj = new Veiculo();
        obj = registarVeiculo();
        veiculoDAO.create(obj);
    }

    @FXML
    public void carregarTableViewVeiculos(){

    }

    @FXML
    public void handleEditarVeiculo(){

    }

    @FXML
    public void handleDeletarVeiculo(){

    }

    private Veiculo registarVeiculo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Veiculo obj = new Veiculo();
        try {
            if(textFieldRegFab.getText() == null || textFieldRegFab.getText().trim().equals("")){

            }
            obj.setRg_fab(textFieldRegFab.getText().toUpperCase());
            if(textFieldPlaca.getText() == null || textFieldPlaca.getText().trim().equals("")) {

            }
            obj.setPlaca(textFieldPlaca.getText().toUpperCase());
            if(textFieldMarca.getText() == null || textFieldMarca.getText().trim().equals("")) {

            }
            obj.setMarca(textFieldMarca.getText());
            if(textFieldModelo.getText() == null || textFieldModelo.getText().trim().equals("")) {

            }
            obj.setModelo(textFieldModelo.getText());

            clearFileds();
            alert.setContentText("Veículo Registrado com Sucesso!");
            alert.showAndWait();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }

    public void clearFileds(){
        textFieldRegFab.setText("");
        textFieldPlaca.setText("");
        textFieldMarca.setText("");
        textFieldModelo.setText("");
    }
}

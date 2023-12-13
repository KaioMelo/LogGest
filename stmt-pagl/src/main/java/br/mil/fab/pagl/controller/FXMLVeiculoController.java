package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.VeiculoDAO;
import br.mil.fab.pagl.model.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

    private Veiculo veiculo;
    private List<Veiculo> listVeiculos;
    private ObservableList<Veiculo> observableListVeiculo;
    private VeiculoDAO veiculoDAO;
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
    public void carregarTableViewVeiculos(){
        tableColumnRegFab.setCellValueFactory(new PropertyValueFactory<>("rg_fab"));
        tableColumnPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        tableColumnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tableColumnModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        listVeiculos = veiculoDAO.findAll();

        observableListVeiculo = FXCollections.observableArrayList(listVeiculos);
        tableViewVeiculo.setItems(observableListVeiculo);
    }

    @FXML
    public void handleAdicionarVeiculo() throws IOException{
        veiculo.setRg_fab(textFieldRegFab.getText());
        veiculo.setPlaca(textFieldPlaca.getText());
        veiculo.setMarca(textFieldMarca.getText());
        veiculo.setModelo(textFieldModelo.getText());

        veiculoDAO.create(veiculo);
        carregarTableViewVeiculos();
    }

    @FXML
    public void handleEditarVeiculo(){

    }

    @FXML
    public void handleDeletarVeiculo(){

    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}

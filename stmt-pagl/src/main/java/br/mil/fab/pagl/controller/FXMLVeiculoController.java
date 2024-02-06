package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.VeiculoDAO;
import br.mil.fab.pagl.dao.impl.VeiculoDAOImpl;
import br.mil.fab.pagl.model.Veiculo;
import br.mil.fab.pagl.service.VeiculoService;
import br.mil.fab.pagl.util.Alerts;
import br.mil.fab.pagl.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class FXMLVeiculoController implements Initializable {

    @FXML
    private TableView<Veiculo> tableViewVeiculo;
    @FXML
    private TableColumn<Veiculo, String> tableColumnIDVeiculo;
    @FXML
    private TableColumn<Veiculo, String> tableColumnRegFab;
    @FXML
    private TableColumn<Veiculo, String> tableColumnPlaca;
    @FXML
    private TableColumn<Veiculo, String> tableColumnMarca;
    @FXML
    private TableColumn<Veiculo, String> tableColumnModelo;
    @FXML
    private TableColumn<Veiculo, Veiculo> tableColumnUPDATE;
    @FXML
    private TableColumn<Veiculo, Veiculo> tableColumnDELETE;
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


    private VeiculoService service = new VeiculoService();

    private void setVeiculoService(VeiculoService service){
        this.service = service;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarTableViewVeiculos();
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
        loadScene("/view/FXMLOrdemMissao.fxml", event);
    }

    @FXML
    public void handleVeiculo(ActionEvent event) throws IOException {
        loadScene("/view/FXMLVeiculo.fxml", event);
    }

    @FXML
    public void handleMotorista(ActionEvent event) throws IOException {
        loadScene("/view/FXMLMotorista.fxml", event);
    }

    @FXML
    public void handleAdicionarVeiculo(ActionEvent event) {
        Veiculo obj = new Veiculo();
        obj = registarVeiculo();
        service.saveOrUpdate(obj);
        tableViewVeiculo.getItems().clear();
        carregarTableViewVeiculos();
    }

    @FXML
    public void carregarTableViewVeiculos() {
        tableColumnIDVeiculo.setCellValueFactory(new PropertyValueFactory<>("id_veiculo"));
        tableColumnRegFab.setCellValueFactory(new PropertyValueFactory<>("rg_fab"));
        tableColumnPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        tableColumnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tableColumnModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tableViewVeiculo.getItems().addAll(service.findAll());
        initEditButtons();
        initRemoveButtons();
    }

    @FXML
    public void handleEditarVeiculo(ActionEvent event){
        Stage parentStage = Utils.currentStage(event);
        Veiculo obj = new Veiculo();
        createDialogForm(obj,"/view/FXMLVeiculoForm.fxml", parentStage);
    }

    public Veiculo registarVeiculo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Veiculo obj = new Veiculo();
        try {
            if (validarEntradasDeDados()) {
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

    private boolean validarEntradasDeDados() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Veiculo obj = new Veiculo();
        String errorMessage = "";
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

    private void createDialogForm(Veiculo obj, String absolutName, Stage parentStage){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
            Pane pane = loader.load();

            FXMLVeiculoFormController controller = loader.getController();
            controller.setVeiculo(obj);
            controller.updateFormData();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Entre com os dados de atualização");
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(parentStage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();
        }catch (IOException e){
            Alerts.showAlert("IO Exception", "Error Loading View", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void initEditButtons() {
        tableColumnUPDATE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnUPDATE.setCellFactory(param -> new TableCell<Veiculo, Veiculo>() {
            private final Button button = new Button("Editar");
            @Override
            protected void updateItem(Veiculo obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(
                        event -> createDialogForm(
                                obj, "/view/FXMLVeiculoForm.fxml",Utils.currentStage(event)));
            }
        });
    }

    private void initRemoveButtons() {
        tableColumnDELETE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnDELETE.setCellFactory(param -> new TableCell<Veiculo, Veiculo>() {
            private final Button button = new Button("Remover");
            @Override
            protected void updateItem(Veiculo obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(event -> removeVeiculo(obj));
            }
        });
    }

    private void removeVeiculo(Veiculo obj) {
        Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Tem certeza que deseja deletar:");
        if(result.get() == ButtonType.OK){
            if(service == null){
                throw  new IllegalStateException("Service was null");
            }
            try{
                service.remove(obj);
                carregarTableViewVeiculos();
            }catch (Exception e){
                Alerts.showAlert("Erro ao remover veículo", null, e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }
}

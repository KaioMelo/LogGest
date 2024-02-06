package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.MotoristaDAO;
import br.mil.fab.pagl.dao.impl.MotoristaDAOImpl;
import br.mil.fab.pagl.model.Motorista;
import br.mil.fab.pagl.model.Veiculo;
import br.mil.fab.pagl.service.MotoristaService;
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


public class FXMLMotoristaController implements Initializable {

    @FXML
    private TableView<Motorista> tableViewMotorista;
    @FXML
    private TableColumn<Motorista, String> tableColumnID;
    @FXML
    private TableColumn<Motorista, String> tableColumnNome;
    @FXML
    private TableColumn<Motorista, Integer> tableColumnCNH;
    @FXML
    private TableColumn<Motorista, String> tableColumnOM;
    @FXML
    private TableColumn<Motorista, Motorista> tableColumnUPDATE;
    @FXML
    private TableColumn<Motorista, Motorista> tableColumnDELETE;
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
    private MotoristaService service = new MotoristaService();

    private void setMotoristaService(MotoristaService service){
        this.service = service;
    }

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

    public void handleAdicionarMotorista (ActionEvent event){
        Motorista obj = new Motorista();
        obj = registrarMotorista();
        service.saveOrUpdate(obj);
        tableViewMotorista.getItems().clear();
        carregarTableViewMotorista();
    }

    @FXML
    public void carregarTableViewMotorista() {
        tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id_motorista"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome_motorista"));
        tableColumnCNH.setCellValueFactory(new PropertyValueFactory<>("cnh"));
        tableColumnOM.setCellValueFactory(new PropertyValueFactory<>("om"));
        tableColumnSessao.setCellValueFactory(new PropertyValueFactory<>("sessao"));
        tableViewMotorista.getItems().addAll(service.findAll());
        initEditButtons();
        initRemoveButtons();
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

    private void createDialogForm(Motorista obj, String absolutName, Stage parentStage){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
            Pane pane = loader.load();

            FXMLMotoristaFormController controller = loader.getController();
            controller.setMotorista(obj);
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
        tableColumnUPDATE.setCellFactory(param -> new TableCell<Motorista, Motorista>() {
            private final Button button = new Button("Editar");
            @Override
            protected void updateItem(Motorista obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(
                        event -> createDialogForm(
                                obj, "/view/FXMLMotoristaForm.fxml", Utils.currentStage(event)));
            }
        });
    }

    private void initRemoveButtons() {
        tableColumnDELETE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnDELETE.setCellFactory(param -> new TableCell<Motorista, Motorista>() {
            private final Button button = new Button("Remover");
            @Override
            protected void updateItem(Motorista obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(event -> removeMotorista(obj));
            }
        });
    }

    private void removeMotorista(Motorista obj) {
        Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Tem certeza que deseja deletar:");
        if(result.get() == ButtonType.OK){
            if(service == null){
                throw  new IllegalStateException("Service was null");
            }
            try{
                service.remove(obj);
                carregarTableViewMotorista();
            }catch (Exception e){
                Alerts.showAlert("Erro ao remover Motorista", null, e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }
}

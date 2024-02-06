package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.dao.OrdemMissaoDAO;
import br.mil.fab.pagl.dao.impl.OrdemMissaoDAOImpl;
import br.mil.fab.pagl.model.OrdemMissao;
import br.mil.fab.pagl.util.Alerts;
import br.mil.fab.pagl.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class FXMLOrdemMissaoController implements Initializable {
    @FXML
    private TableView<OrdemMissao> tableViewMissoes;
    @FXML
    private TableColumn<OrdemMissao, Integer> tableColumnID;
    @FXML
    private TableColumn<OrdemMissao, String> tableColumnSolicitante;
    @FXML
    private TableColumn<OrdemMissao, String> tableColumnContato;
    @FXML
    private TableColumn<OrdemMissao, String> tableColumnServico;
    @FXML
    private TableColumn<OrdemMissao, String> tableColumnDestino;
    @FXML
    private TableColumn<OrdemMissao, Date> tableColumnData;
    @FXML
    private TableColumn<OrdemMissao, OrdemMissao> tableColumnUPDATE;
    @FXML
    private TableColumn<OrdemMissao, OrdemMissao> tableColumnDELETE;

    private OrdemMissaoDAO missaoDAO = new OrdemMissaoDAOImpl();

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

    @FXML
    public void carregarTableViewMotorista() {
        tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id_ordem"));
        tableColumnSolicitante.setCellValueFactory(new PropertyValueFactory<>("solicitante"));
        tableColumnContato.setCellValueFactory(new PropertyValueFactory<>("contato"));
        tableColumnServico.setCellValueFactory(new PropertyValueFactory<>("servico"));
        tableColumnDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        tableColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableViewMissoes.getItems().addAll(missaoDAO.findAll());
    }

    @FXML
    public void handleRegistrarOrdemMissao(ActionEvent event){
        Stage parentStage = Utils.currentStage(event);
        OrdemMissao obj = new OrdemMissao();
        createDialogForm(obj,"/view/FXMLOrdemMissaoForm.fxml", parentStage);
    }

    private void createDialogForm(OrdemMissao obj, String absolutName, Stage parentStage){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
            Pane pane = loader.load();

            FXMLOrdemMissaoFormController controller = loader.getController();
            controller.setOrdemMissao(obj);
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
}

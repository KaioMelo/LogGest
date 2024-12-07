//package br.mil.fab.pagl.controller;
//
//import entities.model.br.com.loggest.Viagens;
//import service.model.br.com.loggest.OrdemMissaoService;
//import util.model.br.com.loggest.Alerts;
//import util.model.br.com.loggest.Utils;
//import javafx.beans.property.ReadOnlyObjectWrapper;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.Pane;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Date;
//import java.util.Optional;
//import java.util.ResourceBundle;
//
//public class FXMLOrdemMissaoController implements Initializable {
//    @FXML
//    private TableView<Viagens> tableViewMissoes;
//    @FXML
//    private TableColumn<Viagens, Integer> tableColumnID;
//    @FXML
//    private TableColumn<Viagens, String> tableColumnSolicitante;
//    @FXML
//    private TableColumn<Viagens, String> tableColumnContato;
//    @FXML
//    private TableColumn<Viagens, String> tableColumnServico;
//    @FXML
//    private TableColumn<Viagens, String> tableColumnDestino;
//    @FXML
//    private TableColumn<Viagens, Date> tableColumnData;
//    @FXML
//    private TableColumn<Viagens, Viagens> tableColumnUPDATE;
//    @FXML
//    private TableColumn<Viagens, Viagens> tableColumnDELETE;
//
//    private OrdemMissaoService service = new OrdemMissaoService();
//
//    private void setOrdemMissaoService(OrdemMissaoService service){
//        this.service = service;
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        carregarTableViewMissoes();
//    }
//
//    private void loadScene(String fxmlPath, ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
//        ScrollPane root = loader.load();
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//        stage.centerOnScreen();
//    }
//
//
//
//    @FXML
//    public void handleMissao(ActionEvent event) throws IOException {
//        loadScene("/view/FXMLOrdemMissao.fxml", event);
//    }
//
//    @FXML
//    public void handleVeiculo(ActionEvent event) throws IOException {
//        loadScene("/view/FXMLVeiculo.fxml", event);
//    }
//
//    @FXML
//    public void handleMotorista(ActionEvent event) throws IOException {
//        loadScene("/view/FXMLMotorista.fxml", event);
//    }
//
//    @FXML
//    public void carregarTableViewMissoes() {
//        tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id_ordem"));
//        tableColumnSolicitante.setCellValueFactory(new PropertyValueFactory<>("solicitante"));
//        tableColumnContato.setCellValueFactory(new PropertyValueFactory<>("contato"));
//        tableColumnDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
//        tableColumnServico.setCellValueFactory(new PropertyValueFactory<>("servico"));
//        tableColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
//        initEditButtons();
//        initRemoveButtons();
//        tableViewMissoes.getItems().addAll(service.findAll());
//    }
//
//    @FXML
//    public void handleRegistrarOrdemMissao(ActionEvent event){
//        Stage parentStage = Utils.currentStage(event);
//        Viagens obj = new Viagens();
//        createDialogForm(obj,"/view/FXMLOrdemMissaoForm.fxml", parentStage);
//    }
//
//    private void createDialogForm(Viagens obj, String absolutName, Stage parentStage){
//        try{
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
//            Pane pane = loader.load();
//
//            FXMLOrdemMissaoFormController controller = loader.getController();
//            controller.setOrdemMissao(obj);
//            controller.updateFormData();
//
//            Stage dialogStage = new Stage();
//            dialogStage.setTitle("Entre com os dados de atualização");
//            dialogStage.setScene(new Scene(pane));
//            dialogStage.setResizable(false);
//            dialogStage.initOwner(parentStage);
//            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.showAndWait();
//        }catch (IOException e){
//            Alerts.showAlert("IO Exception", "Error Loading View", e.getMessage(), Alert.AlertType.ERROR);
//        }
//    }
//
//    private void initEditButtons() {
//        tableColumnUPDATE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
//        tableColumnUPDATE.setCellFactory(param -> new TableCell<Viagens, Viagens>() {
//            private final Button button = new Button("Editar");
//            @Override
//            protected void updateItem(Viagens obj, boolean empty) {
//                super.updateItem(obj, empty);
//                if (obj == null) {
//                    setGraphic(null);
//                    return;
//                }
//                setGraphic(button);
//                button.setOnAction(
//                        event -> createDialogForm(
//                                obj, "/view/FXMLOrdemMissaoForm.fxml",Utils.currentStage(event)));
//            }
//        });
//    }
//
//    private void initRemoveButtons() {
//        tableColumnDELETE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
//        tableColumnDELETE.setCellFactory(param -> new TableCell<Viagens, Viagens>() {
//            private final Button button = new Button("Remover");
//            @Override
//            protected void updateItem(Viagens obj, boolean empty) {
//                super.updateItem(obj, empty);
//                if (obj == null) {
//                    setGraphic(null);
//                    return;
//                }
//                setGraphic(button);
//                button.setOnAction(event -> removerMissao(obj));
//            }
//        });
//    }
//
//    private void removerMissao(Viagens obj) {
//        Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Tem certeza que deseja deletar:");
//        if(result.get() == ButtonType.OK){
//            if(service == null){
//                throw  new IllegalStateException("Service was null");
//            }
//            try{
//                service.remove(obj);
//                carregarTableViewMissoes();
//            }catch (Exception e){
//                Alerts.showAlert("Erro ao remover Missão", null, e.getMessage(), Alert.AlertType.ERROR);
//            }
//        }
//    }
//}

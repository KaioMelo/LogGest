package br.com.loggest.controller.cliente;


import br.com.loggest.model.entities.Endereco;
import br.com.loggest.model.entities.PessoaFisica;
import br.com.loggest.model.entities.enuns.TipoContato;
import br.com.loggest.model.entities.enuns.TipoSexo;
import br.com.loggest.model.service.ViaCEPService;
import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCadastrarClientesPFController implements Initializable {

    @FXML private TextField textFieldNome;
    @FXML private TextField textFieldCPF;
    @FXML private TextField textFieldRG;
    @FXML private TextField textFieldPIS;
    @FXML private TextField textFieldTitulo;
    @FXML private TextField textFieldCTPS;
    @FXML private ChoiceBox<TipoSexo> choiceBoxTipoSexo;
    @FXML private ChoiceBox<TipoContato> choiceBoxTipoContato;
    @FXML private TextField textFieldDDD;
    @FXML private TextField textFieldNumero;
    @FXML private ToggleButtonGroup toggleGroupContato;
    @FXML private ToggleButtonGroup toggleGroupEmail;
    @FXML private TextField textFieldEmail;
    @FXML private RadioButton radioAutorizaEmail;
    @FXML private TextField textFieldCEP;
    @FXML private TextField textFieldEstado;
    @FXML private TextField textFieldCidade;
    @FXML private TextField textFieldBairro;
    @FXML private TextField textFieldLogradouro;
    @FXML private TextField textFieldComplemento;

    private static final int MAX_DIGITOS_CEP = 8;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxTipoSexo.setItems(
                FXCollections.observableArrayList(TipoSexo.values())
        );
        choiceBoxTipoContato.setItems(
                FXCollections.observableArrayList(TipoContato.values())
        );

        textFieldCEP.textProperty().addListener((observable, oldValue, newValue) -> {
            String cepNumerico = newValue.replaceAll("[^0-9]", "");
            String formattedCep = cepNumerico;
            if (cepNumerico.length() > MAX_DIGITOS_CEP) {
                cepNumerico = cepNumerico.substring(0, MAX_DIGITOS_CEP);
            }
            if (cepNumerico.length() > 5) {
                formattedCep = cepNumerico.substring(0, 5) + "-" + cepNumerico.substring(5);
            } else {
                formattedCep = cepNumerico;
            }
            if (!textFieldCEP.getText().equals(formattedCep)) {
                int caretPosition = textFieldCEP.getCaretPosition();
                textFieldCEP.setText(formattedCep);
                if (formattedCep.length() <= MAX_DIGITOS_CEP + 1) {
                    textFieldCEP.positionCaret(formattedCep.length());
                }
            }
            if (cepNumerico.length() == MAX_DIGITOS_CEP) {
                buscarCepAutomatico(cepNumerico);
            }
        });
    }

    private void loadScene(String fxmlPath, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        ScrollPane root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    public void handleHome(ActionEvent event) throws IOException {
        loadScene("/view/home/FXMLInicio.fxml", event);
    }

    @FXML
    public void handleClientes(ActionEvent event) throws IOException {
        loadScene("/view/cliente/FXMLClientes.fxml", event);
    }

    @FXML
    public void handleFornecedores(ActionEvent event) throws IOException {
        loadScene("/view/FXMLRegistroFornecedores.fxml", event);
    }

    @FXML
    public void handleEstoque(ActionEvent event) throws IOException {
        loadScene("/view/FXMLControleEstoque.fxml", event);
    }

    @FXML
    public void handleVeiculos(ActionEvent event) throws IOException {
        loadScene("/view/FXMLControleVeiculos.fxml", event);
    }

    @FXML
    public void handleRecursosHumanos(ActionEvent event) throws IOException {
        loadScene("/view/FXMLControleRecursosHumanos.fxml", event);
    }

    @FXML
    public void handleFinanceiro(ActionEvent event) throws IOException {
        loadScene("/view/FXMLControleFinanceiro.fxml", event);
    }

    @FXML
    public void handleRelatorios(ActionEvent event) throws IOException {
        loadScene("/view/FXMLControleRelatorios.fxml", event);
    }

    @FXML
    public void handleEstatisticas(ActionEvent event) throws IOException {
        loadScene("/view/FXMLEstatisticas.fxml", event);
    }

    @FXML
    public void handlerSalvarClientePessoaFisica(ActionEvent event) throws  IOException{
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica = salvarCliente();
    }

    private void buscarCepAutomatico(String cep){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Task<String> task = new Task<String>() {
            @Override
            protected String call() throws Exception {
                return ViaCEPService.buscarCep(cep);
            }
            @Override
            protected void succeeded() {
                try{
                    String jsonResponse = getValue();
                    Gson gson = new Gson();
                    Endereco endereco = gson.fromJson(jsonResponse, Endereco.class);

                    if (endereco.isErro()) {
                        alert.setTitle("ERROR ao Buscar CEP!");
                        alert.setHeaderText("CEP não encontrado!");
                        alert.show();
                        clerFieldsEndereco();
                    } else {
                        textFieldLogradouro.setText(endereco.getLogradouro().toUpperCase());
                        textFieldBairro.setText(endereco.getBairro().toUpperCase());
                        textFieldCidade.setText(endereco.getLocalidade().toUpperCase());
                        textFieldEstado.setText(endereco.getUf().toUpperCase());
                    }
                }catch (Exception e){
                    alert.setTitle("ERROR ao Buscar CEP!");
                    alert.setHeaderText("CEP não encontrado!");
                    alert.setContentText("Erro ao processar a resposta: " + e.getMessage());
                    alert.show();
                }
            }
            @Override
            protected void failed() {
                alert.setTitle("ERROR ao Buscar CEP!");
                alert.setHeaderText("CEP não encontrado!");
                alert.setContentText("Falha na comunicação com ViaCEP: " + getException().getMessage());
                alert.show();
            }
        };
        new Thread(task).start();
    }

    private PessoaFisica salvarCliente(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        PessoaFisica pessoaFisica = new PessoaFisica();
        try {
            if (validarEntradasDeDados()){

                return pessoaFisica;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private boolean validarEntradasDeDados() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String errorMessage = "";

        if (textFieldNome.getText() == null || textFieldNome.getText().trim().equals("")) {
            errorMessage += "Nome Inválido: \n";
        }
        if (textFieldCPF.getText() == null || textFieldCPF.getText().trim().equals("")) {
            errorMessage += "CPF Inválido: \n";
        }
        if (textFieldRG.getText() == null || textFieldRG.getText().trim().equals("")) {
            errorMessage += "RG Inválido: \n";
        }
        if (textFieldTitulo.getText() == null || textFieldTitulo.getText().trim().equals("")) {
            errorMessage += "Título Inválido: \n";
        }
        if (textFieldPIS.getText() == null || textFieldPIS.getText().trim().equals("")) {
            errorMessage += "PIS Inválido: \n";
        }
        if (textFieldCTPS.getText() == null || textFieldCTPS.getText().trim().equals("")) {
            errorMessage += "CTPS Inválido: \n";
        }
        if (getSexoSelecionado() == null || getSexoSelecionado().getDescricao().trim().equals("")) {
            errorMessage += "Selecione um tipo de sexo: \n";
        }
        if (getContatoSelecionado() == null || getContatoSelecionado().getDescricao().trim().equals("")) {
            errorMessage += "Selecione um tipo de Contato: \n";
        }
        if (textFieldDDD.getText() == null || textFieldDDD.getText().trim().equals("")) {
            errorMessage += "DDD Inválido: \n";
        }
        if (textFieldNumero.getText() == null || textFieldNumero.getText().trim().equals("")) {
            errorMessage += "Número Inválido: \n";
        }
        if (textFieldNumero.getText() == null || textFieldNumero.getText().trim().equals("")) {
            errorMessage += "Número Inválido: \n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            clearFileds();
            alert.setTitle("ERROR ao Cadastrar Cliente Pessoa Física!");
            alert.setHeaderText("Campos inválidos, por favor, corrija!");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

    private void exibirErro(String mensagem) {
        System.out.println("ERRO: " + mensagem);
    }
    public void clearFileds() {
        textFieldNome.setText("");
        textFieldCPF.setText("");
        textFieldRG.setText("");
        textFieldTitulo.setText("");
        textFieldPIS.setText("");
        textFieldCTPS.setText("");
        this.clerFieldsEndereco();
    }

    private void clerFieldsEndereco(){
        textFieldEstado.setText("");
        textFieldLogradouro.setText("");
        textFieldBairro.setText("");
        textFieldCidade.setText("");
    }


    public TipoSexo getSexoSelecionado() {
        return choiceBoxTipoSexo.getSelectionModel().getSelectedItem();
    }
    public TipoContato getContatoSelecionado() {
        return choiceBoxTipoContato.getSelectionModel().getSelectedItem();
    }

    public boolean getAutorizacaoContato() {
        for (Toggle toggle : toggleGroupContato.getToggles()) {
            if (toggle.isSelected()) {
                if (toggle.getUserData() != null) {
                    String userDataValue = toggle.getUserData().toString();
                    return Boolean.parseBoolean(userDataValue);
                }
                return false;
            }
        }
        return false;
    }

    public boolean getAutorizacaoEmail() {
        for (Toggle toggle : toggleGroupEmail.getToggles()) {
            if (toggle.isSelected()) {
                if (toggle.getUserData() != null) {
                    String userDataValue = toggle.getUserData().toString();
                    return Boolean.parseBoolean(userDataValue);
                }
                return false;
            }
        }
        return false;
    }
}

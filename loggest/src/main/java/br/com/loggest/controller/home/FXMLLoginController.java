package br.com.loggest.controller.home;

import br.com.loggest.model.entities.Funcionario;
import br.com.loggest.model.exceptions.ValidationException;
import br.com.loggest.model.service.FuncionarioService;
import br.com.loggest.model.util.Alerts;
import br.com.loggest.model.util.SceneNavigator;
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

public class FXMLLoginController implements Initializable {

    @FXML
    private TextField textFieldMatricula;
    @FXML
    private PasswordField passwordFieldSenha;
    @FXML
    private Button btnLogin;

    private Funcionario funcionario;

    private FuncionarioService service = new FuncionarioService();

    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public void setAdministradorService(FuncionarioService service){
        this.service = service;
    }
    @Override
    public void initialize(URL url, ResourceBundle rB) {
    }

    private void loadScene(String fxmlPath, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        ScrollPane root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
        SceneNavigator.navigateTo(scene);
    }

    @FXML
    public void handleLoginAdmin(ActionEvent event) throws IOException{
        try{
//            if(!textFieldMatricula.getText().trim().isBlank() && !passwordFieldSenha.getText().trim().isBlank()){
            if(validarLogin()){
//                Pessoa obj = new Pessoa();
                String matricula = textFieldMatricula.getText().trim();
                String senha = passwordFieldSenha.getText().trim();

                if(service.verificarLogin(matricula, senha)){
                    loadScene("/view/home/FXMLInicio.fxml", event);
                }else{
                    Alerts.showAlert("ERROR", "E-mail ou senha incorretos!", null, Alert.AlertType.ERROR);
                }
            }
            else{
                Alerts.showAlert("ERROR", "Campos inválidos!", null, Alert.AlertType.ERROR);
                clearFields();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Boolean validarLogin(){
//        Pessoa obj = new Pessoa();
        if(validarEntradaDeDados()){
//            obj.getEmails().get(0).setDescricao(textFieldEmail.getText());
//            obj.getSenha().setSenhaNova(passwordFieldSenha.getText());
            return true;
        }
        return false;
    }

    private boolean validarEntradaDeDados(){
        ValidationException exception = new ValidationException("Validation error");
//        Pessoa obj = new Pessoa();
        if (textFieldMatricula.getText() == null || textFieldMatricula.getText().trim().equals("")) {
            exception.addError("Matricula", "Inválido");
        }
//        obj.getEmails().get(0).setDescricao(textFieldMatricula.getText());
        if (passwordFieldSenha.getText() == null || passwordFieldSenha.getText().trim().equals("")) {
            exception.addError("Senha", "Inválido");
        }
//        obj.getSenha().setSenhaNova(passwordFieldSenha.getText());
        if (exception.getErrors().size() == 0) {
            return true;
        }else{
            clearFields();
            Alerts.showAlert("ERROR ao Fazer Login!", "Campos inválidos, por favor, corrija!", null, Alert.AlertType.ERROR);
            return false;
        }
    }

    public void clearFields() {
        textFieldMatricula.setText("");
        passwordFieldSenha.setText("");
    }
}

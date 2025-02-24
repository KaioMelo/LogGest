package br.com.loggest.controller;

import br.com.loggest.model.entities.Administrador;
import br.com.loggest.model.exceptions.ValidationException;
import br.com.loggest.model.service.AdministradorService;
import br.com.loggest.model.util.Alerts;
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
    private TextField textFieldEmail;
    @FXML
    private PasswordField passwordFieldSenha;
    @FXML
    private Button btnLogin;

    private Administrador adm;

    private AdministradorService service = new AdministradorService();

    public void setAdministrador(Administrador adm){
        this.adm = adm;
    }

    public void setAdministradorService(AdministradorService service){
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
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    public void handleLoginAdmin(ActionEvent event) throws IOException{
        try{
            if(!textFieldEmail.getText().trim().isBlank() && !passwordFieldSenha.getText().trim().isBlank()){
                Administrador obj = validarLogin();
                if(service.verificarLogin(obj)){
                    loadScene("/view/FXMLInicio.fxml", event);
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

    public Administrador validarLogin(){
        Administrador obj = new Administrador();
        if(validarEntradaDeDados()){
            obj.getEmail().setDescricao(textFieldEmail.getText());
            obj.setSenhas(passwordFieldSenha.getText());
        }
        return obj;
    }

//    private void saveAndUpdate(ActionEvent event){
//        if(adm == null){
//            throw new IllegalStateException("Entity was null");
//        }
//        if (service == null) {
//            throw new IllegalStateException("Service was null");
//        }
//        try{
//            service.saveOrUpdate(adm);
//        }catch (Exception e){
//
//        }
//    }

    private boolean validarEntradaDeDados(){
        ValidationException exception = new ValidationException("Validation error");
        Administrador obj = new Administrador();

        if (textFieldEmail.getText() == null || textFieldEmail.getText().trim().equals("")) {
            exception.addError("E-mail", "Inválido");
        }
        obj.getEmail().setDescricao(textFieldEmail.getText());
        if (passwordFieldSenha.getText() == null || passwordFieldSenha.getText().trim().equals("")) {
            exception.addError("Senha", "Inválido");
        }
        obj.setSenhas(passwordFieldSenha.getText());
        if (exception.getErrors().size() == 0) {
            return true;
        }else{
            clearFields();
            Alerts.showAlert("ERROR ao Fazer Login!", "Campos inválidos, por favor, corrija!", null, Alert.AlertType.ERROR);
            return false;
        }
    }

    public void clearFields() {
        textFieldEmail.setText("");
        passwordFieldSenha.setText("");
    }
}

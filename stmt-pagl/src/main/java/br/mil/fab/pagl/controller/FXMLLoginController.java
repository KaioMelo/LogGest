package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.model.entities.Administrador;
import br.mil.fab.pagl.model.entities.OrdemMissao;
import br.mil.fab.pagl.model.exceptions.ValidationException;
import br.mil.fab.pagl.model.service.AdministradorService;
import br.mil.fab.pagl.model.util.Alerts;
import br.mil.fab.pagl.model.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ResourceBundle;

public class FXMLLoginController implements Initializable {

    @FXML
    private TextField textFieldEmail;
    @FXML
    private PasswordField passwordFieldSenha;
    @FXML
    private Button btnLogin;

    private Administrador adm;

    private AdministradorService service;

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
            if(textFieldEmail.getText().isBlank() == false && passwordFieldSenha.getText().isBlank() == false){
                Administrador obj = new Administrador();
                obj = validarLogin();
                service.verificarLogin(obj);
//                Alerts.showAlert("SUCESSO", "Olá seja bem-vindo", null, Alert.AlertType.NONE);
//                clearFields();
                loadScene("/view/FXMLInicio.fxml", event);
            }
            else{
                Alerts.showAlert("ERROR", "Usuário incorreto ou não existe!", null, Alert.AlertType.ERROR);
                clearFields();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Administrador validarLogin(){
        Administrador obj = new Administrador();
        if(validarEntradaDeDados()){
            obj.setEmail(textFieldEmail.getText());
            obj.setSenha(passwordFieldSenha.getText());
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
        Alert alert = new Alert(Alert.AlertType.ERROR);
        ValidationException exception = new ValidationException("Validation error");
        Administrador obj = new Administrador();

        if (textFieldEmail.getText() == null || textFieldEmail.getText().trim().equals("")) {
            exception.addError("E-mail", "Inválido");
        }
        obj.setEmail(textFieldEmail.getText());
        if (passwordFieldSenha.getText() == null || passwordFieldSenha.getText().trim().equals("")) {
            exception.addError("Senha", "Inválido");
        }
        obj.setSenha(passwordFieldSenha.getText());
        if (exception.getErrors().size() == 0) {
            return true;
        }else{
            clearFields();
            alert.setTitle("ERROR ao Fazer Login!");
            alert.setHeaderText("Campos inválidos, por favor, corrija!");
            alert.show();
            return false;
        }
    }

    public void clearFields() {
        textFieldEmail.setText("");
        passwordFieldSenha.setText("");
    }
}

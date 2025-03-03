package com.application.javafx2.gui.controller;

import com.application.javafx2.gui.ScreenLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

     @FXML
     private TextField txtField1;

     @FXML
     private PasswordField passwordField;

     @FXML
     private Button btnLogin;

     private Stage stage;

     public void setStage(Stage stage) {
         this.stage = stage;
     }

     @FXML
     public void  onBtnLoginAction () {
         ScreenLoader.loadForm("/com/application/javafx2/Main-view.fxml");
     }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /*
    public  void loadForm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/application/login/Main-view.fxml"));
            AnchorPane newForm = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(newForm);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Alerts.showAlert(null, "ERRO", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
   */
}
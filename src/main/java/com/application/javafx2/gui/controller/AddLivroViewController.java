package com.application.javafx2.gui.controller;

import com.application.javafx2.gui.Alerts;

import com.application.javafx2.model.entity.Livro;
import com.application.javafx2.model.service.LivroService;
import com.application.javafx2.repository.Dao.DaoFactory;
import com.application.javafx2.repository.Dao.LivroDao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

 public class AddLivroViewController implements Initializable{

    @FXML
    TextField txtTitulo;

    @FXML
    TextField txtLancamento;

    @FXML
    TextField txtAutor;

    @FXML
    ComboBox<String> generoComboBox;

    UpdateTableListener updateTableListener;

    public void setUpdateTableListener (UpdateTableListener updateTableListener) {
        this.updateTableListener = updateTableListener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generoComboBox.setItems(FXCollections.observableArrayList("Dark-fantasy", "Fantasia", "Educação", "Romance", "Anime", "Picante"));
    }

    @FXML
    public void btnAddOnAction() {
        LivroDao livroDao = DaoFactory.crateLivroDao();
        LivroService service = new LivroService(livroDao);
        Livro livro = instantiateObj();
        int rowsAffected = service.insert(livro);
        if (rowsAffected > 0) {
            Alerts.showAlert("Sucesso!", " ", "Dados cadastrados com sucesso !", Alert.AlertType.CONFIRMATION);
            updateTableListener.updateTable();
        }
        cleanText();
    }

    private Livro instantiateObj() {
        return new Livro(txtTitulo.getText(), txtLancamento.getText(), txtAutor.getText(), generoComboBox.getValue());
    }

    private void cleanText() {
        txtTitulo.clear();
        txtLancamento.clear();
        txtAutor.clear();
    }
}

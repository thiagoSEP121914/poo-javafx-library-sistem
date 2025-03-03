package com.application.javafx2.gui.controller;

import com.application.javafx2.gui.ScreenLoader;
import com.application.javafx2.model.entity.Livro;
import com.application.javafx2.model.service.LivroService;
import com.application.javafx2.repository.Dao.DaoFactory;
import com.application.javafx2.repository.Dao.LivroDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    TableView<Livro> tbLivro;

    @FXML
    TableColumn<Livro, Integer> idColumn;

    @FXML
    TableColumn<Livro, String> tituloColumn;

    @FXML
    TableColumn<Livro, String> anoLancamentoColumn;

    @FXML
    TableColumn<Livro, String> autorColumn;

    @FXML
    TableColumn<Livro, String> generoColumn;

    @FXML
    TableColumn<Livro, String> statusColumn;

    @FXML
    TextField searchField;

    @FXML
    ImageView btnIivroIcon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tituloColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        anoLancamentoColumn.setCellValueFactory(new PropertyValueFactory<>("anoLancamento"));
        autorColumn.setCellValueFactory(new PropertyValueFactory<>("autor"));
        generoColumn.setCellValueFactory(new PropertyValueFactory<>("genero"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        ObservableList<Livro> livros = loadTableView();
        tbLivro.setItems(livros);

        searchFieldOnAction();
    }

    private ObservableList<Livro> loadTableView () {
        LivroDao livroDao = DaoFactory.crateLivroDao();
        LivroService mainServices = new LivroService(livroDao);
        List<Livro> listLivros =  mainServices.findAll();
        return FXCollections.observableArrayList(listLivros);
    }

    public void searchFieldOnAction() {
        searchField.setPromptText("Buscar:");
    }

    @FXML
    public void onBtnLivroClicked() {
        System.out.println("CLicado clicado");
        ScreenLoader.loadForm("/com/application/javafx2/Livro-view.fxml");
    }
}

package com.application.javafx2.gui.controller;

import com.application.javafx2.gui.ScreenLoader;
import com.application.javafx2.model.entity.Livro;
import com.application.javafx2.model.service.LivroService;
import com.application.javafx2.repository.Dao.DaoFactory;
import com.application.javafx2.repository.Dao.LivroDao;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LivroViewController implements Initializable, UpdateTableListener {

    @FXML
    private TableView<Livro> tbLivro;

    @FXML
    private TableColumn<Livro, Integer> idColumn;

    @FXML
   private  TableColumn<Livro, String> tituloColumn;

    @FXML
    private TableColumn<Livro, String> anoLancamentoColumn;

    @FXML
    private TableColumn<Livro, String> autorColumn;

    @FXML
    private TableColumn<Livro, String> generoColumn;

    @FXML
    private TableColumn<Livro, String> statusColumn;

    @FXML
    private TextField searchField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTableView();
    }

    private void loadTableView() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tituloColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        anoLancamentoColumn.setCellValueFactory(new PropertyValueFactory<>("anoLancamento"));
        autorColumn.setCellValueFactory(new PropertyValueFactory<>("autor"));
        generoColumn.setCellValueFactory(new PropertyValueFactory<>("genero"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        LivroDao livroDao = DaoFactory.crateLivroDao();
        LivroService service = new LivroService(livroDao);
        List<Livro> listLivro = service.findAll();
        tbLivro.setItems(FXCollections.observableArrayList(listLivro));
        tbLivro.refresh();
    }

    public void searchFieldOnAction() {
        searchField.setPromptText("Buscar:");
    }

    @FXML
    public void onBtnLivroMouseClicked() {
        System.out.println("CLicado clicado");
        ScreenLoader.loadForm("/com/application/javafx2/Livro-view.fxml");
    }
    @FXML
    public void btnAddOnAction() {
        System.out.println("Cliquei no botão Adicionar Livro");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/application/javafx2/AddLivro-view.fxml"));
            Parent root = loader.load();
            AddLivroViewController addLivroController = loader.getController();
            addLivroController.setUpdateTableListener(this);
            ScreenLoader.loadForm(root);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar a tela" + e.getMessage());
        }
    }

    @FXML
    public void btnEditOnAction() {
        System.out.println("Cliquei no botão Editar Livro");

        Livro livroSelecionado = tbLivro.getSelectionModel().getSelectedItem();

        if (livroSelecionado != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/application/javafx2/EditLivro-view.fxml"));
                Parent root = loader.load();
                EditLivroController editLivroController = loader.getController();
                editLivroController.setLivro(livroSelecionado);
                editLivroController.setUpdateTableListener(this);
                ScreenLoader.loadForm(root);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao carregar a tela de edição: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhum livro selecionado para editar.");
        }
    }

    @Override
    public void updateTable() {
        loadTableView();
    }
}

package com.application.javafx2.gui;

import com.application.javafx2.gui.controller.AddLivroViewController;
import com.application.javafx2.gui.controller.UpdateTableListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class ScreenLoader {


    public static void loadForm(String url) {
        try {
            FXMLLoader loader = new FXMLLoader(ScreenLoader.class.getResource(url));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Não foi possivel carregar a view " + e.getMessage());
        }
    }


    public static void loadForm(Parent parent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }
    public static void loadForm(String url, Stage currentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(ScreenLoader.class.getResource(url));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            if (currentStage != null) {
                currentStage.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível carregar a view: " + e.getMessage());
        }
    }

}

package com.application.javafx2.gui;

import javafx.scene.control.Alert;

public class Alerts {
    public static void showAlert(String title, String header, String content, Alert.AlertType type) {
        // Cria o alerta com o tipo especificado
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

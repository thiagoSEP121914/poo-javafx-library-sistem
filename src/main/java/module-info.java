module com.application.javafx2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.application.javafx2 to javafx.fxml;
    opens com.application.javafx2.model.entity to javafx.base;  // Add this line to open the model.entity package
    exports com.application.javafx2;
    exports com.application.javafx2.gui;
    opens com.application.javafx2.gui to javafx.fxml;
    exports com.application.javafx2.gui.controller;
    opens com.application.javafx2.gui.controller to javafx.fxml;
}

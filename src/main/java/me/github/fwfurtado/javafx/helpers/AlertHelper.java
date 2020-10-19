package me.github.fwfurtado.javafx.helpers;

import javafx.scene.control.Alert;
import javafx.stage.Window;

public class AlertHelper {
    public static void error(String title, String message, Window owner) {
        buildAndShowAlertOf(Alert.AlertType.ERROR, title, message, owner);
    }

    public static void confirmation(String title, String message, Window owner) {
        buildAndShowAlertOf(Alert.AlertType.CONFIRMATION, title, message, owner);
    }

    private static void buildAndShowAlertOf(Alert.AlertType type, String title, String message, Window owner){
        var alert = new Alert(type);

        alert.setTitle(title);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}


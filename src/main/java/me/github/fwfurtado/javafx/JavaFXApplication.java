package me.github.fwfurtado.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class JavaFXApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        var loginURL = this.getClass().getClassLoader().getResource("login.fxml");

        var layout = FXMLLoader.<Pane>load(loginURL);
        var scene = new Scene(layout);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

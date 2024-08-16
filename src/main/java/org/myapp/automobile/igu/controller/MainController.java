package org.myapp.automobile.igu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {


    public Button buttonRegis;

    public void btnRegistration(ActionEvent actionEvent) throws IOException {

//        System.out.println("Hello");

        Stage stage;
        Parent root;

        // Obtén la referencia al botón
        stage = (Stage) buttonRegis.getScene().getWindow();

        // Carga el nuevo FXML
        root = FXMLLoader.load(getClass().getResource("/org/myapp/automobile/registration.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}